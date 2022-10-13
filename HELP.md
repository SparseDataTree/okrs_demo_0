# Getting Started

## OKRs demo 0

### Introduction
We are starting very simply, with several exposed endpoints
* createTopic(String topicName)
* writeToTopic(String topicName, String message)  
* listTopics()
* addParent(String topicName, String parent)
* getReport(String topicName)

Eventually (in a later demo), we will also want:
* addComment(String topicName, String comment)
* createUser(String name)... maybe a DB for this?
* login(String name, password?)  
* deleteTopic(String topicName)

## Backend
I'm still mulling over what would be a good first step.
Maybe just concatentate the latest messages.

But let's call out some of the functionality we want eventually:
* authorization to add messages to a topic
* ability for anyone to add comments to a topic (different from messages). Not sure if we want parallel topics or if we want topics with labels.  I need to learn more about this.
* auto-update for report updates - sent to email.
* how do we confirm identity?  cookies?  login?
* event objects rather than just text.  Add metadata, like who wrote what.

## Front end.
Just the rest endpoint for now, but perhaps eventually a UI for endpoints; and to navigate the topic tree; and to see reports


### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-kafka)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

