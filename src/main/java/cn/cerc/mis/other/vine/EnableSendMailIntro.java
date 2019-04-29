package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableSendMailIntro implements IBookOption {

    @Override
    public String getTitle() {
        return "启用邮件发送功能，在接单及出货时，自动发送邮件于客户";
    }

}
