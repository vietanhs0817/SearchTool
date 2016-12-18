/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.docker.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vietanhs0817
 */
public class Core {
    
    private final File[] files;
    
    public Core(String path) {
        File f = new File(path);
        this.files = f.listFiles();
    }
    
    private ArrayList<String> readFileText(File file) throws FileNotFoundException, IOException{
        ArrayList<String> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String in = br.readLine();
        while(in != null){
            data.add(in);
            in = br.readLine();
        }
        return data;
    }
    
    public HashMap<String,String> bank(File file) throws IOException{
        HashMap<String,String> bank = new HashMap<>();
        ArrayList<String> data = readFileText(file);
        data.stream().forEach((line) -> {
            int index = line.lastIndexOf("|");
            if (index > 0) {
                bank.put(line.substring(0,index), line.substring(index+1));
            }
        });
        return bank;
    }
   

    public File[] getFiles() {
        return files;
    }
    
    
}
