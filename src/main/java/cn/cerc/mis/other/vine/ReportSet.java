package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportSet implements IBookOption {

    @Override
    public String getTitle() {
        return "可对报表台头、销售订单页头和页尾、条码标签广告语、小票打印、销售对账页尾进行设置";
    }

    @Override
    public String getKey() {
        return "Report";
    }

}
