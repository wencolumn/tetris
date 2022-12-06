package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

public class layerGame extends layer {

    private static final Image act = new ImageIcon("picture/games/方块.png").getImage();

    private static final int actSize=5;

    private static int frameSize = 4;

    public layerGame(int x, int y, int w, int t, gameDto dto) {
        super(x, y, w, t,dto);
    }

    public void paint(Graphics g) {
        //创建窗口
        this.CreateWindow(g);

        //打印地图
        boolean[][] map = this.dto.getGameMap();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if(map[x][y]) {
                    drawAct (x,y,0,g);
                }
            }
        }
        //拿到坐标
        Point[] points = this.dto.getGameAct().getActPoint();
        //获得方块编号  0--6
        int typeCode = this.dto.getGameAct().getTypeCode();
        //打印方块
        for (int i = 0; i < points.length; i++) {
            drawAct (points[i].x,points[i].y,typeCode+1,g);
        }
    }





    //绘制正方形块
    private void drawAct (int x,int y,int ImageIndex,Graphics g){
        g.drawImage(act,
                this.x+(x << actSize)+frameSize,
                this.y+(y << actSize)+frameSize,
                this.x+(x+1 << actSize)+frameSize,
                this.y+(y+1 << actSize)+frameSize,
                ImageIndex<<actSize,0,(ImageIndex+1)<<actSize,1<<actSize,null);
    }
}
