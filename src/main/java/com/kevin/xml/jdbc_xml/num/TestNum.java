package com.kevin.xml.jdbc_xml.num;

import com.kevin.util.DBUtil;
import com.kevin.xml.jdbc_xml.entity.Num;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     读取数据库的数据插入到xml
 * @createDate 2018/12/25
 */
public class TestNum {

    public static void main(String[] args) {

        // 当前系统时间
        long start = System.currentTimeMillis();
        // 将数据备份成xml文件
        // 查询所有数据为一个list集合，泛型Num
        List<Num> list = selAll();
        // 将list中的数据输出到一个xml文件中
        writeNum2Xml(list);
        long stop = System.currentTimeMillis();
        System.out.println("耗时:" + (stop - start));

    }

    /**
     * 查询所有数据
     * @return
     */
    private static List<Num> selAll() {

        List<Num> list = new ArrayList<Num>();
        String sql = "select * from t_num order by num";
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Num num = new Num();
                num.setId(rs.getString("id"));
                num.setNum(rs.getInt("num"));
                num.setType(rs.getString("type"));
                list.add(num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, pstmt, conn);
        }
        return list;
    }

    /**
     * 将list中的数据写入xml
     * @param list
     */
    private static void writeNum2Xml(List<Num> list) {

        String file = "src/main/resources/xml/nums.xml";
        Document doc = DocumentHelper.createDocument();
        Element nums = doc.addElement("nums");
        // 循环为根元素添加子元素
        for (Num num:list) {
            nums.addElement("num")
                    .addAttribute("id",num.getType())
                    .addAttribute("type",num.getType())
                    .addText(num.getNum() + "");
        }
        // 输出到文件
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(file),format);
            writer.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
