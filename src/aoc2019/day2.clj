(ns aoc2019.day2
  (:gen-class))

(def inputs (list 1 12 2 3 1 1 2 3 1 3 4 3 1 5 0 3 2 1 6 19 1 5 19 23 1 23 6 27 1 5 27 31 1 31 6 35 1 9 35 39 2 10 39 43 1 43 6 47 2 6 47 51 1 5 51 55 1 55 13 59 1 59 10 63 2 10 63 67 1 9 67 71 2 6 71 75 1 5 75 79 2 79 13 83 1 83 5 87 1 87 9 91 1 5 91 95 1 5 95 99 1 99 13 103 1 10 103 107 1 107 9 111 1 6 111 115 2 115 13 119 1 10 119 123 2 123 6 127 1 5 127 131 1 5 131 135 1 135 6 139 2 139 10 143 2 143 9 147 1 147 6 151 1 151 13 155 2 155 9 159 1 6 159 163 1 5 163 167 1 5 167 171 1 10 171 175 1 13 175 179 1 179 2 183 1 9 183 0 99 2 14 0 0))

(defn- get-operator
  [op-code]
  (case op-code
    1 +
    2 *
    99 'noop))

(defn- get-operand
  [ord initial-index complete-list]
  (let [location (+ ord initial-index)]
    (nth complete-list (nth complete-list location))))

(defn transform-list
  [input-list initial-index]
  (let [operator (get-operator (nth input-list initial-index))]
    (if (= operator 'noop)
      input-list
      (let [first-operand (get-operand 1 initial-index input-list)
            second-operand (get-operand 2 initial-index input-list)
            output-index (nth input-list (+ initial-index 3))
            result (operator first-operand second-operand)
            split-list (split-at output-index input-list)]
        (transform-list
         (concat
          (first split-list)
          (concat (list result) (rest (second split-list))))
         (+ 4 initial-index))))))

(defn get-noun-and-verb
  [input-list target]
  (remove
   nil?
   (let [minimum (min (count input-list) 100)] 
     (for [noun (range minimum)
           verb (range minimum)]
       (let [result (transform-list (assoc (vec input-list) 1 noun 2 verb) 0)]
         (when (= (first result) target)
           (list (nth result 1) (nth result 2))))))))

(defn day2-part1-solution [] (transform-list inputs 0))
(defn day2-part2-solution 
  [] 
  (let [result (first (get-noun-and-verb inputs 19690720))
        noun (first result)
        verb (second result)]
    (+ (* 100 noun) verb)))
