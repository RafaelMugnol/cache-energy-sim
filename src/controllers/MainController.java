/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.CacheParameters;
import views.MainView;

/**
 *
 * @author Rafael
 */
public class MainController {

    private MainView mView;
    private double cacheSize; 
    private CacheParameters param = new CacheParameters();
    
    public MainController() {
        this.mView = new MainView(this);
        mView.setVisible(true);
    }

    public void escArquivo() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti");

        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());

            String linha;
            try {
                FileReader ler = new FileReader(file);
                BufferedReader buff = new BufferedReader(ler);
                while (buff.ready()) {
                    linha = buff.readLine();
                    if (linha.contains("Total cache size (bytes):")){
                        String[] array = linha.split(":");
                        param.setCacheSize(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Number of banks:")){
                        String[] array = linha.split(":");
                        param.setBanks(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Associativity:")){
                        String[] array = linha.split(":");
                        param.setAssociativity(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Block size (bytes):")){
                        String[] array = linha.split(":");
                        param.setBlockSize(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Read/write Ports:")){
                        String[] array = linha.split(":");
                        param.setrWPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Read ports:")){
                        String[] array = linha.split(":");
                        param.setrPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Write ports:")){
                        String[] array = linha.split(":");
                        param.setwPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Technology size (nm):")){
                        String[] array = linha.split(":");
                        param.setTechSize(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Access time (ns):")){
                        String[] array = linha.split(":");
                        param.setAccessTime(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Cycle time (ns):")){
                        String[] array = linha.split(":");
                        param.setCycleTime(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Precharge Delay (ns):")){
                        String[] array = linha.split(":");
                        param.setPrechargeDelay(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Activate Energy (nJ):")){
                        String[] array = linha.split(":");
                        param.setActivateEnergy(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Read Energy (nJ):")){
                        String[] array = linha.split(":");
                        param.setrEnergy(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Write Energy (nJ):")){
                        String[] array = linha.split(":");
                        param.setwEnergy(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Precharge Energy (nJ):")){
                        String[] array = linha.split(":");
                        param.setPrechargeEnergy(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Leakage Power Closed Page (mW):")){
                        String[] array = linha.split(":");
                        param.setPowerClosedPage(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Leakage Power Open Page (mW):")){
                        String[] array = linha.split(":");
                        param.setPowerOpenPage(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Leakage Power I/O (mW):")){
                        String[] array = linha.split(":");
                        param.setPowerIO(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Refresh power (mW):")){
                        String[] array = linha.split(":");
                        param.setRefreshPower(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Cache height x width (mm):")){
                        String[] array = linha.split(":");
                        String[] array2 = array[array.length - 1].split("x");
                        param.setCacheHeight(Double.parseDouble(array2[array2.length - 2]));
                        param.setCacheWidth(Double.parseDouble(array2[array2.length - 1]));
                    }
                    else if (linha.contains("Block size")){
                        String[] array = linha.split(":");
                        param.setBlockSise(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Read only ports")){
                        String[] array = linha.split(":");
                        param.setReadOnlyPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Write only ports")){
                        String[] array = linha.split(":");
                        param.setWriteOnlyPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Read write ports")){
                        String[] array = linha.split(":");
                        param.setReadWritePorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Single ended read ports")){
                        String[] array = linha.split(":");
                        param.setSingleEndedReadPorts(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Cache banks")){
                        String[] array = linha.split(":");
                        param.setCacheBanks(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("Technology")){
                        String[] array = linha.split(":");
                        param.setTechnology(Double.parseDouble(array[array.length - 1]));
                    }
                    else if (linha.contains("cache type")){
                        String[] array = linha.split(":");
                        param.setCacheType(Double.parseDouble(array[array.length - 1]));
                    }
                    
                }
            } catch (FileNotFoundException ex) {
                mView.manssageDialog("Arquivo não encontrado!");
            } catch (IOException ex) {
                //
            }

        }
    }
}
