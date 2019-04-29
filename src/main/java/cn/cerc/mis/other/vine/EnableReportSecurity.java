package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableReportSecurity implements IBookOption {

    @Override
    public String getTitle() {
        return "启用安全报表控制，未确认的单据不允许打印报表";
    }

}
