(ns bob
  [:require [clojure.string :refer [trim]]])

(defn- has-question? [question]
  (re-matches #".*\?" question))

(defn- re-matches-contains [regex text]
  (re-matches (re-pattern (str ".*" regex ".*")) text))

(defn- is-shouting? [text]
  (and (re-matches-contains "[A-Z]+" text)
       (not (re-matches-contains "[a-z]+" text))))

(defn- blank? [question]
  (= "" (trim question)))

(defn response-for [question]
  (cond
    (is-shouting? question) "Whoa, chill out!"
    (has-question? question) "Sure."
    (blank? question) "Fine. Be that way!"
    :else "Whatever."))

