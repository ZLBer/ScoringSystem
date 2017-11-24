package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.Login;
import test.service.IModifyPwdService;

import javax.annotation.Resource;

/**
 * Created by libin on 2017/9/24.
 */
@Service("modifyPwdService")
public class ModifyPwdService implements IModifyPwdService {
    @Override
    public int modifyPwd(Login user, String password) {
        return 0;
    }
}
