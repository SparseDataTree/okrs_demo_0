# Getting Started

## OKRs demo 0

### Introduction
Our goal is to demonstrate a system for sharing OKRs across an enterprise.



### There are three parts to this demonstration:
1. reports - automatically generated and delivered when new OKRs are added and when OKRs are updated
2. backend for handling and delivering events (creation and updating of OKRs)
3. interactive system for navigating OKR team nodes; and for supporting comment streams.

### There are four parts to the reporting system:
1. **team-specific** reports that are generated with each new comment on team OKRs.  (These are triggered by comments or OKR changes for a team.)
2. **enterprise-comment-radar** report of which teams OKRs have new comments. (These are chron jobs that report blocks of comments added during a time interval - maybe daily)
3. **team-contextual** reports that give the OKR context (full upstream OKRs plus team-specific subscriptions), not including comments. (I'm thinking that these could be chron jobs too.)
4. **manager-contextual** reports that give the OKR updates for all teams directly reporting to a manager.

The first two types of reports are accessible to anyone.  (For the third report, the main value of it is for members of the team in context; but people interested in getting reports of updates to a team's OKRs can subscribe to that team.)

#### The proposed workflow is:
1. users can navigate team nodes via a UI; with edges indicating accountability (e.g. management hierarchy). 
2. People can leave comments, and can respond to existing comments, at the level of stated objectives and key results.
3. Comments can lead to threads of discussion.
4. New Versions of OKRs can be generated.  The unit of versioning is: one objective and an associated set of key results.

#### What about insertion or deletion of teams?  That is not part of the initial demo.

#### Events:
1. New comment:  this contributes to two kinds of events: team-specific reports (at the level of a specific objective and its key results.), and enterprise radar (which is a chron job)
2. Changes to objectives or key results for a team triggers an event which may be integrated into a Kafka topic consumer so that it is propagated down the 
accountability edges; and additionally to any subscribers.  

Team-contextual reports provide an organized set of team-level OKRs (along accountability edges and via intentional subscription), along with time of last update, and links back to the interactive enterprise 
OKR system.

I am starting very simply (perhaps just with the team-contextual reports), showing what a report might look like, and how it might be automatically
generated from create/update events.  I am also starting with unformatted reports.  As further development is warranted, it 
would be interesting to consider making, perhaps, html or md reports.


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


### Comments
I am considering making comments parts of specific versions of objectives or key results.
This is not the only way this could be done.  Lots of learning to do.

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

