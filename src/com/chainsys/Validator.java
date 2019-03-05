package com.chainsys;


public class Validator {
	public void validatePin(User user) throws Exception {
		if(user.getPin()>=9999 && user.getPin()<=1000)
		{
			throw new Exception("Invalid pin number");
		}
	}

}
