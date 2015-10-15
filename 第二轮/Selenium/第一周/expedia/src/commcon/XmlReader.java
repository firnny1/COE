package commcon;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader { 
	static String xml_url="D:/jichen/expedia/src/";
	
   /**
    * 
    * @param name
    * @param xmlname
    * @return
    */
   public List XmlReaderList(String name,String xmlname){    		   
		   
			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 
		        factory.setIgnoringElementContentWhitespace(true);
		        
		        factory.setNamespaceAware(false);
		        
		        factory.setValidating(false);
		       		       	      
		        List<String> xpath = new ArrayList<String>();
	        try {
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            
	            File xmlFile = new File(xml_url+xmlname);
	           
	            Document doc = builder.parse(xmlFile);
	                
	            Element root = doc.getDocumentElement();
	                                  
	          NodeList nl = root.getChildNodes(); 
	                  
	          for(int i=0;i<nl.getLength();i++){
	        	  
	        	  Node n=nl.item(i);        	
	        	  
	        	  if(n.getNodeType()==Node.ELEMENT_NODE){	        		  
	        		  
	        		  if(n.getNodeName()==name){	        			  
	        		 
	        			  for(Node node=n.getFirstChild();node!=null;node=node.getNextSibling()) { 

	        			  if(node.getNodeType()==Node.ELEMENT_NODE){
	        			
	        				  xpath.add(node.getFirstChild().getNodeValue());
	        				  	        				
	        			  }	        			 
	        		  }		 
	        	  }
	           }
	          }
	           
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
	      	        
			return xpath;
	        }
	/**
	 * 
	 * @param name name 是input
	 * @param xmlname
	 * @return
	 */  
   public Map XmlReaderMap(String name,String xmlname){    
	   	       	   
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
	        factory.setIgnoringElementContentWhitespace(true);
	        
	        factory.setNamespaceAware(false);
	        
	        factory.setValidating(false);
	        
	        Map map=new HashMap<String, List>(); 
	        
	        List<String> xpath = new ArrayList<String>();
	        
	        List<String> xpath1 = new ArrayList<String>();
	        
	        
	        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            File xmlFile = new File(xml_url+xmlname);
           
            Document doc = builder.parse(xmlFile);
                    
            Element root = doc.getDocumentElement();
                                  
          NodeList nl = root.getChildNodes(); 
                  
          for(int i=0;i<nl.getLength();i++){
        	  
        	  Node n=nl.item(i);        	
        	  
        	  if(n.getNodeType()==Node.ELEMENT_NODE){	        		  
        		  
        		  if(n.getNodeName()==name){	        			  
        		 
        			  for(Node node=n.getFirstChild();node!=null;node=node.getNextSibling()) { 

        			  if(node.getNodeType()==Node.ELEMENT_NODE){
        				
        				  xpath.add(node.getFirstChild().getNodeValue());
        				  
        			      xpath1.add(node.getNodeName());
        				  
//        			      System.out.println("static String "+node.getNodeName()+"=\""+node.getNodeName()+"\";");  				
        			  }	        			 
        		  }		 
        	  }
           }
          }
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
      	     map.put("1", xpath1);
      	     map.put("2", xpath);
		return map;
        }

   
      ///////////////////////////////////////输入xml节点name返回value	  
	   
public String XmlReaderOne(String name,String xmlname){
		   
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 
	        factory.setIgnoringElementContentWhitespace(true);
	        
	        factory.setNamespaceAware(false);
	        
	        factory.setValidating(false);
	        
	        String BackgroundChar=null;
	        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
//            System.out.println(xml_url+xmlname);
            File xmlFile = new File(xml_url+xmlname);
           
            Document doc = builder.parse(xmlFile);
                    
            Element root = doc.getDocumentElement();
                      
          BackgroundChar = root.getElementsByTagName(name).item(0).getFirstChild().getNodeValue();           
           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
		return BackgroundChar;
	   }
	   
  public void PrintAllName(String xml){
	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
      factory.setIgnoringElementContentWhitespace(true);
      
      factory.setNamespaceAware(false);
      
      factory.setValidating(false);
     		       	      
      List<String> xpath = new ArrayList<String>();
  try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      
      File xmlFile = new File(xml_url+xml);
     
      Document doc = builder.parse(xmlFile);
              
      Element root = doc.getDocumentElement();
                            
    NodeList nl = root.getChildNodes(); 
            
    for(int i=0;i<nl.getLength();i++){
  	  
  	  Node n=nl.item(i);        	
  	  
  	  if(n.getNodeType()==Node.ELEMENT_NODE){	        		  
  		  
  		 System.out.println("static String "+n.getNodeName()+"=\""+n.getNodeName()+"\";");  						  
  		 
  			  for(Node node=n.getFirstChild();node!=null;node=node.getNextSibling()) { 

  			  if(node.getNodeType()==Node.ELEMENT_NODE){
  			
  				  
  				 System.out.println("public static String "+node.getNodeName()+"=\""+node.getNodeName()+"\";");  				      				
  			  }	        			 
  		  }		 
  	 
     }
    }
     
  } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
  }
	        
  }
 public static void main(String[] sss){
		   
	 XmlReader xr=new XmlReader();
	 
	 xr.PrintAllName("XPATH/Benefit/ORSO.xml");

	   }
	}