/**
 * 
 */
package fa.dfa;

import java.util.Map;
import java.util.Set;

import fa.State;

/**
 * @author Johnathon Begg, Jonathan Tipton
 *
 */
public class DFA implements DFAInterface {
	DFAState[] Final = new DFAState[20];
	DFAState[] StateList = new DFAState[40];
	DFAState Start;
	int FinalStatesCount = 0;
	int TotalStatesCount = 0;

	public void addFinalState(String nextToken) {
		// TODO Auto-generated method stub
		
		Final[FinalStatesCount] = new DFAState(nextToken);
		FinalStatesCount++;
		addState(nextToken);
		
	}

	public void addStartState(String startStateName) {
		// TODO Auto-generated method stub
		Start = new DFAState(startStateName);
		
	}

	public void addState(String nextToken) {
		// TODO Auto-generated method stub
		StateList[TotalStatesCount] = new DFAState(nextToken);
		TotalStatesCount++;
		
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

}
