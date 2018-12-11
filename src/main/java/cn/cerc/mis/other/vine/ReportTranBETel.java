package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ReportTranBETel implements IBookOption {

    @Override
    public String getTitle() {
        return "小票打印报表店家电话";
    }

}