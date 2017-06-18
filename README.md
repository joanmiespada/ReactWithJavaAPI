
## ReactWithJavaAPI Project

The objective of the project is show a whole example of full-stack app using the next stack:

Front-end: React with Redux. You'll be able find it on dir ./frontEnd
Back-end: Java API without Frameworks such as Spring, Hibernate,... Directory: ./backendEnd

## Backend

The Back-end has been splited in two projectes:
1) BusinessLayer: It contains all functional requirements. Business has been implemented with some libraries as Lombok Project.
2) API: It contains all technical requirements to expose the BusinessLayer through REST API. It has a dependency with BusinessLayer. Here, I've used Gson library to transform POJO objects to Json objects. As REST API, it has not session. You can only use verbs GET and POST.  

Both projects have been compiled with Gradle for dependencies and IntelliJ. Perhaps some dependencies would need to be updated with the correct paths. 

## Frontend


## BBDD & SeedData

The data is stored in a SqLite DB file. Everytime the API starts the DB is recreated from scratch.
The seed data is here:

ID  USER     PWD      ROLES
1, 'Jhon',  "123456" ADMIN
2, 'Michael,"123456" PAGE1
3, 'Sword', "123456" PAGE2
4, 'Black', "123456" PAGE3
5, 'Ruben', "123456" PAGE1+PAGE3

## Startup

Front-end: you can go to frontEnd folder and run: npm install && npm start. You can see the website on http://localhost:3000
Back-end: you can go to Backend folder and run: java -jar ./api/out/artifacts/api_jar/api.jar. Anyway I recommend open this folder with IntelliJ and Run the project by Main class. 

## TDD

You can find jUnit test on BusinessLayer.

 








