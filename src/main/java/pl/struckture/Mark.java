package pl.struckture;

public class Mark {
    protected Integer idMark;
    protected String mark;

    public Mark(Integer idMark, String mark) {
        this.idMark = idMark;
        this.mark = mark;
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
