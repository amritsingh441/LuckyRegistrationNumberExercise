package com.stackroute;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Complete the code below as given in the problem.md file
public class LuckyRegistrationNumber {


	public static int checkRegistrationNumber(String regNumber) {
		String pattern = "^(KA|DL)(0[1-9]|10)[A-Z]{1,2}[1-9]\\d{3}$";
		Pattern ptr = Pattern.compile(pattern);
		Matcher mtchr = ptr.matcher(regNumber);
		int n = 0, sum = 0;
		if(mtchr.matches()) {
			int tmp = Integer.parseInt(regNumber.substring(regNumber.length()-4));
			while(tmp > 0) {
				n = tmp%10;
				sum = sum + n;
				tmp = tmp/10;
			}
			if(sum%9 == 6) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return -1;
		}
	}

	//Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		//Use Scanner to get input from console
		Scanner sc = new Scanner(System.in);
		String regNumber = sc.nextLine();
		int res = checkRegistrationNumber(regNumber);
		if(res == 0) {
			System.out.println("Valid Registration Number");
		}else if (res == 1) {
			System.out.println("Lucky Registration Number");
		}else {
			System.out.println("Invalid Registration Number");
		}
	}
}