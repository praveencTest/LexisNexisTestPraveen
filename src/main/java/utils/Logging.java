package utils;

import org.apache.commons.logging.Log;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Logging {
    public static Logger log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){
        setLoggerFormat();
        log.info("\u001B[32m" + "========="+sTestCaseName+"TEST START===========" + "\u001B[0m");
    }
    public static void endTestCase(String sTestCaseName){
        setLoggerFormat();
        log.info("\u001B[32m" + "========="+sTestCaseName+"TEST END=============" + "\u001B[0m");
    }

    public static void info(String message){
        log.info(message);
    }

    public static void setLoggerFormat()
    {
        log.setUseParentHandlers(false);
        log.addHandler(new ConsoleHandler() {
            {setOutputStream(System.out);}
        });
    }
}
