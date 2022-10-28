# Getting Started

## OKRs demo 0

### Introduction
Our goal is to demonstrate a system for sharing OKRs across an enterprise.

There are three parts to this demonstration:
1. reports - automatically generated and delivered when new OKRs are added and when OKRs are updated
2. backend for handling and delivering events (creation and updating of OKRs)
3. interactive system for navigating OKR team nodes; and for supporting comment streams.

The proposed workflow is that users can navigate team nodes via a UI; with edges indicating accountability. 
People can leave comments, and can respond to existing comments, at the level of stated objectives and key results.

Changes to objectives or key results for a team triggers events which are propagated down the 
accountability edges; additionally, people can subscribe to receive events from particular teams.  

Reports provide an organized set of team-level OKRs (along accountability edges and via intentional subscription), along with time of last update, and links back to the interactive enterprise 
OKR system. 



We are starting very simply, showing what a report might look like, and how it might be automatically
generated from create/update events.


The event backend is still in flux.  I am looking at using Kafka; providing several endpoints
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

The interactive OKR system is also presently still in a lot of flux.  I am starting to build out the 
objects needed to support it, but have not yet made any decisions about UI or DB technology for it.

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

