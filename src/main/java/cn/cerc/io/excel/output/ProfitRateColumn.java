package cn.cerc.io.excel.output;

public class ProfitRateColumn extends Column {

    @Override
    public Object getValue() {
        return getRecord().getDouble(getCode()) + "%";
    }

}
