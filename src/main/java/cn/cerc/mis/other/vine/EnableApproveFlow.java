package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableApproveFlow implements IBookOption {

    @Override
    public String getTitle() {
        return "启用单据审核流程管理";
    }

}
