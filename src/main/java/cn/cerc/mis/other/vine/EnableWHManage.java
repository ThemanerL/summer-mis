package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableWHManage implements IBookOption {

    @Override
    public String getTitle() {
        return "启用多仓别管理，允许设置多个仓别及使用仓别调拔单";
    }

}
