package com.kevin.xml.jdbc_xml;

import com.kevin.util.DateUtils;
import com.kevin.xml.jdbc_xml.entity.EfeeFlightPlan;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @title
 * @description     解析xml的数据并用使用反射将数据保存到实体类中
 * @author caonanqing
 * @createDate 2019/1/10
 * @version 1.0
 */
public class EfeeFlightXml {

    public static Logger LOGGER = Logger.getLogger(EfeeFlightXml.class);
    // 时间格式
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    // 文件路径，文件类型不一定需要xml，可以是txt等。里面格式正确就行
    public static String fileName = "src/main/resources/xml/efee.txt";
    // 读取XML文件
    public static File file = new File(fileName);

    public static void main(String[] args) {
        try {
            EfeeFlightPlan efeeFlightPlan = new EfeeFlightPlan();
            // 将解析的数据暂存到map中
            Map<String,String> map = new HashMap<String,String>();
            // 创建SAXReader对象，用于读取xml文件
            SAXReader reader = new SAXReader();
            // 读取XML文件，得到Document对象
            Document xml = reader.read(file);
            // 获取根元素
            Element root = xml.getRootElement();
            // 获取根节点下的第一层path元素
            Element path = root.element("path");
            List<Element> elements = path.elements();
            for (Element element:elements) {
                // 获取第二层path元素
                if(element.getName().contains("path")){
                    List<Element> eles = element.elements();
                    for (Element ele:eles) {
                        // 获取第三层path元素
                        if(ele.getName().contains("path")){
                            List<Element> els = ele.elements();
                            for (Element el:els) {
                                // 第三层field
                                Attribute name = el.attribute("name");
                                String eName = (ele.attribute("name").getValue() + "_" + name.getValue()).replace("_", "").toUpperCase();
                                String eValue = el.getText().trim();
                                map.put(eName,eValue);
                            }
                        }else {
                            // 第二层field
                            Attribute name = ele.attribute("name");
                            String eName = (element.attribute("name").getValue() + "_" + name.getValue()).replace("_", "").toUpperCase();
                            String eValue = ele.getText().trim();
                            map.put(eName,eValue);
                        }
                    }
                }else {
                    // 第一层field
                    String eName = element.attribute("name").getValue().replace("_","").toUpperCase();
                    String eValue = element.getText().trim();
                    map.put(eName,eValue);
                }
            }

            Class planClass = efeeFlightPlan.getClass();
            Field[] fields = planClass.getDeclaredFields();
            for (Field field : fields) {
                // 获取属性名称
                String fieldName = field.getName();
                // 将字段大写化
                String fieldCase = fieldName.toUpperCase();
                // 遍历map
                for (Map.Entry<String,String> entry : map.entrySet()) {
                    // 判断map中的key是否与属性名对应
                    if(entry.getKey().contains(fieldCase)) {
                        // 打破封装
                        field.setAccessible(true);
                        if(fieldName.equals("ata") && !entry.getKey().equals("ATADATEINSECONDS") ){
                            continue;
                        }else if(fieldName.equals("time") && !entry.getKey().equals("TIMEDATEINSECONDS")){
                            continue;
                        }else if(fieldName.equals("fix") && !entry.getKey().equals("CURRENTFIX")){
                            continue;
                        }else if(fieldName.equals("dof") && !entry.getKey().equals("HANDOFFINFONEXTSECTOR")){
                            continue;
                        }else if(fieldName.equals("etd") && !entry.getKey().equals("ETDBDATEINSECONDS")){
                            continue;
                        }

                        if(entry.getKey().contains("DATEINSECONDS") || entry.getKey().contains("UNIVERSALSEC")) {
                            field.set(efeeFlightPlan, DateUtils.valueToInt(entry.getKey(),entry.getValue()));
                        }else if(fieldName.equals("cfl") || fieldName.equals("level") || fieldName.equals("pssrcode")
                                || fieldName.equals("uid") || fieldName.equals("creationtimetimebaseid") || fieldName.equals("creationtimeuniversalusec")
                                || fieldName.equals("creationtimeuniversalsec") || fieldName.equals("modificationtimeuniversalsec")
                                || fieldName.equals("modificationtimetimebaseid") || fieldName.equals("modificationtimeuniversalusec")){
                            field.set(efeeFlightPlan, DateUtils.valueToInt(entry.getKey(),entry.getValue()));
                        }else {
                            field.set(efeeFlightPlan,entry.getValue());
                        }
                        //System.out.println(entry.getKey()+"-----"+fieldName.toUpperCase());
                    }
                }
            }
            System.out.println(efeeFlightPlan);

        } catch (DocumentException e) {
            LOGGER.warn("获得XML文件Document对象异常: " + e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOGGER.warn("通过反射实例化对象异常: " + e);
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }

    }

}
