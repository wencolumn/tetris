package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class playerControl extends KeyAdapter{

    private gameControl gCtrl;

    public playerControl(gameControl gCtrl){
        this.gCtrl = gCtrl;
    }
    //键盘按下事件
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                this.gCtrl.keyUp();
                break;
            case KeyEvent.VK_DOWN:
                this.gCtrl.keyDown();
                break;
            case KeyEvent.VK_LEFT:
                this.gCtrl.keyLeft();
                break;
            case KeyEvent.VK_RIGHT:
                this.gCtrl.keyRight();
                break;
            case KeyEvent.VK_Q:
                this.gCtrl.keyStart();
                break;
            default:
                break;
        }
    }

}
