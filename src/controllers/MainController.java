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
import models.Graphic;
import views.GraphicView;
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
    

    public String escArquivoConfig() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.ini)", "ini");
        String nome = "";
        
        int returnVal = this.iView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.iView.getSelectedFile();
            nome = file.getName();
            cacheMemory.escArquivoConfig(file);

        }
        return nome;
    }
    
    public String escArquivoVal() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Valgrind File (.txt)", "txt");
        String nome = "";
        int returnVal = this.iView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.iView.getSelectedFile();
            nome = file.getName();
            cacheMemory.escArquivoValgrind(file);

        }
        return nome;
    }

    public String escArquivoStats() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.txt)", "txt");
        String nome = "";
        int returnVal = this.iView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.iView.getSelectedFile();
            nome = file.getName();
            cacheMemory.escArquivoStats(file);
        }
        return nome;
    }

    public void abreMainView(boolean ll) {
        
        this.mView = new MainView(this, cacheMemory.matInfo(), ll);
        mView.setVisible(true);
    }

    public String escArquivoL1D() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File", "cacti", "nvsim");

        int returnVal = this.mView.showFileChooserDialog(filtro);
        String nome = "";
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            File file = this.mView.getSelectedFile();
            nome = file.getName();
            //mView.setTextA(file.getName());

            cacheMemory.escArquivoL1D(file);

        }
        return (nome);
    }
    
    public String escArquivoL1I() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti", "nvsim");
        String nome = "";
        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());
            nome = file.getName();
            cacheMemory.escArquivoL1I(file);

        }
        return nome;
    }
    
    public String escArquivoL2() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Memory File (.cacti)", "cacti", "nvsim");
        String nome = "";
        int returnVal = this.mView.showFileChooserDialog(filtro);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = this.mView.getSelectedFile();
            //mView.setTextA(file.getName());
            nome = file.getName();
            cacheMemory.escArquivoL2(file);

        }
        return nome;
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
   
   public void geraGrafico(){
       
       GraphicView gv = new GraphicView(Graphic.criaGrafico(Graphic.createDataset(cacheMemory.returnEnergy())));
       gv.setVisible(true);
   }
}
