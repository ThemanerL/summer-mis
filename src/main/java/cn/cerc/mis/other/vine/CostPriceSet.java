package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class CostPriceSet implements IBookOption {

    @Override
    public String getTitle() {
        return "成本单价取移动加权价（如打上勾取加权价，如不打上勾取进货价）";
    }

}
