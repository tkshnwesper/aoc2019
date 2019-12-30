(ns aoc2019.day4)

(def inputs '(172930 683082))

(defn meets-criteria-1?
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

(defn meets-criteria-2?
  [lower-bound upper-bound number]
  (let [number-string (.toString number)]
    (and
     (= (count number-string) 6)
     (and
      (>= number lower-bound)
      (<= number upper-bound))
     (not (empty? (filter
                   (partial = 2)
                   (map
                    (comp count first)
                    (re-seq #"(\d)\1+" number-string)))))
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
     ((apply partial meets-criteria-1? inputs) i)))))

(defn day4-part2-solution 
  []
  (count
   (filter true? (for [i (apply range inputs)]
                   ((apply partial meets-criteria-2? inputs) i)))))