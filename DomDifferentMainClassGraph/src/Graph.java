import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List <GraphNode> nodesList = new ArrayList <GraphNode>();
	private List <GraphEdge> edgesList = new ArrayList <GraphEdge>();
	
	//�berladener Konstruktor
	public Graph(List<GraphNode> nodesList, List<GraphEdge> edgesList) {
	     this.nodesList = nodesList;
	     this.edgesList = edgesList;
	}

	public List<GraphNode> getNodesList() {
		return nodesList;
	}

	public List<GraphEdge> getEdgesList() {
		return edgesList;
	}

	@Override
	public String toString(){
		return "node list : \n"+nodesList+"edge list : "+edgesList;
	}
}
