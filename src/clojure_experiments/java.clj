(ns clojure-experiments.java
  (:import [java.nio.file Files CopyOption]
           [java.util Comparator]
           ))

;; interesting talk from Ghadi Shayban named 'Java Made (Somewhat) Simple'
;; https://youtu.be/-zszF8bbXM0

;; Brian Goetz <-- look for this guy
;; Mark Reinhold <--
;; John Rose (Oracle) <--
;; Doug Lea


;; -- calling a varargs in java via interop
;; public static Path copy(Path source, Path target, CopyOptions ... options)
;; using arrays
(comment
  (let [source "" target ""]
    (Files/copy source target (make-array CopyOption 0))
    (Files/copy source target (into-array CopyOption []))))


;; erasure: ignore the bracketed things
(reify Comparator
  (compare [_ o1 o2]))

;; these classes comes from different classloaders
(defrecord MyInfo [a b c])
(def a (->MyInfo 1 2 3))

(defrecord MyInfo [a b c])
(def b (->MyInfo 1 2 3))

(= (class a) (class b))
;; => false
