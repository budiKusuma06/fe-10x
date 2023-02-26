(ns fe-10x.components.input.label
  (:require [fe-10x.components.input.template :as label]))

(defn label [labl type]
  (label/label {:labl labl :type type}))