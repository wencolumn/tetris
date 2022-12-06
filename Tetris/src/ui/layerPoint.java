package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

public class layerPoint extends layer {
    private static Image score = new ImageIcon("picture/String/分数.png").getImage();
    private static Image highScore = new ImageIcon("picture/String/最高分.png").getImage();
    private static Image levelNumber = new ImageIcon("picture/String/难度数字.png").getImage();
    private int imgLevelW = 100;
    private int imgLevelH = 100;
    public layerPoint(int x, int y, int w, int t, gameDto dto){
        super(x,y,w,t,dto);
    }
    public void paint(Graphics g){
        this.CreateWindow(g);
        g.drawImage(score,this.x+firstW,this.y+firstH,
                this.x+firstW+180,this.y+firstH+120,
                0,0,150,100,
                null);
        //分数
        this.drawNumberLeftPad(0, 32+140, this.dto.getPoint(), g);
    }
    //显示数字
    private void drawNumberLeftPad(int x, int y, int num, Graphics g) {
        String StrNum = Integer.toString(num);
        for (int i = 0; i < StrNum.length(); i++) {
            int bit = StrNum.charAt(i) - '0';
            g.drawImage(levelNumber,
                    this.x + x +100*i, this.y + y,
                    this.x + x+100*i+100, this.y + y +100,
                    bit * imgLevelW, 0,
                    bit * imgLevelW + imgLevelW, imgLevelH, null);

        }
    }
}
