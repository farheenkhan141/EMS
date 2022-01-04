package com.training.employeemanagementsystem.constant;

public enum Gender {
	MALE, FEMALE, OTHER;
	
	public static Gender toEnum(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			return Gender.MALE;
		}if(gender.equalsIgnoreCase("female")) {
			return Gender.FEMALE;
		}
		return Gender.OTHER;
		
	}
}
