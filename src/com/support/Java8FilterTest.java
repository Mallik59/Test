package com.support;

import java.util.*;
import java.util.stream.Collectors;

public class Java8FilterTest {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		
		l1.add("a");
		l1.add("b");
		l1.add("c");
		
		l2.add("b");
		l2.add("a");
		
		
		/*System.out.println(l1.stream()
        .filter(pr -> l2.stream().anyMatch(s -> pr.equals(s)))
        .collect(Collectors.toList()));*/
		System.out.println(l1.stream().filter(l-> l2.contains(l)).collect(Collectors.toList()));
	}
}
