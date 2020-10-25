package com.telRan.tests.tests;

import com.telRan.tests.model.Board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvider {
    @org.testng.annotations.DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"1DPboards","public"});
        list.add(new Object[]{"1D-Pboards","public"});
        list.add(new Object[]{"1s","public"});
        list.add(new Object[]{"!@#*^%$","public"});

        return list.iterator();
    }

    @org.testng.annotations.DataProvider
    public Iterator<Object[]>validBoardsFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));

        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Board().withBoardName(split[0])
                    .withTeamVisibility(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
