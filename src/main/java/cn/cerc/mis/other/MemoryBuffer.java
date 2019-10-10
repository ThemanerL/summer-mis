package cn.cerc.mis.other;

import cn.cerc.db.cache.Buffer;

public class MemoryBuffer extends Buffer implements AutoCloseable {

    public MemoryBuffer(BufferType bt, String... keys) {
        super();
        this.setKey(buildKey(bt, keys));
    }

    @Override
    public final void close() {
        this.post();
    }

    public static void delete(BufferType bt, String... keys) {
        Buffer buff = new Buffer(buildKey(bt, keys));
        buff.clear();
    }

    public static String buildKey(BufferType bt, String... keys) {
        if (keys == null || keys.length == 0)
            throw new RuntimeException("[MemoryBuffer]Wrong initialization parameter！");

        if (keys.length == 1 && keys[0] == null)
            throw new RuntimeException("Incorrect value！");

        StringBuffer str = new StringBuffer();
        str.append(bt.ordinal());
        for (String key : keys)
            str.append(".").append(key);
        return str.toString();
    }
}
