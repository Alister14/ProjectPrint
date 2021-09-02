package pl.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Data.DatabaseHandling;
import pl.struckture.Client;
import pl.struckture.Mark;

import java.util.ArrayList;

public class MarkModel {

    private ObservableList<MarkFx> markList = FXCollections.observableArrayList();
    private ObjectProperty<MarkFx> markFxObjectProperty = new SimpleObjectProperty<>();

    public void init(){

        ArrayList<Mark> marks = DatabaseHandling.getMarks();
        this.markList.clear();
        marks.forEach(client -> {
            MarkFx markFx= new MarkFx();
            markFx.setIdMark(client.getIdMark());
            markFx.setMark(client.getMark());
            this.markList.add(markFx);
        });
    }

    public ObservableList<MarkFx> getMarkList() {
        return markList;
    }

    public void setMarkList(ObservableList<MarkFx> markList) {
        this.markList = markList;
    }

    public MarkFx getMarkFxObjectProperty() {
        return markFxObjectProperty.get();
    }

    public ObjectProperty<MarkFx> markFxObjectPropertyProperty() {
        return markFxObjectProperty;
    }

    public void setMarkFxObjectProperty(MarkFx markFxObjectProperty) {
        this.markFxObjectProperty.set(markFxObjectProperty);
    }
}
