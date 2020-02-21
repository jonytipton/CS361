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
				//System.out.println("found A state");
			}
			//find toState
			if (iterator.getName().equals(toState)) {
				bState = iterator;
				//System.out.println("found b state");
			}
		}
		//add transition to aState
		aState.addTransition(onSymb, bState);
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
		
		for(DFAState iter: states) {
			//if it is a final state, it is no longer final
			if(finalStates.contains(iter)) {
				complementDFA.states.add(iter);
			}
			else {
				complementDFA.finalStates.add(iter);
				complementDFA.states.add(iter);
			}
		}
		return complementDFA;
	}
	
	//returns true if the laguage accepts the string
	public boolean accepts(String input) {
		currentState = startState;
		boolean accepts = false;
		//if string is "e"mpty dont traverse
		if(input.equals("e") && finalStates.contains(currentState)) {
			accepts = true;
		}
		//print starting state
		while(input.length()>0) {
			//System.out.println(currentState.getName() + " :" + input);
			//get first character as next route to traverse
			char route = input.charAt(0);
			
			//remove first character from input string
			//this will allow for tracking remaining input
			input = input.substring(1);
			
			
			
			//retrive next state from current state
			//useing the map
			currentState = getToState(currentState, route);
			
			//if no more input
			//&& current state is final 
			if(input.length() ==0 && finalStates.contains(currentState)) {
				//System.out.println("Final State: " + currentState.getName() + " reached");
				accepts = true;
			}
			
		}
		
		return accepts;
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
		//add first part of string
		String result = 
				"Q = { " + states.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"Sigma = { " + alphabet.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", "") + " }\n"+
				"delta = \n\t"; 
		
		for(char letter : alphabet) {
			result += "\t" + letter;
		}
		//add transitions
		//iteratre through each state
		for(DFAState iter: states) {
			result += "\n\t" + iter.getName();
			//print state
			for(char route : alphabet) {
				//print next char
				result += "\t";
				DFAState temp = iter.nextState(route);
				result += temp.getName();
				
			}
			//print next line
		}
		
		
		//add end of string
		
		
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
