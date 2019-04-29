package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableSendMobileIntro implements IBookOption {

    @Override
    public String getTitle() {
        return "EnableSendMobileIntro";
    }

}
