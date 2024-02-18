# Tests As Demos

## Introduction
The idea here is to demonstrate a backend module without building a front end, 
but in such a way as to make clear what is going on.

First issue is to define scope.  What do we hope to demo?
1. Interactive system of okrs supporting:
   2. team navigation
   3. commenting
   4. editing/versioning okrs
   5. Team creation, insertion, and deletion
6. Kafka Event generation on updates; by types:
   7. team metadata
   8. okrs
   9. comments
10. Kafka consumers that generate okr reports from these events.  We have covered
this in fairly good detail in the HELP.md file.

## Order Of Development

1. Well, I've already started building out some "testing" for report generation for 
the team-context type report.  It is pretty informal - no asserts!  I'm just using 
the tests with breakpoints to examine the reports being generated.  For this stage
of develpment, I think that is ok.
Maybe a little more clean up on the tests around report generation are in order.

2. I would like to start building out the interactive system.
Again, we would use a testing framework to initiate the interactions; but we would 
have the hooks in place to import it into a frontend project.
   3. First step is to sketch out the functionality we want.  Not all of this needs
   to be coded.  I do have a question about versioning; do I really want to do this 
   internally or would it make sense to use available repository functionality?  Could we 
   use git to manage versions of okrs?  There is a java library called JGit.  There 
   are others too.  That might be worth its own demo. Of course, the okr objects will 
   be instances of Java classes.  So, we would presumably use serialization to json blobs. 
   Why not just use MongoDb?  Well, using MongoDB might take a bit more work to support versioning.  
   Maybe we save lists of versioned okrs?  A quick look online suggests that this is an established
   pattern.  Using a DB also solves our search problem for us.
   4. Ok, let's check out versioning on MongoDB (https://www.mongodb.com/blog/post/building-with-patterns-the-document-versioning-pattern).
   So we have some work to demonstrate CRUD on MongoDB with the versioning pattern.  Then we will also want
   to demonstrate some basic search capabilities.
   5. After we have the basics for interacting with the DB, we want display and edit features.  Of course, for now,
   pre-UI, we will likely use a test framework to validate these functions.
   6. Now, we implement our specific enterprise okr plan on top of the CRUD functionality and the basic view/edit functionality.
   I would think that we would do step 4 as a separate sandbox module; refine it separately; and bring it in as a 
   dependency... unless there is already a good CRUD library for Java and MongoDB, in which case, our separate project i
   is just for learning.