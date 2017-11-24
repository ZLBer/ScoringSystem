package test.service;

import test.domain.Login;

/**
 * Created by libin on 2017/9/24.
 */
public interface IModifyPwdService {
    int modifyPwd(Login user, String password);
}
