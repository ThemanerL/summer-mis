package cn.cerc.jui.fields;

import cn.cerc.core.Record;
import cn.cerc.jui.core.HtmlWriter;
import cn.cerc.jui.parts.UIComponent;

public class CustomField extends AbstractField {

    public CustomField(UIComponent dataView, String name, int width) {
        super(dataView, name, width);
        this.setField("_selectCheckBox_");
    }

    @Override
    public String getText(Record ds) {
        if (buildText == null)
            return "";
        HtmlWriter html = new HtmlWriter();
        buildText.outputText(ds, html);
        return html.toString();
    }

}
