package com.chainsys.validator;

import java.util.regex.Pattern;

public class ValidatorUtil {
	public static boolean isValidMobileNumber(String mobilenumber) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		java.util.regex.Matcher m = p.matcher(mobilenumber);
		return (m.find() && m.group().equals(mobilenumber));
	}
	public static boolean isValidName(String input){
		return input!= null && !input.trim().equals("") && input.matches("^[a-zA-Z]*$"); 

	}
	public static boolean isValidPassword(String input){
		return input!= null && !input.trim().equals("") ;
	}
//	public static boolean isValidId(int input){
//		Pattern digitpattern = Pattern.compile("//d{3}");
//		String[] number ={"input"};
//		return input>=0 && number.matches(digitpattern);
//
//	}
	public static boolean isValidEmail(String input){
		return input.indexOf('@')== -1 && input.indexOf('.')== -1;
	}

}
