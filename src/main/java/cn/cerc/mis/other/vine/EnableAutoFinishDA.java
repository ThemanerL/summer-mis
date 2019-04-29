package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableAutoFinishDA implements IBookOption {

    @Override
    public String getTitle() {
        return "是否开启采购单自动结案";
    }

}
