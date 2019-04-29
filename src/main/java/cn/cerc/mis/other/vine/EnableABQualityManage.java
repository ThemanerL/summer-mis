package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableABQualityManage implements IBookOption {

    @Override
    public String getTitle() {
        return "是否开启进货单商品品质状况管理";
    }

}
