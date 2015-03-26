
package models;

/**
 *
 * @author Rafael
 */
public class CacheStats {
    private long readHits, readMisses;
    private double missRate;
    private long assoc, size, block_size;
    private String type;
    public CacheParameters cPar; 

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

    /**
     * @return the assoc
     */
    public long getAssoc() {
        return assoc;
    }

    /**
     * @param assoc the assoc to set
     */
    public void setAssoc(long assoc) {
        this.assoc = assoc;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the blok_size
     */
    public long getBlock_size() {
        return block_size;
    }

    /**
     * @param blok_size the blok_size to set
     */
    public void setBlock_size(long blok_size) {
        this.block_size = blok_size;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
