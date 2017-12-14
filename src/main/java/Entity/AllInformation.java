package Entity;

/**
 * Created by Андрей on 13.12.2017.
 */
public class AllInformation {

    private LO lo;
    private String dataInNeededFormatInString;
    private String name;
    private boolean copyMark;
    private String folderOYY;

    public AllInformation() {
    }
    public AllInformation(LO lo, String dataInNeededFormatInString, String name, boolean copyMark) {
        this.lo = lo;
        this.dataInNeededFormatInString = dataInNeededFormatInString;
        this.folderOYY = dataInNeededFormatInString.substring(2,4);
        this.name = name;
        this.copyMark = copyMark;
    }

    public LO getLo() {
        return lo;
    }
    public void setLo(LO lo) {
        this.lo = lo;
    }

    public String getDataInNeededFormatInString() {
        return dataInNeededFormatInString;
    }
    public void setDataInNeededFormatInString(String dataInNeededFormatInString) {
        this.dataInNeededFormatInString = dataInNeededFormatInString;
    }

    public boolean isCopyMark() {
        return copyMark;
    }
    public void setCopyMark(boolean copyMark) {
        this.copyMark = copyMark;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFolderOYY() {
        return folderOYY;
    }
    public void setFolderOYY(String folderOYY) {
        this.folderOYY = folderOYY;
    }

    @Override
    public String toString() {
        return "AllInformation{" +
                "lo=" + lo +
                ", dataInNeededFormatInString='" + dataInNeededFormatInString + '\'' +
                ", name='" + name + '\'' +
                ", copyMark=" + copyMark +
                '}';
    }
}
