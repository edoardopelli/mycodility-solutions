package com.amazon.aws.test;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {
	
	public static void main(String[] args) {
		PermMissingElem p = new PermMissingElem();
		p.solution(new int[] {1,4,3,2,5,7,8,10,6});
		p.solution(new int[] {1});
	}
	
	public int solution(int[] A) {
	    int max = A.length + 1;
	    
	    //load array elements into array so would be quick to check if elements exist
	    Set incompleteSet = new HashSet();
	    for(int i=0; i<A.length; i++) {
	      incompleteSet.add(A[i]);
	    }

	    for(int i=1; i<max+1; i++) {
	      if(!incompleteSet.contains(i)) {
	        return (i);
	      }
	    }
	    return -1;
	}

}
