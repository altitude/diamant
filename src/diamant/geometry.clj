(ns diamant.geometry
  (:require [scad-clj.model :as model]))

(defn circleify
  "Copy object n times around a circle of the given radius"
  [radius n object]
  (let [angle (/ (* 2 Math/PI) n)
        obj (if (vector? object) object [object])]
    (->>
     (range n)
     (map #(->>
            (get obj (mod %1 (count obj)))
            (model/translate [radius 0 0])
            (model/rotate [0 0 (* angle %1)]))))))

(defn symmetry
  [block]
  (->>
   [-1 1]
   (map #(->>
          block
          (model/scale [%1 1 1])))
   (apply model/union)))