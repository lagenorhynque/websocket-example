(ns websocket-example.core)

(defn mount-components []
  (let [content (js/document.getElementById "app")]
    (while (.hasChildNodes content)
      (.removeChild content (.-lastChild content)))
    (.appendChild content (js/document.createTextNode "Welcome to websocket-example"))))

(defn init! []
  (mount-components))
