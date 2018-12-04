package cn.cerc.jbean.other;

import org.springframework.stereotype.Component;

import cn.cerc.jbean.core.Application;
import cn.cerc.jmis.sms.PhoneVerify;

@Component
public class SystemTableVine implements SystemTable {

    // 帐套资料表
    @Override
    public String getBookInfo() {
        return "OurInfo";
    }

    // 帐套参数档
    @Override
    public String getBookOptions() {
        return "VineOptions";
    }

    // 应用菜单表
    @Override
    public String getAppMenus() {
        return "SysFormDef";

        PhoneVerify obj = Application.getBean("phoneVerify", PhoneVerify.class);
    }

    // 客户客制化菜单
    @Override
    public String getCustomMenus() {
        return "cusmenu";
    }

    // 用户自定义菜单
    @Override
    public String getUserMenus() {
        return "UserMenu";
    }

    // 用户资料表
    @Override
    public String getUserInfo() {
        return "Account";
    }

    // 用户参数表
    @Override
    public String getUserOptions() {
        return "UserOptions";
    }

    // 用户角色表
    @Override
    public String getUserRoles() {
        return "UserRoles";
    }

    // 角色权限表
    @Override
    public String getRoleAccess() {
        return "UserAccess";
    }

    // 用户设备认证记录表
    @Override
    public String getDeviceVerify() {
        return "AccountVerify";
    }

    // 安全手机管控表
    @Override
    public String getSecurityMobile() {
        return "s_securityMobile";
    }

    // 当前在线用户
    @Override
    public String getCurrentUser() {
        return "CurrentUser";
    }

    // 记录用户需要查看的消息
    @Override
    public String getUserMessages() {
        return "message_temp";
    }

    // 记录用户的关键操作
    @Override
    public String getUserLogs() {
        return "UserLogs";
    }

    // 记录应用服务被调用的历史
    @Override
    public String getAppLogs() {
        return "AppServiceLogs";
    }

    // 记录网页被调用的历史
    @Override
    public String getPageLogs() {
        return "WebPageLogs";
    }

    // 记录在线用户数
    @Override
    public String getOnlineUsers() {
        return "onlineusers";
    }

    // 运营商帐套代码
    @Override
    public String getManageBook() {
        return "000000";
    }

    // 多语言数据字典: 旧版本
    @Override
    public String getLangDict() {
        return "s_langDict";
    }

    // 多语言数据字典: 新版本
    @Override
    public String getLanguage() {
        return "s_language";
    }

    // 表格列自定义存储表，建议存于MongoDB
    public static String getGridManager() {
        return "s_gridManager";
    }

}