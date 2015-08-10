# NBR-FX
This is the Java FX GUI for NBR project

# Prerequisites

* (0) [NBR-core Project] (http://github.com/frawla/NBR-core.git)
* (1) Java 8
* (2) Gradle 2.4 
* (3) Maven 3.0.4
* (4) Eclipse IDE Kepler with Java 8 support of Luna


# How to Run
Two choices are available, either with Maven or Gradel.
--
* Maven 
	
** Change to `/NBR-FX` directory and execute: `mvn run`

*Gradle 
** Change to `/NBR-FX` directory and execute: `gradle run`

# How to Prepare the source code for Eclispe IDE

Execute the follwoing commands 
--
* (1) $ gradle eclipse 
* (2) $ gradle config


# Common Issues

* (1) Overriding method `initialize` of interface `Initializable` by class `NetConfigController` may cause compile-time error.
	How to solve it?
	TODO

	
