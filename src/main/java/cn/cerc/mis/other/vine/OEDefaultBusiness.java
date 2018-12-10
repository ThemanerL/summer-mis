package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class OEDefaultBusiness implements IBookOption {

    @Override
    public String getTitle() {
        return "默认业务人员，用于处理在线订货单客户关联";
    }

}
