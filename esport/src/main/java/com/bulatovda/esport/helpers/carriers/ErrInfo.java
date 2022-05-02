package com.bulatovda.esport.helpers.carriers;


public interface ErrInfo<E, D> {

	ErrData<E, D> setData(D data);
	ErrData<E, D> setError(E error);

	E getError();

	D getData();
}
