package cn.cerc.jmis.page.qrcode;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.core.ClientDevice;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.service.SvrAutoLogin;

public class FrmQRCode extends AbstractForm implements JayunEasyLogin {

    @Override
    public IPage execute() throws Exception {
        new JayunQrcode(this.getRequest(), this.getResponse()).execute(this);
        return null;
    }

    @Override
    public JayunMessage getLoginToken() {
        JayunMessage message;
        SvrAutoLogin svrLogin = new SvrAutoLogin(this);
        if (svrLogin.check(this, this.getRequest())) {
            ClientDevice info = ((ClientDevice) this.getClient());
            message = new JayunMessage(true, "已确认");
            message.setToken(info.getSid());
            message.setUrl("WebDefault");
        } else {
            message = new JayunMessage(false, svrLogin.getMessage());
        }
        return message;
    }

    @Override
    public String getNotifyUrl() {
        return "FrmSecurity";
    }

    @Override
    public boolean logon() {
        return true;
    }

}
