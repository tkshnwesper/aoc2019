(ns aoc2019.day1-test
  (:require [clojure.test :refer :all]
            [aoc2019.day1 :refer :all]))

(deftest day1-part1-test
  (testing "Empty inputs"
    (is (= (aoc2019.day1/calculate-fuel-requirements '()) 0)))
  (testing "With mass 12"
    (is (= (aoc2019.day1/calculate-fuel-requirements '(12)) 2.0))))

(deftest day1-part2-test 
  (testing "Empty inputs"
    (is (= (aoc2019.day1/calculate-fuel-requirements-with-fuel '()) 0)))
  (testing "With mass 1969"
    (is (= (aoc2019.day1/calculate-fuel-requirements-with-fuel '(1969)) 966.0))))
