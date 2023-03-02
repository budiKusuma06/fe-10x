(ns fe-10x.components.input.label
  (:require [fe-10x.components.input.template :as label]))

(defn label [_]
  (let []
    (fn [labl value type req? dis? err? evnt]
      [label/label {:labl labl :value value :type type :req? req? :dis? dis? :err? err? :evnt evnt}])))