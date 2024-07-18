/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DataS {
    private static DataS instance;
    public ArrayList<Capuccino> cappuccinoList;

    private DataS() {
        cappuccinoList = new ArrayList<>();
    }

    public static DataS getInstance() {
        if (instance == null) {
            instance = new DataS();
        }
        return instance;
    }
}