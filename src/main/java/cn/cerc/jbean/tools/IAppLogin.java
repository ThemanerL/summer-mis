package cn.cerc.jbean.tools;

import java.io.IOException;

import javax.servlet.ServletException;

import cn.cerc.jbean.form.IForm;

public interface IAppLogin {

    void init(IForm form);

    String checkSecurity(String token) throws IOException, ServletException;

    String checkLogin(String userCode, String password) throws IOException, ServletException;

}
