(ns some-pedestal.core
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))



(defn respond-hello [request]
  {:status 200 :body "hola desde aqui... bye bye no"})






;; (defn stop-server []
;;   (http/stop server))


(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(defn create-server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/join? true
    ::http/port 8989}))

(def server (http/start (create-server)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
