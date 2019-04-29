package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowDiyPartCode implements IBookOption {

    @Override
    public String getTitle() {
        return "关闭商品自动编号，改为手动录入商品编号";
    }

}
