(ns bob
  [:require [clojure.string :refer [trim]]])

(defn- ends-in-question? [question]
  (re-matches #".*\?" question))

(defn- re-contains [regex text]
  (re-matches (re-pattern (str ".*" regex ".*")) text))

(defn- is-shouting? [text]
  (and (re-contains "[A-Z]+" text)
       (not (re-contains "[a-z]+" text))))

(defn- blank? [text]
  (= "" (trim text)))

(defn response-for [question]
  (cond
    (is-shouting? question) "Whoa, chill out!"
    (ends-in-question? question) "Sure."
    (blank? question) "Fine. Be that way!"
    :else "Whatever."))

