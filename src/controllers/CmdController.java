/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CacheMemory;

/**
 *
 * @author Rafael
 */
public class CmdController {

    private CacheMemory cacheMemory;
    private File file;

    public CmdController(String[] args) {
        cacheMemory = new CacheMemory();
        for (int pos = 1; pos < args.length; pos++) {
            if (args[pos].contains("--config=")) {
                cacheMemory.escArquivoConfig(new File(args[pos].split("=")[1]));
            }
        }
        for (int pos = 1; pos < args.length; pos++) {
            if (args[pos].contains("--stats=")) {
                cacheMemory.escArquivoStats(new File(args[pos].split("=")[1]));//C:\Users\Rafael\Desktop\config.ini
            }

        }
        for (int pos = 1; pos < args.length; pos++) {
            if (args[pos].contains("--outPath=")) {
                file = new File(args[pos].split("=")[1] + "saida.csv");
            }

        }

        cacheMemory.escArquivoL1D(new File(args[args.length - 3]));
        cacheMemory.escArquivoL1I(new File(args[args.length - 2]));
        cacheMemory.escArquivoL2(new File(args[args.length - 1]));
        
        
        cacheMemory.calcEnergy();
        try {
            cacheMemory.salvaArquivo(file);
        } catch (IOException ex) {
            Logger.getLogger(CmdController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
