# Spring Boot + Kotlin + CRA

This is Boilerplate for application using Spring Boot, Kotlin, and CRA(Create React App).

---

### Target
- Serving web contents and API on a single server
- Integrate build process of React and SpringBoot by Gradle 
- Separate source directory of Frontend(CRA) and Backend(SpringBoot)


### Environment
- Java 11
- Spring Boot 2.7.1
- Kotlin 1.6.21

*This is not mandatory! You can adjust it to your environment*

### Getting Started
move to 'backend' directory and execute
```bash
$ gradle bootRun
```
or if there is no gradle
```bash
$ gradlew bootRun
```

### Note
- Most familiar CRA structures can be used as they are, and node package management using npm is also possible. 
- React can be built separately. This is very useful for dev
- It is free from CORS because it operates as a single spring boot application