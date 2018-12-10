package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class BEDefaultCusCode implements IBookOption {

    @Override
    public String getTitle() {
        return "快速销售模式时，零售默认客户代码（<font color=red>新版系统将以默认零售会员为主</font>）";
    }

}
