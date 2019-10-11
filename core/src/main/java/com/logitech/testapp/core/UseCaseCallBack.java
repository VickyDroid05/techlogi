package com.logitech.testapp.core;

public interface UseCaseCallBack<T> {

    void onSuccessCallBack(T t);

    void onErrorCallBack(Failure error);

}
