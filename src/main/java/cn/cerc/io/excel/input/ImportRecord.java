package cn.cerc.io.excel.input;

import cn.cerc.core.Record;

public interface ImportRecord {
    public boolean process(Record rs) throws Exception;
}
