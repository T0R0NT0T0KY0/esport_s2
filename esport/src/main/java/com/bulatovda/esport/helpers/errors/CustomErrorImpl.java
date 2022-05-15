package com.bulatovda.esport.helpers.errors;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomErrorImpl implements CustomError {
	private String error;
	private List<CustomErrorDetail> details;

	public CustomErrorImpl(String error, String detail) {
		List<CustomErrorDetail> details = new ArrayList<>();
		details.add(new CustomErrorDetail(detail));
		this.error = error;
		this.details = details;
	}

	public CustomErrorImpl(String error, List<String> details) {
		this.error = error;
		this.details = details.stream().map(CustomErrorDetail::new).collect(Collectors.toList());
	}

	@Override
	public List<CustomErrorDetail> addDetail(String detail) {
		details.add(new CustomErrorDetail(detail));
		return details;
	}
}
