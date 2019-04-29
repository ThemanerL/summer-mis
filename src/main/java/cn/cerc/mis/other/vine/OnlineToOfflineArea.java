package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class OnlineToOfflineArea implements IBookOption {

    @Override
    public String getTitle() {
        return "网单代发区域等级范围设置（<font color=red>0、按省 1、按市 2、按县 3、指定市 4、指定县 5、指定镇</font>）";
    }

}
