(ns bob)

(defn- has-question? [question]
  (re-matches #".*\?" question))

(defn- is-shouting? [question]
  (and (re-matches #".*[A-Z]+.*" question)
       (not (re-matches #".*[a-z]+.*" question))))

   
(defn response-for [question]
  (cond
    (is-shouting? question) "Whoa, chill out!"
    (has-question? question) "Sure."
    :else "Whatever."))

