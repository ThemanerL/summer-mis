package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ABAndBGDefaultMonthly implements IBookOption {

    @Override
    public String getTitle() {
        return "进货时不登记现金付款金额，进货后由财务做付款单登记";
    }

}
