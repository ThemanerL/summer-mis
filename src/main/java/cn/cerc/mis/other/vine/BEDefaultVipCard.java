package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class BEDefaultVipCard implements IBookOption {

    @Override
    public String getTitle() {
        return "登记零售单时，零售默认会员代码";
    }

}
