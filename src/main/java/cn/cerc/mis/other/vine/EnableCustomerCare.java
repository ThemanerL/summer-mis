package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableCustomerCare implements IBookOption {

    @Override
    public String getTitle() {
        return "启用客户关怀功能，允许一个客户有多个联系人，并登记其生日提醒等资料";
    }

}
