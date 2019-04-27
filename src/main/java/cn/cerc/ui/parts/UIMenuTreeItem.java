package cn.cerc.ui.parts;

import java.util.ArrayList;
import java.util.List;

import cn.cerc.ui.core.HtmlWriter;
import cn.cerc.ui.vcl.UIImage;

public class UIMenuTreeItem extends UIComponent {
    private UIImage img;
    private String name;
    private String code;
    private boolean menuLock;
    private List<UIMenuTreeItem> items = new ArrayList<>();

    private String target = "_blank";

    public UIMenuTreeItem() {
    }

    public UIMenuTreeItem(UIComponent owner) {
        super(owner);
    }

    @Override
    public void output(HtmlWriter html) {
        if (items.size() == 0) {
            html.println("<a href=\"%s\">", getCode(), getName());
            if (img != null)
                img.output(html);
            html.println(getName());
            html.print("</a>");
        } else {
            html.print("<a href=\"%s\">", getCode());
            html.print("<cite>%s</cite>", getName());
            html.print("<span class=\"layout-nav-more\"></span>");
            html.print("</a>");
            html.println("<dl class=\"layout-nav-child\">");

            for (UIMenuTreeItem item : items) {
                html.println("<dd>");
                item.output(html);
                html.println("</dd>");
            }

            html.println("</dl>");
        }
    }

    public UIMenuTreeItem init(String name, String code) {
        this.name = name;
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public UIMenuTreeItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public UIMenuTreeItem setCode(String url) {
        this.code = url;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public UIMenuTreeItem setTarget(String target) {
        this.target = target;
        return this;
    }

    public boolean isMenuLock() {
        return menuLock;
    }

    public UIMenuTreeItem setMenuLock(boolean menuLock) {
        this.menuLock = menuLock;
        return this;
    }

    public UIMenuTreeItem addSubitem(String name, String code) {
        UIMenuTreeItem item = new UIMenuTreeItem();
        item.init(name, code);
        items.add(item);
        return item;
    }

    public UIImage addImg() {
        if (img == null)
            img = new UIImage();
        return img;
    }
}