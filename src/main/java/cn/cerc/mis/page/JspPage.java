package cn.cerc.mis.page;

import cn.cerc.mis.form.IForm;

public class JspPage extends AbstractJspPage {

    public JspPage(IForm form) {
        super(form);
    }

    public JspPage(IForm form, String jspFile) {
        super(form);
        this.setJspFile(jspFile);
    }

    public void add(String id, Object value) {
        put(id, value);
    }
}
