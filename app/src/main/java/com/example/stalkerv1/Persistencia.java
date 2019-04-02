package com.example.stalkerv1;

import java.util.ArrayList;
//Singleton
public final class Persistencia {
    private static final Persistencia INSTANCE = new Persistencia();
    public ArrayList<Pessoa> strs;

    private Persistencia(){
        this.strs = new ArrayList<>();
    }

    public static Persistencia getInstance(){
        return INSTANCE;
    }

    public static int queryStr(String query){
        int id = 0;
        for(Pessoa s: INSTANCE.strs){
            if(s.getNome().toUpperCase().contains(query.toUpperCase())){
                return id;
            }
            id++;
        }
        return -1;
    }
}
