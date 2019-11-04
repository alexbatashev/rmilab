package com.example.lib;

import java.io.Serializable;

public class GameUpdate implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] gameboard;
    private int nextMoveBy;

    public enum GameStatus {
        A_WINS,
        B_WINS,
        DRAW,
        MOVE
    }

    private GameStatus gameStatus;

    public GameUpdate(int[][] gameboard, int nextMoveBy, GameStatus status) {
        this.gameboard = gameboard;
        this.nextMoveBy = nextMoveBy;
        this.gameStatus = status;
    }

    public int[][] getGameboard() {
        return gameboard;
    }

    public int getNextMoveBy() {
        return nextMoveBy;
    }

    @Override
    public boolean equals(Object obj) {
        GameUpdate gb = (GameUpdate) obj;

        if (gameStatus != gb.gameStatus) {
            return false;
        }

        if (nextMoveBy != gb.nextMoveBy) {
            return false;
        }

        // todo sanity checks
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameboard[i][j] != gb.gameboard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
