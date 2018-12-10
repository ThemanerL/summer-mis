package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportTranBCFoot implements IBookOption {

    @Override
    public String getTitle() {
        return "销售订单页尾备注";
    }

}
