package net.pixelscape.tagger.ui.mixins;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JPanel that imitates a JList but that supports panels.
 */
public class PanelList extends JPanel {

    private boolean first = true;

    public PanelList() {
        super();
        this.setLayout(new GridBagLayout());
    }

    public void add(FolderItemMixin mixin) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        if (first) {
            this.first = false;
        } else {
            mixin.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        }
        this.add(mixin, gbc);

        this.validate();
        this.repaint();
    }

}
