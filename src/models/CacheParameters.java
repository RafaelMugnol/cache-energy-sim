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
    private double cacheSize, banks, associativity, blockSize, rWPorts, rPorts, wPorts, techSize,
        accessTime, cycleTime, prechargeDelay, activateEnergy, rEnergy, wEnergy,
        prechargeEnergy, powerClosedPage, powerOpenPage,  powerIO, refreshPower, cacheHeight, cacheWidth,
        blockSise, readOnlyPorts, writeOnlyPorts, readWritePorts, singleEndedReadPorts,
        cacheBanks, technology, cacheType;

    
    
    
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
     * @return the banks
     */
    public double getBanks() {
        return banks;
    }

    /**
     * @param banks the banks to set
     */
    public void setBanks(double banks) {
        this.banks = banks;
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
     * @return the rWPorts
     */
    public double getrWPorts() {
        return rWPorts;
    }

    /**
     * @param rWPorts the rWPorts to set
     */
    public void setrWPorts(double rWPorts) {
        this.rWPorts = rWPorts;
    }

    /**
     * @return the rPorts
     */
    public double getrPorts() {
        return rPorts;
    }

    /**
     * @param rPorts the rPorts to set
     */
    public void setrPorts(double rPorts) {
        this.rPorts = rPorts;
    }

    /**
     * @return the wPorts
     */
    public double getwPorts() {
        return wPorts;
    }

    /**
     * @param wPorts the wPorts to set
     */
    public void setwPorts(double wPorts) {
        this.wPorts = wPorts;
    }

    /**
     * @return the techSize
     */
    public double getTechSize() {
        return techSize;
    }

    /**
     * @param techSize the techSize to set
     */
    public void setTechSize(double techSize) {
        this.techSize = techSize;
    }

    /**
     * @return the accessTime
     */
    public double getAccessTime() {
        return accessTime;
    }

    /**
     * @param accessTime the accessTime to set
     */
    public void setAccessTime(double accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * @return the cycleTime
     */
    public double getCycleTime() {
        return cycleTime;
    }

    /**
     * @param cycleTime the cycleTime to set
     */
    public void setCycleTime(double cycleTime) {
        this.cycleTime = cycleTime;
    }

    /**
     * @return the prechargeDelay
     */
    public double getPrechargeDelay() {
        return prechargeDelay;
    }

    /**
     * @param prechargeDelay the prechargeDelay to set
     */
    public void setPrechargeDelay(double prechargeDelay) {
        this.prechargeDelay = prechargeDelay;
    }

    /**
     * @return the activateEnergy
     */
    public double getActivateEnergy() {
        return activateEnergy;
    }

    /**
     * @param activateEnergy the activateEnergy to set
     */
    public void setActivateEnergy(double activateEnergy) {
        this.activateEnergy = activateEnergy;
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
     * @return the prechargeEnergy
     */
    public double getPrechargeEnergy() {
        return prechargeEnergy;
    }

    /**
     * @param prechargeEnergy the prechargeEnergy to set
     */
    public void setPrechargeEnergy(double prechargeEnergy) {
        this.prechargeEnergy = prechargeEnergy;
    }

    /**
     * @return the powerClosedPage
     */
    public double getPowerClosedPage() {
        return powerClosedPage;
    }

    /**
     * @param powerClosedPage the powerClosedPage to set
     */
    public void setPowerClosedPage(double powerClosedPage) {
        this.powerClosedPage = powerClosedPage;
    }

    /**
     * @return the powerOpenPage
     */
    public double getPowerOpenPage() {
        return powerOpenPage;
    }

    /**
     * @param powerOpenPage the powerOpenPage to set
     */
    public void setPowerOpenPage(double powerOpenPage) {
        this.powerOpenPage = powerOpenPage;
    }

    /**
     * @return the powerIO
     */
    public double getPowerIO() {
        return powerIO;
    }

    /**
     * @param powerIO the powerIO to set
     */
    public void setPowerIO(double powerIO) {
        this.powerIO = powerIO;
    }

    /**
     * @return the refreshPower
     */
    public double getRefreshPower() {
        return refreshPower;
    }

    /**
     * @param refreshPower the refreshPower to set
     */
    public void setRefreshPower(double refreshPower) {
        this.refreshPower = refreshPower;
    }

    /**
     * @return the cacheHeight
     */
    public double getCacheHeight() {
        return cacheHeight;
    }

    /**
     * @param cacheHeight the cacheHeight to set
     */
    public void setCacheHeight(double cacheHeight) {
        this.cacheHeight = cacheHeight;
    }

    /**
     * @return the cacheWidth
     */
    public double getCacheWidth() {
        return cacheWidth;
    }

    /**
     * @param cacheWidth the cacheWidth to set
     */
    public void setCacheWidth(double cacheWidth) {
        this.cacheWidth = cacheWidth;
    }

    /**
     * @return the blockSise
     */
    public double getBlockSise() {
        return blockSise;
    }

    /**
     * @param blockSise the blockSise to set
     */
    public void setBlockSise(double blockSise) {
        this.blockSise = blockSise;
    }

    /**
     * @return the readOnlyPorts
     */
    public double getReadOnlyPorts() {
        return readOnlyPorts;
    }

    /**
     * @param readOnlyPorts the readOnlyPorts to set
     */
    public void setReadOnlyPorts(double readOnlyPorts) {
        this.readOnlyPorts = readOnlyPorts;
    }

    /**
     * @return the writeOnlyPorts
     */
    public double getWriteOnlyPorts() {
        return writeOnlyPorts;
    }

    /**
     * @param writeOnlyPorts the writeOnlyPorts to set
     */
    public void setWriteOnlyPorts(double writeOnlyPorts) {
        this.writeOnlyPorts = writeOnlyPorts;
    }

    /**
     * @return the readWritePorts
     */
    public double getReadWritePorts() {
        return readWritePorts;
    }

    /**
     * @param readWritePorts the readWritePorts to set
     */
    public void setReadWritePorts(double readWritePorts) {
        this.readWritePorts = readWritePorts;
    }

    /**
     * @return the singleEndedReadPorts
     */
    public double getSingleEndedReadPorts() {
        return singleEndedReadPorts;
    }

    /**
     * @param singleEndedReadPorts the singleEndedReadPorts to set
     */
    public void setSingleEndedReadPorts(double singleEndedReadPorts) {
        this.singleEndedReadPorts = singleEndedReadPorts;
    }

    /**
     * @return the cacheBanks
     */
    public double getCacheBanks() {
        return cacheBanks;
    }

    /**
     * @param cacheBanks the cacheBanks to set
     */
    public void setCacheBanks(double cacheBanks) {
        this.cacheBanks = cacheBanks;
    }

    /**
     * @return the technology
     */
    public double getTechnology() {
        return technology;
    }

    /**
     * @param technology the technology to set
     */
    public void setTechnology(double technology) {
        this.technology = technology;
    }

    /**
     * @return the cacheType
     */
    public double getCacheType() {
        return cacheType;
    }

    /**
     * @param cacheType the cacheType to set
     */
    public void setCacheType(double cacheType) {
        this.cacheType = cacheType;
    }


   
}
