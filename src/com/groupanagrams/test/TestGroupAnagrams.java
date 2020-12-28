package com.groupanagrams.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.groupanagrams.GroupAnagrams;

import junit.framework.Assert;

public class TestGroupAnagrams {
	
	private GroupAnagrams groupAnagrams;
	
	@Before
	public void setupBeforeEachTestCase() {
		groupAnagrams = new GroupAnagrams();
	}

	@Test
	public void testGroupAnagrams() {
		String[] strArr = new String[] {"CAT","DOG","TAC","MAD","DAM","AMD","GOD","SET"};
		List<List<String>> result =  groupAnagrams.getGroupAnagrams(strArr);
		Assert.assertEquals(4, result.size());
		List<List<String>> actualResult = new ArrayList<List<String>>();
		actualResult.add(new ArrayList<String>(Arrays.asList("CAT","TAC")));
		actualResult.add(new ArrayList<String>(Arrays.asList("DOG","GOD")));
		actualResult.add(new ArrayList<String>(Arrays.asList("MAD","DAM","AMD")));
		actualResult.add(new ArrayList<String>(Arrays.asList("SET")));
		// order of the strings will be maintained 
		for(int i=0;i<4;i++) {
			Assert.assertTrue(isEqualList(result.get(i),actualResult.get(i)));
		}
	}
	
	private boolean isEqualList(List<String> l1,List<String> l2) {
		return l1.containsAll(l2) && l2.containsAll(l1);
	}
}
