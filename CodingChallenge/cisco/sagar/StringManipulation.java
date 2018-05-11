package com.help.sagar;

import org.junit.Before;
import org.junit.Test;

import java.util.StringTokenizer;

import static junit.framework.TestCase.assertEquals;

public class StringManipulation {

    public String modifyURL(String url, String token) {
        StringBuilder modifiedString = new StringBuilder("https://ccwdir.cloudapps.cisco.com");

        String[] arr = url.split("\\.com");
        for(int i = 1; i < arr.length; i++) {
            modifiedString.append(arr[i]);
        }
        return modifiedString.toString();
    }

    StringManipulation obj = null;
    @Before
    public void setup() {
        obj = new StringManipulation();
    }
    @Test
    public void testModifyURL() {
        String url = "https://ccwdir-pblu-head2.cloudapps.cisco.com/ccwdir/importNsgPunchOutItems?" +
                "tranId=212273&amp;orderLineObjectId=1700059898&amp;mgUnqId=1807e908-aac6-43ad-b97d-859d5c6f935a";
        String modifiedURL = "https://ccwdir.cloudapps.cisco.com/ccwdir/importNsgPunchOutItems?" +
                "tranId=212273&amp;orderLineObjectId=1700059898&amp;mgUnqId=1807e908-aac6-43ad-b97d-859d5c6f935a";
        String token = ".com";

        assertEquals(modifiedURL, obj.modifyURL(url,token));
    }
}
