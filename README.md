# Clojure-KT2
### :fire: Example virtual plotter work!

---

PS C:\NewSemester\Clojure\Clojure-KT2> clj
Clojure 1.11.2
user=> (load-file "plotter.clj")

This program simulates a plotter moving in 2D space and drawing shapes.

Available commands:

(plotter-process) --- Start the plotter simulation.

"----------------------------"
user=> (plotter-process)


Lowering the carriage

...Draw a line from (0.0, 0.0) т (100, 0) use black color.

Turn to 120.0 degrees

...Draw a line from (100, 0) т (50, 87) use black color.

Turn to 120.0 degrees

...Draw a line from (50, 87) т (0, 0) use black color.

Turn to 120.0 degrees


Raise the carriage

Set the carriage position to (10.0, 10.0).

Install red line color.


Lowering the carriage

...Draw a line from (10.0, 10.0) т (90, 10) use red color.

Turn to 90.0 degrees

...Draw a line from (90, 10) т (90, 90) use red color.

Turn to 90.0 degrees

...Draw a line from (90, 90) т (10, 90) use red color.

Turn to 90.0 degrees

...Draw a line from (10, 90) т (10, 10) use red color.

Turn to 90.0 degrees


Raise the carriage
nil

---