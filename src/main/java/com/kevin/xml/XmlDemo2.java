package com.kevin.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     创建xml文件
 * @createDate 2018/12/24
 */
public class XmlDemo2 {

    public static void main(String[] args) throws IOException {

        //String file = Demo2.class.getClassLoader().getResource("book2.xml").getFile();
        String file = "src/main/resources/xml/book2.xml";

        // 通过DocumentHelper生成一个Document对象
        Document doc = DocumentHelper.createDocument();
        // 添加并得到根元素
        Element root = doc.addElement("books");
        // 为根元素添加子元素
        Element book = root.addElement("book");
        // 为book元素添加属性
        book.addAttribute("id","b01");
        // 为book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        // 为子元素添加文本
        name.addText("Thinking in Java");
        author.addText("Mr.Cao");
        price.addText("88");
        // 将doc输出到xml
        //FileWriter fileWriter = new FileWriter(new File(file));
        //doc.write(fileWriter);
        // 关闭资源
        //fileWriter.close();
        // 格式良好的输出
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(new File(file)), format);
        writer.write(doc);
        // 关闭资源
        writer.close();


    }
}
