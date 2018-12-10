package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class BMDefaultDeptCode implements IBookOption {

    @Override
    public String getTitle() {
        return "登记转账单时，银行费用默认部门代码";
    }

}
