package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class PurToPurFinal implements IBookOption {

    @Override
    public String getTitle() {
        return "关闭手开采购自动审核";
    }

}
