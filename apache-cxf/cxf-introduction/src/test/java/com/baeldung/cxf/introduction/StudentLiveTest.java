package com.baeldung.cxf.introduction;

import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.commons.logging.impl.SimpleLog;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class StudentLiveTest {

	static {
		((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.INFO);
	}

	private static final SimpleLog LOG = new SimpleLog(StudentLiveTest.class.getSimpleName());
	static {
		LOG.setLevel(SimpleLog.LOG_LEVEL_ALL);
	}

	private static final QName SERVICE_NAME = new QName("http://oh.my/myServiceName", "Baeldung");
	private static final QName PORT_NAME = new QName("http://introduction.cxf.baeldung.com/", "myPortName");
	private static final String ENDPOINT_ADDRESS = "http://localhost:8080/ohmy";

	private Service service;
	private MyWebService myWebService;

	public StudentLiveTest() {
		service = Service.create(SERVICE_NAME);
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, ENDPOINT_ADDRESS);
		myWebService = service.getPort(PORT_NAME, MyWebService.class);
	}

	@Test
	public void helloString() {
		LOG.info(myWebService.sayHiTo("You"));
	}

	@Test
	public void helloObject() {
		LOG.info(myWebService.addEntity(new StudentImpl("John Doe")));
	}

	@Test
	public void usingGetStudentsMethod_thenCorrect() {
		myWebService.addEntity(new StudentImpl("Student1"));
		myWebService.addEntity(new StudentImpl("Student2"));
		final Map<Integer, Entity> students = myWebService.getEntities();
		for (Entry<Integer, Entity> entry : students.entrySet()) {
			LOG.info(entry.getValue().getName());
		}
	}

	@Test
	public void shutdown() {
		myWebService.shutdown();
	}

	public static void main(String args[]) throws InterruptedException {
		Server.run();
	}

}