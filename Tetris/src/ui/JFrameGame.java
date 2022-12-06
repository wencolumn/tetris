package ui;

import javax.swing.JFrame;
import java.awt.*;

public class JFrameGame extends JFrame {
    public JFrameGame(JPanelGame panelGame) {
        //设置标题
        this.setTitle("俄罗斯方块");
        //设置关闭项
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        this.setSize(1400,800);
        //居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width-this.getWidth())/2;
        int y = (screen.height-this.getHeight())/2-18;
        this.setLocation(x,y);
        //设置默认Panel
        this.setContentPane(panelGame);
        //默认该窗口为显示
        this.setVisible(true);
    }
}
