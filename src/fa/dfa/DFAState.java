package fa.dfa;

import java.util.*;

import fa.State;

public class DFAState extends State {
	
	private Map<Character, DFAState> traverseMap = new HashMap<>();
	
	public DFAState (String name) {
		this.name = name;
	}
	
	public void addTransition(char onSymb, DFAState toState) {
		traverseMap.put(Character.valueOf(onSymb), toState);
	}
	
	public DFAState nextState(char route) {
		return traverseMap.get(route);
	}
}

