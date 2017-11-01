/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.custom.elements;

import com.crazycode.util.ImageClass;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.CustomTextField;

/**
 *
 * @author Tanieska
 */
public class SearchField extends CustomTextField {

    private final Label lbl;
    private boolean isSearch;

    public SearchField() {
        super();
        lbl = new Label();
        setIcon(ImageClass.icSearch_A());
        setChange();
        setDeleteOption(this);
    }

    private void setIcon(String iconString) {
        Image img = new Image(getClass().getResource(iconString).toExternalForm());
        ImageView imgV = new ImageView(img);
        lbl.setGraphic(imgV);
        this.setLeft(lbl);

    }

    private void setChange() {
        this.setOnKeyTyped((event) -> {
            this.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                if (newValue.isEmpty()) {
                    isSearch = false;
                    setIcon(ImageClass.icSearch_A());
                    lbl.setCursor(Cursor.DEFAULT);
                } else {
                    isSearch = true;
                    setIcon(ImageClass.icCancel_A());
                    lbl.setCursor(Cursor.HAND);
                }
            });
        });
    }

    private void setDeleteOption(CustomTextField field) {
        lbl.setOnMouseClicked((event) -> {
            if (isSearch) {
                field.setText("");
            }
        });
    }
}
