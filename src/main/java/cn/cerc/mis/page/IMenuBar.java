package cn.cerc.mis.page;

import java.util.List;

import cn.cerc.mis.form.IForm;
import cn.cerc.jui.core.UrlRecord;

public interface IMenuBar {
    // 登记菜单栏菜单项
    public int enrollMenu(IForm form, List<UrlRecord> menus);
}
