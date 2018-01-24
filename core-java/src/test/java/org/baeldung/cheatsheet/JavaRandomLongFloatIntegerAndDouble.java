package org.baeldung.cheatsheet;

import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;

public class JavaRandomLongFloatIntegerAndDouble {

	public static class WithCommons {
		public double boundedDouble(RandomDataGenerator rng, double leftLimit, double rightLimit) {
			return rng.nextUniform(leftLimit, rightLimit);
		}

		public float boundedFloat(RandomDataGenerator rng, float leftLimit, float rightLimit) {
			return leftLimit + rng.getRandomGenerator().nextFloat() * (rightLimit - leftLimit);
		}

		public int boundedInteger(RandomDataGenerator rng, int leftLimit, int rightLimit) {
			return rng.nextInt(leftLimit, rightLimit);
		}

		public long boundedLong(RandomDataGenerator rng, long leftLimit, long rightLimit) {
			return rng.nextLong(leftLimit, rightLimit);
		}

		public double unboundedDouble(RandomDataGenerator rng) {
			return rng.getRandomGenerator().nextDouble();
		}

		public float unboundedFloat(RandomDataGenerator rng) {
			return rng.getRandomGenerator().nextFloat();
		}

		public int unboundedInteger(RandomDataGenerator rng) {
			return rng.getRandomGenerator().nextInt();
		}

		public long unboundedLong(RandomDataGenerator rng) {
			return rng.getRandomGenerator().nextLong();
		}
	}

	public static class WithMath {
		public long boundedLong(long leftLimit, long rightLimit) {
			return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		}

		public double unboudedDouble() {
			return Math.random();
		}
	}

	public double boundedDouble(Random rng, double leftLimit, double rightLimit) {
		return leftLimit + rng.nextDouble() * (rightLimit - leftLimit);
	}

	public float boundedFloat(Random rng, float leftLimit, float rightLimit) {
		return leftLimit + rng.nextFloat() * (rightLimit - leftLimit);
	}

	public int boundedInteger(Random rng, int leftLimit, int rightLimit) {
		return leftLimit + (int) (rng.nextFloat() * (rightLimit - leftLimit));
	}

	public float unboundedFloat(Random rng) {
		return rng.nextFloat();
	}

	public int unboundedInteger(Random rng) {
		return rng.nextInt();
	}

	public long unboundedLong(Random rng) {
		return rng.nextLong();
	}

}
