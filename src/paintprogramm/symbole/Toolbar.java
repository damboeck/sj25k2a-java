package paintprogramm.symbole;

import paintprogramm.Paintable;
import paintprogramm.WindowInfo;

import java.awt.*;
import java.util.Vector;

public class Toolbar implements Paintable {

    int symbolSize = 30;
    private PositionEnum position;
    private WindowInfo windowInfo;
    private Vector<Tool> tools = new Vector<>();

    public Toolbar(WindowInfo windowInfo) {
        this.position   = PositionEnum.LEFT;
        this.windowInfo = windowInfo;
        tools.add(new Tool(this,ToolEnum.SELECT));
        tools.add(new Tool(this,ToolEnum.LINE));
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

}
