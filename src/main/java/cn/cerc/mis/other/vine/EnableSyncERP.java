package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableSyncERP implements IBookOption {

    @Override
    public String getTitle() {
        return "启用华软ERP同步到地藤系统";
    }

}
