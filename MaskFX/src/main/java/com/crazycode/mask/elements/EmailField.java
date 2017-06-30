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
public class EmailField extends TextField {

    String first = "[A-Za-z0-9.]";
    String email = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void replaceText(int start, int end, String text) {
        String oldString = getText();

        if (text.isEmpty() || text.matches(first) || forAt(oldString)) {
            super.replaceText(start, end, text);
        }

    }

    private boolean forAt(String text) {
        int count = 0;
        if (!text.isEmpty()) {
            if (text.contains("@")) {
                count++;
            }
            return (count == 0);
        }
        return false;
    }

}
