package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException,IOException {
        JAXBContext context =  JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj,writer);
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(writer.toString()));
        String s;
        while ((s=reader.readLine())!=null){
            if (s.contains("<"+tagName)){
                builder.append("<!--"+comment+"-->"+"\n");
            }
            builder.append(s);
            builder.append("\n");

        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
        try {
            System.out.println(toXmlWithComment(cat,"second","it is a comment"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

@XmlType(name = "first") @XmlRootElement
class Cat {
    @XmlElement(name = "second")public String name;
    @XmlElement(name = "second") public int age;
    @XmlElement(name = "second")public int weight; Cat() { } }
