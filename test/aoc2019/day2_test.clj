(ns aoc2019.day2-test
  (:require [clojure.test :refer :all]
            [aoc2019.day2 :refer :all]))

(deftest day2-test
  (testing "test addition"
    (is (= (aoc2019.day2/transform-list '(1 0 0 0 99) 0) '(2 0 0 0 99))))
  (testing "test multiplication"
    (is (= (aoc2019.day2/transform-list '(2 3 0 3 99) 0) '(2 3 0 6 99))))
  (testing "multiple iterations"
    (is (= (aoc2019.day2/transform-list '(1 1 1 4 99 5 6 0 99) 0) '(30 1 1 4 2 5 6 0 99)))))