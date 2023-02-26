(ns fe-10x.components.input.icon
  (:require [fe-10x.components.input.template :as label]))

(defn tooltips [labl mesg type]
  [label/tooltips {:labl labl :mesg mesg :type type}])