package com.company;

public class gira {
    public program proObj = new program();
    public static gira girObj;

    static {
        try {
            girObj = new gira();
        } catch (com.company.myexception myexception) {
            myexception.printStackTrace();
        }
    }

    public gira() throws myexception {
    }

    public static void main(String[] args) {
        girObj.proObj.run();
    }
}
