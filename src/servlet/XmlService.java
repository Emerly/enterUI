package servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;






public class XmlService {
	   
	    private static String filepath ="D:/mywork/enterUI/WebContent/WEB-INF/user.xml";
	    public static void writeFile(Document document){
	    	//DocumentFactory factory = new DocumentFactory(); 
	        //Document document = factory.createDocument();
	    	OutputFormat format = new OutputFormat("\t",true,"UTF-8");
			XMLWriter xmlWriter;
	    	try {
				xmlWriter = new XMLWriter(new FileWriter(new File(filepath)),format);
				xmlWriter.write(document);
				xmlWriter.flush();
				xmlWriter.close();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }
	    public static Element getRoot() {
	    	SAXReader reader = new SAXReader();
			Document doc = null;
			try {
				doc = reader.read(new File(filepath));
			} catch (DocumentException e) {
				e.printStackTrace();
				
			}
			return doc.getRootElement();
		}
	
		public static void adduser(String username,String password,String id){
		    
			//SAXReader reader = new SAXReader();  
	        // 通过read方法读取一个文件 转换成Document对象  
			DocumentFactory factory = new DocumentFactory(); 
	        Document document = factory.createDocument();
	        //Document document = null;
			//try {
			//	document = reader.read(new File("D:/mywork/enterUI/WebContent/WEB-INF"));
			//} catch (DocumentException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}  
	        //获取根节点元素对象  
	        
	        //遍历所有的元素节点  
			Element root = document.addElement("root");
			Element user =root.addElement("user");
			user.addAttribute("id", id);
			Element nameElement = user.addElement("username");
			Element passElement = user.addElement("password");
			Element pidElement = user.addElement("pid");
			nameElement.setText(username);
			passElement.setText(password);
			pidElement.setText("00");
			writeFile(document);
			
		
	}
    public static void addUser(String username,String password,String id){
		    
//			SAXReader reader = new SAXReader();  
//	        // 通过read方法读取一个文件 转换成Document对象  
//			//DocumentFactory factory = new DocumentFactory(); 
//	        //Document document = factory.createDocument();
//	        Document document = null;
//			try {
//			document = reader.read(new File("D:/mywork/enterUI/WebContent/WEB-INF/user.xml"));
//			} catch (DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//	        //获取根节点元素对象  
//	        
//	        //遍历所有的元素节点  
//			Element root = document.getRootElement();
    	    Element root = getRoot();
    	    Document document = root.getDocument();
			Element user =root.addElement("user");
			user.addAttribute("id", id);
			Element nameElement = user.addElement("username");
			Element passElement = user.addElement("password");
			Element pidElement = user.addElement("pid");
			nameElement.setText(username);
			passElement.setText(password);
			pidElement.setText("00");
			writeFile(document);
	}
     public static Boolean isUser(String pass){
    	Boolean flag = false;
      	Element root = getRoot();
      	Iterator<Element> userElements = root.elementIterator("user");
		while (userElements.hasNext()) {
			Element userElement = userElements.next();
			String password = userElement.elementText("password");
			if (password.equals(pass)) {
			    flag = true;
				break;
			}
		}
		return flag;
     }
}
