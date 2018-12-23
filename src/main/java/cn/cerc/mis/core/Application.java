package cn.cerc.mis.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.cerc.core.IHandle;
import cn.cerc.core.SupportHandle;
import cn.cerc.db.core.IAppConfig;
import cn.cerc.db.core.ServerConfig;
import cn.cerc.mis.form.IForm;

public class Application {
    // private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static String xmlFile = "classpath:application.xml";
    private static ApplicationContext context;

    // private static ApplicationContext serviceItems;
    // private static String serviceFile = "classpath:app-services.xml";
    // private static ApplicationContext reportItems;
    // private static String reportFile = "classpath:app-report.xml";

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

    public static IAppConfig getAppConfig() {
        init();

        if (context.containsBean("AppConfig")) // 请不要再使用这个beanId
            return context.getBean("AppConfig", IAppConfig.class);

        if (context.containsBean("appConfig"))
            return context.getBean("appConfig", IAppConfig.class);

        return context.getBean("appConfigDefault", IAppConfig.class);
    }

    public static IHandle getHandle() {
        init();

        if (context.containsBean("AppHandle")) // 请不要再使用这个beanId
            return context.getBean("AppHandle", IHandle.class);

        if (context.containsBean("handle"))
            return context.getBean("handle", IHandle.class);

        if (context.containsBean("handleDefault"))
            return context.getBean("handleDefault", IHandle.class);
        else
            throw new RuntimeException(String.format("%s 中没有找到 bean: handle 及  handleDefault", xmlFile));

    }

    public static IPassport getPassport(IHandle handle) {
        init();
        IPassport bean = getBean("passport", IPassport.class);
        if (bean != null && handle != null)
            bean.setHandle(handle);
        return bean;
    }

    public static boolean containsBean(String beanId) {
        init();
        return context.containsBean(beanId);
    }

    public static <T> T getBean(String beanId, Class<T> requiredType) {
        init();
        return context.getBean(beanId, requiredType);
    }

    public static IAppErrorPage getAppErrorPage() {
        init();

        if (context.containsBean("appErrorPage"))
            return context.getBean("appErrorPage", IAppErrorPage.class);

        return context.getBean("appErrorPageDefault", IAppErrorPage.class);
    }

    public static IService getService(IHandle handle, String serviceCode) {
        init();
        IService bean = context.getBean(serviceCode, IService.class);
        if (bean != null && handle != null)
            bean.init(handle);
        return bean;
    }

    public static <T> T get(Class<T> requiredType) {
        init();

        String[] items = requiredType.getName().split("\\.");
        String itemId = items[items.length - 1];

        String beanId;
        if (itemId.substring(0, 2).toUpperCase().equals(itemId.substring(0, 2))) {
            beanId = itemId;
        } else {
            beanId = itemId.substring(0, 1).toLowerCase() + itemId.substring(1);
        }

        T bean = context.getBean(beanId, requiredType);
        return bean;
    }

    public static <T> T get(IHandle handle, Class<T> requiredType) {
        T bean = get(requiredType);
        if (bean != null && handle != null) {
            if (bean instanceof SupportHandle)
                ((SupportHandle) bean).init(handle);
        }
        return bean;
    }

    public static <T> T get(String beanId, Class<T> requiredType) {
        init();
        return context.getBean(beanId, requiredType);
    }

    public static <T> T get(String beanId, Class<T> requiredType, String beanDefaultId) {
        init();
        return context.getBean(context.containsBean(beanId) ? beanId : beanDefaultId, requiredType);
    }

    public static IForm getForm(HttpServletRequest req, HttpServletResponse resp, String formId) {
        if (formId == null || formId.equals("") || formId.equals("service"))
            return null;

        init();

        // ApplicationContext applicationContext = WebApplicationContextUtils
        // .getRequiredWebApplicationContext(req.getServletContext());

        if (!context.containsBean(formId))
            throw new RuntimeException(String.format("form %s not find!", formId));

        IForm form = context.getBean(formId, IForm.class);
        if (form != null) {
            form.setRequest(req);
            form.setResponse(resp);
        }

        return form;
    }

    private static synchronized void init() {
        if (context == null)
            context = new FileSystemXmlApplicationContext(xmlFile);
    }

    public static String getLangage() {
        init();
        String lang = ServerConfig.getInstance().getProperty(deviceLanguage);
        if (lang == null || "".equals(lang) || LangageDefault.equals(lang))
            return LangageDefault;
        else if ("en".equals(lang))
            return lang;
        else
            throw new RuntimeException("not support language: " + lang);
    }

}
