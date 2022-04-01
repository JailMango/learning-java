package com.jailmango.exercise.utils.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dom4jUtils
 *
 * @author jailmango
 * @CreateDate 2018/11/12
 * @see com.jailmango.exercise.utils.dom4j
 * @since R9.0<br>
 */
public class Dom4jUtils {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Dom4jUtils.class);

    public static void main(String[] args) {
        Document document = load(
            "/Users/mango/Documents/repository/github/learning-java/learning-java/java-util/src/main/resources/WriteData.xml");

        // ==========
        // 获取根节点
        // Element root = document.getRootElement();
        //
        // Element menuElement = root.addElement("Menu");
        // menuElement.addAttribute("menuName", "menu1");
        // menuElement.setText("text");
        // ==========

        // ==========
        // 遍历
        foreach(document, "/Data/Big/Medium");
        // ==========

        int a = 1;
    }

    /**
     * 读取XML文件
     * 
     * @param fileName String
     * @return Document
     */
    public static Document load(String fileName) {
        Document document = null;

        try {
            SAXReader reader = new SAXReader();
            document = reader.read(new File(fileName));
        }
        catch (DocumentException e) {
            logger.error(e.getLocalizedMessage());
        }

        return document;
    }

    /**
     * 将Document写入XML文件
     * 
     * @param document Document
     * @param fileName String
     * @return boolean
     */
    public static boolean doc2XmlFile(Document document, String fileName) {
        boolean flag = true;
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            writer.write(document);
            writer.close();
        }
        catch (Exception ex) {
            flag = false;
            logger.error(ex.getLocalizedMessage());
        }

        return flag;
    }

    /**
     * 遍历
     * 
     * @param document Document
     * @param xpath String
     */
    public static void foreach(Document document, String xpath) {
        List<Node> list = document.selectNodes(xpath);
        Iterator<Node> iterator = list.iterator();

        int count = 0;

        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            element.addAttribute("count", String.valueOf(++count));

            Attribute attr = element.attribute("count");
            String value = attr.getValue();

            String value1 = element.attributeValue("count");
        }

        doc2XmlFile(document,
            "/Users/mango/Documents/repository/github/learning-java/learning-java/java-util/src/main/resources/WriteData.xml");
    }
}
