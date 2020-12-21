package study.datastruct;

import java.util.Stack;

/**
 * @author niuzhenhao
 * @date 2020/12/21 13:42
 * @desc
 */

public class A迷宫问题 {
    public static void main(String[] args) {
        int[][] map = {                           //迷宫地图,1代表墙壁，0代表通路
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,0,0,1,1,0,1,1},
                {1,0,1,1,1,0,0,0,1,1},
                {1,0,0,0,1,0,0,0,1,1},
                {1,0,1,0,0,0,1,0,0,1},
                {1,0,1,1,1,0,1,0,0,1},
                {1,1,0,0,0,1,0,0,1,1},
                {1,1,1,1,1,1,1,1,1,1}
        };
        Stack<point> point = new Stack<>();
        int n = map.length - 1;
        int m = map[0].length - 1;
        point.push(new point(1, 1, 1));
        map[1][1] = 2;
        while (!point.isEmpty()) {
            point peek = point.peek();

            for (int i = 0; i < map.length; i++) {

                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println("-----------------------------");



            int x = peek.x;
            int y = peek.y;
            if (x == n -1){
                System.out.println("find out");
                break;
            }
            if (x + 1 < n && map[x + 1][y] == 0) {
                point.push(new point(x + 1, y, 1));
                map[x + 1][y] = 2;
            }
            else if (y + 1 < m && map[x][y + 1] == 0) {
                point.push(new point(x, y + 1, 2));
                map[x][y+1] = 2;
            }
            else if (x - 1 > 0 && map[x-1][y] == 0) {
                point.push(new point(x-1, y, 3));
                map[x-1][y] = 2;
            }
            else if (y - 1 > 0 && map[x][y-1] == 0) {
                point.push(new point(x,y-1, 4));
                map[x][y-1] = 2;
            } else {
                while (!point.empty()) {
                    point before = point.pop();
                    int by = before.y;
                    int bx = before.x;
                    if (before.d == 4) {
                    } else {
                        int d = before.d;
                        if (d == 1 && by + 1 < m && map[bx][by+1] ==0) {
                            point.push(new point(bx, by + 1, 2));
                            map[bx][by + 1] = 2;
                            break;
                        } else if (d == 2 && bx-1>0 && map[bx-1][by]==0 ) {
                            point.push(new point(bx-1, by, 3));
                            map[bx-1][by] = 2;
                            break;
                        } else if (d == 3 && by-1>0 && map[bx][by-1]==0) {
                            point.push(new point(bx, by-1, 4));
                            map[bx][by] = 2;
                            break;
                        }
                    }
                }

            }





        }



    }
    static class point {
        int x;
        int y;
        int d;
        public point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
    }
}
