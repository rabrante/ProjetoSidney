/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rosadesktop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    
    public static Map<String,String> getMapColumnName()
    {
        Map<String,String> mapColumnName = new HashMap<>();
        mapColumnName.put("Cod Vend","codVend");
        mapColumnName.put("Cod Ped","pedido");
        mapColumnName.put("Cod Cliente","codCli");
        mapColumnName.put("Nome Cliente","nomCli");
        mapColumnName.put("Total Ped","totPed");
        mapColumnName.put("Status","situ");
        mapColumnName.put("Emissão","via");
        
        return mapColumnName;
    }   
    
    public static Map<String,String> getMapColumnNamePedido()
    {
        Map<String,String> mapColumnName = new HashMap<>();
        mapColumnName.put("Pedido", "pedido");
        mapColumnName.put("Cod Art", "codArt");
        mapColumnName.put("Descrição", "descricao");
        mapColumnName.put("Saida", "qtdSai");
        mapColumnName.put("Devol", "qtdRet");
        mapColumnName.put("Prec Custo", "preCus");
        mapColumnName.put("Prec Vend", "preVen");
        
        return mapColumnName;
    }
}
