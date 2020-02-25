/**
 * 
 */
package fa.dfa;

import java.util.*;

/**
 * February 2020
 * Implementation of a DFA (Deterministic Finite Automata)
 * Each DFA has a set of states and subset of final states, an initial start state,
 * a current state, and a set of characters that represent the DFA's recognized alphabet. 
 * @author Johnathon Begg, Jonathan Tipton
 *
 */
public class DFA implements DFAInterface {
	//States
	public Set<DFAState> finalStates = new LinkedHashSet<>();
	public  Set<DFAState> states = new LinkedHashSet<>();
	public DFAState startState;
	public DFAState currentState;
	//Alphabet
	public  Set<Character> alphabet = new LinkedHashSet<>();
	
	
	/**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
	public void addFinalState(String name) {
		//create new Final state, add to final and regular state sets
		DFAState newFinal = new DFAState(name);
		finalStates.add(newFinal);
		states.add(newFinal);
	}

	
	/**
	 * Adds the initial state to the DFA instance
	 * @param startStateName is the label of the start state
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
	}

	
	/**
	 * Adds the transition to the DFA's delta data structure
	 * Adds the alphabet symbol to the DFA's alphabet set
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
	public  void addTransition (String fromState, char onSymb, String toState) {
		DFAState aState = null;
		DFAState bState = null;
		for (DFAState iterator : states) {
			//find fromState
			if (iterator.getName().equals(fromState)) {
				aState = iterator;
			}
			//find toState
			if (iterator.getName().equals(toState)) {
				bState = iterator;
			}
		}
		//add transition to aState traverseMap (HashMap)
		aState.addTransition(onSymb, bState);
		alphabet.add(onSymb);
	}

	
	/**
	 * This method returns the complement of this DFA. 
	 * That is a new DFA, such as its language is the complement 
	 * of this DFA’s language. All final states of this 
	 * DFA become non-final (i.e., regular) states and vice versa.
	 * @return the complementing DFA of this DFA object
	 */
	public DFA complement() {
		DFA complementDFA = new DFA();
		//complements of a DFA share the same alphabet and start state
		complementDFA.alphabet = this.alphabet;
		complementDFA.startState = this.startState; 
		
		for(DFAState iter: states) {
			//if it is a final state, make it regular
			if(finalStates.contains(iter)) {
				complementDFA.states.add(iter);
			}
			//if it is a regular state, make it final
			else {
				complementDFA.finalStates.add(iter);
				complementDFA.states.add(iter);
			}
		}
		return complementDFA;
	}
	
	
	/**
	 * Simulates a DFA with String input to determine
	 * whether the DFA recognizes input as a valid string.
	 * @param input - the input string
	 * @return true if input in the language of the DFA and false otherwise
	 */
	public boolean accepts(String input) {
		currentState = startState;
		boolean accepts = false;
		//if string is "e"mpty don't traverse
		if(input.equals("e") && finalStates.contains(currentState)) {
			accepts = true;
		}
		while(input.length()>0) {
			//get first character as next route to traverse
			char route = input.charAt(0);
			//remove first character from input string
			//this will allow for tracking remaining characters in input
			input = input.substring(1);

			//retrieve next state from current state using map
			currentState = getToState(currentState, route);
			
			//if no more input and current state is final 
			if(input.length() == 0 && finalStates.contains(currentState)) {
				accepts = true;
			}
		}
		return accepts;
	}

	
	/**
	 * Getter for Q (set of all states)
	 * @return a set of states that FA has
	 */
	public Set<? extends DFAState> getStates() {
		return states;
	}

	
	/**
	 * Getter for F (set of final states)
	 * @return a set of final states that FA has
	 */
	public Set<? extends DFAState> getFinalStates() {
		return finalStates;
	}

	
	/**
	 * Getter for q0 (start state)
	 * @return the start state of FA
	 */
	public DFAState getStartState() {
		return startState;
	}

	
	/**
	 * Getter for Sigma (set of alphabet characters)
	 * @return the alphabet of FA
	 */
	public Set<Character> getABC() {
		return alphabet;
	}

	
	/**
	 * Construct the textual representation of the DFA
	 * The order of the states and the alphabet is the order
	 * in which they were instantiated in the DFA.
	 * @return String representation of the DFA
	 */
	public String toString() {
		String result = 
				"Q = { " + states.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"Sigma = { " + alphabet.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"delta = \n\t"; 
		for(char letter : alphabet) {
			result += "\t" + letter;
		}
		//add transitions
		//iterate through each state
		for(DFAState iter: states) {
			result += "\n\t" + iter.getName();
			//print state
			for(char route : alphabet) {
				//print next char
				result += "\t";
				DFAState temp = iter.nextState(route);
				result += temp.getName();	
			}
		}
		result +="\nq0 = " + startState +
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
		DFAState nextState = from.nextState(onSymb);
		return nextState;
	}
}
