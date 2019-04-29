package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class BEDefaultBankAccount implements IBookOption {

    @Override
    public String getTitle() {
        return "默认柜台银行刷卡账户";
    }

}
