package com.kostya.mvpsampleexample.login_interface;

public interface IAuthView extends ILoginView{

    void showResult(String message);

    void success(String message);

    void failure(String message);
}
