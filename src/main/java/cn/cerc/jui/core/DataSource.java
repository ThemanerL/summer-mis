package cn.cerc.jui.core;

import cn.cerc.core.DataSet;

public interface DataSource {

    public void addField(IField field);

    public DataSet getDataSet();

    public boolean isReadonly();

    public void updateValue(String id, String code);
}
