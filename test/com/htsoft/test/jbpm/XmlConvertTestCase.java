package com.htsoft.test.jbpm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.htsoft.core.util.XmlUtil;

public class XmlConvertTestCase {

	public static void main(String[]args){
		Document jpdlDoc = DocumentHelper.createDocument();
	    Element processEl = jpdlDoc.addElement( "process" );
		
	    processEl.addAttribute("name", "testProcess");
	    
		Set transitionSet=new HashSet();
		
		Map<String,Element> nodeMap=parseDrawXml(transitionSet);
		
		Map<String,Element> newNodeMap=new LinkedHashMap();
		Iterator<String> ids=nodeMap.keySet().iterator();
		
		while(ids.hasNext()){
			String id=ids.next();
			Element pNode=nodeMap.get(id);
			
			Element curNewNode=processEl.addElement(pNode.getQualifiedName());
			
			String x=pNode.attributeValue("x");
			String y=pNode.attributeValue("y");
			
			String width=pNode.attributeValue("w");
			Integer intWidth=new Integer(width)+10;
			
			String height=pNode.attributeValue("h");
			Integer intHeight=new Integer(height)+10;
			
			curNewNode.addAttribute("name", pNode.attributeValue("name"));
			curNewNode.addAttribute("g", x + "," + y + "," + intWidth + "," + intHeight );
			
			newNodeMap.put(id, curNewNode);
		}

		Iterator<Element> tranIt=transitionSet.iterator();
		
		while(tranIt.hasNext()){
			Element tranEl=tranIt.next();
			
			String g=tranEl.attributeValue("g");
			System.out.println("g:"+ g);
			String name=tranEl.attributeValue("name");
			
			//取到Start节点
			Element startNode=(Element)tranEl.selectSingleNode("./startConnector/rConnector/Owner/*");
			Element endNode=(Element)tranEl.selectSingleNode("./endConnector/rConnector/Owner/*");
			
			if(startNode!=null && endNode!=null){
				String startRef=startNode.attributeValue("ref");
				String endRef=endNode.attributeValue("ref");
				
				Element newStartNode;
				Element endStartNode;
				if(startRef!=null && endRef!=null){
					 newStartNode=newNodeMap.get(startRef);
					 endStartNode=newNodeMap.get(endRef);
				}else{
					String startId=startNode.attributeValue("id");
					String endId=startNode.attributeValue("id");
					newStartNode=newNodeMap.get(startId);
					endStartNode=newNodeMap.get(endId);
				}
				Element transitionEl=newStartNode.addElement("transition");
				transitionEl.addAttribute("name", name);
				transitionEl.addAttribute("to", endStartNode.attributeValue("name"));
				transitionEl.addAttribute("g",g);
			}
			//System.out.println("startNodeXML:" + startNode.asXML());
		}
		//System.out.println("last xml:" + processEl.asXML());
	}
	
	public static Map<String, Element> parseDrawXml(Set transitionSet){
		
		Map<String, Element> map=new LinkedHashMap<String, Element>();

		String path="L:/devtools/workspace/joffice/test/com/htsoft/test/jbpm/NewFile1.xml";
		
		Document drawDoc=XmlUtil.load(path);
		Element rootEl=drawDoc.getRootElement();
		List<Element> figures=rootEl.selectNodes("/drawing/figures/*");
		
		for(Element el:figures){
			String id=el.attributeValue("id");
			String ref=el.attributeValue("ref");
			if("transition".equals(el.getQualifiedName())){//transition
				transitionSet.add(el);
			}else{//node
				if(id!=null){
					map.put(id,el);
				}else if(ref!=null){
					Node figureNode=rootEl.selectSingleNode("/drawing/figures//*[@id='" + ref + "']");
					map.put(ref, (Element)figureNode);
				}
			}
		}
		return map;
		
	}
	
}
