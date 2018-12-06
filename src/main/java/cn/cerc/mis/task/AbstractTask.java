package cn.cerc.mis.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cerc.mis.core.AbstractHandle;
import cn.cerc.mis.core.AppHandle;
import cn.cerc.mis.core.Application;
import cn.cerc.mis.core.ISystemTable;

public abstract class AbstractTask extends AbstractHandle implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(AbstractTask.class);
    private String describe;
    /** 缓存时间/秒 **/
    private int interval;
    private String time = "";
    @Autowired
    public ISystemTable systemTable;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 外部执行入口
     */
    @Override
    public void run() {
        try (AppHandle handle = new AppHandle()) {
            this.setHandle(handle);
            handle.setProperty(Application.userCode, "admin");
            this.execute();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    // 具体业务逻辑代码
    public abstract void execute() throws Exception;
}
