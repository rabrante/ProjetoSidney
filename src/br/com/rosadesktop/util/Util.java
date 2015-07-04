/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.util;

import java.util.ArrayList;

/**
 *
 * @author Claudio
 */
public class Util 
{
    public static String getRightDate(String date)
    {
        String temp = date;
        
        String year = temp.substring(0,temp.indexOf("-"));
        
        temp = temp.substring(temp.indexOf("-")+1);
        
        String month = temp.substring(0,temp.indexOf("-"));
        
        temp = temp.substring(temp.indexOf("-")+1);
        
        String day = temp;
        
        temp = day+"/"+month+"/"+year;
        
        return temp;
    }
    
    public static ArrayList<String> getListColumnName()
    {
        ArrayList<String> listColumnName = new ArrayList<>();
        listColumnName.add(0,"codVend");
        listColumnName.add(1,"pedido");
        listColumnName.add(2,"codCli");
        listColumnName.add(3,"nomCli");
        listColumnName.add(4,"totPed");
        listColumnName.add(5,"situ");
        listColumnName.add(6,"via");
        
        return listColumnName;
    }
}
