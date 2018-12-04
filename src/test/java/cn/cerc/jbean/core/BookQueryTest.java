package cn.cerc.jbean.core;

import org.junit.Ignore;
import org.junit.Test;

import cn.cerc.jbean.other.SystemTable;
import cn.cerc.jbean.rds.StubHandle;
import cn.cerc.jdb.core.TDateTime;

public class BookQueryTest {

    @Test(expected = RuntimeException.class)
    @Ignore
    public void test() {
        SystemTable systemTable = Application.getBean("systemTable", SystemTable.class);
        StubHandle handle = new StubHandle();
        BookQuery ds = new BookQuery(handle);
        ds.add("select * from %s where CorpNo_='144001'", systemTable.getBookInfo());
        ds.open();
        ds.edit();
        ds.setField("UpdateKey_", TDateTime.Now());
        ds.post();
    }

}
