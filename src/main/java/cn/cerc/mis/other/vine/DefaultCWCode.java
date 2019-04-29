package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class DefaultCWCode implements IBookOption {

    @Override
    public String getTitle() {
        return "默认仓别代码";
    }

}
