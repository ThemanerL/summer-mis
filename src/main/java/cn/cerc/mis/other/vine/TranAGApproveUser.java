package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class TranAGApproveUser implements IBookOption {

    @Override
    public String getTitle() {
        return "在无销售单时，进行销货退回时的审核人员帐号（注：须先启用单据审核流程管理）";
    }

}
