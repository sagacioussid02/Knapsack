package orcl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram2 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "aaabaabcba";
		int counter = 0;
		int size = str1.length();
		System.out.println("hello");
		int j =0;
		List<Integer> indexes = new ArrayList<>();
		Map<Character, Integer> map1 =new HashMap<>();
		Map<Character, Integer> map2 =new HashMap<>();
		
		for(int i =0; i < size; i++) {
			char ch = str1.charAt(i);
			map1.put(ch, map1.getOrDefault(ch, 0) +1);
		}
		
	
		for(int i =0; i< str2.length(); i++) {
			char ch = str2.charAt(i);
			if(i>=str1.length())  {                                            //&& map1.containsKey(str2.charAt(i-size))
				char pre = str2.charAt(i-size);
				if( map1.get(pre) == map2.get(pre) ) {
					counter--;
				}
				map2.put(pre, map2.getOrDefault(pre, 0) - 1);
				
				if( map1.get(pre) == map2.get(pre) ) {
					counter++;
				}
			}
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
			Integer instances = map2.get(ch);
			
			if(map1.get(ch) == instances) {
				counter++;
			}else if(map1.get(ch) < instances) {
				counter--;
			}
			
			if(counter == map1.size()) {
				indexes.add(i-size +1);
			}
			
		}
		
		for(Integer x: indexes) {
			System.out.println(x);
		}
	}
	}

