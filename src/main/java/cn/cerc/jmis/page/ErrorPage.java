package cn.cerc.jmis.page;

import java.io.IOException;

import javax.servlet.ServletException;

import cn.cerc.jbean.core.Application;
import cn.cerc.jbean.form.IForm;
import cn.cerc.jbean.form.IPage;

public class ErrorPage implements IPage {
    private Throwable error;
    protected IForm form;

    public ErrorPage() {
        super();
    }

    public ErrorPage(IForm page) {
        super();
        this.setForm(page);
    }

    public ErrorPage(IForm form, Throwable error) {
        super();
        this.setForm(form);
        this.error = error;
    }

    @Override
    public void setForm(IForm form) {
        this.form = form;
    }

    @Override
    public IForm getForm() {
        return form;
    }

    @Override
    public String execute() throws ServletException, IOException {
        error.printStackTrace();
        String message = error.toString();
        getRequest().setAttribute("msg", message.substring(message.indexOf(":") + 1));
        String jspFile = Application.getAppConfig().getJspErrorFile();
        return jspFile;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

}
