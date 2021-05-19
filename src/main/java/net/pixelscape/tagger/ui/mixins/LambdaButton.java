package net.pixelscape.tagger.ui.mixins;

import javax.swing.*;

/**
 * A JButton that accepts the action on the constructor.
 */
public class LambdaButton extends JButton {

    public LambdaButton(String text, Runnable listener) {
        super(text);
        this.addActionListener(e -> listener.run());
    }

}
