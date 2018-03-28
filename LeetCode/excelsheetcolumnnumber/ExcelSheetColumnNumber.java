package com.leetcode.excelsheetcolumnnumber;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int len = s.length();
        int value = len > 0 ? s.charAt(len-1) - 'A' + 1 : 0;
        for(int i = len-2, j = 1; i >= 0; i--, j++){
            value += Math.pow(26,j) * (s.charAt(i) - 'A' + 1);
        }
        return value;
    }

    @Test
    public void testTitleToNumber(){
        assertEquals(1, new ExcelSheetColumnNumber().titleToNumber("A"));
        assertEquals(2, new ExcelSheetColumnNumber().titleToNumber("B"));
        assertEquals(702, new ExcelSheetColumnNumber().titleToNumber("ZZ"));
        assertEquals(458329, new ExcelSheetColumnNumber().titleToNumber("ZAZA"));
    }
}
