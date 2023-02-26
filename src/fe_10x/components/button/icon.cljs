(ns fe-10x.components.button.icon
  (:require [fe-10x.components.button.template :as btn]
            [reagent.core :as r]))

;; variant
(defn base [icon disb]
  [btn/icon {:icns {:icon icon} :dis? disb}])

;; container
(defn bare [icon disb]
  [btn/icon {:icns {:icon icon :cont "bare"} :dis? disb}])
(defn fill [icon disb]
  [btn/icon {:icns {:icon icon :cont "filled"} :dis? disb}])
(defn border [icon disb]
  [btn/icon {:icns {:icon icon :cont "bordered"} :dis? disb}])
(defn inverse [icon disb]
  [btn/icon {:icns {:icon icon :cont "inverse"} :dis? disb}])

;; tooltips
(defn tooltips [mesg]
  (let [open? (r/atom false)]
    (fn []
      [:div {:style {:position "relative"}}
       [:div {:on-click #(swap! open? not)}
        [btn/icon {:icns {:icon "info"} :dis? false}]]
       [:div {:class "slds-popover slds-popover_tooltip slds-nubbin_bottom-left"
              :style {:position "absolute"
                      :bottom "32px"
                      :left "-16px"
                      :display (if @open? "flex" "none")
                      :width "200px"}
              :role "tooltip"}
        [:div {:class "slds-popover__body"}
         mesg]]])))