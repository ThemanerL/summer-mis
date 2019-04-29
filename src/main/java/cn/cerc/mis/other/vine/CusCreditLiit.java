package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class CusCreditLiit implements IBookOption {

    @Override
    public String getTitle() {
        return "启用客户信用额度管理";
    }

}
