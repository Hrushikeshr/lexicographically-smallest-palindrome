package com.problem;

import java.util.HashMap;
import java.util.Scanner;

public class NewTest {

    public static void palindrome(String s, int n) {
    	try {
    		 HashMap<Character, Integer> cnt = new HashMap<>();
    	        String R = "";

    	        // Count the occurrences of
    	        // every character in the string
    	        char[] strArray = s.toCharArray();
    	        for(char ch : strArray) {
    	            if(cnt.containsKey(ch)) {
    	                cnt.put(ch, cnt.get(ch) + 1);
    	            } else {
    	                cnt.put(ch, 1);
    	            }
    	        }
    	        // Create a string of characters
    	        // with odd occurrences
    	        for(char ch='a'; ch<='z'; ch++) {
    	            if((cnt.get(ch) != null) && cnt.get(ch) % 2 != 0) {
    	                R = R + ch;
    	            }
    	        }
    	        int l = R.length();
    	        int j = 0;
    	        char[] rArray = R.toCharArray();

    	        for(int i = l-1; i >= l/2; i--) {
    	            cnt.put(rArray[i], cnt.get(rArray[i]) - 1);
    	            rArray[i] = rArray[j];
    	            cnt.put(rArray[j], cnt.get(rArray[j])+1);
    	            j++;
    	        }
    	        // Create three strings to make
    	        // first half second half and
    	        // middle one.
    	        String first = "";
    	        String middle = "";
    	        StringBuilder second = new StringBuilder();
    	        for(char ch='a'; ch<='z'; ch++) {
    	            if(cnt.get(ch) != null) {
    	                if(cnt.get(ch) % 2 == 0) {
    	                    j = 0;
    	                    while(j < cnt.get(ch)/2) {
    	                        first = first + ch;
    	                        j++;
    	                    }
    	                } else {
    	                    j = 0;

    	                    while(j < (cnt.get(ch)-1)/2) {
    	                        first = first + ch;
    	                        j++;
    	                    }
    	                    middle = middle + ch;
    	                }
    	            }
    	        }

    	        second.append(first);
    	        second.reverse();

    	        String result = first + middle + second;

    	        System.out.println(result);
		} catch (Exception e) {
			System.out.println("Unusual Access");
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
    	try {
    		  Scanner scanner = new Scanner(System.in);
    		  System.out.println("Please enter a string: ");
    	        String S = scanner.next();
    	        int n = S.length();
    	        palindrome(S,n);
    	        scanner.close();
		} catch (Exception e) {
			System.out.println("Exception occur");
		}
      

    }
}
