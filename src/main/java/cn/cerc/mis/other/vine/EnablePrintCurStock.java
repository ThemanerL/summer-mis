package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnablePrintCurStock implements IBookOption {

    @Override
    public String getTitle() {
        return "打印出仓通知单时打印分仓库存";
    }

}
