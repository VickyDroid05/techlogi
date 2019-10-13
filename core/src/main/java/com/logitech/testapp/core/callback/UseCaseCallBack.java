package com.logitech.testapp.core.callback;

import com.logitech.testapp.core.error.Failure;

public interface UseCaseCallBack<T> {

    void onSuccessCallBack(T t);

    void onErrorCallBack(Failure error);

}
