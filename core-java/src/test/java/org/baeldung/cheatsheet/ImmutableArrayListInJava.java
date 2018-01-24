package org.baeldung.cheatsheet;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

public class ImmutableArrayListInJava {

	public <T> List<T> unmodifiableList(List<T> list) {
		return Collections.unmodifiableList(list);
	}

	public <T> List<T> unmodifiableList2(List<T> list) {
		return ListUtils.unmodifiableList(list);
	}
	
	public <T> List<T> synchronizedList(List<T> list) {
		return ListUtils.synchronizedList(list);
	}

	

}
