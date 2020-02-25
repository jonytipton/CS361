package fa.dfa;

import java.util.*;

import fa.State;

/**
 * CS361
 * February 2020
 * Represents a DFAState object
 * @author Johnathon Begg, Jonathan Tipton
 */
public class DFAState extends State {
	//use HashMap to store transition functions
	private Map<Character, DFAState> traverseMap = new HashMap<>();
	
	
	/**
	 * Create new DFAState with String input name
	 * @param name
	 */
	public DFAState (String name) {
		this.name = name;
	}
	
	
	/**
	 * Crate new transition from this DFAState to another
	 * DFAState with char input onSymb
	 * @param onSymb
	 * @param toState
	 */
	public void addTransition(char onSymb, DFAState toState) {
		traverseMap.put(Character.valueOf(onSymb), toState);
	}
	
	
	/**
	 * returns DFAState given by traverseMap (transition function) on input char "route"
	 * @param route
	 * @return next DFAState 
	 */
	public DFAState nextState(char route) {
		return traverseMap.get(route);
	}
}

