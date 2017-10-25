/**
 * MIT License
 *
 * Copyright (c) 2017 Tanieska
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.crazycode.mask.elements;

import java.util.ArrayList;
import org.controlsfx.control.textfield.CustomTextField;

/**
 *
 * @author Tanieska
 */
public class MaskField extends CustomTextField {

    private String mask;
    private final ArrayList<String> patterns;

    public MaskField() {
        super();
        patterns = new ArrayList<>();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        String tempText = getText() + text;
        if (mask == null || mask.length() == 0) {
            super.replaceText(start, end, text);
        } else if (tempText.matches(this.mask) || tempText.length() == 0) {
            super.replaceText(start, end, text);
        } else if (text.isEmpty()) {
            super.replaceText(start, end, text);
        } else {
            if (tempText.length() < patterns.size()) {
                if (text.matches(patterns.get(start))) {
                    super.replaceText(start, end, text);
                }
            }
        }
    }

    /**
     * @return the Regex Mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public void setMask(String mask) {

        String tempMask = "^";

        for (int i = 0; i < mask.length(); ++i) {

            char temp = mask.charAt(i);
            String regex;
            int counter = 1;
            int step = 0;

            if (i < mask.length() - 1) {
                for (int j = i + 1; j < mask.length(); ++j) {
                    if (temp == mask.charAt(j)) {
                        ++counter;
                        step = j;
                    } else if (mask.charAt(j) == '!') {
                        counter = -1;
                        step = j;
                    } else {
                        break;
                    }
                }
            }
            switch (temp) {
                case '*':
                    regex = ".";             //Accept any character
                    break;
                case 'S':
                    regex = "[^\\s]";        //Any character, except Space
                    break;
                case 'P':
                    regex = "[A-z.]";       //Only Letters and Points
                    break;
                case 'M':
                    regex = "[0-z.]";       //Letters, Numbers and Points
                    break;
                case 'A':
                    regex = "[0-z]";        //Only Alphanumerics
                    break;
                case 'N':
                    regex = "[0-9]";        //Only Numbers
                    break;
                case 'L':
                    regex = "[A-z]";        //Only Letters
                    break;
                case 'U':
                    regex = "[A-Z]";        //Only Uppercase Letters
                    break;
                case 'l':
                    regex = "[a-z]";        //Only Lowercase Letters
                    break;
                case '.':
                    regex = "\\.";
                    break;
                default:
                    regex = Character.toString(temp);
                    break;
            }

            if (counter != 1) {

                this.patterns.add(regex);

                if (counter == -1) {
                    regex += "+";
                    this.patterns.add(regex);
                } else {
                    String tempRegex = regex;
                    for (int k = 1; k < counter; ++k) {
                        regex += tempRegex;
                        this.patterns.add(tempRegex);
                    }
                }

                i = step;

            } else {
                this.patterns.add(regex);
            }
            tempMask += regex;
        }

        this.mask = tempMask + "$";
    }

}
