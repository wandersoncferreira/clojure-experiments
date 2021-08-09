(ns clojure-experiments.tap)

(add-tap println)

(defn spy [v]
  (tap> v)
  v)

(->> (range 1 20)
     (map inc)
     (spy)
     (filter even?)
     )

(defn print-odd-values [v]
  (when (seq? v)
    (println (filter odd? v))))

(remove-tap println)
(add-tap print-odd-values)

;; only one tap at a time! if you register a function with `add-tap`, you need
;; to remove it (`remove-tap`) before adding a new one.
