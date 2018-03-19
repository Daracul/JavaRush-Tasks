package com.javarush.task.task21.Expirience;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;

/**
 * Created by amalakhov on 16.05.2017.
 */
public class ChoiceFormatTest1 {
    public static void main(String[] args) {
        double[] filelimits = {0,1,2};
        String[] filepart = {"are no files","is one file","are {2} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, NumberFormat.getInstance()};
        MessageFormat pattform = new MessageFormat("There {1} on {0}");
        pattform.setFormats(testFormats);
        Object[] testArgs = {null, "ADisk", null};
        for (int i = 0; i < 4; ++i) {
            testArgs[0]=new Integer(i);
            testArgs[2]=testArgs[0];
            System.out.println(pattform.format(testArgs));
        }
    }
}
