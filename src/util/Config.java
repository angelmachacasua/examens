/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author Asullom
 */
public class Config {

    public static final String DEFAULT_DATE_STRING_FORMAT_PE = "dd/MM/yyyy";
    public static final String DEFAULT_DATE_STRING_FORMAT_PE_L = "dd/MM/yyyy HH:mm:ss.SSS";
    public static final String DEFAULT_DECIMAL_STRING_FORMAT = "#,##0.00";
    public static final String DEFAULT_DECIMAL_FORMAT = "###0.00";
    
    //https://www.baeldung.com/java-check-string-number
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
