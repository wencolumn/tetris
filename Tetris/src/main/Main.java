package main;

import control.gameControl;
import control.playerControl;
import dto.gameDto;
import service.gameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

    public static void main(String[] args) {
        //创建游戏数据源
        gameDto dto = new gameDto();
        //创建游戏面板
        JPanelGame jp = new JPanelGame(dto);
        //创建游戏逻辑
        gameService gService = new gameService(dto);
        //创建游戏控制器
        gameControl gc = new gameControl(jp, gService);
        //创建玩家控制器
        playerControl pc = new playerControl(gc);
        //安装玩家控制器
        jp.setGameControl(pc);
        //创建游戏窗口
        JFrameGame jf = new JFrameGame(jp);

    }
}
