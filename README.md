# Consuming REST services from a Java app

A simple JAX-RS Client usage example. Fetches weather data from a openweathermap.org and displays that on a simple Vaadin UI.

Use a JAX-RS 2.0 compatible server (~ Java EE 7 ) to deploy the app. Wildfly plugin is in the pom.xml, so an easy method is just to execute:

```
mvn wildfly:run
```
