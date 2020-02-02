import java.util.Arrays;
import java.util.List;

public class App{

	public static void main(String[] args) {
		
		new App(args);
		
	}
	
	private App(String[] param){
		List<String> paramList = Arrays.asList(param);
		
		if(paramList.size() > 0 ){
			final Graph graph = loadGraph(paramList);
			if(paramList.contains("-s")){
				calculateSp(graph, paramList);
			}else if (paramList.contains("-b")){
				calculateBc(graph,paramList);
			}else if(paramList.contains("-a")){
				calculatePr(graph);
			}
			
		}
	}

	private void calculatePr(Graph graph) {
		System.out.println("this is calculates properties");
		
	}

	private void calculateBc(Graph graph, List<String> paramList) {
		String nodeA = paramList.get(2);
		System.out.println("this is using : "+paramList.get(1)+" calculate Betweeness of:"+nodeA);
		
	}

	private void calculateSp(Graph graph, List<String> paramList) {
		String start = paramList.get(2);
		String end = paramList.get(3);
		System.out.println("this is using : "+paramList.get(1)+" start : "+start+" end : "+end);
	}

	private Graph loadGraph(List<String> paramList) {
		final String filePath = paramList.get(0); //take the index 0 array which user input to the system 
		final GraphXmlReader reader = new GraphXmlReader();
		return reader.loadGraph(filePath);
	}
	
}
/*Graph graph;
		Handler handler1 = new Handler();
		
		handler1.loadtest();
		handler1.printGraph();*/