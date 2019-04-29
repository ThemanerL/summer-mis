package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class SafetyStockSynPartStock implements IBookOption {

    @Override
    public String getTitle() {
        return "启用分仓别进行安全库存设置(其会自动同步到商品基本资料档)";
    }

}
