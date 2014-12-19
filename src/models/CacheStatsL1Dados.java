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
public class CacheStatsL1Dados extends CacheStats{
    private long writeHits;
    private long writeMisses;

    /**
     * @return the writeHits
     */
    public long getWriteHits() {
        return writeHits;
    }

    /**
     * @param writeHits the writeHits to set
     */
    public void setWriteHits(long writeHits) {
        this.writeHits = writeHits;
    }

    /**
     * @return the writeMisses
     */
    public long getWriteMisses() {
        return writeMisses;
    }

    /**
     * @param writeMisses the writeMisses to set
     */
    public void setWriteMisses(long writeMisses) {
        this.writeMisses = writeMisses;
    }
}
