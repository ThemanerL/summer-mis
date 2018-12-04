package cn.cerc.jbean.services;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cerc.jbean.core.AbstractService;
import cn.cerc.jbean.core.IStatus;
import cn.cerc.jbean.core.ServiceException;
import cn.cerc.jbean.other.SystemTable;
import cn.cerc.jdb.core.DataSet;
import cn.cerc.jdb.core.Record;
import cn.cerc.jdb.mysql.SqlQuery;

public class SvrUserOption extends AbstractService {
    @Autowired
    private SystemTable systemTable;

    @Override
    public IStatus execute(DataSet dataIn, DataSet dataOut) throws ServiceException {
        Record head = dataIn.getHead();
        SqlQuery ds = new SqlQuery(this);
        ds.add(String.format("select Value_ from %s", systemTable.getUserOptions()));
        ds.add(String.format("where UserCode_=N'%s' and Code_=N'%s'", this.getUserCode(), head.getString("Code_")));
        ds.open();
        dataOut.appendDataSet(ds);
        return success();
    }
}