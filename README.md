# Core_Bank 


To Recieve an Email Verification 

 Create an Email Account to mailtrap (https:mailtrap.io) Change line 3 and 4 to your own username and password of your own mailtrap creditails on this directory 
 (main/java/com.core_back/config/MailConfig)).
 
 emailConfig.setHost("smtp.mailtrap.io");
 emailConfig.setPort(2525);
 emailConfig.setUsername("709c9a6f20e8a7");
 emailConfig.setPassword("69e15050544da6");
 
For Database To Connect

 Edit the Application.Properties on the resources folder in Line 2 and 4 change the username,
 and password to your own local machine MySql Database Admin Creditails.


spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/core_bank
spring.datasource.username=root
spring.datasource.password=MA12@ronyo
spring.datasource.driver-class-name=com.mysql.jdbc.Driver


#Server Attribute / Config
server.address=127.0.0.1
server.port=8070

#Disable Default Error Page
server.error.whitelabel.enabled=false

