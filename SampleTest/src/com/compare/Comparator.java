package com.compare;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
	public int compare(T a, T b);
	
	public static <U> Comparator<U> comparing(Function<U, Comparable> f) {
			return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
	}
	
	public default Comparator<T> thenCompare(Comparator<T> cmp) {
		return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
	}
	
	public default Comparator<T> thenCompare(Function<T, Comparable> f) {
		return thenCompare(comparing(f));
	}
}
