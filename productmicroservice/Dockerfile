FROM openjdk:11.0.10-jdk
ADD target/productmicroservice.jar productmicroservice.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "productmicroservice.jar"]