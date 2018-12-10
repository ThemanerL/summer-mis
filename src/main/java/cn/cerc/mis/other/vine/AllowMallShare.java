package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowMallShare implements IBookOption {

    @Override
    public String getTitle() {
        return "是否开放在线商城（允许所有人查看本公司商品信息）";
    }

}
