package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowERPSynchro implements IBookOption {

    @Override
    public String getTitle() {
        return "允许地藤系统与ERP系统交换数据,此功能当前暂支持华软ERP系统";
    }

}
