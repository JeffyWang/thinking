package com.jeffy.reflect.loadbean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Administrator on 14-4-18.
 */
public class Analysis {
    private static XStream xstream = new XStream(new DomDriver());

    public static List<Person> PERSONS = null;

    public Analysis() {
        File file = getFile("com.jeffy.reflect/Beans.xml");
        List<Person> personList = getBean(fileToString(file));
        PERSONS = personList;
    }

    public File getFile(String fileName) {
        URL filePath = Thread.currentThread().getContextClassLoader().getResource(fileName);
        System.out.println(filePath.toString());
        File file = new File(filePath.getFile());

        return file;
    }

    public String fileToString(File file) {
        BufferedReader br;
        StringBuffer fileContent = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            fileContent = new StringBuffer();
            while((line=br.readLine())!=null){
                fileContent.append(line);
            }
        } catch (IOException e) {
            System.out.println("read file error");
        }
        System.out.println("persons : " + fileContent.toString());
        return fileContent.toString();
    }

    public Object xmlToBean(String xml, Class clazz) {
        xstream.processAnnotations(clazz);
        return xstream.fromXML(xml);
    }

    public List<Person> getBean(String bean) {
        Persons persons = (Persons) xmlToBean(bean, Persons.class);
        List<Person> personList = persons.getPersons();
        return personList;
    }

    public static List<Person> getPERSONS() {
        return PERSONS;
    }
}
