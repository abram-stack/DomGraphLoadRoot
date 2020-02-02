import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Handler{
	
		private Graph graph;
		
		public Graph loadtest(){
		try {
			File xmlDoc = new File("./src/LargeGraph.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			//normalize
			doc.getDocumentElement().normalize();
			//now XML is loaded as a Document into memory
			
			//initialize GraphNode and GraphEdge List 
			List<GraphNode> nList = new ArrayList<GraphNode>();
			List<GraphEdge> edgeList = new ArrayList<GraphEdge>();
			
			//CONVERT XML INTO ARRAYLIST 
			NodeList noList = doc.getElementsByTagName("node");
			NodeList edList  = doc.getElementsByTagName("edge");
			
			//NODE ELEMENT
			for(int i = 0; i <noList.getLength();i++){
				Node nNode = noList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){				
					GraphNode nodes = new GraphNode();
					Element eElement = (Element) nNode;
						nodes.setNode_id(eElement.getAttribute("id"));
						nodes.setLabel(Integer.parseInt(eElement.getElementsByTagName("data").item(0).getTextContent()));						
						nList.add(nodes);
				}
			}
			
		//EDGE ELEMENTS
			for(int i = 0; i < edList.getLength();i++){
				Node eNode = edList.item(i);
				if(eNode.getNodeType()==Node.ELEMENT_NODE){							
					Element edgeElement = (Element) eNode;
					
					GraphEdge edge;
					GraphNode nodeSource;
					GraphNode nodeTarget;
					//parsing String into Integer using regular expression
					String sourceLabel = edgeElement.getAttribute("source");
					sourceLabel = sourceLabel.replaceAll("\\D", "");
					int sourcLabelInt = Integer.parseInt(sourceLabel);
					nodeSource= new GraphNode(edgeElement.getAttribute("source"),sourcLabelInt);
					
					String targetLabel = edgeElement.getAttribute("target");
					targetLabel = targetLabel.replaceAll("\\D", "");
					int targetLabelInt = Integer.parseInt(targetLabel);
					nodeTarget= new GraphNode(edgeElement.getAttribute("target"),targetLabelInt);
						
					String edgeId = edgeElement.getElementsByTagName("data").item(0).getTextContent();
					int edgeWeight = Integer.parseInt(edgeElement.getElementsByTagName("data").item(1).getTextContent());
					
					edge = new GraphEdge(edgeId,nodeSource, nodeTarget, edgeWeight);
					edgeList.add(edge);
				}
			}
			
			checkIfEmpty(nList, edgeList);
			//CREATE object graph and return graph
			graph = new Graph(nList, edgeList);
			
		} 
		catch (SAXException | ParserConfigurationException | IOException e) {
			System.err.println("IO exception is caught. Cannot find the File");
			e.printStackTrace();
		}
		return graph;
	}
		
		
		public void checkIfEmpty(List<GraphNode> checklist, List<GraphEdge> checklist2 ){
			if(checklist.isEmpty() && checklist2.isEmpty())
			{
				System.out.println("node list and edge list cannot be initialize");
			}else if(checklist.isEmpty())
				System.out.println("node list cannot be initialize");
			else if(checklist2.isEmpty()){
				System.out.println("edge List cannot be initialize");
			}
			else{
				System.out.println("Both lists have been initialized");
			}
		}
		public void printGraph(){
			System.out.println(graph.toString());
		}
		}