package com.test.tony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		//l.add(6);
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(3);
		l.add(2);
		l.add(3);
		System.out.println(l.get(3));
		//l.add(index, element);
		//l.add(5);
		/*l.add(1);
		l.add(1);
		l.add(1);
		l.add(2);
		l.add(3);*/
		//System.out.println(maxPoints(l));
		String s = "mallik";
		s = s.substring(0,5);
		System.out.println(s);
		
		
	}
	
	 public static long maxPoints(List<Integer> elements) {
	        long maxPoints = 0;
	        int maxNum = 0;
	        int aNum = 0;
	        int bNum = 0;
	        while(elements.size() > 0){
	        // Write your code here
	         maxNum = Collections.max(elements);
	         aNum = maxNum -1;
	         bNum = maxNum +1;
	        
	        //maxPoints = maxPoints + maxNum;
	        while(elements.indexOf(maxNum) >= 0){
	        elements.remove(elements.indexOf(maxNum));
	        maxPoints = maxPoints + maxNum;
	        }
	        
	         while(elements.indexOf(aNum) >= 0)
	        elements.remove(elements.indexOf(aNum));
	        
	         while(elements.indexOf(bNum) >= 0)
	        elements.remove(elements.indexOf(bNum));
	        }
	        return maxPoints;
	    }
}
