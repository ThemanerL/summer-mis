package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class DisablePasswordSave implements IBookOption {

    @Override
    public String getTitle() {
        return "禁止所有用户在电脑上保存密码";
    }

}
