package com.baeldung.cheatsheet;

import java.util.Map.Entry;

import org.apache.commons.logging.impl.SimpleLog;
import org.junit.Test;

public class DumpEnvironment {

	private static final SimpleLog LOG = new SimpleLog(DumpEnvironment.class.getSimpleName());
	static {
		LOG.setLevel(SimpleLog.LOG_LEVEL_ALL);
	}

	public static void dump() {
		for (Entry<Object, Object> prop : System.getProperties().entrySet()) {
			LOG.info(prop.getKey() + " : " + prop.getValue());
		}
	}

	public static void main(String[] args) {
		dump();
	}

	@Test
	public void test() {
		dump();
	}
}
