/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rafael
 */
public class CacheMemory {

    private CacheStatsL1Dados cL1D;
    private CacheStatsL1Inst cL1I;
    private CacheStatsL2 cL2;
    private int nCache = 0;
    //variaveis para o cálculo de energia
    private double readL1D, readL1I, writeL1D, readL2, writeL2, tEnergy;

    public void escArquivoConfig(File file) {
        String linha;
        try {
            FileReader ler = new FileReader(file);
            BufferedReader buff = new BufferedReader(ler);
            while (buff.ready()) {
                linha = buff.readLine();
                //l1 dados
                if (linha.equals("[system.cpu.dcache]")) {
                    cL1D = new CacheStatsL1Dados();
                    nCache++;
                    for (int i = 0; i < 23; i++) {
                        linha = buff.readLine();
                        if (linha.contains("assoc")) {
                            String[] array = linha.split("=");
                            cL1D.setAssoc(Long.parseLong(array[array.length - 1]));
                        } else if (linha.contains("size")) {
                            String[] array = linha.split("=");
                            cL1D.setSize(Long.parseLong(array[array.length - 1]));
                        }
                    }

                } else if (linha.equals("[system.cpu.dcache.tags]")) {
                    for (int i = 0; i < 8; i++) {
                        linha = buff.readLine();
                        if (linha.contains("type")) {
                            String[] array = linha.split("=");
                            cL1D.setType(array[array.length - 1]);
                        } else if (linha.contains("block_size")) {
                            String[] array = linha.split("=");
                            cL1D.setBlock_size(Long.parseLong(array[array.length - 1]));
                        }
                    }

                } //l1 inst
                else if (linha.equals("[system.cpu.icache]")) {
                    cL1I = new CacheStatsL1Inst();
                    nCache++;
                    for (int i = 0; i < 23; i++) {
                        linha = buff.readLine();
                        if (linha.contains("assoc")) {
                            String[] array = linha.split("=");
                            cL1I.setAssoc(Long.parseLong(array[array.length - 1]));
                        } else if (linha.contains("size")) {
                            String[] array = linha.split("=");
                            cL1I.setSize(Long.parseLong(array[array.length - 1]));
                        }
                    }

                } else if (linha.equals("[system.cpu.icache.tags]")) {
                    for (int i = 0; i < 8; i++) {
                        linha = buff.readLine();
                        if (linha.contains("type")) {
                            String[] array = linha.split("=");
                            cL1I.setType(array[array.length - 1]);
                        } else if (linha.contains("block_size")) {
                            String[] array = linha.split("=");
                            cL1I.setBlock_size(Long.parseLong(array[array.length - 1]));
                        }
                    }

                } //l2
                else if (linha.equals("[system.l2]")) {
                    cL2 = new CacheStatsL2();
                    nCache++;
                    for (int i = 0; i < 23; i++) {
                        linha = buff.readLine();
                        if (linha.contains("assoc")) {
                            String[] array = linha.split("=");
                            cL2.setAssoc(Long.parseLong(array[array.length - 1]));
                        } else if (linha.contains("size")) {
                            String[] array = linha.split("=");
                            cL2.setSize(Long.parseLong(array[array.length - 1]));
                        }
                    }

                } else if (linha.equals("[system.l2.tags]")) {
                    for (int i = 0; i < 8; i++) {
                        linha = buff.readLine();
                        if (linha.contains("type")) {
                            String[] array = linha.split("=");
                            cL2.setType(array[array.length - 1]);
                        } else if (linha.contains("block_size")) {
                            String[] array = linha.split("=");
                            cL2.setBlock_size(Long.parseLong(array[array.length - 1]));
                        }
                    }

                }
            }
        } catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
    }

    public void escArquivoStats(File file) {

        String linha;
        try {
            FileReader ler = new FileReader(file);
            BufferedReader buff = new BufferedReader(ler);
            while (buff.ready()) {
                linha = buff.readLine();
                //l2
                cL2.setWriteMiss();//inicializado com 0
                if (linha.contains("system.l2.ReadReq_hits::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL2.setReadHits(l);
                } else if (linha.contains("system.l2.Writeback_hits::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL2.setWriteHits(l);
                } else if (linha.contains("system.l2.ReadReq_misses::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL2.setReadMisses(l);
                } else if (linha.contains("system.l2.overall_miss_rate::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    double l = Double.parseDouble(t);
                    cL2.setMissRate(l);
                } //l1inst
                else if (linha.contains("system.cpu.icache.ReadReq_hits::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1I.setReadHits(l);
                } else if (linha.contains("system.cpu.icache.ReadReq_misses::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1I.setReadMisses(l);
                } else if (linha.contains("system.cpu.icache.overall_miss_rate::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    double l = Double.parseDouble(t);
                    cL1I.setMissRate(l);
                } //l1d
                else if (linha.contains("system.cpu.dcache.ReadReq_hits::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1D.setReadHits(l);
                } else if (linha.contains("system.cpu.dcache.WriteReq_hits::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1D.setWriteHits(l);
                } else if (linha.contains("system.cpu.dcache.ReadReq_misses::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1D.setReadMisses(l);
                } else if (linha.contains("system.cpu.dcache.WriteReq_misses::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    long l = Long.parseLong(t);
                    cL1D.setWriteMisses(l);
                } else if (linha.contains("system.cpu.dcache.overall_miss_rate::total")) {
                    String[] array = (linha.split("total")[1]).split("#");
                    String t = array[0].trim();
                    double l = Double.parseDouble(t);
                    cL1D.setMissRate(l);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            //
        }

    }

    public void escArquivoL1D(File file) {
        String linha;
        try {
            FileReader ler = new FileReader(file);
            BufferedReader buff = new BufferedReader(ler);
            cL1D.cPar = new CacheParameters();
            while (buff.ready()) {
                linha = buff.readLine();
                if (linha.contains("Total cache size (bytes):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setCacheSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Number of banks:")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Associativity:")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setAssociativity(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Block size (bytes):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setBlockSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read/write Ports:")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setrWPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read ports:")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setrPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write ports:")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setwPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology size (nm):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setTechSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Access time (ns):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setAccessTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cycle time (ns):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setCycleTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Delay (ns):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setPrechargeDelay(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Activate Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setActivateEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setrEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setwEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setPrechargeEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Closed Page (mW):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setPowerClosedPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Open Page (mW):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setPowerOpenPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power I/O (mW):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setPowerIO(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Refresh power (mW):")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setRefreshPower(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache height x width (mm):")) {
                    String[] array = linha.split(":");
                    String[] array2 = array[array.length - 1].split("x");
                    cL1D.cPar.setCacheHeight(Double.parseDouble(array2[array2.length - 2]));
                    cL1D.cPar.setCacheWidth(Double.parseDouble(array2[array2.length - 1]));
                } else if (linha.contains("Block size")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setBlockSise(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read only ports")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setReadOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write only ports")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setWriteOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read write ports")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setReadWritePorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Single ended read ports")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setSingleEndedReadPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache banks")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setCacheBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology")) {
                    String[] array = linha.split(":");
                    cL1D.cPar.setTechnology(Double.parseDouble(array[array.length - 1]));
                }

            }
        } catch (FileNotFoundException ex) {
            // 
        } catch (IOException ex) {
            //
        }

    }

    public void escArquivoL1I(File file) {
        String linha;
        try {
            FileReader ler = new FileReader(file);
            BufferedReader buff = new BufferedReader(ler);
            cL1I.cPar = new CacheParameters();
            while (buff.ready()) {
                linha = buff.readLine();
                if (linha.contains("Total cache size (bytes):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setCacheSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Number of banks:")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Associativity:")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setAssociativity(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Block size (bytes):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setBlockSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read/write Ports:")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setrWPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read ports:")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setrPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write ports:")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setwPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology size (nm):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setTechSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Access time (ns):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setAccessTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cycle time (ns):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setCycleTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Delay (ns):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setPrechargeDelay(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Activate Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setActivateEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setrEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setwEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setPrechargeEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Closed Page (mW):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setPowerClosedPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Open Page (mW):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setPowerOpenPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power I/O (mW):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setPowerIO(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Refresh power (mW):")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setRefreshPower(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache height x width (mm):")) {
                    String[] array = linha.split(":");
                    String[] array2 = array[array.length - 1].split("x");
                    cL1I.cPar.setCacheHeight(Double.parseDouble(array2[array2.length - 2]));
                    cL1I.cPar.setCacheWidth(Double.parseDouble(array2[array2.length - 1]));
                } else if (linha.contains("Block size")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setBlockSise(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read only ports")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setReadOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write only ports")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setWriteOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read write ports")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setReadWritePorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Single ended read ports")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setSingleEndedReadPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache banks")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setCacheBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setTechnology(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("cache type")) {
                    String[] array = linha.split(":");
                    cL1I.cPar.setCacheType(Double.parseDouble(array[array.length - 1]));
                }

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            //
        }
    }

    public void escArquivoL2(File file) {

        String linha;
        try {
            FileReader ler = new FileReader(file);
            BufferedReader buff = new BufferedReader(ler);
            cL2.cPar = new CacheParameters();
            while (buff.ready()) {
                linha = buff.readLine();
                if (linha.contains("Total cache size (bytes):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setCacheSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Number of banks:")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Associativity:")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setAssociativity(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Block size (bytes):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setBlockSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read/write Ports:")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setrWPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read ports:")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setrPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write ports:")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setwPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology size (nm):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setTechSize(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Access time (ns):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setAccessTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cycle time (ns):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setCycleTime(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Delay (ns):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setPrechargeDelay(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Activate Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setActivateEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setrEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setwEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Precharge Energy (nJ):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setPrechargeEnergy(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Closed Page (mW):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setPowerClosedPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power Open Page (mW):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setPowerOpenPage(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Leakage Power I/O (mW):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setPowerIO(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Refresh power (mW):")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setRefreshPower(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache height x width (mm):")) {
                    String[] array = linha.split(":");
                    String[] array2 = array[array.length - 1].split("x");
                    cL2.cPar.setCacheHeight(Double.parseDouble(array2[array2.length - 2]));
                    cL2.cPar.setCacheWidth(Double.parseDouble(array2[array2.length - 1]));
                } else if (linha.contains("Block size")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setBlockSise(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read only ports")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setReadOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Write only ports")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setWriteOnlyPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Read write ports")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setReadWritePorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Single ended read ports")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setSingleEndedReadPorts(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Cache banks")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setCacheBanks(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("Technology")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setTechnology(Double.parseDouble(array[array.length - 1]));
                } else if (linha.contains("cache type")) {
                    String[] array = linha.split(":");
                    cL2.cPar.setCacheType(Double.parseDouble(array[array.length - 1]));
                }

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            //
        }
    }

    public void calcEnergy() {

        readL1D = (cL1D.getReadHits() * cL1D.cPar.getrEnergy() + (cL1D.getReadMisses() * (cL1D.cPar.getrEnergy() + cL1D.cPar.getwEnergy())));
        readL1I = (cL1I.getReadHits() * cL1I.cPar.getrEnergy() + (cL1I.getReadMisses() * (cL1I.cPar.getrEnergy() + cL1I.cPar.getwEnergy())));
        writeL1D = (cL1D.getWriteHits() * cL1D.cPar.getrEnergy() + (cL1D.getWriteMisses() * (cL1D.cPar.getwEnergy() + cL1D.cPar.getrEnergy())));
        readL2 = (cL2.getReadHits() * cL2.cPar.getrEnergy() + (cL2.getReadMisses() * (cL2.cPar.getrEnergy() + cL2.cPar.getwEnergy())));
        writeL2 = (cL2.getWriteHits() * cL2.cPar.getrEnergy() + (cL2.getWriteMiss() * (cL2.cPar.getwEnergy() + cL2.cPar.getrEnergy())));

        tEnergy = (readL1D + readL1I + writeL1D + readL2 + writeL2);
    }

    public double[] returnEnergy() {
        return (new double[]{readL1D, readL1I, writeL1D, readL2, writeL2, tEnergy});
    }

    public String[][] matInfo() {
        String[][] mat = new String[nCache][4];
        if (nCache >= 1) {
            mat[0][0] = cL1D.getType() + "";
            mat[0][1] = cL1D.getSize() + "";
            mat[0][2] = cL1D.getBlock_size() + "";
            mat[0][3] = cL1D.getAssoc() + "";
            if (nCache >= 2) {
                mat[1][0] = cL1I.getType() + "";
                mat[1][1] = cL1I.getSize() + "";
                mat[1][2] = cL1I.getBlock_size() + "";
                mat[1][3] = cL1I.getAssoc() + "";
                if (nCache >= 3) {
                    mat[2][0] = cL2.getType() + "";
                    mat[2][1] = cL2.getSize() + "";
                    mat[2][2] = cL2.getBlock_size() + "";
                    mat[2][3] = cL2.getAssoc() + "";
                }
            }
        }
        return mat;
    }

    public void salvaArquivo(File file) throws IOException {
        FileWriter w = new FileWriter(file);;
        BufferedWriter escreve = new BufferedWriter(w);

        escreve.write(" ; Dynamic Read; Dynamic Write; Dynamic Total; Leakage (Static)");
        escreve.write("L1D; " + readL1D + "; " + writeL1D + "; " + (readL1D + writeL1D) + "; " + cL1D.cPar.somaLeakage());
        escreve.write("L1I; " + readL1I + "; ; " + (readL1I) + "; " + cL1I.cPar.somaLeakage());
        escreve.write("L1Total; " + (readL1D + readL1I) + "; " + writeL1D + "; " + (readL1D + writeL1D + readL1I) + "; " + (cL1D.cPar.somaLeakage() + cL1I.cPar.somaLeakage()));
        escreve.write("L2; " + readL2 + "; " + writeL2 + "; " + (readL2 + writeL2) + "; " + cL2.cPar.somaLeakage());
        escreve.write("Total; " + (readL1D + readL1I + readL2) + "; " + (writeL1D + writeL2) + "; " + (readL1D + writeL1D + readL1I + readL2 + writeL2) + "; " + (cL1D.cPar.somaLeakage() + cL1I.cPar.somaLeakage() + cL2.cPar.somaLeakage()));

        escreve.close();
        w.close();
    }
}
