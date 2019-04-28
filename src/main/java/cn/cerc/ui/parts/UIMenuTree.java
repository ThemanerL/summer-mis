package cn.cerc.ui.parts;

import java.util.ArrayList;
import java.util.List;

import cn.cerc.ui.core.HtmlWriter;

public class UIMenuTree extends UIComponent {
    private List<UIMenuTreeItem> items = new ArrayList<>();

    public UIMenuTree(UIComponent owner) {
        super(owner);
    }

    @Override
    public void output(HtmlWriter html) {
        html.println("<div class='layout-side-scroll'>");
        html.println("<ul class='layout-nav layout-nav-tree'  lay-filter='test'>");
        for (UIMenuTreeItem item : items) {
            html.println(item.toString());
        }
        html.println("</ul>");
        html.println("</div>");
    }

    public List<UIMenuTreeItem> getItems() {
        return items;
    }

    public UIMenuTreeItem addItem() {
        UIMenuTreeItem item = new UIMenuTreeItem(this);
        items.add(item);
        return item;
    }
}
