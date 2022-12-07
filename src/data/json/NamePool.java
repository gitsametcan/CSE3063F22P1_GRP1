package data.json;

import java.util.List;

public class NamePool {
	private List<String> names;
	private List<String> lastNames;
	
	public NamePool(List<String> names, List<String> lastNames) {
		super();
		this.names = names;
		this.lastNames = lastNames;
	}
	
	
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public List<String> getLastNames() {
		return lastNames;
	}
	public void setLastNames(List<String> lastNames) {
		this.lastNames = lastNames;
	}
}
