package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class DefaultProfitMargin implements IBookOption {

    @Override
    public String getTitle() {
        return "网单代发货利润率（<font color=red>需启用O2O模组</font>）";
    }

}
