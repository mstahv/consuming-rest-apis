# Consuming REST services from a Java app

A simple JAX-RS Client usage example. Fetches weather data from a openweathermap.org and displays that on a simple Vaadin UI. See the related article, [consuming REST servevices from Java apps](https://vaadin.com/blog/-/blogs/consuming-rest-services-from-java-applications).

To run the example, **get a free API key** from [openweathermap.com](http://openweathermap.org/api) and put it to file **src/main/resources/META-INF/apache-deltaspike.properties**

Use a JAX-RS 2.0 compatible server (~ Java EE 7 ) to deploy the app. Wildfly plugin is in the pom.xml, so an easy method is just to execute:

```
mvn wildfly:run
```
