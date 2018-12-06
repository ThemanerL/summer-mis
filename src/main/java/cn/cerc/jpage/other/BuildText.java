package cn.cerc.jpage.other;

import cn.cerc.core.Record;
import cn.cerc.jpage.core.HtmlWriter;

public interface BuildText {
    public void outputText(Record record, HtmlWriter html);
}
