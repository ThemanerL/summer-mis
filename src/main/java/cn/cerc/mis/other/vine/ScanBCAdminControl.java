package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ScanBCAdminControl implements IBookOption {

    @Override
    public String getTitle() {
        return "扫描状态变更由专人控制";
    }

}
