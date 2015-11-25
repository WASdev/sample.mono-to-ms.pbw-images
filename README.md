# Image service for the Plants By WebSphere monlith

This microservice provides a repository for images associated with the Plants By WebSphere application.

## Background

Plants by WebSphere is an Internet storefront application that specializes in the sale of plants and gardening tools. Using the Plants by WebSphere store front, customers can open accounts, browse for items to purchase, view product details, and place orders.

As part of evolving this application into microservices, this microservice provides access to all images. The main monolithic application redirects the client to this service. This service then returns images, either from its database or from its resources, via a REST API.

# Installation
Download the code to your system and run:

```mvn clean install```

This will build the application and downlaod a copy of Liberty. To run the app after this, run:

```image-wlpcfg/target/liberty/wlp/bin/server start pbw-images```

To prove your install is ready, navigate to [http://localhost:9081/images/resources/veggies_strawberries_48.jpg](http://localhost:9081/images/resources/veggies_strawberries_48.jpg). This should return an image. From here, the pbw-monolith application should pull images from this server.

# Further reading
[Starting the evolution to microservices (using the Plants By WebSphere sample)](https://developer.ibm.com/wasdev/docs/starting-evolution-microservices-using-plants-websphere-sample/)
