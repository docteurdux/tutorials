package org.baeldung.cheatsheet;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaGenerateRandomString {
	public static class WithCommons {
		public String randomAlphabeticString() {
			return RandomStringUtils.randomAlphabetic(10);
		}

		public String randomAlphanumeric() {
			return RandomStringUtils.randomAlphanumeric(10);
		}

		public String randomString() {
			return RandomStringUtils.random(10);
		}

		public String randomStringFactory(int len, boolean useLetters, boolean useNumbers) {
			return RandomStringUtils.random(len, useLetters, useNumbers);
		}
	}

	public String randomString(Random rng, int len) {
		byte[] array = new byte[len];
		rng.nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}

	public String randomStringInRange(Random rng, int leftLimit, int rightLimit, int len) {
		StringBuilder buffer = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			buffer.append((char) (leftLimit + (int) (rng.nextFloat() * (rightLimit - leftLimit + 1))));
		}
		return buffer.toString();
	}
}
