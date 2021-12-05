# Read Me First

The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Spring Configuration Processor, Rest
  Repositories HAL Explorer, MS SQL Server Driver, Rest Repositories, Spring HATEOAS, Vaadin, Spring Boot DevTools,
  Spring Web Services, Jersey'. As a result, your application may not work as expected.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-spring-hateoas)
* [Vaadin](https://vaadin.com/spring)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-sql)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#using-boot-devtools)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-webservices)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/2.6.1/reference/html/spring-boot-features.html#boot-features-r2dbc)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jersey)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Creating CRUD UI with Vaadin](https://spring.io/guides/gs/crud-with-vaadin/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Acessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)

### Additional Links

These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#spring-aot-maven)
* [R2DBC Homepage](https://r2dbc.io)

## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started with Spring
Native. Docker should be installed and configured on your machine prior to creating the image,
see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-buildpacks)
.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 GeekTextSC:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image. The GraalVM
native-image compiler should be installed and configured on your machine,
see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-native-build-tools)
.

To create the executable, run the following goal:

```
$ ./mvnw package -Pnative
```

Then, you can run the app as follows:

```
$ target/GeekTextSC
```
