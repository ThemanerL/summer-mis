package cn.cerc.jui.core;

public interface IColumn extends IField {

    public String format(Object value);

    default public int getWidth() {
        return 1;
    }
}
