package com.kevin.xml.jdbc_xml.num;

import com.kevin.util.DBUtil;
import com.kevin.xml.jdbc_xml.entity.Num;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     解析xml的数据存到数据库
 * @createDate 2018/12/25
 */
public class TestNum2 {

    public static void main(String[] args) {

        // 将xml中的信息还原到sh数据库中
        // 解析xml，生成list集合
        List<Num> list = parseXml();
        // list中的数据写入数据库中
        saveNumFromList(list);

    }

    /**
     * 解析xml，生成list集合
     * @return
     */
    private static List<Num> parseXml(){
        String file = "src/main/resources/xml/nums.xml";

        List<Num> list = new ArrayList();
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(new File(file));
            Element nums = doc.getRootElement();
            Iterator<Element> it = nums.elementIterator();
            while (it.hasNext()) {
                Element e = it.next();
                Num num = new Num();
                num.setId(e.attributeValue("id"));
                num.setType(e.attributeValue("type"));
                num.setNum(Integer.parseInt(e.getText()));
                list.add(num);
            }
            System.out.println(list.size());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将list中的数据写入数据库
     * @param list
     */
    private static void saveNumFromList(List<Num> list) {

        String sql = "insert into t_num values (?, ?, ?)";
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
        try {
            conn.setAutoCommit(false);
            for (Num num:list) {
                DBUtil.bindParam(pstmt,
                        num.getId(),
                        num.getNum(),
                        num.getType() );
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("批量插入数据完成");
            conn.commit();
        } catch (SQLException e) {
            try {
                // 如果出错，事务回滚
                conn.rollback();
                System.out.println("插入数据有误，回滚");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(null, pstmt, conn);
        }
    }


}
