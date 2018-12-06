package cn.cerc.mis.tools;

import static cn.cerc.mis.other.UserOptions.UserOptionEnabled;

import cn.cerc.core.IHandle;
import cn.cerc.mis.excel.output.AccreditManager;

public class ExportAccreditManager implements AccreditManager {
    private String securityCode;
    private String describe;

    @Override
    public boolean isPass(Object handle) {
        if (securityCode == null)
            throw new RuntimeException("securityCode is null");
        IHandle appHandle = (IHandle) handle;
        return UserOptionEnabled(appHandle, securityCode);
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
