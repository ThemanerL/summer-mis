package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class UpdateTBDateToEffectiveDate implements IBookOption {

    @Override
    public String getTitle() {
        return "单据生效时，单据日期自动等于生效日期";
    }

}
