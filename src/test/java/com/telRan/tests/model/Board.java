package com.telRan.tests.model;

public class Board {

    private  String boardVisibility;
    private  String boardName;

    public Board withBoardName(String boardName){
        this.boardName = boardName;
        return this;
    }

   public  Board withTeamVisibility(String teamVisibility){
        this.boardVisibility = teamVisibility;
        return this;
   }

    public String getBoardName() {
        return boardName;
    }
    public String getBoardVisibility() {
        return boardVisibility;
    }

    @Override
    public String toString() {
        return "Board{"+ "BoardName'" + boardName  + '\'' + ", boardVisibility='"
    + boardVisibility + '\'' + '}';
    }


    public class withBoardName {
        public withBoardName(String s) {
        }
    }
}




