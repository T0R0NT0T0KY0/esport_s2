package com.bulatovda.esport.helpers.errors;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomErrorImpl implements CustomError {
	private String error;
	private List<CErrDetails> details;


	@Override
	public String getMessage() {
		return "{" +
				"\terror: \"" + error + "\"," +
				"\tdetails: [" + details + "]" +
				"}";
	}
}
