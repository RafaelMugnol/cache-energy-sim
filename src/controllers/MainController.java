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
import models.CacheMemory;
import models.CacheParameters;
import models.CacheStatsL1Dados;
import models.CacheStatsL1Inst;
import models.CacheStatsL2;
import views.InicialView;
import views.MainView;

/**
 *
 * @author Rafael
 */
public class MainController {

    private MainView mView;
    private InicialView iView;
    private CacheMemory cacheMemory;
   

    
    public MainController() {

        iView = new InicialView(this);
        iView.setVisible(true);
        cacheMemory =  new CacheMemory();
    }
    

    public void escArquivoConfig() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.ini)", "ini");

        int returnVal = this.iView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.iView.getSelectedFile();
            //mView.setTextA(file.getName());
            cacheMemory.escArquivoConfig(file);

        }

    }

    public void escArquivoStats() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.txt)", "txt");

        int returnVal = this.iView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.iView.getSelectedFile();
            //mView.setTextA(file.getName());
            cacheMemory.escArquivoStats(file);
        }

    }

    public void abreMainView() {
        
        this.mView = new MainView(this, cacheMemory.matInfo());
        mView.setVisible(true);
    }

    public void escArquivoL1D() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti");

        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());

            cacheMemory.escArquivoL1D(file);

        }
    }
    
    public void escArquivoL1I() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti");

        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());

            cacheMemory.escArquivoL1I(file);

        }
    }
    
    public void escArquivoL2() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti");

        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());

            cacheMemory.escArquivoL2(file);

        }
    }

   public double[] returnEnergy(){
       cacheMemory.calcEnergy();
       return(cacheMemory.returnEnergy());
   }
   
   public void save() throws IOException{
       FileNameExtensionFilter filtro = new FileNameExtensionFilter("Table File (.csv)", "csv");
       
       int returnVal = this.mView.showFileSaveDialog(filtro);
       cacheMemory.salvaArquivo(this.mView.getSelectedFile());
   }
}
