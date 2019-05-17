package Graph;

import java.util.*;

/**
 *Directed graph using list of lists.
 *
 * @param <T> Type of data.
 */
public class Graph<T> {

	private List<HashMap<T,Integer>> adjacent;
	private List<T> vertex;
	private Map<T, Integer> indexes;

	public Graph() {
		vertex = new ArrayList<T>();
		indexes = new HashMap<T, Integer>();	
		adjacent = new ArrayList<HashMap<T,Integer>>();
	}
	
	public int size() {
		return vertex.size();
	}

	public T get(int index) {
		return vertex.get(index);
	}

	
	public Integer indexOf(T key) {
		return indexes.get(key);
	}

	public void addVertex(T n, Integer index) {
		vertex.add(n);
		indexes.put(n, index);
		adjacent.add(new HashMap<T,Integer>());
	}

	public void addEdge(T n1, T n2, Integer w) {
		if(vertex.contains(n1) && vertex.contains(n2)) {
			T v2 = vertex.get(indexOf(n2));
			T v1 = vertex.get(indexOf(n1));
			adjacent.get(indexOf(n1)).put(v2, w);
			adjacent.get(indexOf(n2)).put(v1, w);
		}
		
	}
		public void removeNode(T d) {
			vertex.remove(d);
			indexes.remove(d);
		}
		
		public List<T> getVertex() {
			return vertex;
		}

		public void setVertex(List<T> vertex) {
			this.vertex = vertex;
		}

		public void removeEdge(T n1, T n2) {
			if(vertex.contains(n1)) {
				int index = indexOf(n1);
				if(adjacent.get(index).containsKey(n2)) {
					T v2 = vertex.get(indexOf(n2));
					adjacent.get(index).remove(v2);
				}
			}
			if(vertex.contains(n2)) {
				int index = indexOf(n2);
				if(adjacent.get(index).containsKey(n1)) {
					T v1 = vertex.get(indexOf(n1));
					adjacent.get(index).remove(v1);
				}
			}
		}

		public HashMap<T,Integer> getAdjacents(T source){
			return adjacent.get(indexOf(source));
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

			for(int j = 0; j < vertex.size()-1; j++) {
				for(int i = 0; i < vertex.size(); i++) {
					T current = vertex.get(i);
					HashMap<T,Integer> adj = getAdjacents(current);
					for(T x : adj.keySet()) {
						int weight = adj.get(x);
						int srcIndex = indexOf(x);
						if(dist[i] != Integer.MAX_VALUE && dist[i]+weight<dist[srcIndex]) {
							dist[srcIndex] = dist[i]+weight;
						}
					}
				}
			}

			return dist;
		}

		public ArrayList<T> bfs(T source) {
			Queue<T> q = new LinkedList<T>();
			ArrayList<T> b = new ArrayList<T>();
			boolean[] visited = new boolean[vertex.size()];

			q.add(source);
			b.add(source);
			
			int srcIndex = indexOf(source);
			visited[srcIndex] = true;

			while(!q.isEmpty()) {
				T current = q.poll();
				HashMap<T,Integer> adj = getAdjacents(current);
				for(T x : adj.keySet()) {
					if(!visited[indexOf(x)]) {
						q.add(x);
						b.add(x);
						System.out.println(x);
						visited[indexOf(x)] = true;
					}
				}
			}
			return b;
		}

		/**
		 * Depth First Search algorithm from source vertex.
		 * @param source - Source vertex.
		 */
		public void dfs(T source) {
			Stack<T> s = new Stack<T>();
			boolean[] visited = new boolean[vertex.size()];
			s.push(source);
			visited[indexOf(source)] = true;

			while(!s.isEmpty()) {
				T current = s.pop();
				HashMap<T,Integer> adj = getAdjacents(current);
				for(T x : adj.keySet()) {
					if(!visited[indexOf(x)]) {
						s.push(x);
						System.out.println(x);
						visited[indexOf(x)] = true;
					}
				}
			}
		}

		public Graph<T> kruskal(T source) {

			return null;
		}
		
		private int[] init() {
			int[] parents = new int[vertex.size()];
			for(int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			return parents;
		}

		private int root(int x, int[] id) {
			while(id[x] != x) {
				id[x] = id[id[x]];
				x = id[x];
			}
			return x;
		}

		//	private void union(int x, int y) {
		//		int p = root(x);
		//		int q = root
		//	}

		public List<ArrayList> getEdges(){
			List<ArrayList> edges = new ArrayList<ArrayList>();
			for(int i = 0; i < vertex.size(); i++) {
				T current = vertex.get(i);
				ArrayList currEdges = new ArrayList();
				HashMap<T,Integer> adj = getAdjacents(current);
				for(T x : adj.keySet()) {
					Integer w = adj.get(x);
					edges.get(i).add(current);
					edges.get(i).add(x);
					edges.get(i).add(w);
				}
			}
			return edges;
		}
}
