(ns fe-10x.components.input.label
  (:require [fe-10x.components.input.template :as label]))

(defn label [labl value type evnt]
  (let []
    (fn [labl type]
      [label/label {:labl labl :value value :type type :evnt evnt}])))