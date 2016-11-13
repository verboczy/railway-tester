package org.yakindu.scr;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
    	
import org.yakindu.scr.section2.ISection2Statemachine.SCIProtocolListener;

import org.yakindu.scr.section2.ISection2Statemachine.SCISectionListener;
import org.yakindu.scr.section2.Section2Statemachine;
import org.yakindu.scr.section2.Section2Statemachine.State;

interface SectionComponentInterface {
	
	void raiseUnoccupy( );
	
	void raiseRestartProtocol( );
	
	void raiseCanGoFromCW( );
	
	void raiseCanGoFromCCW( );
	
	void raiseCannotGoFromCCW( );
	
	void raiseReleaseFromCW( );
	
	void raiseCannotGoFromCW( );
	
	void raiseReserveFromCW( );
	
	void raiseReleaseFromCCW( );
	
	void raiseOccupy( );
	
	void raiseReserveFromCCW( );
}

public class SectionComponent implements SectionComponentInterface {
	// The wrapped Yakindu statemachine
	private Section2Statemachine section2Statemachine = new Section2Statemachine();
	
	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new LinkedList<Message>();
	private Queue<Message> eventQueue2 = new LinkedList<Message>();
	
	public SectionComponent() {
		// Initializing and entering the wrapped statemachine
		section2Statemachine.init();
		section2Statemachine.enter();
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
	   			case "unoccupy":
	   				section2Statemachine.getSCITrain().raiseUnoccupy();
	   				break; 
	   			case "cannotGoFromCCW":
	   				section2Statemachine.getSCIProtocol().raiseCannotGoFromCCW();
	   				break; 
	   			case "cannotGoFromCW":
	   				section2Statemachine.getSCIProtocol().raiseCannotGoFromCW();
	   				break; 
	   			case "releaseFromCW":
	   				section2Statemachine.getSCIProtocol().raiseReleaseFromCW();
	   				break; 
	   			case "reserveFromCW":
	   				section2Statemachine.getSCIProtocol().raiseReserveFromCW();
	   				break; 
	   			case "releaseFromCCW":
	   				section2Statemachine.getSCIProtocol().raiseReleaseFromCCW();
	   				break; 
	   			case "canGoFromCW":
	   				section2Statemachine.getSCIProtocol().raiseCanGoFromCW();
	   				break; 
	   			case "restartProtocol":
	   				section2Statemachine.getSCIProtocol().raiseRestartProtocol();
	   				break; 
	   			case "occupy":
	   				section2Statemachine.getSCITrain().raiseOccupy();
	   				break; 
	   			case "reserveFromCCW":
	   				section2Statemachine.getSCIProtocol().raiseReserveFromCCW();
	   				break; 
	   			case "canGoFromCCW":
	   				section2Statemachine.getSCIProtocol().raiseCanGoFromCCW();
	   				break; 
	   			default:
	   				throw new IllegalArgumentException("No such event!");
	   		}
	   }
	   section2Statemachine.runCycle();
	}
	
	public void raiseUnoccupy( ) {
		getInsertQueue().add(new Message("unoccupy", null));
	}
	
	public void raiseRestartProtocol( ) {
		getInsertQueue().add(new Message("restartProtocol", null));
	}
	
	public void raiseCanGoFromCW( ) {
		getInsertQueue().add(new Message("canGoFromCW", null));
	}
	
	public void raiseCanGoFromCCW( ) {
		getInsertQueue().add(new Message("canGoFromCCW", null));
	}
	
	public void raiseCannotGoFromCCW( ) {
		getInsertQueue().add(new Message("cannotGoFromCCW", null));
	}
	
	public void raiseReleaseFromCW( ) {
		getInsertQueue().add(new Message("releaseFromCW", null));
	}
	
	public void raiseCannotGoFromCW( ) {
		getInsertQueue().add(new Message("cannotGoFromCW", null));
	}
	
	public void raiseReserveFromCW( ) {
		getInsertQueue().add(new Message("reserveFromCW", null));
	}
	
	public void raiseReleaseFromCCW( ) {
		getInsertQueue().add(new Message("releaseFromCCW", null));
	}
	
	public void raiseOccupy( ) {
		getInsertQueue().add(new Message("occupy", null));
	}
	
	public void raiseReserveFromCCW( ) {
		getInsertQueue().add(new Message("reserveFromCCW", null));
	}
	
	List<SCIProtocolListener> getSCIProtocolListeners() {
		return section2Statemachine.getSCIProtocol().getListeners();
	}
	
	List<SCISectionListener> getSCISectionListeners() {
		return section2Statemachine.getSCISection().getListeners();
	}
	
	public boolean isStateActive(State state) {
		return section2Statemachine.isStateActive(state);
	}
	
}
