package org.wy.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCP3 {

    public boolean robot1(String command, int[][] obstacles, int x, int y) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (map.get(obstacle[0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(obstacle[1]);
                map.put(obstacle[0], list);
            } else {
                map.get(obstacle[0]).add(obstacle[1]);
            }
        }
        if (x == 0 && y == 0) return true;
        int curX = 0;
        int curY = 0;
        while (curX <= x && curY <= y) {
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    curY++;
                } else {
                    curX++;
                }

//                for (int[] obstacle : obstacles) {
//                    if (obstacle[0] == curX && obstacle[1] == curY) return false;
//                }
                if (map.get(curX) != null && map.get(curX).contains(curY)) return false;

                if (curX == x && curY == y) return true;
            }
        }
        return false;
    }


    public boolean robot(String command, int[][] obstacles, int x, int y) {

        char[] chars = command.toCharArray();
        int roundX = 0;
        int roundY = 0;
        for (char aChar : chars) {
            if (aChar == 'U') {
                roundY++;
            } else roundX++;
        }
        int step = reach(command,x,y, roundX, roundY);
        if (step==-1)return false;
        for (int[] obstacle : obstacles) {
            int stepObs = reach(command,obstacle[0],obstacle[1], roundX, roundY);
            if (stepObs!=-1 && stepObs<step)return false;
        }
        return true;
    }

    private int reach(String command, int targetX, int targetY, int roundX, int roundY) {


        int round = Math.min(targetX/roundX,targetY/roundY);
        roundX*=round;
        roundY*=round;
        if (roundX==targetX&&roundY==targetY)return roundX+roundY;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i)=='U')roundY++;else roundX++;
            if (roundX==targetX&&roundY==targetY)return roundX+roundY;
            if (roundX>targetX || roundY>targetY)return -1;
        }
        return -1;

    }


}
