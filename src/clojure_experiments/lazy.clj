(ns clojure-experiments.lazy)



;;; lazy-seq are chunked in batches of 32
;;; do not rely on lazy-seq to trigger side effect calls
(defn print-inc [num]
  (println "Incrementing: " num)
  (inc num))

(take 3 (map print-inc (range 1 10000)))
;; => (2 3 4)
;;
;; this will print from 1 to 32
