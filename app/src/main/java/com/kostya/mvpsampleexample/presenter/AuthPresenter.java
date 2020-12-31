package com.kostya.mvpsampleexample.presenter;

import com.kostya.mvpsampleexample.login_interface.IAuthView;
import com.kostya.mvpsampleexample.model.User;

public class AuthPresenter {

    private IAuthView iAuthView;
    private User user;

    public AuthPresenter(IAuthView iAuthView) {
        this.iAuthView = iAuthView;
    }

    public void validateData(String email,String password) {
        iAuthView.showProgress();
        user = new User(email, password);

        int userResultValidate = user.isValidate();

        switch (userResultValidate){
            case 1:
                iAuthView.showProgress();
                iAuthView.showResult("Введите почту");
                iAuthView.failure("Ошибка");
                iAuthView.hideProgress();
                break;

            case 2:
                iAuthView.showProgress();
                iAuthView.showResult("Введите папроль");
                iAuthView.failure("Ошибка");
                iAuthView.hideProgress();
                break;

            case 3:
                iAuthView.showProgress();
                iAuthView.showResult("Введите пустые поля");
                iAuthView.failure("Ошибка");
                iAuthView.hideProgress();
                break;

            case 0:
                iAuthView.showProgress();
                iAuthView.showResult("Успешный вход");
                iAuthView.success("Успешно");
                iAuthView.hideProgress();
                break;
            default:
                iAuthView.showProgress();
                iAuthView.showResult("Error");
                iAuthView.hideProgress();
        }
    }

}
