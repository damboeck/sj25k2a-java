package paintprogramm.symbole;

import paintprogramm.Paintable;

import java.awt.*;

public class Tool {

    private Toolbar toolbar;
    private ToolEnum toolEnum;

    public Tool(Toolbar toolbar, ToolEnum toolEnum) {
        this.toolbar  = toolbar;
        this.toolEnum = toolEnum;
    }

    public void paint(Graphics2D g, Point pos) {
        int s = toolbar.symbolSize;
        g.setColor(Color.lightGray);
        g.fillRect(pos.x+2,pos.y+2,s-4,s-4);
        g.setColor(Color.black);
        switch (toolEnum) {
            case LINE -> {
                g.drawLine(pos.x+4,pos.y+s-4,pos.x+s-4,pos.y+4);
            }
        }
    }

}
