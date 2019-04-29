package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableTranDetailCW implements IBookOption {

    @Override
    public String getTitle() {
        return "启动库存入、出库单单身仓别管理";
    }

}
