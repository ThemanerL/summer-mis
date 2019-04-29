package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AvailableStockOption implements IBookOption {

    @Override
    public String getTitle() {
        return "可用库存设置，默认可用库存等于当前库存";
    }

}
