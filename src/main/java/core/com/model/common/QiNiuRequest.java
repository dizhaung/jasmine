package core.com.model.common;

/**
 * Created by wangjianan on 16-11-27.
 */
public class QiNiuRequest {
    public long fsize;
    public String key;
    public String hash;
    public int width;
    public int height;

    public long getFsize() {
        return fsize;
    }

    public void setFsize(long fsize) {
        this.fsize = fsize;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "QiNiuRequest{" +
                "fsize=" + fsize +
                ", key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
