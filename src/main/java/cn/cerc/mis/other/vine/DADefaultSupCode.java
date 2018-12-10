package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class DADefaultSupCode implements IBookOption {

    @Override
    public String getTitle() {
        return "MRP计算时，默认厂商代码";
    }

}
