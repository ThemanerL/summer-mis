package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableStockLessControl implements IBookOption {

    @Override
    public String getTitle() {
        return "启用商品库存不足控制，不允许库存数量出现负数";
    }

}
