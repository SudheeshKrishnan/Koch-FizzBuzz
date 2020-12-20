# Koch-FizzBuzz
Below are the instruction to execute the project in local

Step 1. Checkout the branch navigate to the folder fizzbuzz
Step 2. Build the project using the maven command mvn clean install which also would execute the tests.The test cases can be executed independently using mvn test command.
Step 3. Run the application by mvn spring-boot:run command  
Step 4. Documentation on the api's can be seen by accessing the end point http://localhost:8080/swagger-ui/
Step 5. Access the end point for example http://localhost:8080/fizzbuzz?low=40&&high=50

Below are the instructions to run the docker image of the application

Prerequisite
1. The docker for windows should be installed in your machine 
2. The docker hub account is mandatory.

Note: With mvn clean install , the spotify plugin would build the image named vayalankatil/fizzbuzz:1.0.0 ,you can verify the same by using docker images command 

Step 1. run the command 'docker run -p 8080:8080 vayalankatil/fizzbuzz:1.0.0' which would download the image from docker hub if it does not exist in local and then map the conatiner port
       8080 to the host machine port i.e 8080.
	   
Step 2. Access the url for example http://localhost:8080/swagger-ui/ and http://localhost:8080/fizzbuzz?low=40&&high=50 