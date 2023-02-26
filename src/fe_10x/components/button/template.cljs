(ns fe-10x.components.button.template
  (:require [reagent.core :as r]))

(defn icon [{:keys [vart icns dis?]}]
  [:button (merge {:class (clojure.string/join " " ["slds-button slds-button_icon"
                                                    (cond
                                                      (= (:cont icns) "bare") "slds-button_icon-container"
                                                      (= (:cont icns) "filled") "slds-button_icon-border-filled"
                                                      (= (:cont icns) "bordered") "slds-button_icon-border"
                                                      (= (:cont icns) "inverse") "slds-button_icon-border-inverse")
                                                    (when vart (str "slds-button_icon-" vart))])}
                  {:style {:display "flex"
                           :justify-content "center"
                           :align-items "center"}}
                  (when dis?
                    {:disabled true}))

   [:svg {:class "slds-button__icon"
          :aria-hidden true}
    [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#" (:icon icns))}]]])


(defn label [{:keys [labl vart dis?]}]
  [:button (merge {:class (clojure.string/join " " ["slds-button"
                                                    (when vart (str "slds-button_" vart))])}
                  {:style {:display "flex"
                           :justify-content "center"
                           :align-items "center"}}
                  (when dis?
                    {:disabled true}))
   labl])

(defn label-lt [{:keys [labl vart icns dis?]}]
  [:button (merge {:class (clojure.string/join " " ["slds-button"
                                                    (when vart (str "slds-button_" vart))])}
                  {:style {:display "flex"
                           :justify-content "center"
                           :align-items "center"}}
                  (when dis?
                    {:disabled true})) 
   [:svg {:class "slds-button__icon slds-button__icon_left"
          :aria-hidden true}
    [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#" (:icon icns))}]]
   labl])

(defn label-rt [{:keys [labl vart icns dis?]}]
  [:button (merge {:class (clojure.string/join " " ["slds-button"
                                                    (when vart (str "slds-button_" vart))])}
                  {:style {:display "flex"
                           :justify-content "center"
                           :align-items "center"}}
                  (when dis?
                    {:disabled true}))
   labl
   [:svg {:class "slds-button__icon slds-button__icon_right"
          :aria-hidden true}
    [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#" (:icon icns))}]]])

(defn group-label [{:keys [menu sume]}]
  (let [menu (r/atom menu)
        sume (r/atom sume)
        open? (r/atom false)] 
    (fn []
      [:div {:class "slds-button-group"
             :role "group"}
       (->> @menu
            (map (fn [{:keys [labl]}]
                   (label {:labl labl :vart "neutral"}))))
       (when-not (nil? sume) [:div {:class (clojure.string/join " " ["slds-dropdown-trigger slds-dropdown-trigger_click slds-button_last"
                                                                     (when @open? "slds-is-open")])}
                              [:button (merge {:class "slds-button slds-button_icon slds-button_icon-border-filled"}
                                              {:on-click (fn []
                                                           (swap! open? not))}
                                              {:style {:disrplay "flex"
                                                       :justify-content "center"
                                                       :align-items "center"}})

                               [:svg {:class "slds-button__icon"
                                      :aria-hidden true}
                                [:use {:xlink-href (str "/assets/icons/utility-sprite/svg/symbols.svg#threedots")}]]]
                              [:div {:class "slds-dropdown slds-dropdown_right slds-dropdown_actions"}
                               [:ul {:class "slds-dropdown__list"
                                     :role "menu"}
                                (->> @sume
                                     (map (fn [{:keys [labl]}]
                                            [:li {:class "slds-dropdown__item"
                                                  :role "presentation"}
                                             [:a {:href "#"
                                                  :role "menuitem"}
                                              [:span {:class "slds-truncate"
                                                      :title labl}
                                               labl]]])))]]])])))