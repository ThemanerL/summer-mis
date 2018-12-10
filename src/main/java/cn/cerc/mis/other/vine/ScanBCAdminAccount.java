package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ScanBCAdminAccount implements IBookOption {

    @Override
    public String getTitle() {
        return "变更指定操作人员帐号";
    }

}
