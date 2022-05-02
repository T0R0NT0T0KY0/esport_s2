package com.bulatovda.esport.helpers.errors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CErrDetails {
	private String error;

	@Override
	public String toString() {
		return "{" +
				"\terror: \"" + error + "\"" +
				"}";
	}
}
