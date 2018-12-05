package cn.cerc.jmis.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IErrorPage {
    String getErrorPage(HttpServletRequest req, HttpServletResponse resp, Throwable error);
}
