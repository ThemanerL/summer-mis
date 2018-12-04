package cn.cerc.jbean.services;

import cn.cerc.jbean.core.AbstractService;
import cn.cerc.jbean.core.IStatus;
import cn.cerc.jbean.core.ServiceException;
import cn.cerc.jdb.core.DataSet;
import cn.cerc.jdb.core.Record;
import cn.cerc.jdb.mysql.SqlQuery;

public class SvrBookOption extends AbstractService {

    @Override
    public IStatus execute(DataSet dataIn, DataSet dataOut) throws ServiceException {
        Record head = dataIn.getHead();

        SqlQuery ds = new SqlQuery(this);
        ds.add("select Value_ from %s ", systemTable.getBookOptions());
        ds.add("where CorpNo_ = '%s' and Code_ = '%s'", this.getCorpNo(), head.getString("Code_"));
        ds.open();
        dataOut.appendDataSet(ds);
        return success();
    }
}