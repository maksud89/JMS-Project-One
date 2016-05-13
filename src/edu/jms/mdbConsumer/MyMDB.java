package edu.jms.mdbConsumer;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;


@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/HELLOWORLDMDBQueue"),
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class MyMDB implements MessageListener {
	 private final static Logger LOGGER = Logger.getLogger(MyMDB.class.toString());

	    /**
	     * @see MessageListener#onMessage(Message)
	     */
	    public void onMessage(Message rcvMessage) {
	        TextMessage msg = null;
	        try {
	            if (rcvMessage instanceof TextMessage) {
	                msg = (TextMessage) rcvMessage;
	                LOGGER.info("Received Message from queue: " + msg.getText());
	            } else {
	                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
	            }
	        } catch (JMSException e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}
