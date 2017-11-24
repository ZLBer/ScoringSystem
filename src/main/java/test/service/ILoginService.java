package test.service;

import test.domain.*;

public interface ILoginService {
    MemberLogin verifyMUserIdentity(String username, String password);
    AdminLogin verifyAUserIdentity(String username, String password);
}
