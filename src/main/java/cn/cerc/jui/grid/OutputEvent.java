package cn.cerc.jui.grid;

import cn.cerc.jui.grid.lines.AbstractGridLine;

public interface OutputEvent {
    void process(AbstractGridLine line);
}
