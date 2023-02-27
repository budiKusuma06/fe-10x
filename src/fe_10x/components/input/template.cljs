(ns fe-10x.components.input.template
  (:require [fe-10x.components.button.icon :as btn-icon]))

(defn rand-str [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 65))))))

(defn label [{:keys [labl value type evnt]}]
  (let [rand (rand-str 20)]
    (fn [{:keys [labl type]}]
      (println value)
      [:div {:class "slds-form-element"}
       [:label {:class "slds-form-element__label"
                :for rand}
        labl]
       [:div {:class "slds-form-element__control slds-p-top_xx-small"}
        [:input (merge {:class "slds-input"}
                       {:id rand}
                       {:type type}
                       {:placeholder labl}
                      ;;  {:value value}
                       {:on-change evnt}
                       )]]])))

(defn tooltips [{:keys [labl mesg type]}]
  (let [rand (rand-str 20)]
    (fn []
      [:div {:class "slds-form-element"}
       [:label {:class "slds-form-element__label"
                :for rand}
        labl]
       [:div {:class "slds-form-element__icon"}
        [btn-icon/tooltips mesg]]
       [:div {:class "slds-form-element__control slds-p-top_xx-small"}
        [:input {:class "slds-input"
                 :id rand
                 :type type
                 :placeholder labl}]]])))