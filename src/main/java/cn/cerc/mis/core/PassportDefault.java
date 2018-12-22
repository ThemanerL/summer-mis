package cn.cerc.mis.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.cerc.mis.rds.PassportRecord;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PassportDefault extends AbstractHandle implements IPassport {

    @Override
    public boolean passProc(String versions, String procCode) {
        return true;
    }

    @Override
    public boolean passAction(String procCode, String action) {
        return true;
    }

    @Override
    public PassportRecord getRecord(String procCode) {
        PassportRecord result = new PassportRecord();
        result.setAdmin(true);
        return result;
    }

    @Override
    public boolean passsMenu(String menuCode) {
        return true;
    }

}