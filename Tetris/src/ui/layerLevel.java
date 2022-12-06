package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

public class layerLevel extends layer {
    private static Image levelNumber = new ImageIcon("picture/String/难度数字.png").getImage();
    private static Image scoreNumber = new ImageIcon("picture/String/分数数字.png").getImage();
    private static Image level = new ImageIcon("picture/String/难度.png").getImage();
    private static Image delete = new ImageIcon("picture/String/消行.png").getImage();
    private int imgLevelW = 100;
    private int imgLevelH = 100;


    public layerLevel(int x, int y, int w, int t, gameDto dto) {
        super(x, y, w, t, dto);
    }

    public void paint(Graphics g) {
        this.CreateWindow(g);
        //显示窗口汉字
        g.drawImage(level, this.x + firstW, this.y + firstH, this.x + firstW + 140, this.y + firstH + 100, 20, 0, 190, 100, null);
        g.drawImage(delete, this.x + firstW, this.y + secondH, this.x + firstW + 140, this.y + secondH + 100, 0, 0, 150, 100, null);
        //显示等级
        this.drawNumberLeftPad(32+140, 24, this.dto.getLevel(), g);
        //显示消行数
        this.drawNumberLeftPad(32+140, 24+140, this.dto.getRemoveLine(), g);
    }

    //显示数字
    private void drawNumberLeftPad(int x, int y, int num, Graphics g) {
        String StrNum = Integer.toString(num);
        for (int i = 0; i < StrNum.length(); i++) {
                int bit = StrNum.charAt(i) - '0';
                g.drawImage(levelNumber,
                        this.x + x +80*i, this.y + y,
                        this.x + x+80*i+80, this.y + y +100,
                        bit * imgLevelW, 0,
                        bit * imgLevelW + imgLevelW, imgLevelH, null);

        }
    }
}
