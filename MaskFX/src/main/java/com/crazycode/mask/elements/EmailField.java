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
public class EmailField extends TextField {

    private boolean isAt; //Si contiene arroba
    private final ArrayList<String> patterns;

    public EmailField() {
        super();
        patterns = new ArrayList<>();
        isAt = false;
        setMask();
    }

    private void setMask() {
        patterns.add("[0-z.]");
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.isEmpty()) {
            super.replaceText(start, end, text);
        } else {
            if (text.matches(patterns.get(0)) && !text.equals("@")) {
                super.replaceText(start, end, text);
            } else if (!isAt && (start>0) && text.equals("@")) {
                super.replaceText(start, end, text);
                isAt = true;
            }
        }
    }

    @Override
    public void deleteText(int start, int end) {
        String text = getText();
        if ((text.substring(start, end)).equals("@")) {
            isAt = false;
        }
        super.deleteText(start, end); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
