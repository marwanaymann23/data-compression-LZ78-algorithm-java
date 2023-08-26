public class Tag {
    protected int index;
    protected int ascii;



    public Tag(int index, int ascii) {
        this.index = index;
        this.ascii = ascii;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public int getAscii() {
        return ascii;
    }
    public void setAscii(int ascii) {
        this.ascii = ascii;
    }
}