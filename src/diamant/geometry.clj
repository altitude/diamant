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

(defn tile-square
  "Copy object on a square grid of given spacing"
  [spacing count-x count-y object]
  (->>
   (for [x (range count-x) y (range count-y)]
     (->>
      object
      (model/translate [(* x spacing) (* y spacing) 0])))))

(defn tile-hex
  "Copy object on a hexagonal grid of given spacing"
  [spacing count-x count-y object]
  (let [t (/ spacing 1.73205080757)]
    (->>
     (for [x (range count-x) y (range count-y)]
       (model/translate
        [(+ (* x spacing) (if (odd? y) (/ spacing 2) 0))
         (* y t 1.5)
         0]
        object)))))
