package animate;

import graphisch.MyFrame;

/**
 * Basisframe für Animationen mit der AWT
 */
public abstract class MyFrameAnimate extends MyFrame implements Runnable {

    private int  frameTimeMs = 50;
    private long timeMs;
    private long deltaTimeMs;

    public MyFrameAnimate(String title, int width, int height) {
        super(title, width, height);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        timeMs = 0;
        while(true) {
            deltaTimeMs = (System.currentTimeMillis() - startTime) - timeMs;
            //timeMs = System.currentTimeMillis() - startTime;
            timeMs += deltaTimeMs;
            repaint();
            long actualTime = System.currentTimeMillis() - startTime;
            long waitTime   = frameTimeMs - (actualTime - timeMs);
            if (waitTime <= 0) continue;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {}
        }
    }


    public int getFrameTimeMs() {
        return frameTimeMs;
    }

    public void setFrameTimeMs(int frameTimeMs) {
        this.frameTimeMs = frameTimeMs;
    }

    public long getTimeMs() {
        return timeMs;
    }

    public long getDeltaTimeMs() {
        return deltaTimeMs;
    }
}
