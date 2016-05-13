# JMS-Project-One
This is a sample JMS project using JBOSS Hornetq.

1. Sevlet PublishMessage is a message producer that sends messages to a JMS destination deployed to a JBoss EAP server. (Producer and Consumer in the same server)
2. MyMDB is a message driven bean which will consume message asynchronously from JBoss EAP server(MessageListener need to be implemented by the consumer to 
consume message asynchronously, onMessage() method will be fired as soon as anu message get produced by the producer)

How to Run in eclipse:

* Clone it, import it in eclipse
* Make sure all the required APIs are in the classpath. Example: Servlet, JMS etc
* Locate  EAP_HOME/standalone/configuration/standalone-full.xml 
* Update standalone-full.xml with the following HELLOWORLDMDBQueue jms-queue in a new <jms-destinations> element under the hornetq-server section of the messaging subsystem.   
    <jms-queue name="HELLOWORLDMDBQueue">
         <entry name="java:/queue/HELLOWORLDMDBQueue"/>
         <entry name="java:jboss/exported/jms/queue/HELLOWORLDMDBQueue"/>
    </jms-queue>
* Run the project in jboss server with standalone-full.xml. 
* To produce message access URL http://localhost:8080/JMS-Project-One/publish
* Servlet will notified that message has been sent to the destination
* As MyMDB is Asynchrnous consumer, as soon as message is produced, it will consume the message. Check the console to get the consume message-
   09:02:07,793 INFO  [class edu.jms.mdbConsumer.MyMDB] (Thread-0 (HornetQ-client-global-threads-320892372)) Received Message from queue: Message has been produce at: Fri May 13 09:02:07 BST 2016
* Connection factory is "java:/ConnectionFactory"