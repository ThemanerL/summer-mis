package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class SenderInfo implements IBookOption {

    @Override
    public String getTitle() {
        return "对寄往本公司的收件人姓名、电话、地址进行设置";
    }

}
