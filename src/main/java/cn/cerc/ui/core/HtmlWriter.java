package cn.cerc.ui.core;

import cn.cerc.db.other.utils;

public class HtmlWriter {
    private StringBuilder builder = new StringBuilder();

    public void print(String value) {
        builder.append(value);
    }

    public void print(String format, Object... args) {
        builder.append(String.format(format, args));
    }

    public void println(String value) {
        builder.append(value);
        builder.append(utils.vbCrLf);
    }

    public void println(String format, Object... args) {
        builder.append(String.format(format, args));
        builder.append(utils.vbCrLf);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
