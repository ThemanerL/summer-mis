package cn.cerc.io.excel.output;

public interface HistoryWriter {
    public void start(Object handle, Template template);

    public void finish(Object handle, Template template);
}
