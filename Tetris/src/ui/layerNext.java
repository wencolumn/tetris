package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

public class layerNext extends layer {

    private static Image[] NEXT_IMG;

    static {
        NEXT_IMG = new Image[7];
        for (int i=0;i<NEXT_IMG.length;i++){
            NEXT_IMG[i] = new ImageIcon("picture/games/" +i+ ".png").getImage();
        }
    }


    private static Image next = new ImageIcon("picture/String/下一块.png").getImage();


    public layerNext(int x, int y, int w, int t, gameDto dto){
        super(x,y,w,t,dto);
    }

    public void paint(Graphics g){
        this.CreateWindow(g);
        g.drawImage(next,this.x+firstW,this.y+firstH,null);
        g.drawImage(NEXT_IMG[this.dto.getNext()],this.x+230,this.y+160,null );
    }

    private void drawImgAtCenter(Graphics g,Image img){
        int imgW = img.getWidth(null);
        int imgH = img.getHeight(null);
        g.drawImage(img,this.x+(this.w - imgW>>1),this.y+(this.h - imgH>>1),null);
    }
}
