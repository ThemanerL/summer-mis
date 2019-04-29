package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class StudentFileSupCorpNo implements IBookOption {

    @Override
    public String getTitle() {
        return "设置互联上游账套（助学计划）";
    }

}
