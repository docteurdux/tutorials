package com.baeldung.cheatsheet;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.FileSystems;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.commons.logging.impl.SimpleLog;
import org.baeldung.cheatsheet.HowToRunAShellCommandInJava;
import org.junit.Test;

public class BasicIntroductionToJMX {

	private static final SimpleLog LOG = new SimpleLog(BasicIntroductionToJMX.class.getSimpleName());
	static {
		LOG.setLevel(SimpleLog.LOG_LEVEL_ALL);
	}

	public static interface HelloWorldMBean {

		public String getHello();

		public void setHello(String hello);

	}

	public static class HelloWorld implements HelloWorldMBean {

		private String hello;

		@Override
		public String getHello() {
			return hello;
		}

		@Override
		public void setHello(String hello) {
			this.hello = hello;
		}

	}

	@Test
	public void test() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException, InterruptedException, IOException {
		ObjectName objectName = new ObjectName("com.baeldung.tutorial:type=basic,name=helloworld");
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		server.registerMBean(new HelloWorld(), objectName);
		LOG.info(launchJConsole());
	}

	private int launchJConsole() throws IOException, InterruptedException {
		String sep = FileSystems.getDefault().getSeparator();
		String jconsole = System.getProperty("java.home") + sep + ".." + sep + "bin" + sep + "jconsole.exe";
		if (!new File(jconsole).exists()) {
			jconsole = System.getProperty("java.home") + sep + ".." + sep + "bin" + sep + "jconsole";
		}
		ProcessBuilder builder = new ProcessBuilder(jconsole);
		builder.directory(new File(System.getProperty("user.home")));
		Process process = builder.start();
		HowToRunAShellCommandInJava.gobble(process);
		return process.waitFor();
	}

}
