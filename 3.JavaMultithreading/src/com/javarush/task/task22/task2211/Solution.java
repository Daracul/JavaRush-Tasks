package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        Charset windows1251 = Charset.forName("windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        FileInputStream fis = new FileInputStream(args[0]);

        byte[] buffer =new byte[fis.available()];
        fis.read(buffer);
        String newTestString = new String(buffer,utf8);
        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(new String(buffer,utf8).getBytes(windows1251));
        fos.close();
        fis.close();
    }
}
