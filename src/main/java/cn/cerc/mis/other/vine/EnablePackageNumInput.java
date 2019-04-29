package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnablePackageNumInput implements IBookOption {

    @Override
    public String getTitle() {
        return "启用包装单位录单,即在录单时可以录入包装的数量";
    }

}
