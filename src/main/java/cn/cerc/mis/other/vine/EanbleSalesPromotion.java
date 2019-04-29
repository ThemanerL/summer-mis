package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EanbleSalesPromotion implements IBookOption {

    @Override
    public String getTitle() {
        return "启用促销包作业模式，用于满足如买M送N，或量大优惠等";
    }

}
