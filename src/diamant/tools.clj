(ns diamant.tools
  (:require [scad-clj.model :as model]))

(defn slice
  [block]
  (model/difference
   block
   (let [s 500]
     (->>
      (model/cube s s s)
      (model/translate [(/ s 2) 0 0])))))