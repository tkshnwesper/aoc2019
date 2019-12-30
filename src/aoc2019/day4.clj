(ns aoc2019.day4)

(def inputs '(172930 683082))

(defn meets-criteria?
  [lower-bound upper-bound number]
  (let [number-string (.toString number)]
    (and
     (= (count number-string) 6)
     (and
      (>= number lower-bound)
      (<= number upper-bound))
     (not (nil? (re-find #"(\d)\1" number-string)))
     (not (nil? (re-find
                 (re-pattern (str
                              "^"
                              (apply str (for [i (range 1 10)]
                                           (str (.toString i) "*")))
                              "$"))
                 number-string))))))

(defn day4-part1-solution 
  []
  (count
   (filter true? (for [i (apply range inputs)]
     ((apply partial meets-criteria? inputs) i)))))