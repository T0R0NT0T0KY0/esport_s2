package com.bulatovda.esport.helpers.carriers;


public interface ErrorInfo<E, D> {

	ErrorData<E, D> setData(D data);
	ErrorData<E, D> setError(E error);

	E getError();

	D getData();
}
