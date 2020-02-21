/**
 * 
 */
package fa.dfa;

import java.util.*;

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
	private Map<String, Map<String, String>> transitionMap = new HashMap<>();
	//States
	private Set<DFAState> finalStates = new HashSet<>();
	private Set<DFAState> states = new HashSet<>();
	private DFAState startState;
	private DFAState currentState;
	//Alphabet
	private Set<Character> alphabet = new HashSet<>();
	
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
	 * Adds the alphabet symbol to the DFA's alphabet set
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
	 * This method must return the complement of this DFA. 
	 * That is a new DFA, such as its language is the complement 
	 * of this DFA’s language. Recall from the slides, that in 
	 * order to do so, we need to make all final states of this 
	 * DFA non-final (i.e., regular) states and vice versa.
	 * 
	 * swap final and non-final states
	 * @return a copy of this DFA
	 */
	public DFA complement() {
		DFA complementDFA = new DFA();
		complementDFA.alphabet = this.alphabet; //same for complementDFA
		complementDFA.startState = this.startState; //same for complementDFA
		
		Iterator<DFAState> statesIterator = states.iterator();
		while (statesIterator.hasNext()) {
			if (!finalStates.contains(statesIterator.next())){
				complementDFA.addFinalState(statesIterator.next().getName());
			}
			else {
				complementDFA.addState(statesIterator.next().getName());
			}
		}
		/*
		 * for each element in states set
		 * check if state is non-final, add to complementDFA.finalStates if non-final
		 * if final, add to complementDFA.states
		 */
		return complementDFA;
	}

	public boolean accepts(String input) {
			//TODO
		return false;
	}

	/**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
	public Set<? extends DFAState> getStates() {
		return states;
	}

	/**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
	public Set<? extends DFAState> getFinalStates() {
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

	
	//TODO create separate string builder instead of using replaceAll to get correct formatting
	//need to check instructions for correct format of toString
	public String toString() {
		String abc = alphabet.toString();
		String test = "";
		StringTokenizer tk = new StringTokenizer(abc, " ");
		while(tk.hasMoreTokens()) {
			test = test+tk.nextToken();
		}
		String result = 
				"Q = { " + states.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"Sigma = { " + alphabet.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"delta = \n" +
				"q0 = " + startState +
				"\nF = { " + finalStates.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") +
				" }\n";
		
		return result;
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
