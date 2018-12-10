package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class CreditLineApproveUser implements IBookOption {

    @Override
    public String getTitle() {
        return "超出信用额度审核人员帐号（注：须先启用单据审核流程管理）";
    }

}
