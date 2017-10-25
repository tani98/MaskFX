/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.custom.elements;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import org.controlsfx.control.textfield.CustomTextField;

/**
 *
 * @author Tanieska
 */
public class SearchField extends CustomTextField {

    static FontAwesomeIconView icon;
    
    private static final String iconSearch = "-glyph-name: SEARCH;";
    private static final String iconCancel = "-glyph-name: REMOVE;";

    public SearchField() {
        super();
        icon = new FontAwesomeIconView();
        setIcon(this, iconSearch);
        setChange(this);
        setDeleteOption(this);
    }

    private static void setIcon(CustomTextField field, String iconString) {
        final Label lbl = new Label();        
        icon.setStyle(iconString);
        lbl.setGraphic(icon);
        field.setLeft(lbl);

    }

    private static void setChange(CustomTextField field) {
        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (field.getText().isEmpty()) {
                setIcon(field, iconSearch);
                icon.setCursor(Cursor.DEFAULT);
            } else {
                setIcon(field, iconCancel);
                icon.setCursor(Cursor.HAND);
            }
        });
    }
    
    private void setDeleteOption(CustomTextField field){   
        icon.setOnMouseClicked((event) -> {
            field.setText("");
        });       
    }    
}
