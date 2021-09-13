# products-rest-app
## MyRetail Products Rest App for Target
The following technologies are being used :- 
```
Spring Boot 
Maven 
MongoDB
```

The following REST Methods are enabled :- 
```
GET - Retreives Product Details based on provided ID. The ID cannot be empty. 
PUT - Updates only the Price of the Product if the record already exists. ID cannot be empty. 
POST - Used to SAVE (CREATE) records on the DB. 
```
The project can be ran on the local computer the following JSON Structure needs to be followed to save Objects to DB. 
`{"id":13456789345,"name":"Western Digital HDD","price":{"currencyCode":"USD","currencyValue":43.57}}`

MongoDB needs to installed on the local machine and `mongod` process needs to be running. Example for setting up MongoDB located [here](https://zellwk.com/blog/local-mongodb/)

Once the first request is made via REST Client the application creates the DB with the properties set in application.properties, which are :- 
```
spring.data.mongodb.database=retail_products_repo
spring.data.mongodb.port=27017
```
The above properties can be updated to update database name. 

POST Request :- http://localhost:8080/api/v1/products
