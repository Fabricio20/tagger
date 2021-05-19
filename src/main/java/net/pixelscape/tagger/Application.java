package net.pixelscape.tagger;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class Application {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        new Tagger().onInit();
    }

}
