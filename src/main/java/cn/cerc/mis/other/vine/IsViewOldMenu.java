package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class IsViewOldMenu implements IBookOption {

    @Override
    public String getTitle() {
        return "是否显示旧版菜单链接（带闪电标识）";
    }

}
