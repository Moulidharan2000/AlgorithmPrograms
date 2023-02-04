package com.bridgelabz.algorithmprograms;

import java.util.ArrayList;
import java.util.List;

public class GenericsSearch {
	
	public <T> int binarySearch(List<T> list, T element) {
	    int low = 0;
	    int high = list.size() - 1;
	    while (low <= high) {
	      int mid = (low + high) / 2;
	      int comparisonResult = ((String) element).compareTo((String) list.get(mid));
	      if (comparisonResult == 0) {
	        return mid;
	      } else if (comparisonResult < 0) {
	        high = mid - 1;
	      } else {
	        low = mid + 1;
	      }
	    }
	    return -1;
	  }
	
	public <T> List<T> mergeSort(List<T> list) {
	  
		if (list.size() <= 1) {
	      return list;
	    }
	    int mid = list.size() / 2;
	    List<T> left = list.subList(0, mid);
	    List<T> right = list.subList(mid, list.size());
	    left = mergeSort(left);
	    right = mergeSort(right);
	    return merge(left, right);
	  }

	  private <T> List<T> merge(List<T> left, List<T> right) {
	   
		  int leftIndex = 0;
	    int rightIndex = 0;
	    List<T> result = new ArrayList<>(left.size() + right.size());
	    while (leftIndex < left.size() && rightIndex < right.size()) {
	      if (((String) left.get(leftIndex)).compareTo((String) right.get(rightIndex)) < 0) {
	        result.add(left.get(leftIndex++));
	      } else {
	        result.add(right.get(rightIndex++));
	      }
	    }
	    while (leftIndex < left.size()) {
	      result.add(left.get(leftIndex++));
	    }
	    while (rightIndex < right.size()) {
	      result.add(right.get(rightIndex++));
	    }
	    return result;
	  }
}
