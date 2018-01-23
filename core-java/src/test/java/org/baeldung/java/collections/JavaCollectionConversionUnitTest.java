package org.baeldung.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class JavaCollectionConversionUnitTest {

	// fakes generics for array instanciation, because Java forbids instanciation of
	// arrays of generics
	class U {
	};

	public static class WithCommons {

		public <T> void arrayToList(T[] array) {
			List<T> list = new ArrayList<>(array.length);
			CollectionUtils.addAll(list, array);
		}

		public <T> Set<T> arrayToSet(T[] array) {
			final Set<T> set = new HashSet<>(6);
			CollectionUtils.addAll(set, array);
			return set;
		}

		public final Set<Integer> listToSet(List<Integer> list) {
			final Set<Integer> set = new HashSet<>(list.size());
			CollectionUtils.addAll(set, list);
			return set;
		}

		public int[] setToArrayOfPrimitive(Set<Integer> set) {
			return ArrayUtils.toPrimitive(set.toArray(new Integer[set.size()]));
		}

		public final List<Integer> setToList(Set<Integer> set) {
			final List<Integer> list = new ArrayList<>(set.size());
			CollectionUtils.addAll(list, set);
			return list;
		}

	}

	public <T> List<T> arrayToList(T[] array) {
		return Arrays.asList(array);
	}

	public <T> Set<T> arrayToSet(T[] array) {
		return new HashSet<T>(Arrays.asList(array));
	}

	public <T> void arrayToSetWithAddAll(T[] array) {
		final Set<T> set = new HashSet<T>();
		Collections.addAll(set, array);
	}

	public U[] listToArray(List<U> list) {
		return list.toArray(new U[list.size()]);
	}

	public <T> Set<T> listToSet(List<T> list) {
		return new HashSet<>(list);
	}

	public <T> U[] mapToArrayOfValues(Map<T, U> map) {
		Collection<U> values = map.values();
		return values.toArray(new U[values.size()]);
	}

	public <K, V> List<V> mapToListOfValues(Map<K, V> map) {
		return new ArrayList<>(map.values());
	}

	public <K, V> Set<V> mapToSetOfValues(Map<K, V> map) {
		return new HashSet<>(map.values());
	}

	public U[] setToArray(Set<U> set) {
		return set.toArray(new U[set.size()]);
	}

	public <T> List<T> setToList(Set<T> set) {
		return new ArrayList<>(set);
	}
}
