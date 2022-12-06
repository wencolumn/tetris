package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

public class layerBackground extends layer {

    private static Image background = new ImageIcon("picture/background/background.png").getImage();
    protected layerBackground(int x, int y, int w, int t, gameDto dto) {
        super(x, y, w, t,dto);
    }

    public void paint(Graphics g) {
        g.drawImage(background,0,0,1400,800,0,0,960,549,null);
    }
}
