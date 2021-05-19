package net.pixelscape.tagger.framework;

import javax.swing.*;

public abstract class UI {

    public abstract void build();

    public abstract JFrame getFrame();

    private boolean built = false;

    public void setBuilt(boolean built) {
        this.built = built;
    }

    public void show() {
        if (!built) {
            this.build();
            this.setBuilt(true);
        }
        JFrame frame = this.getFrame();
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    public void hide() {
        JFrame frame = this.getFrame();
        if (frame != null) {
            frame.setVisible(false);
        }
    }

}
