/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Rafael
 */

/*
#Cache size                    : 32768 *
#Block size                    : 64
#Associativity                 : 4
#Read only ports               : 0
#Write only ports              : 0
#Read write ports              : 1
#Single ended read ports       : 0
#Cache banks (UCA)             : 1
#Technology                    : 0.032
Temperature                   : 350
Tag size                      : 19
#cache type                    : Cache
Model as memory               : 0
Access mode                   : 0
Data array cell type          : 4

    Total cache size (bytes): 32768
    Number of banks: 1
    Associativity: 4
    Block size (bytes): 64
    Read/write Ports: 1
    Read ports: 0
    Write ports: 0
    Technology size (nm): 32

    Access time (ns): 1.26907
    Cycle time (ns):  2.03685
    Precharge Delay (ns): 0
    Activate Energy (nJ): 0.00878176
    Read Energy (nJ): 0.0621026
    Write Energy (nJ): 0.0414834

    Precharge Energy (nJ): 0.0316549
    +Leakage Power Closed Page (mW): 0.39616
    +Leakage Power Open Page (mW): 0.693652
    +Leakage Power I/O (mW): 0.691852
    Refresh power (mW): 6.92249e-05
    Cache height x width (mm): 0.266179 x 0.147025*/

public class CacheParameters {
    private double cacheSize, associativity, blockSize, rEnergy, wEnergy, leakage;

    /**
     * @return the cacheSize
     */
    public double getCacheSize() {
        return cacheSize;
    }

    /**
     * @param cacheSize the cacheSize to set
     */
    public void setCacheSize(double cacheSize) {
        this.cacheSize = cacheSize;
    }

    /**
     * @return the associativity
     */
    public double getAssociativity() {
        return associativity;
    }

    /**
     * @param associativity the associativity to set
     */
    public void setAssociativity(double associativity) {
        this.associativity = associativity;
    }

    /**
     * @return the blockSize
     */
    public double getBlockSize() {
        return blockSize;
    }

    /**
     * @param blockSize the blockSize to set
     */
    public void setBlockSize(double blockSize) {
        this.blockSize = blockSize;
    }

    /**
     * @return the rEnergy
     */
    public double getrEnergy() {
        return rEnergy;
    }

    /**
     * @param rEnergy the rEnergy to set
     */
    public void setrEnergy(double rEnergy) {
        this.rEnergy = rEnergy;
    }

    /**
     * @return the wEnergy
     */
    public double getwEnergy() {
        return wEnergy;
    }

    /**
     * @param wEnergy the wEnergy to set
     */
    public void setwEnergy(double wEnergy) {
        this.wEnergy = wEnergy;
    }

    /**
     * @return the leakage
     */
    public double getLeakage() {
        return leakage;
    }

    /**
     * @param leakage the leakage to set
     */
    public void setLeakage(double leakage) {
        this.leakage = leakage;
    }
       
            
     

    
    
    
   
}
