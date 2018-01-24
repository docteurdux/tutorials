package org.baeldung.cheatsheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.baeldung.cheatsheet.ConvertingBetweenAnArrayAndAListInJava.U;

public class ConvertingBetweenAnArrayAndASetInJava {

	public static class WithCommons {
		public <T> Set<T> arrayToSet(T[] array) {
			final Set<T> set = new HashSet<>(6);
			CollectionUtils.addAll(set, array);
			return set;
		}
	}

	public <T> Set<T> arrayToSet(T[] array) {
		return new HashSet<T>(Arrays.asList(array));
	}

	public <T> void arrayToSetWithAddAll(T[] array) {
		final Set<T> set = new HashSet<T>();
		Collections.addAll(set, array);
	}

	public U[] setToArray(Set<U> set) {
		return set.toArray(new U[set.size()]);
	}

}
