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
public class DoubleField extends TextField {

    public int maxLength;
    int count = 0;

    public DoubleField() {
        super();
    }

    String expression = "\\d"; //es número

    @Override
    public void replaceText(int start, int end, String text) {
        String oldString = getText();

        if (isOk(text, oldString)) {
            if (getMaxLength() > 0) {
                if (oldString.length() < getMaxLength()) {
                    super.replaceText(start, end, text);
                }
            } else {
                super.replaceText(start, end, text);
            }
            count = 0;
        }
    }

    private boolean forDecimal(String text) {
        int count = 0;
        if (!text.isEmpty()) {
            if (text.contains(".")) {
                count++;
            }
            return (count == 0);
        }
        return false;
    }

    private boolean isOk(String text, String oldString) {
        return text.isEmpty() || text.matches(expression) || forDecimal(oldString);
    }

    /*
    *El valor de caracter maximo
     */
    public final void setMaxLength(int value) {
        this.maxLength = value;
    }

    public int getMaxLength() {
        return maxLength;
    }

}
