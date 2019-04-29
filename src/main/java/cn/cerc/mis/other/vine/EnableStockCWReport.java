package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableStockCWReport implements IBookOption {

    @Override
    public String getTitle() {
        return "启用进出仓通知作业模式，需要打印进、出仓通知单";
    }

}
