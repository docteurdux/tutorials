package org.baeldung.cheatsheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

public class ConvertingBetweenAnArrayAndAListInJava {

	// fakes generics
	class U {
	};

	public static class WithCommons {

		public <T> void arrayToList(T[] array) {
			List<T> list = new ArrayList<>(array.length);
			CollectionUtils.addAll(list, array);
		}

		public int[] setToArrayOfPrimitive(Set<Integer> set) {
			return ArrayUtils.toPrimitive(set.toArray(new Integer[set.size()]));
		}

	}

	public <T> List<T> arrayToList(T[] array) {
		return Arrays.asList(array);
	}

	public U[] listToArray(List<U> list) {
		return list.toArray(new U[list.size()]);
	}

}
