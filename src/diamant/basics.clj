(ns diamant.basics
  (:require [scad-clj.model :as model]))

(defn inner-tube
  [inner-radius thickness height]
  (model/difference
   (model/cylinder (+ inner-radius thickness) height)
   (model/cylinder inner-radius (+ 1 height))))

(defn outer-tube
  [outer-radius thickness height]
  (inner-tube (- outer-radius thickness) thickness height))