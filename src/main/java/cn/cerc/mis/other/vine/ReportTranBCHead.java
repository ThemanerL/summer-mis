package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportTranBCHead implements IBookOption {

    @Override
    public String getTitle() {
        return "销售订单页头备注";
    }

}
