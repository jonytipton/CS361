/**
 * 
 */
package fa.dfa;

import java.util.*;

import fa.State;

/**
 * @author Johnathon Begg, Jonathan Tipton
 *
 */
public class DFA implements DFAInterface {
	/**
	DFAState[] Final = new DFAState[20];
	DFAState[] StateList = new DFAState[40];
	DFAState Start;
	int FinalStatesCount = 0;
	int TotalStatesCount = 0;
	*/
	
	//transition function written as "a0a"
	//use String as key value containing current DFAState.name and 
	//concat with transition value, return new DFAState
	Map<String, DFAState> transitionMap = new HashMap<String, DFAState>();
	
	//must use a concrete class that implements java.util.Set interface to represent DFA elements
	Set<DFAState> finalSet = new HashSet<DFAState>();
	Set<DFAState> stateSet = new HashSet<DFAState>();
	DFAState startState;
	
	
	public void addFinalState(String nextToken) {
		//working with SET so duplicates will not occur
		addState(nextToken);
		finalSet.add(new DFAState(nextToken));
		
		//finalSet.add(nextToken);
		/**
		Final[FinalStatesCount] = new DFAState(nextToken);
		FinalStatesCount++;
		addState(nextToken);*/
		
	}

	public void addStartState(String startStateName) {
		startState = new DFAState(startStateName);
	}

	public void addState(String nextToken) {
		stateSet.add(new DFAState(nextToken));
		
		/**
		StateList[TotalStatesCount] = new DFAState(nextToken);
		TotalStatesCount++;*/
		
	}

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		
	}

	public DFA complement() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean accepts(String input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<? extends State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getStartState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Character> getABC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getToState(DFAState from, char onSymb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		
		return null;
	}

}
