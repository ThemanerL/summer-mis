package cn.cerc.ui.parts;

import java.util.ArrayList;
import java.util.List;

import cn.cerc.ui.core.HtmlWriter;
import cn.cerc.ui.vcl.UIImage;

public class UIMenuTreeItem extends UIComponent {
    private UIImage img;
    private String name;
    private String code;
    private boolean menuExpand;
    private List<UIMenuTreeItem> items = new ArrayList<>();

    private String target = "_blank";
    private String active;

    public UIMenuTreeItem() {
    }

    public UIMenuTreeItem(UIComponent owner) {
        super(owner);
    }

    @Override
    public void output(HtmlWriter html) {
        if (items.size() == 0) {
            html.println("<li class='layout-nav-item");
            if (active != null)
                html.println(" %s", active);
            html.println("'>");
            html.println("<a href=\"%s\">", getCode(), getName());
            if (img != null)
                img.output(html);
            html.println(getName());
            html.print("</a>");
            html.print("</li>");
        } else {
            html.println("<li class='layout-nav-item");
            if (isMenuExpand())
                html.println(" layout-nav-itemed");
            html.println("'>");
            html.print("<a href=\"javascript: void(0)\" onclick=\"%s\">", getCode());
            if (img != null)
                img.output(html);
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
            html.println("</li>");
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

    public boolean isMenuExpand() {
        return menuExpand;
    }

    public UIMenuTreeItem setMenuExpand(boolean menuExpand) {
        this.menuExpand = menuExpand;
        return this;
    }
    public UIMenuTreeItem setMenuActive() {
        this.active = "layout-active";
        return this;
    }

    public UIMenuTreeItem addSubitem(String name, String code, boolean isActive) {
        UIMenuTreeItem item = new UIMenuTreeItem();
        item.init(name, code);
        items.add(item);
        if (isActive) {
            item.setMenuActive();
        }
        return item;
    }

    public UIImage addImg() {
        if (img == null)
            img = new UIImage();
        return img;
    }
}