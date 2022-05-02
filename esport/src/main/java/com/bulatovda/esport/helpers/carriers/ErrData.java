package com.bulatovda.esport.helpers.carriers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrData<E, D> implements ErrInfo<E, D> {

	private D data;
	private E error;

	public ErrData<E, D> setData(D data) {
		this.data = data;
		return this;
	}

	public ErrData<E, D> setError(E error) {
		this.error = error;
		return this;
	}
}
