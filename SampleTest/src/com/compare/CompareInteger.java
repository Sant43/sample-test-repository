package com.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class CompareInteger {

	public static void main(String[] args) {
		
		Integer[] intArray = {1,5,6,3,7};
		//List<Integer> intList = Arrays.asList(intArray); 
		//Collections.sort(intList);
		//System.out.println(intList.toString());
		
		/*Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(a, b);
			}
		};*/

		Arrays.sort(intArray, ((a,b) -> Integer.compare(a, b)));
		//Arrays.sort(intArray, comparator);
		
		System.out.println(Arrays.asList(intArray).toString());
		
		//BinaryOperator<Integer> bo = (a,b) -> Integer.sum(a,b);
		BinaryOperator<Integer> bo = Integer::sum;
		System.out.println(bo.apply(1,2));
	}

}
