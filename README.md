# phonebook

This Application is Developed in Springboot

Development environment
Java 8
Maven 3


#How to Run Application

Goto root folder and run below maven command  
mvn spring-boot:run  

#API URLs

GetAll Phone Numbers   
GET Request -- http://localhost:8080/allPhones   


GetAll Phone Numbers By Name   
GET Request -- http://localhost:8080/{name}/phones  
ex url (GET Request): http://localhost:8080/prasanth/phones   


Activate Given Phone Number   
PUT Request -- http://localhost:8080/{phoneNum}/activate   
ex url (PUT Request): http://localhost:8080/9742703692/activate  


