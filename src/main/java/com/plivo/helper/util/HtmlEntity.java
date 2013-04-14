package com.plivo.helper.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class HtmlEntity {
    public static String convert(String inputText) {
        StringBuilder buf = new StringBuilder(inputText.length());
        CharsetEncoder encoder = Charset.forName("us-ascii").newEncoder();
        for (int idx = 0; idx < inputText.length(); ++idx) {
            char ch = inputText.charAt(idx);
            if (encoder.canEncode(ch))
                buf.append(ch);
            else {
                buf.append("&#");
                buf.append((int) ch);
                buf.append(';');
            }
        }
        String result = buf.toString();
        return result;
    }
}
