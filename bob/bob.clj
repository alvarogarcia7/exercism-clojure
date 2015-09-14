(ns bob)

(defn- has-question? [question]
  (re-matches #".*\?" question))


(defn- re-matches-contains [regex text]
  (re-matches (re-pattern (str ".*" regex ".*")) text))

(defn- is-shouting? [question]
  (and (re-matches-contains "[A-Z]+" question)
       (not (re-matches-contains "[a-z]+" question))))

(defn- blank? [question]
  (= "" (clojure.string/trim question)))

   
(defn response-for [question]
  (cond
    (is-shouting? question) "Whoa, chill out!"
    (has-question? question) "Sure."
    (blank? question) "Fine. Be that way!"
    :else "Whatever."))

