package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class DefaultProcCode implements IBookOption {

    @Override
    public String getTitle() {
        return "BOM默认制程代码（仅用于制造业版）";
    }

}
