(ns diamant.export
  (:require [scad-clj.scad :as scad]))

(defn write
  ([block] (write "model.scad" block))
  ([name block] (->>
   block
   (scad/write-scad)
   (spit name))))