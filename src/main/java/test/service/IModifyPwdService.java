package test.service;

/**
 * Created by libin on 2017/9/24.
 */
public interface IModifyPwdService {
    int modifyMemberPwd(Object user, String password);
    int  modifyAdminPwd(Object user, String password);
}
