package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AccInitYearMonth implements IBookOption {

    @Override
    public String getTitle() {
        return "财务期初开帐年月";
    }

}
