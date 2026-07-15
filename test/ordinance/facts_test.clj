(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest brussels-has-spec-basis
  (let [sb (facts/spec-basis "brussels")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.bruxelles.be/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "lisbon")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["brussels" "lisbon"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["lisbon"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["brussels.code-deontologique"]
         (mapv :ordinance/id (facts/by-topic "brussels" :ethics))))
  (is (empty? (facts/by-topic "brussels" :labor)))
  (is (empty? (facts/by-topic "lisbon" :governance))))
