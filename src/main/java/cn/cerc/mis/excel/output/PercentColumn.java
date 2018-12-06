package cn.cerc.mis.excel.output;

import cn.cerc.db.other.utils;

public class PercentColumn extends Column {

    @Override
    public Object getValue() {
        String value = utils.formatFloat("0.##", getRecord().getDouble(getCode()));
        return String.format("%s%%", value);
    }
}
