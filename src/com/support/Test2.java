package com.support;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test2 extends Object{

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(35);
		System.out.println(l.stream().reduce(l.get(0),(a,b)->a>b?a:b));
		
	}
	public static void test(String a){
		a="lol";
	}
}
