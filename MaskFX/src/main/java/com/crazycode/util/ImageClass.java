/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crazycode.util;

/**
 *
 * @author Tanieska
 */
public class ImageClass {

    private static final String icSearch = "1497784470_140";
    private static final String icCancel = "1497784463_009";

    public static String icSearch_A() {
        return addAddress(icSearch);
    }

    public static String icCancel_A() {
        return addAddress(icCancel);
    }

    private static String addAddress(String icon) {
        return "/icons/" + icon + ".png";
    }

}
