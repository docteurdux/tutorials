package org.baeldung.cheatsheet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

public class ConvertingBetweenAListAndASetInJava {

	public static class WithCommons {
		public final Set<Integer> listToSet(List<Integer> list) {
			final Set<Integer> set = new HashSet<>(list.size());
			CollectionUtils.addAll(set, list);
			return set;
		}

		public final List<Integer> setToList(Set<Integer> set) {
			final List<Integer> list = new ArrayList<>(set.size());
			CollectionUtils.addAll(list, set);
			return list;
		}
	}

	public <T> Set<T> listToSet(List<T> list) {
		return new HashSet<>(list);
	}

	public <T> List<T> setToList(Set<T> set) {
		return new ArrayList<>(set);
	}
}
