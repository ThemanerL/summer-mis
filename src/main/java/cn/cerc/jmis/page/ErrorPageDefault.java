package cn.cerc.jmis.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cerc.jmis.core.IErrorPage;

public class ErrorPageDefault implements IErrorPage {

    @Override
    public String getErrorPage(HttpServletRequest req, HttpServletResponse resp, Throwable error) {
        error.printStackTrace();
        String msg = error.toString();
        req.setAttribute("msg", msg.substring(msg.indexOf(":") + 1));
        PrintWriter out;
        try {
            out = resp.getWriter();
            out.println("error: " + msg);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
