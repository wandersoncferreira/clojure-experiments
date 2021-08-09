(ns clojure-experiments.every
  "Every? is an interesting function with some gotchas! The vacuous truth is one of them")


;;; vacuous truth -- https://en.wikipedia.org/wiki/Vacuous_truth
;; ok exemple
(every? string? ["string1"]);; => true

;; ok example
(every? string? [1 2 3]);; => false

;; weird!
(every? string? []) ;; => true
;; as there is no single element string, then every element is a string...

;; make sure to test the empty case separately
(and (every? string? []) (seq [])) ;; => nil
