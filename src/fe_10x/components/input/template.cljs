(ns fe-10x.components.input.template
  (:require [fe-10x.components.button.icon :as btn-icon]))

(defn rand-str [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 65))))))

;; attribut label, input value, input type, require?, disabled?, error, event
(defn label [_]
  (let [rand (rand-str 20)]
    (fn [{:keys [labl value type req? dis? err? evnt]}]
      [:div {:class (clojure.string/join " " ["slds-form-element"
                                              (when (:error? err?) "slds-has-error")])}
       [:label {:class "slds-form-element__label"
                :for rand}
        (when req? [:abbr {:class "slds-required"} "* "])
        labl]
       [:div {:class "slds-form-element__control slds-p-top_xx-small"}
        [:input (merge {:class "slds-input"}
                       {:id rand}
                       {:type type}
                       {:value value}
                       {:placeholder labl}
                       (when dis? {:disabled true})
                       {:on-change evnt})]]
       (when (:error? err?) [:div {:class "slds-form-element__help"} (:mesg err?)])])))

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