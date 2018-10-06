package cn.cerc.jbean.tools;

@Deprecated
public class MD5 {
    public final static String get(String str) {
        // 请改为使用 summer-core 的MD5工具
        return cn.cerc.jdb.core.MD5.get(str);
    }
}
