package Entity;

/**
 * Created by Андрей on 15.09.2016.
 */
public class LO implements Comparable{
    private int numberLo;
    private int codeLo;

    public int getNumberLo() {
        return numberLo;
    }
    public void setNumberLo(int numberLo) {
        this.numberLo = numberLo;
    }
    public int getCodeLo() {
        return codeLo;
    }
    public void setCodeLo(int codeLo) {
        this.codeLo = codeLo;
    }

    public LO() {
    }
    public LO(int numberLo, int codeLo) {
        this.numberLo = numberLo;
        this.codeLo = codeLo;
    }

    @Override
    public int compareTo(Object o) {
        LO tmp = (LO) o;
        if(this.codeLo < tmp.getCodeLo()) return -1;
        if(this.codeLo > tmp.getCodeLo()) return 1;
        if(this.codeLo == tmp.getCodeLo()) return 0;
        return 0;
    }
}
