/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.mask.elements;

import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 *
 * @author Tanieska
 */
public class DoubleField extends TextField {

    private boolean isDecimal;
    private final ArrayList<String> patterns;

    public DoubleField() {
        super();
        patterns = new ArrayList<>();
        setMask();
    }

    private void setMask() {
        patterns.add("[0-9]");
        patterns.add(".");
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.isEmpty()) {
            super.replaceText(start, end, text);
        } else {
            if (text.matches(patterns.get(0))) {
                super.replaceText(start, end, text);
            } else if (!isDecimal && text.matches(patterns.get(1))) {
                super.replaceText(start, end, text);
                isDecimal = true;
            }
        }
    }

    @Override
    public void deleteText(int start, int end) {
        String text = getText();
        if ((text.substring(start, end)).equals(".")) {
            isDecimal = false;
        }
        super.deleteText(start, end); //To change body of generated methods, choose Tools | Templates.
    }
}
