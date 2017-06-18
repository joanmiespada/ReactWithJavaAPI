
## ReactWithJavaAPI Project

The objective of the project is show a whole example of full-stack app using these technologies:

Front-end: React with Redux. You'll be able find it on dir ./frontEnd
Back-end: Java API without Frameworks such as Spring, Hibernate,... Mainly vanilla JAVA. Directory: ./backendEnd

## Backend

The Back-end has been splited in two projectes:
1) BusinessLayer: It contains all functional requirements. Business has been implemented with some libraries as Lombok Project. The main idea is keep our buisiness logic decoupled of some technical issues. The business only depends of itself. The business exposes the interface IUsers as a service for users manager and logic driver. For example, check the privelegies of the user that perform an request. Behind it, you'll find a pure diccionary class with CRUD operations.      
2) API: It contains all technical requirements to expose the BusinessLayer through REST API. It has a dependency with BusinessLayer. The Main class (entry point) works as pseudo-container instantiating the API's dependencies and inyect them to the API through the constructor.   Here, I've used Gson library to transform POJO objects to Json objects. As REST API, it has not session. You can only use verbs GET and POST. With aim to keep the layer well implemented, instead of create an MVC project, I've create only Controllers and Model, due to the view is running on front-end. The Controllers folder keeps all code to manage API REST requests. The Model folder keeps DTOs. A DTO is a concret POJO with the api request requeriments. 

BusinessLayer.Entities.IUser -> API.Model.User --->> http ------>> Front-end.

Both projects have been compiled with Gradle for dependencies and IntelliJ. Perhaps some dependencies would need to be updated with the correct paths. Please, check it! 

## Frontend

It has been developed with React, Redux,React-Redux, React-bootstrap, Axios and other JS components. When the front-end is ready inmediately checks wether a user is already loged. In case of not, the front-end raise a modal window ask for about username and password. Check SeedData to choose the correct user. Redux-Loger is enabled, so you can see how the state is evolving at the moment through Javascript Console.    


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
Back-end: you can go to Backend folder and run: java -jar ./api/out/artifacts/api_jar/api.jar. Anyway I recommend open this folder with IntelliJ and Run the project by Main class. API is listening on http://localhost:8000. CORS restriction has been disabled. 

## TDD

You can find jUnit test on BusinessLayer.

 








