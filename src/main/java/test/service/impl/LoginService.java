package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.AdminLogin;
import test.domain.MemberLogin;
import test.mapper.AdminLoginMapper;
import test.mapper.MemberLoginMapper;
import test.service.ILoginService;

import javax.annotation.Resource;

@Service("loginService")
public class LoginService implements ILoginService {

    @Resource
    MemberLoginMapper memberLoginMapper;
    @Resource
    AdminLoginMapper adminuserMapper;

    @Override
    public MemberLogin verifyMUserIdentity(String username, String password) {
        MemberLogin entity = memberLoginMapper.selectByPrimaryKey(username);
        if (entity!=null&&entity.getMemberPassword().equals(password)){
            return entity;
        }
        return null;
    }
    @Override
    public AdminLogin verifyAUserIdentity(String username, String password) {
        AdminLogin entity = adminuserMapper.selectByPrimaryKey(username);
        if (entity!=null&&entity.getAdminPassword().equals(password)){
            return entity;
        }
        return null;
    }
}
