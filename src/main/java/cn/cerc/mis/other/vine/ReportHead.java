package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportHead implements IBookOption {

    @Override
    public String getTitle() {
        return "报表表头设置";
    }

}
