package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class EnableWorkPieceToOP implements IBookOption {

    @Override
    public String getTitle() {
        return "是否开启员工计件生成生产报工单";
    }

}
