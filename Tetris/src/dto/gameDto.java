package dto;

import entity.gameAct;

import java.util.List;
import java.util.logging.Level;

public class gameDto {

    private List<Player> dbRecode;

    private List<Player> diskRecode;

    private boolean[][] gameMap;

    private gameAct gameAct;

    private int Next;

    private int level=1;

    private int point;

    private int removeLine;

    public gameDto(){
        dtoInit();
    }
    //dot初始化
    public void dtoInit(){
        this.gameMap = new boolean[10][20];
    }

    public List<Player> getDbRecode() {
        return dbRecode;
    }

    public void setDbRecode(List<Player> dbRecode) {
        this.dbRecode = dbRecode;
    }

    public List<Player> getDiskRecode() {
        return diskRecode;
    }

    public void setDiskRecode(List<Player> diskRecode) {
        this.diskRecode = diskRecode;
    }

    public boolean[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(boolean[][] gameMap) {
        this.gameMap = gameMap;
    }

    public entity.gameAct getGameAct() {
        return gameAct;
    }

    public void setGameAct(entity.gameAct gameAct) {
        this.gameAct = gameAct;
    }

    public int getNext() {
        return Next;
    }

    public void setNext(int next) {
        Next = next;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRemoveLine() {
        return removeLine;
    }

    public void setRemoveLine(int removeLine) {
        this.removeLine = removeLine;
    }
}
