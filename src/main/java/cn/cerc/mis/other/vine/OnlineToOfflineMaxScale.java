package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class OnlineToOfflineMaxScale implements IBookOption {

    @Override
    public String getTitle() {
        return "商家代发允许的最大时间，按分钟计（<font color=red>需启用O2O模组</font>）";
    }

}
