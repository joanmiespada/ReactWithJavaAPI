
#ReactWithJavaAPI Project

The objective of the project is show a whole example of full-stack app using the next stack:

Front-end: React with Redux. You'll be able find it on dir ./frontEnd
Back-end: Java API without Frameworks such as Spring, Hibernate,... Directory: ./backendEnd

#Backend

The Back-end has been splited in two projectes:
1) BusinessLayer: It contains all functional requirements. Business has been implemented with some libraries as Lombok Project.
2) API: It contains all technical requirements to expose the BusinessLayer through REST API. It has a dependency with BusinessLayer. Here, I've used Gson library to transform POJO objects to Json objects. As REST API, it has not session. You can only use verbs GET and POST.  

Both projects have been compiled with Gradle for dependencies and IntelliJ. Perhaps some dependencies would need to be updated with the correct paths. 

#Frontend




