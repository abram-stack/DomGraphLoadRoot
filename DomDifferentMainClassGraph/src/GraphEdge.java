
public class GraphEdge {
	private GraphNode source;
	private GraphNode target;
	private String edgeId;	//string
	private int weight;
	
	
public GraphEdge() {
		
	}

	

	public GraphEdge(String edgeId, GraphNode source, GraphNode target, int weight) {
		super();
		this.edgeId =edgeId;
		this.source = source;
		this.target = target;
		this.weight = weight;
	}
	public GraphNode getSource() {
		return source;
	}
	public void setSource(GraphNode source) {
		this.source = source;
	}
	public String getEdgeId() {
		return edgeId;
	}
	public void setEdgeId(String edgeId) {
		this.edgeId = edgeId;
	}
	public GraphNode getTarget(){
		return target;
	}
	public void setTarget(GraphNode target) {
		this.target = target;
	}
	public int getEdgeWeight() {
		return weight;
	}
	public void setEdgeWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	/*public String toString() {
		return "edge Id: "+this.edgeId+" target  : "+this.target+"source : "+this.source+" edge weight : "+this.weight;
	}*/
	 public String toString() {
		return "Edge [ID = "+this.edgeId+"source=" + this.source + ", target=" + this.target + "weight = "+this.weight+"]";
	}
	
}
