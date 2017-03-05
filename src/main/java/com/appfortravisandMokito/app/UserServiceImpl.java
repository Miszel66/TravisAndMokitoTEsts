package com.appfortravisandMokito.app;

/**
 * Created by user on 05.03.2017.
 */
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;
    private SecurityService securityService;

    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    public UserServiceImpl(UserDAO dao, SecurityService security) {
        this.userDAO = dao;
        this.securityService = security;
    }
}
