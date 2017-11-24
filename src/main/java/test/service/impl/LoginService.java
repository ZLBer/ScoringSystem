package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.Login;
import test.domain.LoginExample;
import test.mapper.LoginMapper;
import test.service.ILoginService;

import javax.annotation.Resource;
import java.util.List;

@Service("loginService")
public class LoginService implements ILoginService {
    @Resource
    LoginMapper loginMapper;
    @Override
    public Login verifyUserIdentity(String username, String password, int type) {
        username = username.trim();
        password = password.trim();
        LoginExample example = new LoginExample();
        LoginExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(username);
        List<Login> users = loginMapper.selectByExample(example);
        for (Login user:users){
            if (user.getPassword().equals(password)&&user.getCategory()==type)
                return user;
        }
        return null;
    }
}
