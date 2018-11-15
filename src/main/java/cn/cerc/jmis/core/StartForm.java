package cn.cerc.jmis.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import cn.cerc.jbean.core.Application;
import cn.cerc.jbean.core.CustomHandle;
import cn.cerc.jbean.form.IForm;
import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.page.HtmlPage;
import cn.cerc.jmis.page.JsonPage;
import cn.cerc.jmis.page.JspPage;
import cn.cerc.jmis.page.RedirectPage;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/app")
public class StartForm implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(StartForm.class);
    private ApplicationContext applicationContext;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    @Qualifier("customHandle")
    private CustomHandle handle;
    @Autowired
    @Qualifier("clientDevice")
    private ClientDevice clientDevice;

    @RequestMapping("/{formId}.{funcId}")
    public String execute(@PathVariable String formId, @PathVariable String funcId) {
        log.debug(String.format("formId: Frm%s, funcId: %s", formId, funcId));
        if (!applicationContext.containsBean(formId))
            return String.format("formId: Frm%s, funcId: %s", formId, funcId);
        IForm form = applicationContext.getBean(formId, IForm.class);
        try {
            form.setHandle(handle);
            form.setRequest(request);
            form.setResponse(response);

            clientDevice.setRequest(request);
            
            handle.setProperty(Application.sessionId, request.getSession().getId());
            handle.setProperty(Application.deviceLanguage, clientDevice.getLanguage());
            
            request.setAttribute("myappHandle", handle);
            request.setAttribute("_showMenu_", !ClientDevice.device_ee.equals(clientDevice.getDevice()));
            
            form.setClient(clientDevice);
            IPage page = form.execute();
            if (page instanceof JspPage) {
                JspPage jspPage = (JspPage) page;
                return jspPage.getViewFile();
            } else if (page instanceof JsonPage) {
                JsonPage jsonPage = (JsonPage) page;
                response.getWriter().println(jsonPage.toString());
                return null;
            } else if (page instanceof HtmlPage) {
                page.execute();
                return null;
            } else if (page instanceof RedirectPage) {
                RedirectPage redirectPage = (RedirectPage) page;
                return "redirect:" + redirectPage.buildUrl();
            } else {
                log.error("not support: " + page.getClass().getName());
                response.getWriter().println(form.execute().toString());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/{formId}")
    public String execute(@PathVariable String formId) {
        return execute(formId, "execute");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
