package cn.cerc.mis.config;

import java.util.HashMap;
import java.util.Map;

import cn.cerc.jdb.core.IConfig;

public class AppConfigDefault implements IConfig {
    private Map<String, String> params = new HashMap<>();

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getPathForms() {
        return getParam("pathForms", "forms");
    }

    public String getPathServices() {
        return getParam("pathServices", "services");
    }

    /**
     * 
     * @return 返回默认的欢迎页
     */
    public String getFormWelcome() {
        return getParam("formWelcome", "welcome");
    }

    /**
     * 
     * @return 返回默认的主菜单
     */
    public String getFormDefault() {
        return getParam("formDefault", "default");
    }

    /**
     *
     * @return 退出系统确认画面
     */
    public String getFormLogout() {
        return getParam("formLogout", "logout");
    }

    /**
     * 
     * @return 当前设备第一次登录时需要验证设备
     */
    public String getFormVerifyDevice() {
        return getParam("formVerifyDevice", "VerifyDevice");
    }

    /**
     * 
     * @return 在需要用户输入帐号、密码进行登录时的显示
     */
    public String getJspLoginFile() {
        return getParam("jspLoginFile", "common/FrmLogin.jsp");
    }

    public String getParam(String key, String def) {
        String val = params.get(key);
        return val != null ? val : def;
    }

    @Override
    public String getProperty(String key, String def) {
        String val = params.get(key);
        return val != null ? val : def;
    }

    @Override
    public String getProperty(String key) {
        return params.get(key);
    }
}
