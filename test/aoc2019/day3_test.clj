(ns aoc2019.day3-test
  (:require [clojure.test :refer :all]
            [aoc2019.day3 :refer :all]))

(deftest day3-part1-test
  (testing "empty output when inputs are empty"
    (is (= (aoc2019.day3/find-closest-intersection '() '()) nil)))
  (testing "when overlap happens in up direction"
    (is (= (aoc2019.day3/find-closest-intersection '(U1) '(U1)) 1)))
  (testing "when overlap happens in right direction"
    (is (= (aoc2019.day3/find-closest-intersection '(R1) '(R1)) 1)))
  (testing "when intersection happens at (1, 1)"
    (is (= (aoc2019.day3/find-closest-intersection '(U1 R1) '(R1 U1)) 2)))
  (testing "when intersection happens at (-1, -1)"
    (is (= (aoc2019.day3/find-closest-intersection '(L2 D1) '(D1 L2)) 3)))
  (testing "sample test case 1"
    (is (=
         (aoc2019.day3/find-closest-intersection
          '(R75 D30 R83 U83 L12 D49 R71 U7 L72)
          '(U62 R66 U55 R34 D71 R55 D58 R83))
         159)))
  (testing "sample test case 2"
    (is (=
         (aoc2019.day3/find-closest-intersection
          '(R8 U5 L5 D3)
          '(U7 R6 D4 L4))
         6))))

(deftest day3-part2-test
  (testing "sample test case 1"
    (is (= (aoc2019.day3/find-least-number-of-steps-to-intersection
            '(R75 D30 R83 U83 L12 D49 R71 U7 L72)
            '(U62 R66 U55 R34 D71 R55 D58 R83))
           610))))