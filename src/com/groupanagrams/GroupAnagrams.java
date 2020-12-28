package com.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {
	
	Map<String,List<String>> groupAnagrams;
	public GroupAnagrams() {
		groupAnagrams = new LinkedHashMap<String,List<String>>();
	}

	public static void main(String[] args) {
		
		GroupAnagrams grpAnagrams = new GroupAnagrams();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no of Strings you would like to group anagrams");
		int n=scan.nextInt();
		System.out.println("Enter the strings followed by space or new line");
		String[] inputStrings = new String[n];
		for(int i=0;i<n;i++) {
			inputStrings[i]=scan.next();
		}
		scan.close();
		List<List<String>> result = grpAnagrams.getGroupAnagrams(inputStrings);
		System.out.println("Group Anagrams are " + result);
		
	}
	
	public List<List<String>> getGroupAnagrams(String[] input){
		String str;
		String sortedString;
		for(int i=0;i<input.length;i++) {
			str = input[i];
			char[] charArray= str.toCharArray();
			Arrays.sort(charArray);
			sortedString =String.valueOf(charArray);
			if(!groupAnagrams.containsKey(sortedString)) {
				groupAnagrams.put(sortedString, new ArrayList<String>());
			}
			groupAnagrams.get(sortedString).add(str);
		}
		List<List<String>> result = new ArrayList<List<String>>(groupAnagrams.values());
		return result;
	}
	
	
	

}
