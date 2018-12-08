package cn.cerc.mis.core;

public interface IBookOption extends IOption {
    default String getBook() {
        return null;
    }
}
