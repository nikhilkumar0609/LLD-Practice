package DesignLoggingSystem;

public class InfoLogProcessor extends LogProcessor{

	InfoLogProcessor(LogProcessor nexloggerProcessor) {
		super(nexloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == INFO) {
			System.out.println("INFO: " + message);
		}else {
			super.log(logLevel, message);
		}
	}

}
