package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableForecastMode implements IBookOption {

    @Override
    public String getTitle() {
        return "是否开启销售预测管理模式";
    }

}
