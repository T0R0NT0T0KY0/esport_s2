package com.bulatovda.esport.modules.users.errors;

import com.bulatovda.esport.helpers.errors.CErrDetails;
import com.bulatovda.esport.helpers.errors.CustomErrorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserErrors {

	public static CustomErrorImpl notUniqueEmail(String err) {
		return createError(err, "Пользователь с таким Email уже существует");
	}


	public static CustomErrorImpl createError(String err, String detail) {
		List<CErrDetails> list = new ArrayList<>();
		list.add(new CErrDetails(detail));
		return new CustomErrorImpl(err, list);
	}

	public static CustomErrorImpl createError(String err, List<String> details) {
		List<CErrDetails> list =
				details.stream().map(CErrDetails::new).collect(Collectors.toList());
		return new CustomErrorImpl(err, list);
	}
}
