package cn.cerc.mis.other.vine;

import org.springframework.stereotype.Component;

import cn.cerc.mis.core.IBookOption;

@Component
public class AllowERPSynchro implements IBookOption {

    @Override
    public String getTitle() {
        return "允许地藤系统与ERP系统交换数据,此功能当前暂支持华软ERP系统";
    }
//
//    public static void main(String[] args) {
//        BookOptions bookOptions;
//        if (bookOptions.getBoolean(AllowERPSynchro.class)) {
//
//        }
//        if (bookOptions.getInt(AllowERPSynchro.class)) {
//
//        }
//        if (bookOptions.getString(AllowERPSynchro.class)) {
//
//        }
//
//        for(String beanId : Application.getContext().getBeanNamesForType(IBookOption.class)) {
//            IBookOption bookOption = Application.getContext().getOption(beanId);
//            bookOption.getKey();
//        }
//    }
}
