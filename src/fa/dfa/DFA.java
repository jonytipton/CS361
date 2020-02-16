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
	
	//Transition functions
	Map<String, Map<String, String>> transitionMap = new HashMap<>();
	//States
	Set<DFAState> finalStates = new HashSet<>();
	Set<DFAState> states = new HashSet<>();
	Set<Character> alphabet = new HashSet<>();
	DFAState startState;
	DFAState currentState;
	
	/**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
	public void addFinalState(String name) {
		//create new Final state, add to final and regular state sets
		DFAState newFinal = new DFAState(name);
		finalStates.add(newFinal);
		states.add(newFinal);
		
		//addState(nextToken);
		//finalSet.add(nextToken);
		/**
		Final[FinalStatesCount] = new DFAState(nextToken);
		FinalStatesCount++;
		addState(nextToken);*/
	}

	
	/**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
	public void addStartState(String startStateName) {
		startState = new DFAState(startStateName);
		states.add(startState);
	}

	
	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state 
	 */
	public void addState(String name) {
		states.add(new DFAState(name));
		
		/**
		StateList[TotalStatesCount] = new DFAState(nextToken);
		TotalStatesCount++;*/
	}

	/**
	 * Adds the transition to the DFA's delta data structure
	 * Adds the alphabet symbol to t he DFA's alphabet set
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
	public  void addTransition (String fromState, char onSymb, String toState) {
		Map<String, String> newTransition = new HashMap<>();
		//Create onSymb -> toState transition
		newTransition.put(Character.toString(onSymb), toState);
		//create fromState -> newTransition transition
		transitionMap.put(fromState, newTransition);	
		//add onSymb to alphabet set
		alphabet.add(onSymb);
	}

	/**
	 * Computes a copy of this DFA
	 * which language is the complement
	 * of this DFA's language.
	 * @return a copy of this DFA
	 */
	public DFA complement() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean accepts(String input) {

		return false;
	}

	/**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
	public Set<? extends State> getStates() {
		return states;
	}

	/**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
	public Set<? extends State> getFinalStates() {
		return finalStates;
	}

	/**
	 * Getter for q0
	 * @return the start state of FA
	 */
	public DFAState getStartState() {
		return startState;
	}

	/**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
	public Set<Character> getABC() {
		return alphabet;
	}

	
	public String toString() {
		//TODO
		return null;
	}


	@Override
	/**
	 * Uses transition function delta of FA
	 * @param from the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
	public DFAState getToState(DFAState from, char onSymb) {
		return null;
		// TODO Auto-generated method stub
	}

}
