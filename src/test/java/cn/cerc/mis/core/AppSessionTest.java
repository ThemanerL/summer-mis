package cn.cerc.mis.core;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.cerc.core.IHandle;
import cn.cerc.mis.other.UserNotFindException;

public class AppSessionTest {
    private IHandle handle;
    private String corpNo = "911001";
    private String userCode = "9110010001";
    private String clientIP = "127.0.0.1";

    @Before
    public void setUp() {
        handle = Application.getHandle();
    }

    @Test
    @Ignore
    public void test_init() throws UserNotFindException {
        handle.init(corpNo, userCode, clientIP);
        assertEquals("公司别赋值有误", corpNo, handle.getCorpNo());
    }

    @Test(expected = ServiceException.class)
    @Ignore
    public void test_init_error() throws ServiceException, UserNotFindException {
        handle.init(corpNo, userCode + "X", clientIP);
    }
}
