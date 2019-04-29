package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class UpdateCurrentMonthProfit implements IBookOption {

    @Override
    public String getTitle() {
        return "在修改进货价后，每晚自动更新本月所有单据的成本价与毛利";
    }

}
