package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportBarcode implements IBookOption {

    @Override
    public String getTitle() {
        return "条码标签广告语";
    }

}
