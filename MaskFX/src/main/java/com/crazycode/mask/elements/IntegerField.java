/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.mask.elements;

import javafx.scene.control.TextField;

/**
 *
 * @author Tanieska
 */
public class IntegerField extends TextField {

    String expression = "\\d"; //entero
    int maxLength;

    public IntegerField() {
        super();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        // If the replaced text would end up being invalid, then simply
        // ignore this call!
        String oldString = getText();
        if (text.isEmpty() || text.matches(expression)) {
            if (getMaxLength() > 0) {
                if (oldString.length() < getMaxLength()) {
                    super.replaceText(start, end, text);
                }
            } else {
                super.replaceText(start, end, text);
            }

        }
    }

    /*
    *El valor de caracter maximo
     */
    public final void setMaxLength(int max) {
        this.maxLength = max;
    }

    public int getMaxLength() {
        return maxLength;
    }

}
