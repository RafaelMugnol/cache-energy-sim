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
public class CacheStatsL2 extends CacheStats{
    private long writeHits;

    /**
     * @param writeHits the writeHits to set
     */
    public void setWriteHits(long writeHits) {
        this.writeHits = writeHits;
    }

    /**
     * @return the writeHits
     */
    public long getWriteHits() {
        return writeHits;
    }
}
