package DesignLoggingSystem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		logObject.log(LogProcessor.INFO, "just for info ");
        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug this ");
        
      
	}

}
