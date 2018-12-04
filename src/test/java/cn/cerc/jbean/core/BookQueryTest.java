package cn.cerc.jbean.core;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cerc.jbean.other.SystemTable;
import cn.cerc.jbean.rds.StubHandle;
import cn.cerc.jdb.core.TDateTime;

public class BookQueryTest {
    @Autowired
    private SystemTable systemTable;

    @Test(expected = RuntimeException.class)
    @Ignore
    public void test() {
        StubHandle handle = new StubHandle();
        BookQuery ds = new BookQuery(handle);
        ds.add("select * from %s where CorpNo_='144001'", systemTable.getBookInfo());
        ds.open();
        ds.edit();
        ds.setField("UpdateKey_", TDateTime.Now());
        ds.post();
    }

}
