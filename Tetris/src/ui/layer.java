package ui;

import dto.gameDto;

import javax.swing.*;
import java.awt.*;

abstract public class layer {
    //框内额外第一个内容距离框左上角的宽距离
    protected static final int firstW = 33;
    //框内额外第二个内容距离框左上角的宽距离
    protected static final int secondW = 216;
    //框内额外第一个内容距离框左上角的高距离
    protected static final int firstH = 33;
    //框内额外第二个内容距离框左上角的高距离
    protected static final int secondH = 166;
    //窗口左上角正方形边长
    private static final int size = 17;
    //导入窗口图片
    private static Image WINDOW_IMG = new ImageIcon("picture/window/模板.png").getImage();
    //定义图片的长度
    private static int WINDOW_w = WINDOW_IMG.getWidth(null);
    //定义图片的高度
    private static int WINDOW_H = WINDOW_IMG.getHeight(null);
    //窗口左上角位置的x，y坐标
    protected int x;
    protected int y;
    //显示窗口内的宽度和高度
    protected int w;
    protected int h;
    //游戏dto
    protected gameDto dto;

    //构造器
    protected layer(int x, int y, int w, int h,gameDto dto){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dto = dto;
    }

    //绘制窗口
    protected  void CreateWindow(Graphics g){
        //左上
        g.drawImage(WINDOW_IMG,x,y,x+size,y+size,0,0,size,size,null);
        //上
        g.drawImage(WINDOW_IMG,x+size,y,x+w-size,y+size,size,0,WINDOW_w-size,size,null);
        //右上
        g.drawImage(WINDOW_IMG,x+w-size,y,x+w,y+size,WINDOW_w-size,0,WINDOW_w,size,null);
        //左
        g.drawImage(WINDOW_IMG,x,y+size,x+size,y+h-size,0,size,size,WINDOW_H-size,null);
        //中
        g.drawImage(WINDOW_IMG,x+size,y+size,x+w-size,y+h-size,size,size,WINDOW_w-size,WINDOW_H-size,null);
        //右
        g.drawImage(WINDOW_IMG,x+w-size,y+size,x+w,y+h-size,WINDOW_w-size,size,WINDOW_w,WINDOW_H-size,null);
        //左下
        g.drawImage(WINDOW_IMG,x,y+h-size,x+size,y+h,0,WINDOW_H-size,size,WINDOW_H,null);
        //下
        g.drawImage(WINDOW_IMG,x+size,y+h-size,x+w-size,y+h,size,WINDOW_H-size,WINDOW_w-size,WINDOW_H,null);
        //右下
        g.drawImage(WINDOW_IMG,x+w-size,y+h-size,x+w,y+h,WINDOW_w-size,WINDOW_H-size,WINDOW_w,WINDOW_H,null);
    }

    //抽象类子类paint方法
    abstract void paint(Graphics g);

}
