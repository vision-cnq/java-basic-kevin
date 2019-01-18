package com.kevin.xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author kevin
 * @version 1.0
 * @description     解析xml文件
 * @createDate 2018/12/24
 */
public class XmlDemo1 {

    public static void main(String[] args) throws DocumentException {

        //String file = Demo1.class.getClassLoader().getResource("scores2.xml").getFile();
        String file = "src/main/resources/xml/scores2.xml";

        // 创建SAXReader对象，用于读取xml文件
        SAXReader reader = new SAXReader();
        // 读取xml文件，得到Document对象
        Document doc = reader.read(new File(file));
        // 获取根元素
        Element root = doc.getRootElement();
        // 获取跟元素下的所有子元素
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()){
            // 取出元素
            Element e = (Element) iterator.next();
            System.out.println(e.getName());
            // 获取id属性
            Attribute id = e.attribute("id");
            System.out.println(id.getName() + "=" + id.getValue());
            // 获取student的子元素
            Element name = e.element("name");
            Element course = e.element("course");
            Element score = e.element("score");
            System.out.println(name.getName() + "=" + name.getStringValue());
            System.out.println(course.getName() + "=" + course.getText());
            System.out.println(score.getName() + "=" + score.getText());
            System.out.println("------");
        }

    }
}
