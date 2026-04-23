package paintprogramm.symbole;

import paintprogramm.Paintable;
import paintprogramm.WindowInfo;

import java.awt.*;
import java.util.Vector;

public class Toolbar implements Paintable {

    int symbolSize = 30;
    private PositionEnum position;
    protected WindowInfo windowInfo;
    private Vector<Tool> tools = new Vector<>();

    // aktuelle Zeichenparameter
    protected Color     drawColor = Color.BLACK;
    protected Color     fillColor = Color.RED;
    protected int       lineWidth = 1;
    protected LINESTYLE lineStyle = LINESTYLE.LINIE;

    public Toolbar(WindowInfo windowInfo) {
        this.position   = PositionEnum.LEFT;
        this.windowInfo = windowInfo;
        tools.add(new Tool(this,ToolEnum.SELECT));
        tools.add(new Tool(this,ToolEnum.LINE));
        tools.add(new Tool(this,ToolEnum.RECT));
        tools.add(new Tool(this,ToolEnum.OVAL));
        tools.add(new Tool(this,ToolEnum.FREEHAND));
        tools.add(new Tool(this,ToolEnum.DRAWCOLOR));
        tools.add(new Tool(this,ToolEnum.FILLCOLOR));
        tools.add(new Tool(this,ToolEnum.PALETTE));
        tools.add(new Tool(this,ToolEnum.LINESIZE));
        tools.add(new Tool(this,ToolEnum.LINEMODE));
    }

    @Override
    public void paint(Graphics2D g) {
        int w = windowInfo.getWidth();
        int h = windowInfo.getHeight();
        g.setColor(Color.gray);
        switch(position) {
            //TODO alle anderen Lagen müssen noch programmiert werden
            default:
            case LEFT:
                g.fillRect(0,0,symbolSize,h);
                for (int i=0;i<tools.size();i++) {
                    Tool tool = tools.get(i);
                    tool.paint(g,new Point(0,i*symbolSize));
                }
                break;
        }

    }

    /**
     * verarbeitet die Linke Maustaste wenn sie auf der Symbolleiste liegt
     * @param p  Mouse-Position
     * @return   true wenn die Maus auf der Symbolleiste liegt
     */
    public boolean leftMousePressed(Point p) {
        int mx = p.x;
        int my = p.y;
        switch(position) {
            //TODO alle anderen Lagen müssen noch programmiert werden
            default:
            case LEFT:
                if (mx <= symbolSize) {
                    int toolIndex = my / symbolSize;
                    if (toolIndex < tools.size()) {
                        Tool tool = tools.get(toolIndex);
                        tool.leftMousePressed(mx / symbolSize * 100, (my - toolIndex * symbolSize) / symbolSize * 100);
                    }
                    return true;
                }
                break;
        }
        return false;
    }

    public void deSelectAll() {
        for (Tool t:tools) t.selected=false;
    }


}
