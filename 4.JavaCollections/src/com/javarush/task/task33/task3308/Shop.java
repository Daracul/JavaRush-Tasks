package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AMalakhov on 09.08.2017.
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
     @XmlElement public Goods goods;
     @XmlElement public int count ;
     @XmlElement public double profit ;
    @XmlElement(name="secretData")	public String[] secretData;



    @XmlType(name = "goods")
    static class Goods{
        @XmlElement(name="names")List<String> names = new ArrayList<>();

    }
}

