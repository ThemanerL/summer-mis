package cn.cerc.jbean.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.cerc.jbean.form.IForm;
import cn.cerc.jbean.tools.AppLoginManage;
import cn.cerc.jdb.core.IHandle;

public class Application {
    private static String xmlFile = "classpath:application.xml";
    private static ApplicationContext context;
    private static AppConfig appConfig;

//    private static ApplicationContext serviceItems;
//    private static String serviceFile = "classpath:app-services.xml";
    private static ApplicationContext reportItems;
    private static String reportFile = "classpath:app-report.xml";

    // Tomcat JSESSION.ID
    public static final String sessionId = "sessionId";
    // token id
    public static final String token = "ID";
    // user id
    public static final String userId = "UserID";
    public static final String userCode = "UserCode";
    public static final String userName = "UserName";
    public static final String roleCode = "RoleCode";
    public static final String bookNo = "BookNo";
    public static final String deviceLanguage = "language";

    // 签核代理用户列表，代理多个用户以半角逗号隔开
    public static final String ProxyUsers = "ProxyUsers";
    // 客户端代码
    public static final String clientIP = "clientIP";
    // 本地会话登录时间
    public static final String loginTime = "loginTime";
    // 浏览器通用客户设备Id
    public static final String webclient = "webclient";
    // 默认界面语言版本
    public static final String LangageDefault = "cn"; // 可选：cn/en

    public static ApplicationContext getContext() {
        init();
        return context;
    }

    @Deprecated // 请改使用getAppConfig
    public static AppConfig getConfig() {
        init();
        return appConfig;
    }

    public static AppConfig getAppConfig() {
        init();
        return appConfig;
    }

    public static IHandle getHandle() {
        init();
        if (!context.containsBean("AppHandle"))
            throw new RuntimeException(String.format("%s 中没有找到 bean: AppHandle", xmlFile));

        return context.getBean("AppHandle", IHandle.class);
    }

    public static IPassport getPassport(IHandle handle) {
        init();
        AbstractHandle bean = getBean("Passport", AbstractHandle.class);
        if (handle != null)
            bean.setHandle(handle);
        return (IPassport) bean;
    }

    public static boolean containsBean(String beanCode) {
        init();
        return context.containsBean(beanCode);
    }

    public static <T> T getBean(String beanCode, Class<T> requiredType) {
        init();
        return context.getBean(beanCode, requiredType);
    }

    public static IService getService(IHandle handle, String serviceCode) {
        init();

        if (!context.containsBean(serviceCode))
            return null;

        IService bean = context.getBean(serviceCode, IService.class);
        if (handle != null)
            bean.init(handle);
        
        return bean;
    }

    public static IForm getForm(HttpServletRequest req, HttpServletResponse resp, String formId) {
        if (formId == null || formId.equals("") || formId.equals("service"))
            return null;

        init();

//        ApplicationContext applicationContext = WebApplicationContextUtils
//                .getRequiredWebApplicationContext(req.getServletContext());

        if (!context.containsBean(formId))
            throw new RuntimeException(String.format("form %s not find!", formId));

        IForm form = context.getBean(formId, IForm.class);
        form.setRequest(req);
        form.setResponse(resp);

        return form;
    }

    public static ApplicationContext getReportItems() {
        if (reportItems == null)
            reportItems = new FileSystemXmlApplicationContext(reportFile);
        return reportItems;
    }

    @Deprecated // 请改使用 getApplicationContext
    public static ApplicationContext getServices() {
        init();
        return context;
    }

    private static void init() {
        if (context == null) {
            context = new FileSystemXmlApplicationContext(xmlFile);
            appConfig = context.getBean("AppConfig", AppConfig.class);
            if (appConfig == null)
                throw new RuntimeException(String.format("%s 中没有找到 bean: AppConfig", xmlFile));
        }
    }

    public static String getLangage() {
        init();
        String lang = cn.cerc.jdb.core.ServerConfig.getInstance().getProperty(deviceLanguage);
        if (lang == null || "".equals(lang) || LangageDefault.equals(lang))
            return LangageDefault;
        else if ("en".equals(lang))
            return lang;
        else
            throw new RuntimeException("not support language: " + lang);
    }
}
