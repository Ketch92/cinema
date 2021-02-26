# Online CinemaServ

We are happy to welcome you in our Cinema Service.

We have design this web app service for users that have special taste and 
know what they want from life. It is a nice start of a good friendship.

The service is a multilayer application with a database to store the data and encryption of your credentials.
The app is developed with latest moder technologies of Java, Spring, Hibernate and RDMS.

Before we step in, please fulfill following requirements:
- Please, check if you have installed Java of version 11 or later.

- Copy the project and import it to your IDE.
- Install Tomcat web server. 
- Configure Tomcat in your IDE using deployment to war:exploded.
- Install latest PostgreSQL. 
- In the db.properties file write-down the database credentials.
- Create a schema with a name 'cinema'.
- The admin is automatically injected into the database at the first run.

Now you are able to run the project. You will be redirected to the log-in page where you are able to log in as admin.
Also, you can go to localhost:8080/register endpoint and register as a new user.
Here is the list of endpoints for your usage:
- localhost:8080/register
- localhost:8080/cinema-halls -> Get request -> retrieving all movie sessions.
- localhost:8080/cinema-halls -> Post request -> adds new cinema hall.
- localhost:8080/cinema-halls/[id] -> Get request -> retrieving cinema hall by a certain id.
- localhost:8080/movies ->  Get request -> retrieving all movies.
- localhost:8080/movies -> Post request -> adds new movie.
- localhost:8080/movies/[id] -> Get request -> retrieving cinema hall by a certain id.
- localhost:8080/movie-session -> Post request -> adds new movie session. 
- localhost:8080/movie-session/[id] -> Get request -> retrieving movie-session by a certain id.
- localhost:8080/movie-session/available?movieId=[id]&date=[dd.mm.yyyy] -> check available movie sessions.
- localhost:8080/movie-session/[id] -> Put request -> updates the movie session by id.
- localhost:8080/movie-session/[id] -> Delete request -> deletes the movie session by id.
- localhost:8080/orders -> Get request -> retrieves all orders of authorized user. 
- localhost:8080/complete -> Post request -> completes order of authorized user. 
- localhost:8080/shopping-carts/by-user -> Get request -> retrieves a shopping cart of a user 
- localhost:8080/shopping-carts/movie-sessions?movieSessionId=[id] -> Post request -> adds a movie session to shopping cart.
- localhost:8080/users/by-email?email=[email] retrieves a user with a certain email.

We are open for propositions. If you would like to extend the app fork the repository and create a Pool request with changes.
