package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class UpdateInUPFromAA implements IBookOption {

    @Override
    public String getTitle() {
        return "允许在进货时，使用输入的进货价来更新商品基本资料中的进货价";
    }

}
