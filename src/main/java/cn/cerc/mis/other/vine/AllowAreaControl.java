package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowAreaControl implements IBookOption {

    @Override
    public String getTitle() {
        return "启用商品区域专卖控制，防范同区域恶性竞争";
    }

}
