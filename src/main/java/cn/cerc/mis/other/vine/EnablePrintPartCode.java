package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnablePrintPartCode implements IBookOption {

    @Override
    public String getTitle() {
        return "在打印报表时是否打印商品编号";
    }

}
