(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Brussels -- the SIXTEENTH
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo for the
  first fifteen) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Lisbon (lisboa.pt) was attempted first this tick but blocked WebFetch
  entirely -- HTTP 403 even at the bare domain root, a total-domain
  bot-protection block distinct from the usual PDF-garbling or
  single-page 403 cases seen elsewhere in this family. Abandoned
  without forcing it; pivoted to Brussels instead.

  Every entry cites the City of Brussels' own OFFICIAL
  bruxelles.be/reglements-communaux page -- never fabricated. An
  ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"brussels"
   [{:ordinance/id "brussels.reglement-ordre-interieur-conseil-communal"
     :ordinance/title "Règlement d'ordre intérieur du Conseil communal"
     :ordinance/municipality "brussels"
     :ordinance/country "BEL"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.bruxelles.be/reglements-communaux"
     :ordinance/url-provenance :official-bruxelles-be
     :ordinance/enacted-date "2018-01-22"
     :ordinance/last-revised-date "2018-05-17"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "brussels.code-deontologique"
     :ordinance/title "Code déontologique"
     :ordinance/municipality "brussels"
     :ordinance/country "BEL"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.bruxelles.be/reglements-communaux"
     :ordinance/url-provenance :official-bruxelles-be
     :ordinance/enacted-date "2013-10-21"
     :ordinance/last-revised-date "2014-01-25"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance :ethics}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-bel-brussels Wave 0 (ADR-2607141700): "
                 (count (get catalog "brussels")) " Brussels entries seeded "
                 "with an official bruxelles.be citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
