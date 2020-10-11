package com.jietang.leetcode;

import java.util.ArrayList;
import java.util.List;

public class p37_解数独 {
    public static void main(String[] args) {
    }

    public void solveSudoku(char[][] board) {
        char[][] temp = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                temp[i][j] = board[i][j];
            }
        }
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (temp[i][j] == '.') {
                    int use = isUse(board, new int[]{i, j});
                    if (use > 0) {
                        board[i][j] = Character.forDigit(use, 10);
                        list.add(new int[]{i, j});
                    } else {
                        if (list.size() > 0) {
                            int[] ints = list.get(list.size() - 1);
                            i = ints[0];
                            j = ints[1] - 1;

                            list.remove(list.size() - 1);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int isUse(char[][] board, int[] pos) {
        int num = 0;
        if (board[pos[0]][pos[1]] != '.') {
            num = Integer.parseInt(String.valueOf(board[pos[0]][pos[1]]));
        }
        num++;
        int[] heng = getpos(pos[0]);
        int[] shu = getpos(pos[1]);
        flag:
        while (num < 10) {
            for (int i = 0; i < 9; i++) {
                if (board[pos[0]][i] != '.' && Integer.parseInt(String.valueOf(board[pos[0]][i])) == num) {
                    num++;
                    continue flag;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][pos[1]] != '.' && Integer.parseInt(String.valueOf(board[i][pos[1]])) == num) {
                    num++;
                    continue flag;
                }
            }
            for (int i = 0; i < heng.length; i++) {
                for (int j = 0; j < shu.length; j++) {
                    if (board[heng[i]][shu[j]] != '.' && Integer.parseInt(String.valueOf(board[heng[i]][shu[j]])) == num) {
                        num++;
                        continue flag;
                    }
                }
            }
            return num;
        }
        board[pos[0]][pos[1]] = '.';
        return 0;
    }

    private static int[] getpos(int po) {
        switch (po) {
            case 0:
            case 1:
            case 2:
                return new int[]{0, 1, 2};
            case 3:
            case 4:
            case 5:
                return new int[]{3, 4, 5};
            case 6:
            case 7:
            case 8:
                return new int[]{6, 7, 8};
        }
        return null;
    }
}
