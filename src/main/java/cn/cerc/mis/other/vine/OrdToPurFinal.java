package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class OrdToPurFinal implements IBookOption {

    @Override
    public String getTitle() {
        return "关闭订单转采购自动审核";
    }

}
