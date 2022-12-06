package service;

import dto.gameDto;
import entity.gameAct;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class gameService {

    private gameDto dto;
    int levelup ;
    //随机数生成器
    private Random random = new Random();
    private static final int MAX_RANDOM = 6;
    Image k =  new ImageIcon("picture/String/结束.png").getImage();


    public gameService(gameDto dto) {
        this.dto = dto;
        gameAct act = new gameAct(random.nextInt(MAX_RANDOM));
        dto.setGameAct(act);
    }

    public void keyUp() {
        this.dto.getGameAct().round(this.dto.getGameMap());
    }
    //down
    public void keyDown() {
        if (this.dto.getGameAct().move(0, 1,this.dto.getGameMap())) {
            return;
        }
        //获得游戏地图对象
        boolean[][] map = this.dto.getGameMap();
        //获得方块对象
        Point[] act = this.dto.getGameAct().getActPoint();
        //把方块堆积到地图数组
        for (int i = 0; i < act.length; i++) {
            map[act[i].x][act[i].y] = true;
        }
        //******************************************
        // 判断消行，并计算获得的经验值
        int exp = this.plusExp();
        // 如果加分消行
        if (exp > 0) {
            // 增加经验值
            this.plusPoint(exp);
        }
        //*********************************************
        //创建下一个方块
        this.dto.getGameAct().init(this.dto.getNext());
        //随机生成在下一个方块
        this.dto.setNext(random.nextInt(MAX_RANDOM));

        // 检查游戏是否失败
        if (this.isLose()) {
            int score = dto.getPoint();
            int delete = dto.getRemoveLine();
            System.out.println("分数："+score);
            System.out.println("消行；"+delete);
            System.exit(0);
        }
    }

    //判断是否输
    private boolean isLose() {
        // 获得现在的活动方块
        Point[] actPoints = this.dto.getGameAct().getActPoint();
        // 获得现在的游戏地图
        boolean[][] map = this.dto.getGameMap();
        for(int i = 0; i < actPoints.length; i++) {
            if(map[actPoints[i].x][actPoints[i].y]) {
                return true;
            }
        }
        return false;
    }
    //判断是否可消

    private boolean isCanRemoveLine(int y, boolean[][] map) {
        // 单行内对每一个单元格进行扫描
        for (int x = 0; x < 10; x++) {
            if (!map[x][y]) {
                // 如果有一个方格为false则直接到下一行
                return false;
            }
        }
        return true;
    }

    //消行处理
    private void removeLine(int row, boolean[][] map) {
        for (int x = 0; x < 10; x++) {
            for (int y = row; y > 0; y--) {
                map[x][y] = map[x][y - 1];
            }
            map[x][0] = false;
        }
    }

    //加分升级操作
    private void plusPoint(int exp) {
        int level = this.dto.getLevel();
        int rmline = this.dto.getRemoveLine();
        int point = this.dto.getPoint();
        int temp = 0;
        if (rmline % 10 + exp >= 10) {
            this.dto.setLevel(++level);
        }
        this.dto.setRemoveLine(rmline + exp);
        if(exp==1){
            temp =10;
        }
        else if(exp==2){
            temp =30;
        }
        else if(exp==3){
            temp =60;
        }
        else if(exp==4){
            temp =100;
        }
        this.dto.setPoint(point +temp );
    }

    //消行操作
    private int plusExp() {
        // 获得游戏地图
        boolean[][] map = this.dto.getGameMap();
        int exp = 0;
        // 扫描游戏地图，查看是否有可消行
        for (int y = 0; y < 20; y++) {
            // 判断是否可消行
            if (isCanRemoveLine(y, map)) {
                // 如果可消行，就执行
                this.removeLine(y, map);
                // 增加经验值
                exp++;
                levelup++;
            }
        }
        return exp;
    }
    public void keyLeft() {
        this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
    }

    public void keyRight() {
        this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
    }

    public int glevel(){
        return levelup;
    }
}
