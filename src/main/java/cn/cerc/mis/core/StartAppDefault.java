package cn.cerc.mis.core;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cerc.core.IHandle;
import cn.cerc.db.core.IAppConfig;

//@Controller
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@RequestMapping("/")
public class StartAppDefault {
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private HttpServletResponse resp;

    @RequestMapping("/")
    public String doGet() {
        if (req.getParameter(ClientDevice.deviceId_key) != null)
            req.getSession().setAttribute(ClientDevice.deviceId_key, req.getParameter(ClientDevice.deviceId_key));
        if (req.getParameter(ClientDevice.deviceType_key) != null)
            req.getSession().setAttribute(ClientDevice.deviceType_key, req.getParameter(ClientDevice.deviceType_key));

        IAppConfig conf = Application.getAppConfig();
        String jspFile = String.format("redirect：/%s/%s", conf.getPathForms(), conf.getFormWelcome());
        return jspFile;
    }

    @RequestMapping("/MobileConfig")
    @Deprecated
    public String MobileConfig() {
        return mobileConfig();
    }

    @RequestMapping("/mobileConfig")
    public String mobileConfig() {
        if (req.getParameter(ClientDevice.deviceId_key) != null)
            req.getSession().setAttribute(ClientDevice.deviceId_key, req.getParameter(ClientDevice.deviceId_key));
        if (req.getParameter(ClientDevice.deviceType_key) != null)
            req.getSession().setAttribute(ClientDevice.deviceType_key, req.getParameter(ClientDevice.deviceType_key));
        try {
            IForm form;
            if (Application.getContext().containsBean("mobileConfig"))
                form = Application.getBean("mobileConfig", IForm.class);
            else
                form = Application.getBean("MobileConfig", IForm.class);
            form.setRequest(req);
            form.setResponse(resp);

            IHandle handle = Application.getHandle();
            handle.setProperty(Application.sessionId, req.getSession().getId());
            form.setHandle(handle);
            IPage page = form.execute();
            return page.execute();
        } catch (Exception e) {
            try {
                resp.getWriter().print(e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }
    }
}
