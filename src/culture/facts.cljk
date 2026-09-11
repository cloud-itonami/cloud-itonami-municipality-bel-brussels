(ns culture.facts
  "Regional-culture catalog for Brussels (City of Brussels) -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"brussels"
   [{:culture/id "brussels.dish.moules-frites"
     :culture/name "Moules-frites"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :dish
     :culture/summary "Dish of mussels and fries, the national dish of Belgium, originating in Northern France and Belgium."
     :culture/url "https://en.wikipedia.org/wiki/Moules-frites"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.dish.stoemp"
     :culture/name "Stoemp"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :dish
     :culture/summary "Dish of pureed or mashed potatoes and vegetables, cooked in Brussels since the 19th century and part of Brussels cuisine."
     :culture/url "https://fr.wikipedia.org/wiki/Stoemp"
     :culture/url-provenance :wikipedia-fr
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.dish.brussels-waffle"
     :culture/name "Brussels waffle"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :dish
     :culture/summary "One of the several kinds of waffles eaten in Belgium; the American 'Belgian waffle' is largely based on a simplified recipe for the Brussels waffle."
     :culture/url "https://en.wikipedia.org/wiki/Belgian_waffle"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.product.brussels-sprout"
     :culture/name "Brussels sprout"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :product
     :culture/summary "Vegetable cultivated in the 13th century near Brussels, Belgium, from which its name derives; first written reference dates to 1587."
     :culture/url "https://en.wikipedia.org/wiki/Brussels_sprout"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.product.belgian-praline"
     :culture/name "Belgian praline"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :product
     :culture/summary "Filled chocolate invented in 1912 by Jean Neuhaus II, grandson of the founder of the Neuhaus chocolatier established in Brussels in 1857."
     :culture/url "https://en.wikipedia.org/wiki/Neuhaus_(chocolatier)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.beverage.lambic"
     :culture/name "Lambic"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :beverage
     :culture/summary "Beer brewed in the Pajottenland region of Belgium southwest of Brussels since the 13th century, fermented through exposure to wild yeasts native to the Zenne valley."
     :culture/url "https://en.wikipedia.org/wiki/Lambic"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.craft.brussels-lace"
     :culture/name "Brussels lace"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :craft
     :culture/summary "Type of pillow lace that originated in and around Brussels, produced from the 15th century."
     :culture/url "https://en.wikipedia.org/wiki/Brussels_lace"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.festival.ommegang"
     :culture/name "Ommegang of Brussels"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :festival
     :culture/summary "Medieval-style pageant held annually in Brussels, with processions recreating the 1549 Joyous Entry of Emperor Charles V."
     :culture/url "https://en.wikipedia.org/wiki/Ommegang_of_Brussels"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "brussels.heritage.grand-place"
     :culture/name "Grand-Place"
     :culture/name-local "Grote Markt"
     :culture/municipality "brussels"
     :culture/country "BEL"
     :culture/kind :heritage
     :culture/summary "Central square of Brussels, named by UNESCO as a World Heritage Site in 1998."
     :culture/url "https://en.wikipedia.org/wiki/Grand-Place"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-bel-brussels culture catalog "
                 "(ADR-2607171400): " (count (get catalog "brussels"))
                 " Brussels entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
