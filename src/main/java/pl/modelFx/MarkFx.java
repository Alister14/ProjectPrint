package pl.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MarkFx {

    private StringProperty mark = new SimpleStringProperty();
    private IntegerProperty idMark = new SimpleIntegerProperty();


    public String getMark() {
        return mark.get();
    }

    public StringProperty markProperty() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark.set(mark);
    }

    public int getIdMark() {
        return idMark.get();
    }

    public IntegerProperty idMarkProperty() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark.set(idMark);
    }

    @Override
    public String toString() {
        return mark.getValue()+
                " idMark " + idMark.getValue();
    }
}
