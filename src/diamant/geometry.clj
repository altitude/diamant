(ns diamant.geometry
  (:require [scad-clj.model :as model]))

(defn circleify
  "Copy object count times around a circle of the given radius"
  [radius count object]
  (let [angle (/ (* 2 Math/PI) count)]
    (->>
     (range count)
     (map #(->>
            object
            (model/translate [radius 0 0])
            (model/rotate [0 0 (* angle %1)]))))))