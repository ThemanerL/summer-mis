package cn.cerc.jui.parts;

import cn.cerc.jui.core.Component;
import cn.cerc.jui.core.HtmlWriter;

public class UIControl extends UIComponent {

    public UIControl(UIComponent owner) {
        super(owner);
    }

    @Override
    public void output(HtmlWriter html) {
        for (Component component : this.getComponents()) {
            if (component instanceof UIComponent)
                ((UIComponent) component).output(html);
        }
    }

}
