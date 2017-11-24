package test.service;

import test.domain.*;

public interface ILoginService {
    Login verifyUserIdentity(String username, String password,int type);
}
