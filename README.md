# Gitterific Application - SOEN 6441 Fall 2021 Project

# Assignment 1
The overall goal is to develop a web application that can analyze the content on GitHub using its REST API.1 The group part contains the setup of the overall framework for this web app, as well as a simple web interface that takes a string with one or multiple search keywords (input text field at top of the page, see Figure 1) and then displays the latest repositories matching the keyword(s) below the search field. Each match must include the name of the repository’s author and (if available) topics for the repository. Note that you have to search for the whole phrase (and not each keyword individually).

The user has to be able to enter new search terms on the output page, which will result in 10 more results being displayed (i.e., a second search will add 10 more results above the 10 results from the first search and so on – see Figure 2). Keep at most 10 search queries, removing the oldest when more searches are performed.

Gitterific page after two searches, showing two sets of results with 10 repositories each. You have to use the (free) GitHub REST API to access the information, see https://docs.github.com/en/rest. Process the results using the Java 8+ Streams API to add hyperlinks to user profiles, repository locations, and topics (used in the individual parts detailed below). Note: for this assignment, you do not need to stream updates to the user interface. In other words, the front-end page is static until a “refresh” (or new search) is triggered. Individual Part (50%). In addition to the group part above, each team member has to work on one of the following features. Your team has to decide who works on which part – two members cannot work on the same task!

a) User Profile: Create a web page containing all available public profile information about a user, as well as all the other repositories of that user. This profile page must be hyperlinked from the user name from the results on the main search page. The repositories must be hyperlinked to their profile page from part b) below.
b) Repository Profile: Create a web page containing all available details for a repository. List the 20 latest issues of that repository with their information and hyperlink the issues statistics page from part c) below. Also hyperlink the names of the collaborators of the repository to their user profile page from part a) above and add a hyperlink to the commit page from part e) below.
c) Repository Issues: For a repository, fetch the available issues and compute a word-level statistics of the issue titles, counting all unique words in descending order (by frequency of the words). This statistics page must be hyperlinked from the repository profile page from task b) above. You must use the Java 8 Streams API to process the issues.
d) Topics: For a topic2 (hyperlinked from the results in the search results), display the 10 latest repositories containing this topic, in the same format as the results on the main search page.
e) Repository Commits: For a repository (hyperlinked from the repository page of task b) above), fetch the 100 newest commits and compile statistics about: (i) the top-10 committers, i.e., users who had the most commits, where you hyperlink the user to the profile page from task a) and show the total number of commits of that user as a number (n) next to the name; (ii) the minimum, maximum, and average number of additions and deletions across all these commits. You must use the Java 8 Streams API to compute the commits statistics.

# Assignment 2
Your task is to modify your Play application from Assignment #1 to make it a reactive server-push app, i.e., stream live updates to the user interface. Thus, instead of having a static list of information for the search keywords, your application will now dynamically update, by showing new incoming information. When starting a new search, immediately populate the 10 latest results, then append any new incoming information matching the search keywords. Note: when searching repositories, “newest” refers to the updated sort option. You must implement this reactive behavior as an asynchronous server-push solution, using WebSockets and Akka Actors. In particular, a solution where you simply refresh (parts of) a page using, e.g., AJAX on the client side will not be accepted. Depending on your solution, you might have to filter incoming information for duplicates (that is, make sure you do not show the same information multiple times in case there are no new information for a set of search keywords).

The individual part is a continuation of your work from Assignment #1. You have to create a new Akka Actor to perform the same operation as defined in Assignment #1, together with appropriate message classes and unit tests (see the coding guidelines below for details). Note: here you can, but do not have to, define an additional supervisor for your actor (in the group part, you must have a supervisor actor).


To follow the steps in this tutorial, you will need the correct version of Java and a build tool. You can build Play projects with any Java build tool. Since sbt takes advantage of Play features such as auto-reload, the tutorial describes how to build the project with sbt. 

Prerequisites include:

* Java Software Developer's Kit (SE) 1.8 or higher
* sbt 0.13.15 or higher (we recommend 1.2.3) Note: if you downloaded this project as a zip file from https://developer.lightbend.com, the file includes an sbt distribution for your convenience.

To check your Java version, enter the following in a command window:

`java -version`

To check your sbt version, enter the following in a command window:

`sbt sbtVersion`

If you do not have the required versions, follow these links to obtain them:

* [Java SE](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [sbt](http://www.scala-sbt.org/download.html)

## Build and run the project

This example Play project was created from a seed template. It includes all Play components and an Akka HTTP server. The project is also configured with filters for Cross-Site Request Forgery (CSRF) protection and security headers.

To build and run the project:

1. Use a command window to change into the example project directory, for example: `cd play-java-hello-world-web`

2. Build the project. Enter: `sbt run`. The project builds and starts the embedded HTTP server. Since this downloads libraries and dependencies, the amount of time required depends partly on your connection's speed.

3. After the message `Server started, ...` displays, enter the following URL in a browser: <http://localhost:9000>

The Play application responds: `Welcome to the Gitterific!`
