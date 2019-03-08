package com.chainsys.validator;

import com.chainsys.model.User;


public class Validator {
	public void validatePin(User user) throws Exception {
		if(user.getPin()>=9999 && user.getPin()<=1000)
		{
			throw new Exception("Invalid pin number");
		}
	}

}
