# Microservice implementation using Springboot
Scenario: Consider there is a big sale in website and its open only for some specific customers. I've implemented a system which checks if user is customer or fraud and if he/she is customer then I have registered the customer in the database.

I have 7 microservices:
1. Customer: Whenever some person tries to open the site he/she will hit api for this microservice. Customer talks to Test microservice which check if the user is fraud or not. If not fraud it publishes the message to the rabbitmq.
2. Test: This microservice is meant to check if the user is fraud or not. Based on that it returns true or false. (In diagram it is shown as Fraud for better clarity)
3. Apigw: This is our api gate way. Ideally in industry standard all our microservices are in private network and our api are not exposed so this api gateway reverse proxies to the customer microservice.
4. Eureka-Server: In a scenario where there are multiple microservices communicating with each other its tough to remember the ports each service is listening to. So we go for service discovery where each service is listed with ip address and port number that any service can come and look up to.
5. Notification: What this does is it configures the exchange, queue and routing key. It has listener methods which pulls message from the queue whenever a message is available to be pulled. It persists their data in the database.
6. Amqp: Here we create beans for AmqpTemplate and SimpleRabbitListenerContainerFactory. We also create producer method which customer microservice takes help from to publish the message to the exchange.
7. Clients: This is used as feign client for the microservices so that whenever the microservices communicate with each other its via the interface and not implementation. Any changes in the api implementation of the interfaces will be needed to be made at one place and not wherever we are making the rest calls.
![image](https://user-images.githubusercontent.com/73374498/213866069-d6292d4e-8e8b-4d44-b3b8-0d8bdbc191b0.png)

  ![image](https://user-images.githubusercontent.com/73374498/213866285-71fc1113-8596-4bc7-bb60-6311e5207127.png)

## Tech stack used:
1. SpringBoot.
2. PostgreSql.
3. Feign.
4. Zipkin.
5. Sleuth.
6. rabbitmq.
7. Docker.
8. Postman.


For detailed information please go to my notion page:

https://www.notion.so/atridashboard/Creating-config-class-for-rabbitmq-afffb2b91b744b35a79b886d166445ac
