package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableNotODToBC implements IBookOption {

    @Override
    public String getTitle() {
        return "启用无订单出货模式，允许直接录入批发出货单";
    }

}
