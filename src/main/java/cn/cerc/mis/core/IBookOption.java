package cn.cerc.mis.core;

import cn.cerc.core.IHandle;

public interface IBookOption extends IOption {
    default String getBook() {
        return null;
    }

    default boolean getValue(IHandle handle) {
        return true;
    }
}
