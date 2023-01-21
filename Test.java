package com.problem;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string :- ");
		String str = sc.next();
		HashMap<Character, Integer> count = new HashMap<>();
		StringBuilder change = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			count.put(str.charAt(i), count.getOrDefault(str.charAt(i), 0) + 1);
		}
		for (char i = 'a'; i <= 'z'; i++) {
			for (Map.Entry<Character, Integer> iteretor : count.entrySet()) {
				if (i == iteretor.getKey()) {

					for (int l = count.get(i); l > 1; l /= 2) {
						change.append(i);

					}
				}
			}
		}
		for (char i = 'a'; i <= 'z'; i++) {
			for (Map.Entry<Character, Integer> iteretor : count.entrySet()) {
				if (i == iteretor.getKey() && (change.length() <= str.length() / 2) && (iteretor.getValue() % 2 != 0)) {
					change.append(i);
				}
			}

		}
		char last = change.charAt(change.length() - 1);
		char[] arr = new char[change.length() - 1];
		for (int i = 0; i < change.length() - 1; i++) {
			arr[i] = change.charAt(i);
		}
		Arrays.sort(arr);
		String str1 = String.valueOf(arr);
		change.delete(0, change.length());

		change.append(str1);
		if ((str.length() % 2 != 0))
			change.append(last);
		if ((str.length() % 2 == 0) && (count.get(last) % 2 == 0)) {
			change.append(last);
			change.append(last);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			change.append(arr[i]);
		}
		System.out.println("Final String :- " + change);
		sc.close();
	}
}
