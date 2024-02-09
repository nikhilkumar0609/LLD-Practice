package DesignLoggingSystem;

public class ErrorLogProcessor extends LogProcessor{

	ErrorLogProcessor(LogProcessor nexloggerProcessor) {
		super(nexloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == ERROR) {
			System.out.println("ERROR: " + message);
		}else {
			super.log(logLevel, message);
		}
	}

}
