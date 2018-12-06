package cn.cerc.jui.grid;

import cn.cerc.mis.form.IForm;
import cn.cerc.jui.parts.UIComponent;

public class GridFactory {

    public static AbstractGrid build(IForm form, UIComponent owner) {
        AbstractGrid grid;
        if (form.getClient().isPhone())
            grid = new PhoneGrid(form, owner);
        else
            grid = new DataGrid(form, owner);
        return grid;
    }
}
