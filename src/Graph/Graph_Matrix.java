package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph_Matrix<T> {
	
	private int[][] adjMatrix;
	private int numberOfVertex;
	private List<T> vertex;
	

	public  Graph_Matrix(int numberOfVertex) {
		vertex = new ArrayList<T>();
		adjMatrix = new int[numberOfVertex][numberOfVertex];
		this.numberOfVertex = numberOfVertex;
	}
	
	public void addVertex(T n) {
		if(vertex.size() < numberOfVertex) {
			vertex.add(n);
		}
	}
	
	public void addEdge(T n1, T n2, Integer w) {
		if(vertex.contains(n1) && vertex.contains(n2)) {
			int index = indexOf(n1);
			int index2 = indexOf(n2);
			adjMatrix[index][index2] = w;
			adjMatrix[index2][index] = w;
		}
	}
	
	public T get(int index) {
		return vertex.get(index);
	}
	
	public int size() {
		return vertex.size();
	}
	public Integer indexOf(T key) {
		return vertex.indexOf(key);
	}
	
}
