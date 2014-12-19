
package models;

/**
 *
 * @author Rafael
 */
public class CacheStats {
    private long readHits, readMisses;
    private double missRate;

    /**
     * @return the readHits
     */
    public long getReadHits() {
        return readHits;
    }

    /**
     * @param readHits the readHits to set
     */
    public void setReadHits(long readHits) {
        this.readHits = readHits;
    }

    /**
     * @return the readMisses
     */
    public long getReadMisses() {
        return readMisses;
    }

    /**
     * @param readMisses the readMisses to set
     */
    public void setReadMisses(long readMisses) {
        this.readMisses = readMisses;
    }

    /**
     * @return the missRate
     */
    public double getMissRate() {
        return missRate;
    }

    /**
     * @param missRate the missRate to set
     */
    public void setMissRate(double missRate) {
        this.missRate = missRate;
    }
}
