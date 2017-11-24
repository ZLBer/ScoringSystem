package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.AdminLogin;
import test.domain.MemberLogin;
import test.mapper.AdminLoginMapper;
import test.mapper.MemberLoginMapper;
import test.service.IModifyPwdService;

import javax.annotation.Resource;

/**
 * Created by libin on 2017/9/24.
 */
@Service("modifyPwdService")
public class ModifyPwdService implements IModifyPwdService {

    @Resource
    MemberLoginMapper memberLoginMapper;
    @Resource
    AdminLoginMapper adminLoginMapper;

    @Override
   public int modifyMemberPwd(Object user, String password){
       MemberLogin studentlogin=(MemberLogin)user;
        studentlogin.setMemberPassword(password);
         return memberLoginMapper.updateByPrimaryKey(studentlogin);
    }
    public  int modifyAdminPwd(Object user, String password){
      AdminLogin adminuser=(AdminLogin)user;
        adminuser.setAdminPassword(password);
        return adminLoginMapper.updateByPrimaryKey(adminuser);

    }
}
