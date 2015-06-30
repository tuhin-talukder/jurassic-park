# jurassic-park
#h1 jurassic-park
This Application has been developed as SpringBoot Application. requirements for the application are

1. Grails-2.4.5
2. mysql

#h3 Database Configuration
Database configurations are available for modifications on 
'jurassic-park/grais-app/conf/config.groovy' file

Enter your mysql username and password in that file accordingly, and the database url. default database name is 'jurassic'.


#h3 Running Application
Run from IntelliJ Idea, this project was done by IntelliJ Idea 14.1.3

This command will create the database tables initial entries and then start the program in 'http://localhost:8080/jurassic-park'


#h3 using the application
This appliocation exposes 2 api endpoint '/api/dinosaur' and 'api/cage' following is the small description for these 2 endpoint


#h4 '/api/cage'
1. GET request to '/api/cage' creates a full list of Cages
2. GET request to '/api/cage/{id}' gets the Cage with specific id
3. POST request to '/api/cage' creates Cage
4. PUT request to '/api/cage/{id}' with some data updates the Cage with given data (data needs to be 'application/json' format)
5. DELETE request to '/api/cage/{id}' deletes a Dinosaur

#h4 '/api/dinosaur'
1. GET request to '/api/dinosaur' creates a full list of Dinosaurs
2. GET request to '/api/dinosaur/{id}' gets the Dinosaur with specific id
3. POST request to '/api/dinosaur' creates Dinosaur
4. PUT request to '/api/dinosaur/{id}' with some data updates the Dinosaur with given data (data needs to be 'application/json' format)
5. DELETE request to '/api/dinosaur/{id}' deletes a Dinosour
