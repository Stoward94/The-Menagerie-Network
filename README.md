This project was developed for one module during my MSc Software Engineering course.
The Menagerie Network is a pseudo company that acts as the umbrella company for a network of zoos. This project was designed in three major parts.
1. A client application composed with React.
1. A RESTful API written in JAVA
1. A MySQL datastore

## Installation

###### Client
You will need to install client dependencies by running `npm install` in the `clients\website` directory.
Then using webpack dev-server you can launch the client by running `npm start`, exposing the website at `localhost:3000`.

###### Java Web Service
You can use netbeans to build and run the project. Glassfish was the local application server used.


###### MySQL
Under `server\database` you’ll finds scripts you can run to create the schema and seed the database.
Depending on your MySQL instance, you will likely need to update the login credentials to allow the web service to access your instance. 
