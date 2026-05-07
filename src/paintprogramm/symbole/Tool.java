package paintprogramm.symbole;

import paintprogramm.Paintable;
import paintprogramm.Selectable;
import paintprogramm.elements.ZPLinie;
import paintprogramm.elements.ZPRect;

import java.awt.*;

public class Tool {

    private Toolbar  toolbar;
    private ToolEnum toolEnum;
    boolean  selected = false;

    public Tool(Toolbar toolbar, ToolEnum toolEnum) {
        this.toolbar  = toolbar;
        this.toolEnum = toolEnum;
    }

    public void paint(Graphics2D g, Point pos) {
        int s = toolbar.symbolSize;
        if (selected) g.setColor(Color.white);
        else          g.setColor(Color.lightGray);
        g.fillRect(pos.x+2,pos.y+2,s-4,s-4);
        Stroke strokeOld = g.getStroke();
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        switch (toolEnum) {
            case SELECT -> {
                g.translate(pos.x+s-6,pos.y+s-6);
                g.rotate(-Math.PI*5d/4d);
                g.drawLine(0,0,0,(s-12));
                g.fillPolygon(new int[]{0,s/4,-s/4},new int[]{(s-12)*14/10,(s-12)/2,(s-12)/2},3);
                g.rotate(Math.PI*5d/4d);
                g.translate(-(pos.x+s-6),-(pos.y+s-6));
            }
            case LINE -> {
                g.drawLine(pos.x+6,pos.y+s-6,pos.x+s-6,pos.y+6);
            }
            case RECT -> {
                g.drawRect(pos.x+6,pos.y+6,s-12,s-12);
            }
            case OVAL -> {
                g.drawOval(pos.x+6,pos.y+8,s-12,s-16);
            }
            case FREEHAND -> {
                int n=10;
                int[] x = new int[n], y = new int[n];
                for (int i=0; i<n; i++){
                    x[i] = pos.x+6+((s-12)*i)/(n-1);
                    y[i] = pos.y+6+(s-12)/2-(int)((s-12)/2*Math.sin(i/(n-1d)*2*Math.PI));
                }
                g.drawPolyline(x,y,n);
            }
            case DRAWCOLOR -> {
                g.setColor(toolbar.drawColor);
                g.fillRect(pos.x+2,pos.y+2,s-4,s-4);
            }
            case FILLCOLOR -> {
                g.setColor(toolbar.fillColor);
                g.fillRect(pos.x+2,pos.y+2,s-4,s-4);
            }
        }
        g.setStroke(strokeOld);
    }

    /**
     * Verarbeitet einen Mausklick auf der linke Maustaste
     * @param rx relative x-Koordinate des Mausklicks 0..100
     * @param ry relative y-Koordinate des Mausklicks 0..100
     */
    public void leftMousePressed(int rx, int ry) {
        switch (toolEnum) {
            case SELECT,LINE,RECT,OVAL,FREEHAND -> {
                toolbar.deSelectAll();
                this.selected = true;
            }
            default -> {

            }
        }
    }

    /**
     * Verarbeitet einen Mausklick auf der linke Maustaste in der Zeichenebene
     * @param mc translate-kompatible Mausposition
     */
    public void imageLeftMousePressed(Point mc) {
        switch (toolEnum) {
            case LINE -> {
                ZPLinie zpl = new ZPLinie(mc,mc,toolbar.drawColor, toolbar.lineWidth, toolbar.lineStyle);
                toolbar.windowInfo.getElements().add(zpl);
                toolbar.selectedElement = zpl;
            }
            case RECT -> {
                ZPRect zp = new ZPRect(mc,mc,toolbar.drawColor, toolbar.fillColor, toolbar.lineWidth, toolbar.lineStyle);
                toolbar.windowInfo.getElements().add(zp);
                toolbar.selectedElement = zp;
            }
            case SELECT -> {
                toolbar.deSelectAllElements();
                toolbar.selectedElement = null;
                for (Paintable p : toolbar.windowInfo.getElements()) {
                    if (p instanceof Selectable) {
                        Selectable sel = (Selectable) p;
                        if (sel.select(mc)) {
                            toolbar.selectedElement = p;
                        }
                    }
                }
                if (toolbar.selectedElement!=null) {
                    if (toolbar.selectedElement instanceof Selectable) {
                        Selectable sel = (Selectable) toolbar.selectedElement;
                        sel.setSelected(true);
                    }
                }
            }
        }
    }

    public void imageLeftMouseReleased(Point mc) {
        if (toolbar.selectedElement==null) return;
        Paintable p = toolbar.getSelectedElement();
        switch (toolEnum) {
            case LINE -> {
                if (p instanceof ZPLinie) ((ZPLinie) p).setP2(mc);
                toolbar.selectedElement = null;
            }
            case RECT -> {
                if (p instanceof ZPRect) ((ZPRect) p).setP2(mc);
                toolbar.selectedElement = null;
            }
        }
    }

    public void imageMouseDragged(Point mc) {
        if (toolbar.selectedElement==null) return;
        Paintable p = toolbar.getSelectedElement();
        switch (toolEnum) {
            case LINE -> {
                if (p instanceof ZPLinie) ((ZPLinie) p).setP2(mc);
            }
            case RECT -> {
                if (p instanceof ZPRect) ((ZPRect) p).setP2(mc);
            }
        }
    }

}
