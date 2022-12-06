package ui;

import control.gameControl;
import control.playerControl;
import dto.gameDto;
import service.gameService;

import javax.swing.*;
import java.awt.*;

public class JPanelGame extends JPanel {

    private static layer[] layers = null;
    //安装玩家控制器
    public void setGameControl(playerControl pControl){
        this.addKeyListener(pControl);
    }

    public void initComponent(){}

    private gameDto dto;


    public JPanelGame(gameDto dto) {
        //获得游戏数据
        this.dto = dto;
        layers = new layer[]{
                new layerBackground(0, 0, 1400, 800,this.dto),
                new layerPoint(60, 62, 400, 300,this.dto),
                new layerLevel(60, 438, 400, 300,this.dto),
                new layerNext(940, 62, 400, 300,this.dto),
                new layerGame(522, 62, 328, 648,this.dto)
        };


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < layers.length; i++) {
            //打印框体
            layers[i].paint(g);
        }
        //焦点
        this.requestFocus();
    }
}
