package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class BookInfo_Set implements IBookOption {

    @Override
    public String getTitle() {
        return "帐套基本资料设置";
    }

    @Override
    public String getKey() {
        return "_BookInfoSet_";
    }

}
