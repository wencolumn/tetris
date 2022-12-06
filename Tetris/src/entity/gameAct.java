package entity;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class gameAct {
    //方块数组
    private Point[] actPoints;
    //方块编号
    private int typeCode;

    //旋转的界限
    private static int MIN_X = 0;
    private static int MAX_X = 9;
    private static int MIN_Y = 0;
    private static int MAX_Y = 19;


    //刷新数组，对应7个不同的图块
    private static List<Point[]> TYPE_CONFIG;

    static{
        TYPE_CONFIG = new ArrayList<Point[]>(7);
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(3, 1),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(3, 1), new Point(4, 1),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(5, 0), new Point(4, 1), new Point(5, 1),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1),});
        TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1),});
    }

    public gameAct(int typeCode) {
        this.init(typeCode);
    }

    public void init(int typeCode) {
        this.typeCode = typeCode;
        Point[] points = TYPE_CONFIG.get(typeCode);
        actPoints = new Point[points.length];
        for(int i = 0;i<points.length;i++){
            actPoints[i] = new Point(points[i].x,points[i].y);
        }
    }

    public Point[] getActPoint() {
        return actPoints;
    }

    //移动方块的方法
    public boolean move(int moveX, int moveY, boolean[][] gameMap ) {
        //移动处理
        for (int i = 0; i < actPoints.length; i++) {
            int newX = actPoints[i].x + moveX;
            int newY = actPoints[i].y + moveY;
            if (this.isOverMap(newX, newY,gameMap)) {
                return false;
            }
        }
        for (int i = 0; i < actPoints.length; i++) {
            actPoints[i].x += moveX;
            actPoints[i].y += moveY;
        }
        return true;
    }

    //顺时针：A.x = 0.y + 0.x - b.y;
    //      A.y = 0.y - 0.y + b.x;
    public void round(boolean[][] gameMap) {
        if(this.typeCode == 4){
            return;
        }
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
            if (this.isOverMap(newX, newY,gameMap)) {
                return;
            }
        }
        for (int i = 1; i < actPoints.length; i++) {
            int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
            int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
            actPoints[i].x = newX;
            actPoints[i].y = newY;
        }
    }

    //判断是否超出边界
    private boolean isOverMap(int x, int y, boolean[][] gameMap) {
        return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y ||gameMap[x][y];
    }

    //获得方块类型编号
    public int getTypeCode() {
        return typeCode;
    }

}


