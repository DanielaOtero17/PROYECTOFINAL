package Graph;

public class Pair<T> {
	
	private T object;
	private Integer w;
	
	public Pair(T type,Integer n) {
		w = n;
		object = type;
	}

	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}

	public Integer getW() {
		return w;
	}

	public void setW(Integer w) {
		this.w = w;
	}

	@Override
	public int compareTo(Object o) {
		Pair<T> c = (Pair<T>) o;
		if(w < c.getW()) {
			return -1;
		}
		else if(w > c.getW()) {
			return 1;
		}
		else {
			return 0;			
		}
	}
	
	

}
