package cn.cerc.mis.core;

import cn.cerc.db.mysql.MysqlConnection;

public class AppHandle extends AbstractHandle implements AutoCloseable {
    public AppHandle() {
        handle = Application.getHandle();
    }

    @Override
    public void close() {
        this.closeConnections();
    }

    @Override
    public MysqlConnection getConnection() {
        return (MysqlConnection) handle.getProperty(MysqlConnection.sessionId);
    }

    @Override
    public void closeConnections() {
        try {
            this.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUserName() {
        return handle.getUserName();
    }

    @Override
    public void setProperty(String key, Object value) {
        handle.setProperty(key, value);
    }

    @Override
    public boolean init(String bookNo, String userCode, String clientCode) {
        return handle.init(bookNo, userCode, clientCode);
    }

    @Override
    public boolean init(String token) {
        return handle.init(token);
    }

    @Override
    public boolean logon() {
        return handle.logon();
    }
}
