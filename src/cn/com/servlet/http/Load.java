package cn.com.servlet.http;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName parsingXML
 * @Description TODO
 * @Author lishan
 * @DATE 2021-07-29 17:29
 * @Version 1.0
 */
 abstract class Load {
    private Load(){

    }

    public static Map<String,String> loadConfig() throws Throwable {
        Map<String,String> map = new HashMap<String, String>();
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(new FileReader(new File("WEB-INF/web.xml")));
        Element root = doc.getRootElement();
        List<Element> servlets = root.getChildren("servlet",root.getNamespace());
        List<Element> ServletMappings = root.getChildren("servlet-mapping",root.getNamespace());
        for(Element sms : ServletMappings){
            String servletName = sms.getChildText("servlet-name",root.getNamespace());
            String url = sms.getChildText("url-pattern",root.getNamespace());
            for(Element sn : servlets){
                String sName = sn.getChildText("servlet-name",root.getNamespace());
                if(servletName.equals(sName)){
                    String sClass = sn.getChildText("servlet-class",root.getNamespace());
                    map.put(url,sClass);
                    break;
                }
            }
        }
        return map;
    }
    public static void main(String[] args) throws Throwable {
        Map<String,String> map = Load.loadConfig();
        for (String m : map.keySet()) {
            System.out.println(m+"   "+map.get(m));
        }
    }
}
