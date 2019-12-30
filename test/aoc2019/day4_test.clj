(ns aoc2019.day4-test
  (:require [clojure.test :refer :all]
            [aoc2019.day4 :refer :all]))

(deftest test-number-is-within-bounds
  (testing "122222 should return false for bounds 500000-1000000"
    (is (false? (aoc2019.day4/meets-criteria-1? 500000 1000000 122222))))
  (testing "112222 should return true for bounds 500-2000000"
    (is (true? (aoc2019.day4/meets-criteria-1? 500 2000000 112222)))))

(deftest test-two-adjacent-digits-are-the-same
  (testing "10 should fail"
    (is (false? (aoc2019.day4/meets-criteria-1? 0 20 10))))
  (testing "12 should fail"
    (is (false? (aoc2019.day4/meets-criteria-1? 0 20 12)))))

(deftest test-digits-are-increasing
  (testing "221 should fail"
    (is (false? (aoc2019.day4/meets-criteria-1? 100 300 221)))))

(deftest test-number-of-digits-should-be-6
  (testing "12344 should fail"
    (is (false? (aoc2019.day4/meets-criteria-1? 0 66666 12344)))))

(deftest test-two-adjacent-digits-are-not-part-of-larger-group
  (testing "123444 does not meet criteria"
    (is (false? (aoc2019.day4/meets-criteria-2? 0 666666 123444)))))