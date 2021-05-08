# microservices
## Getting Started

Prerequisites:
- JDK 11 
- MySQL 5.7.* or (better) Docker
    - Windows or macOS: install Docker Desktop
- Postman app    

### Running the services

1. Clone the repository
2. Import the project as into your favourite IDE
3. Build all modules(productmicroservice, customermicroservice, creditmicroservice)  
   using `./mvnw clean install` (Unix) or `mvnw.cmd clean install` (Windows)  
   or use build-in tools (`clean` and `install`)
4. Start Docker engine (Linux) or Docker desktop (Windows or macOS)
5. Run project with docker using `print docker-compose up --build`

### Ready to use

Use GET method for url `http://localhost:8082/credit` to get all credits  
or POST method for url `http://localhost:8082/credit` to post new object

You can use the json below as example:


    {
        "customer":{
            "firstName": "examplefirstname",
            "pesel": "12345678912",
            "surname": "examplesurname"
        },
        "product":{
            "name": "exampleproductname",
            "value": 123
        },
        "credit":{
            "name": "examplecreditname"
        }
    }
