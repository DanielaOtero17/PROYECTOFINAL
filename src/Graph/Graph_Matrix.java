package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

	  
	  public int[] bellman_ford(T source) {

			int[] dist = new int[vertex.size()];
			int index = indexOf(source);
			dist[index] = 0;

			for(int i = 0; i < dist.length; i++) {
				if(i != index) {
					dist[i] = Integer.MAX_VALUE;				
				}
			}


			for(int j = 0; j < adjMatrix[index].length-1; j++) {
				for(int i = 0; i < adjMatrix[index].length; i++) {
					if(adjMatrix[index][i] != 0) {
						int weight = adjMatrix[index][i];
						if(dist[index] + weight < dist[i]) {
							dist[i] = dist[index] + weight;
						}
					}
				}
				
			}
			return dist;
		}

	  public ArrayList<T> bfs(T source) {
			ArrayList<T> b = new ArrayList<T>();
			Queue<T> q = new LinkedList<T>();
			boolean[] visited = new boolean[vertex.size()];
			visited[indexOf(source)] = true;

			q.add(source);
			b.add(source);

			while(!q.isEmpty()) {
				T current = q.poll();
				int index = indexOf(current);
				for(int i = 0; i < adjMatrix[index].length; i++) {
					if(adjMatrix[index][i] != 0) {
						if(!visited[i]) {
							q.add(vertex.get(i));
							b.add(vertex.get(i));
							visited[i] = true;
						}					
					}
				}
			}
			System.out.println(b);
			return b;
		}
	  
	  public void dfs(T source) {
			Stack<T> s = new Stack<T>();
			boolean[] visited = new boolean[vertex.size()];
			s.push(source);
			visited[indexOf(source)] = true;

			while(!s.isEmpty()) {
				T current = s.pop();
				int index = indexOf(current);
				for(int i = 0; i < adjMatrix[index].length; i++) {
					if(adjMatrix[index][i] != 0) {
						if(!visited[i]) {
							s.push(vertex.get(i));
							System.out.println(i);
							visited[i] = true;
						}					
					}
				}
			}
		}
		
		
	  public int[][] getAdjMatrix() {
			return adjMatrix;
		}

		
		public void setAdjMatrix(int[][] adjMatrix) {
			this.adjMatrix = adjMatrix;
		}

		public int getNumberOfVertex() {
			return numberOfVertex;
		}

		
		public void setNumberOfVertex(int numberOfVertex) {
			this.numberOfVertex = numberOfVertex;
		}

		
		public List<T> getVertex() {
			return vertex;
		}

		
		public void setVertex(List<T> vertex) {
			this.vertex = vertex;
		}

		public Graph<T> kurskal(T source){
			return null;
		}
	  
}
