/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import models.CacheMemory;

/**
 *
 * @author Rafael
 */
public class CmdController {
    private CacheMemory cacheMemory;
    
    public CmdController(String[] args){

        for(int pos=1; pos < args.length; pos++){
            if(args[pos].contains("--stats=")){
                cacheMemory.escArquivoStats(new File(args[pos].split("=")[1]));//C:\Users\Rafael\Desktop\config.ini
            }
            else if(args[pos].equals("--config=")){
                cacheMemory.escArquivoConfig(new File(args[pos].split("=")[1]));
            }
        }
        
        cacheMemory.escArquivoL1D(new File(args[args.length-3]));
        cacheMemory.escArquivoL1I(new File(args[args.length-2]));
        cacheMemory.escArquivoL2(new File(args[args.length-2]));
       
    }
}
