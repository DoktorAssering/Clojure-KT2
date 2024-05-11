(defn info []
  (do
    (println "\nThis program simulates a plotter moving in 2D space and drawing shapes.")
    (println "\nAvailable commands:")
    (println "\n(plotter-process) --- Start the plotter simulation.\n")
    "----------------------------"))

(defn draw-line [from to color]
  (println (str "\n...Draw a line from (" (:x from) ", " (:y from) ") в (" (:x to) ", " (:y to) ") use " color " color.")))

(defn calc-new-position [distance angle current]
  (let [angle-in-rads (* angle (/ Math/PI 180.0))]
    {:x (Math/round (+ (:x current) (* distance (Math/cos angle-in-rads))))
     :y (Math/round (+ (:y current) (* distance (Math/sin angle-in-rads))))}))

(defn move [distance current-state]
  (let [new-position (calc-new-position distance (:angle current-state) (:position current-state))]
    (if (= (:carriageState current-state) :DOWN)
      (draw-line (:position current-state) new-position (:color current-state))
      (println (str "\n...Move to " distance " from point (" (:x (:position current-state)) ", " (:y (:position current-state)) ")"))) 
    {:position new-position
     :angle (:angle current-state)
     :color (:color current-state)
     :carriageState (:carriageState current-state)}))

(defn turn [angle current-state]
  (println (str "\nTurn to " angle " degrees"))
  {:position (:position current-state)
   :angle (+ (:angle current-state) angle)
   :color (:color current-state)
   :carriageState (:carriageState current-state)})

(defn carriage-up [current-state]
  (println "\n\nRaise the carriage")
  {:position (:position current-state)
   :angle (:angle current-state)
   :color (:color current-state)
   :carriageState :UP})

(defn carriage-down [current-state]
  (println "\n\nLowering the carriage")
  {:position (:position current-state)
   :angle (:angle current-state)
   :color (:color current-state)
   :carriageState :DOWN})

(defn set-color [color current-state]
  (println (str "\nInstall " color " line color."))
  {:position (:position current-state)
   :angle (:angle current-state)
   :color color
   :carriageState (:carriageState current-state)})

(defn set-position [position current-state]
  (println (str "\nSet the carriage position to (" (:x position) ", " (:y position) ")."))
  {:position position
   :angle (:angle current-state)
   :color (:color current-state)
   :carriageState (:carriageState current-state)})

(defn draw-triangle [size current-state]
  (let [states (range 3)] 
    (let [updated-state (carriage-down current-state)] 
      (let [final-state (reduce (fn [state step]
                                  (->> state
                                       (move size)
                                       (turn 120.0)))
                                updated-state
                                states)]
        (carriage-up final-state))))) 

(defn draw-square [size current-state]
  (let [states (range 4)] 
    (let [updated-state (carriage-down current-state)]
      (let [final-state (reduce (fn [state _]
                                  (->> state
                                       (move size)
                                       (turn 90.0)))
                                updated-state
                                states)]
        (carriage-up final-state))))) 

(defn plotter-process []
  (let [init-position {:x 0.0 :y 0.0}
        init-color "black"
        init-angle 0.0
        init-carriageState :UP]

    (let [plotter-state {:position init-position
                         :angle init-angle
                         :color init-color
                         :carriageState init-carriageState}
          plotter-state(draw-triangle 100.0 plotter-state)
          plotter-state (set-position {:x 10.0 :y 10.0} plotter-state)
          plotter-state (set-color "red" plotter-state)
          plotter-state (draw-square 80.0 plotter-state)]
      )))

(info)