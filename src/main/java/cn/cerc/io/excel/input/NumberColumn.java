package cn.cerc.io.excel.input;

import java.text.DecimalFormat;

import cn.cerc.db.other.utils;

public class NumberColumn extends Column {
    @Override
    public Object getValue() {
        return utils.strToDoubleDef(new DecimalFormat("0.######").format(getRecord().getDouble(getCode())), 0);
    }

    @Override
    public boolean validate(int row, int col, String value) {
        String result = "";
        if (!"".equals(value)) {
            result = String.valueOf(Math.abs(Double.parseDouble(value)));
        } else {
            result = "0";
        }
        return utils.isNumeric(utils.formatFloat("0.######", Double.parseDouble(result)));
    }
}
