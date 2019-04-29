package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class NotPrintListUP implements IBookOption {

    @Override
    public String getTitle() {
        return "在商品条码中不打印统一售价";
    }

}
