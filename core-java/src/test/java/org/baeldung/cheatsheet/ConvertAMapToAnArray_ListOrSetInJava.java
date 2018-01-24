package org.baeldung.cheatsheet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.baeldung.cheatsheet.ConvertingBetweenAnArrayAndAListInJava.U;

public class ConvertAMapToAnArray_ListOrSetInJava {
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
}
