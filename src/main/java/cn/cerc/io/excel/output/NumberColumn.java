package cn.cerc.io.excel.output;

import cn.cerc.db.other.utils;

public class NumberColumn extends Column {

    public NumberColumn() {
        super();
    }

    public NumberColumn(String code, String name, int width) {
        super(code, name, width);
    }

    @Override
    public Object getValue() {
        return utils.strToDoubleDef(utils.formatFloat("0.####", getRecord().getDouble(getCode())), 0);
    }
}
