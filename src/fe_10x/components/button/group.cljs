(ns fe-10x.components.button.group
  (:require [fe-10x.components.button.template :as btn]))

(defn label [menu sume]
  [btn/group-label {:menu menu :sume sume}])