package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AGAutoAreaBlack implements IBookOption {

    @Override
    public String getTitle() {
        return "将退货单自动设置成销售黑名单（须先启动区域专卖管控）";
    }

}
