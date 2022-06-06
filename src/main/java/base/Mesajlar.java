package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mesajlar {

    private static final Logger logger = LogManager.getLogger(ActionList.class);
    protected void postiveMessages(String element, String process){
        System.out.println("Step success: The "+process+" has done for "+element+".");
        logger.info("Step success: The "+process+" has done for "+element+".");
    }

    protected void negativeMessages(String failType, String element,String failSource){
        System.out.println("Step fail:\t"+failType+"\nThe "+element+" couldn't do "+failSource+".");
        logger.error("Step fail:\t"+failType+"\nThe "+element+" couldn't do "+failSource+".");
    }
}
