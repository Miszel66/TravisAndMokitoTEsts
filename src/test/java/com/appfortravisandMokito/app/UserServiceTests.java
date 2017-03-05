package com.appfortravisandMokito.app;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by user on 05.03.2017.
 */
public class UserServiceTests {

    private final static UserDAO dao = mock(UserDAO.class);
    private final static SecurityService service = mock(SecurityService.class);
    private final static UserService userservice = new UserServiceImpl(dao,service);
    private static User user = mock(User.class);
    private static final String OLD_PASSWORD = "ZXC123";
    private static final String NEW_PASSWORD = "qwe123";


    @Test
    public void userPasswordChanges() throws Exception {

        when(user.getPassword()).thenReturn(OLD_PASSWORD);

        when(service.md5(user.getPassword())).thenReturn(NEW_PASSWORD);

        userservice.assignPassword(user);

        verify(user).setPassword(NEW_PASSWORD);
        verify(dao).updateUser(user);
    }
}
