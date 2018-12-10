package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowScanBCMode implements IBookOption {

    @Override
    public String getTitle() {
        return "允许出货作业时，使用条码枪备货扫描作业模式";
    }

}
