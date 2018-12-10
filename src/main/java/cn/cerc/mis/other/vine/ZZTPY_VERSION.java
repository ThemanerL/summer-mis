package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class ZZTPY_VERSION implements IBookOption {

    @Override
    public String getTitle() {
        return "启动【郑州太平洋】专用功能项";
    }

}
