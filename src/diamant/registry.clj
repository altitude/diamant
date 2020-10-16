(ns diamant.registry
  (:require [diamant.export :as export]))

(def parts (atom {}))

(def live false)

(defn set-live-mode
  [v]
  (def live v))

(defn defpart
  [name part & {:keys [write] :or {write live}}]
  (swap! parts assoc name part)
  (if write
    (export/write part)
    nil))

(defn getparts
  ([]
   @parts)
  ([& names]
   (->>
    (select-keys @parts names)
    (vals))))