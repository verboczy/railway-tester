package org.yakindu.scr;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
    	
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCIProtocolListener;
import org.yakindu.scr.turnout.TurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

interface TurnoutComponentInterface {
	
	void raiseTurnoutDivergent( );
	
	void raiseReleaseFromDivergent( );
	
	void raiseReleaseFromStraight( );
	
	void raiseCannotGoFromDivergent( );
	
	void raiseCannotGoFromTop( );
	
	void raiseCanGoFromDivergent( );
	
	void raiseReleaseFromTop( );
	
	void raiseCanGoFromTop( );
	
	void raiseTurnoutStraight( );
	
	void raiseCannotGoFromStraight( );
	
	void raiseUnoccupy( );
	
	void raiseReserveFromDivergent( );
	
	void raiseOccupy( );
	
	void raiseReserveFromTop( );
	
	void raiseCanGoFromStraight( );
	
	void raiseReserveFromStraight( );
}

public class TurnoutComponent implements TurnoutComponentInterface {
	// The wrapped Yakindu statemachine
	private TurnoutStatemachine turnoutStatemachine = new TurnoutStatemachine();
	
	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new LinkedList<Message>();
	private Queue<Message> eventQueue2 = new LinkedList<Message>();
	
	public TurnoutComponent() {
		// Initializing and entering the wrapped statemachine
		turnoutStatemachine.init();
		turnoutStatemachine.enter();
	}

	void changeEventQueue() {
		chooseList = !chooseList;
	}
	
	boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}
	
	private Queue<Message> getInsertQueue() {
		if (chooseList) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	private Queue<Message> getProcessQueue() {
		return getInsertQueue() == eventQueue1 ? eventQueue2 : eventQueue1; 
	}
	
	void runCycle() {
	   Queue<Message> eventQueue = getProcessQueue();
	   while (!eventQueue.isEmpty()) {
	   		Message event = eventQueue.remove();
	   		switch (event.getEvent()) {
	   			case "cannotGoFromStraight":
	   				turnoutStatemachine.getSCIProtocol().raiseCannotGoFromStraight();
	   				break; 
	   			case "unoccupy":
	   				turnoutStatemachine.getSCITrain().raiseUnoccupy();
	   				break; 
	   			case "turnoutDivergent":
	   				turnoutStatemachine.getSCITurnout().raiseTurnoutDivergent();
	   				break; 
	   			case "reserveFromDivergent":
	   				turnoutStatemachine.getSCIProtocol().raiseReserveFromDivergent();
	   				break; 
	   			case "releaseFromDivergent":
	   				turnoutStatemachine.getSCIProtocol().raiseReleaseFromDivergent();
	   				break; 
	   			case "releaseFromStraight":
	   				turnoutStatemachine.getSCIProtocol().raiseReleaseFromStraight();
	   				break; 
	   			case "cannotGoFromDivergent":
	   				turnoutStatemachine.getSCIProtocol().raiseCannotGoFromDivergent();
	   				break; 
	   			case "occupy":
	   				turnoutStatemachine.getSCITrain().raiseOccupy();
	   				break; 
	   			case "cannotGoFromTop":
	   				turnoutStatemachine.getSCIProtocol().raiseCannotGoFromTop();
	   				break; 
	   			case "reserveFromTop":
	   				turnoutStatemachine.getSCIProtocol().raiseReserveFromTop();
	   				break; 
	   			case "canGoFromDivergent":
	   				turnoutStatemachine.getSCIProtocol().raiseCanGoFromDivergent();
	   				break; 
	   			case "releaseFromTop":
	   				turnoutStatemachine.getSCIProtocol().raiseReleaseFromTop();
	   				break; 
	   			case "canGoFromTop":
	   				turnoutStatemachine.getSCIProtocol().raiseCanGoFromTop();
	   				break; 
	   			case "canGoFromStraight":
	   				turnoutStatemachine.getSCIProtocol().raiseCanGoFromStraight();
	   				break; 
	   			case "turnoutStraight":
	   				turnoutStatemachine.getSCITurnout().raiseTurnoutStraight();
	   				break; 
	   			case "reserveFromStraight":
	   				turnoutStatemachine.getSCIProtocol().raiseReserveFromStraight();
	   				break; 
	   			default:
	   				throw new IllegalArgumentException("No such event!");
	   		}
	   }
	   turnoutStatemachine.runCycle();
	}
	
	public void raiseTurnoutDivergent( ) {
		getInsertQueue().add(new Message("turnoutDivergent", null));
	}
	
	public void raiseReleaseFromDivergent( ) {
		getInsertQueue().add(new Message("releaseFromDivergent", null));
	}
	
	public void raiseReleaseFromStraight( ) {
		getInsertQueue().add(new Message("releaseFromStraight", null));
	}
	
	public void raiseCannotGoFromDivergent( ) {
		getInsertQueue().add(new Message("cannotGoFromDivergent", null));
	}
	
	public void raiseCannotGoFromTop( ) {
		getInsertQueue().add(new Message("cannotGoFromTop", null));
	}
	
	public void raiseCanGoFromDivergent( ) {
		getInsertQueue().add(new Message("canGoFromDivergent", null));
	}
	
	public void raiseReleaseFromTop( ) {
		getInsertQueue().add(new Message("releaseFromTop", null));
	}
	
	public void raiseCanGoFromTop( ) {
		getInsertQueue().add(new Message("canGoFromTop", null));
	}
	
	public void raiseTurnoutStraight( ) {
		getInsertQueue().add(new Message("turnoutStraight", null));
	}
	
	public void raiseCannotGoFromStraight( ) {
		getInsertQueue().add(new Message("cannotGoFromStraight", null));
	}
	
	public void raiseUnoccupy( ) {
		getInsertQueue().add(new Message("unoccupy", null));
	}
	
	public void raiseReserveFromDivergent( ) {
		getInsertQueue().add(new Message("reserveFromDivergent", null));
	}
	
	public void raiseOccupy( ) {
		getInsertQueue().add(new Message("occupy", null));
	}
	
	public void raiseReserveFromTop( ) {
		getInsertQueue().add(new Message("reserveFromTop", null));
	}
	
	public void raiseCanGoFromStraight( ) {
		getInsertQueue().add(new Message("canGoFromStraight", null));
	}
	
	public void raiseReserveFromStraight( ) {
		getInsertQueue().add(new Message("reserveFromStraight", null));
	}
	
	List<SCIProtocolListener> getSCIProtocolListeners() {
		return turnoutStatemachine.getSCIProtocol().getListeners();
	}
	
	public boolean isStateActive(State state) {
		return turnoutStatemachine.isStateActive(state);
	}
	
}
