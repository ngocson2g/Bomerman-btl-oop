package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;
import uet.oop.bomberman.entities.bomb.Bomb;

public class AIHight extends  AI {
    Enemy _e;
    Bomb _bomb;
    Bomber _bomber;

    public AIHight(Bomb bomb, Enemy e) {
        _bomb = bomb;
        _e = e;
    }

    @Override
    public int calculateDirection() {
        // TODO: cài đặt thuật toán tìm đường đi
        if (_bomber == null) return random.nextInt(4);
        if (_bomb == null) return random.nextInt(4);
        // tranh bom

        if (_bomb.getXTile() > (_e.getXTile() + 20)) return 3;
        else if (_bomb.getXTile() < (_e.getXTile() - 20)) return 1;
        else if (_bomb.getYTile() < (_e.getYTile() - 20)) return 2;
        else if (_bomb.getYTile() > (_e.getYTile() + 20)) return 0;

        //lua theo
        int vertical = random.nextInt(2);
        if (vertical == 1) {
            int v = calculateRowDirection();
            if (v != -1)
                return v;
            else
                return calculateColDirection();

        } else {
            int h = calculateColDirection();

            if (h != -1)
                return h;
            else
                return calculateRowDirection();
        }
    }

    protected int calculateColDirection() {
        if (_bomber.getXTile() < _e.getXTile())
            return 3;
        else if (_bomber.getXTile() > _e.getXTile())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if (_bomber.getYTile() < _e.getYTile())
            return 0;
        else if (_bomber.getYTile() > _e.getYTile())
            return 2;
        return -1;
    }
}