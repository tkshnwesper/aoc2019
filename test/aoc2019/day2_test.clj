(ns aoc2019.day2-test
  (:require [clojure.test :refer :all]
            [aoc2019.day2 :refer :all]))

(deftest day2-part1-test
  (testing "addition"
    (is (= (aoc2019.day2/transform-list '(1 0 0 0 99) 0) '(2 0 0 0 99))))
  (testing "multiplication"
    (is (= (aoc2019.day2/transform-list '(2 3 0 3 99) 0) '(2 3 0 6 99))))
  (testing "multiple iterations"
    (is (= (aoc2019.day2/transform-list '(1 1 1 4 99 5 6 0 99) 0) '(30 1 1 4 2 5 6 0 99)))))

(deftest day2-part2-test
  (testing "noun and verb when no change occurs"
    (is (true? (.contains (aoc2019.day2/get-noun-and-verb '(1 0 0 0 99) 2) '(0 0)))))
  (testing "noun and verb when verb changes"
    (is (true? (.contains (vec (aoc2019.day2/get-noun-and-verb '(1 1 1 0 2 5 6 1 99) 2)) '(30 1))))))
