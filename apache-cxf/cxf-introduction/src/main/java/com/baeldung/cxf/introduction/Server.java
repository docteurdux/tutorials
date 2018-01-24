package com.baeldung.cxf.introduction;

import javax.xml.ws.Endpoint;

import org.apache.commons.logging.impl.SimpleLog;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class Server {

	static {
		((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.INFO);
	}
	private static final SimpleLog LOG = new SimpleLog("Server");
	static {
		LOG.setLevel(SimpleLog.LOG_LEVEL_ALL);
	}
	
	private Server() {
	}

	public static void run() throws InterruptedException {
		MyWebService myWebService = new MyWebServiceImpl();
		String address = "http://localhost:8080/ohmy";
		Endpoint enpoint = Endpoint.publish(address, myWebService);
		LOG.info("Server ready...");
		while (myWebService.isAlive()) {
			Thread.sleep(100);
		}
		LOG.info("Server exiting");
		enpoint.stop();
		
		LOG.info("Endpoint stopped");
		System.exit(0);
	}
}