//class GraphNode represents object Node

public class GraphNode{
	private String nodeId;
	private int nodeLabel;
	
//Konstruktor
public GraphNode() {

}

//�berladener Konstruktor
public GraphNode(String nodeId, int nodeLabel) {
	this.nodeId = nodeId;
	this.nodeLabel = nodeLabel;
}
public GraphNode(String nodeId){
	this.nodeId = nodeId;
}
	//get methods
	public String getNode_id() {
		return nodeId;
	}
	
	//set methods
	public void setNode_id(String nodeId) {
		this.nodeId = nodeId;
	}
	
	//get methods
	public int getLabel() {
		return nodeLabel;
	}
	
	//set methods
	public void setLabel(int nodeLabel) {
		this.nodeLabel = nodeLabel;
	}
	
	
@Override
	public String toString() {
		return "id : "+this.nodeId+" label : "+this.nodeLabel;
	}
}
