package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class PurSafetyRateDefault implements IBookOption {

    @Override
    public String getTitle() {
        return "设置安全库存采购线默认20%低于此值时，将会生成采购建议值";
    }

}
