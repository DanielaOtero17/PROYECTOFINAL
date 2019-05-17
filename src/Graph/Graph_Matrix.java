package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import graph.Pair;

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
	
	
	public void removeNode(T d) {
		int index = indexOf(d);
		for(int i = 0; i < adjMatrix.length;i++) {
			adjMatrix[index][i] = 0;
//			adjMatrix[i][index] = 0;
		}
		vertex.remove(d);
	}

	
	  public void removeEdge(T n1, T n2) {
		if(vertex.contains(n1) && vertex.contains(n2)) {
			int index = indexOf(n1);
			int index2 = indexOf(n2);
			adjMatrix[index][index2] = 0;
			adjMatrix[index2][index] = 0;
		}
	
	  }
	  
	  public ArrayList<T> getAdjacents(T source){
			ArrayList<T> adj = new ArrayList<T>();
			if(vertex.contains(source)) {
				int index = indexOf(source);
				for(int i = 0; i < adjMatrix[index].length; i++) {
					if(adjMatrix[index][i] > 0) {
						T a = vertex.get(i);
						adj.add(a);
					}
				}
			}
			return adj;
		}
	  
	  
	  public int[] dijkstra(T source) {

			//		INT NVERTEX = NODES.SIZE();

			int[] dist = new int[vertex.size()];
			boolean[] vis = new boolean[vertex.size()];
			int[] prev = new int[vertex.size()];

	 		dist[indexOf(source)] = 0;
			for(int i = 0; i < dist.length; i++) {
				if(i != indexOf(source)) {
					dist[i] = Integer.MAX_VALUE;				
				}
			}
			
			for(int i = 0; i < prev.length; i++) {
				prev[i] = -1;
			}

			PriorityQueue<Pair<T>> q = new PriorityQueue<Pair<T>>();
			q.add(new Pair<T>(source,0));


			while(!q.isEmpty()) {
				Pair<T> actual = q.poll();
				int index = indexOf(actual.getObject());
				if(vis[index]) continue;

				vis[index] = true;

				for(int i = 0; i < adjMatrix[index].length; i++) {
					if(adjMatrix[index][i] != 0) {
						int weight = adjMatrix[index][i];
						if(!vis[i]) {
							if(dist[index] + weight < dist[i]) {
								dist[i] = dist[index] + weight;
								prev[i] = index;
								q.add(new Pair(vertex.get(i),weight));
							}
						}
					}
				}
			}
			return prev;
		}

	
}
