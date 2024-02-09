package DesignLoggingSystem;

public class DebugLogProcessor extends LogProcessor{

	DebugLogProcessor(LogProcessor nexloggerProcessor) {
		super(nexloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel, String message) {
		if(logLevel == DEBUG) {
			System.out.println("DEBUG: " + message);
		}else {
			super.log(logLevel, message);
		}
	}

}
