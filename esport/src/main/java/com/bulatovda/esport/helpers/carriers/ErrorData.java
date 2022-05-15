package com.bulatovda.esport.helpers.carriers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorData<E, D> implements ErrorInfo<E, D> {

	private D data;
	private E error;

	public ErrorData<E, D> setData(D data) {
		this.data = data;
		return this;
	}

	public ErrorData<E, D> setError(E error) {
		this.error = error;
		return this;
	}
}
