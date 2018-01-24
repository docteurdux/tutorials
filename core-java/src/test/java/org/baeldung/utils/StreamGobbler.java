package org.baeldung.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Assert;

public class StreamGobbler implements Runnable {
	private InputStream inputStream;

	public StreamGobbler(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void run() {
		new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(Assert::assertNotNull);
	}
}
