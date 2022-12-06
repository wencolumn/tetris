package control;

import dto.gameDto;
import service.gameService;
import ui.JPanelGame;


//控制界面，玩家输出，游戏逻辑
public class gameControl {

    //游戏界面
    private JPanelGame panelGame;
    //游戏逻辑
    private gameService gService;
    private Thread gameThread = null;


    public gameControl(JPanelGame panelGame,gameService gService){
        this.panelGame = panelGame;
        this.gService = gService;
    }

    //控制器的方向键
    public void keyUp() {
        this.gService.keyUp();
        this.panelGame.repaint();

    }

    public void keyDown() {
        this.gService.keyDown();

        this.panelGame.repaint();
    }

    public void keyLeft() {
        this.gService.keyLeft();
        this.panelGame.repaint();
    }

    public void keyRight() {
        this.gService.keyRight();
        this.panelGame.repaint();
    }
    public void keyStart() {
        // 创建线程对象
        this.gameThread = new MainThread();
        // 启动线程
        this.gameThread.start();
    }
    private class MainThread extends Thread {
        @Override
        public void run() {
            // 刷新画面
            panelGame.repaint();
            // 主循环
            while(true) {
                try {
                    // 游戏主行为
                    keyDown();
                    // 刷新画面
                    panelGame.repaint();
                    // 线程睡眠
                    int k = gService.glevel();
                    //k=消行数
                    long m = k/10+1;
                    Thread.sleep(2000/m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
