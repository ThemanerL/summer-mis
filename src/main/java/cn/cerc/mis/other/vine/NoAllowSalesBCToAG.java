package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class NoAllowSalesBCToAG implements IBookOption {

    @Override
    public String getTitle() {
        return "不允许无销售订单进行退货";
    }

}