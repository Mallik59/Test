package com.support;

public interface SInterface {
	String talk();
	default String w(){
		return talk()+" "+"1"; 
	}

	default String y(){
		return talk()+" "+"2"; 
	}
}
