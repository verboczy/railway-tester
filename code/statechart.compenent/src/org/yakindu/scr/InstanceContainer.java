package org.yakindu.scr;

import org.yakindu.scr.section2.ISection2Statemachine.SCIProtocolListener;
import org.yakindu.scr.section2.ISection2Statemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

interface SystemInterface {
	void raiseOccupyTop2( );
	
	void raiseStraight( );
	
	void raiseUnoccupyDiv2( );
	
	void raiseOccupyDiv( );
	
	void raiseUnoccupyStr( );
	
	void raiseOccupyStr( );
	
	void raiseUnoccupyDiv( );
	
	void raiseOccupyDiv2( );
	
	void raiseOccupyTurnout( );
	
	void raiseDivergent( );
	
	void raiseOccupyStr2( );
	
	void raiseOccupyTop( );
	
	void raiseUnoccupyTop2( );
	
	void raiseUnoccupyTop( );
	
	void raiseUnoccupyStr2( );
	
	void raiseUnoccupyTurnout( );
}

public class InstanceContainer implements SystemInterface {
	
    private SectionComponent sectionDiv2 = new SectionComponent();
    
    private SectionComponent sectionStr = new SectionComponent();
    
    private SectionComponent sectionStr2 = new SectionComponent();
    
    private TurnoutComponent turnout = new TurnoutComponent();
    
    private SectionComponent sectionDiv = new SectionComponent();
    
    private SectionComponent sectionTop = new SectionComponent();
    
    private SectionComponent sectionTop2 = new SectionComponent();
    
    public InstanceContainer() {
    	sectionDiv2.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    			sectionDiv.raiseReserveFromCCW();
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    			sectionDiv.raiseCanGoFromCCW();
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    			sectionDiv.raiseCannotGoFromCCW();
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    			sectionDiv.raiseReleaseFromCCW();
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    		}
    	});
    	sectionDiv2.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    	
    	sectionStr.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    			turnout.raiseReserveFromStraight();
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    			sectionStr2.raiseReserveFromCW();
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    			turnout.raiseCanGoFromStraight();
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    			sectionStr2.raiseCanGoFromCW();
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    			turnout.raiseCannotGoFromStraight();
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    			sectionStr2.raiseCannotGoFromCW();
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    			turnout.raiseReleaseFromStraight();
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    			sectionStr2.raiseReleaseFromCW();
    		}
    	});
    	sectionStr.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    	
    	sectionStr2.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    			sectionStr.raiseReserveFromCCW();
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    			sectionStr.raiseCanGoFromCCW();
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    			sectionStr.raiseCannotGoFromCCW();
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    			sectionStr.raiseReleaseFromCCW();
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    		}
    	});
    	sectionStr2.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    	
    	turnout.getSCIProtocolListeners().add(new ITurnoutStatemachine.SCIProtocolListener() {
    		@Override
    		public void onReserveToTopRaised( ) {
    			sectionTop.raiseReserveFromCCW();
    		}
    		
    		@Override
    		public void onReserveToStraightRaised( ) {
    			sectionStr.raiseReserveFromCW();
    		}
    		
    		@Override
    		public void onReserveToDivergentRaised( ) {
    			sectionDiv.raiseReserveFromCW();
    		}
    		
    		@Override
    		public void onCanGoToTopRaised( ) {
    			sectionTop.raiseCanGoFromCCW();
    		}
    		
    		@Override
    		public void onCanGoToStraightRaised( ) {
    			sectionStr.raiseCanGoFromCW();
    		}
    		
    		@Override
    		public void onCanGoToDivergentRaised( ) {
    			sectionDiv.raiseCanGoFromCW();
    		}
    		
    		@Override
    		public void onCannotGoToTopRaised( ) {
    			sectionTop.raiseCannotGoFromCCW();
    		}
    		
    		@Override
    		public void onCannotGoToStraightRaised( ) {
    			sectionStr.raiseCannotGoFromCW();
    		}
    		
    		@Override
    		public void onCannotGoToDivergentRaised( ) {
    			sectionDiv.raiseCannotGoFromCW();
    		}
    		
    		@Override
    		public void onReleaseToTopRaised( ) {
    			sectionTop.raiseReleaseFromCCW();
    		}
    		
    		@Override
    		public void onReleaseToStraightRaised( ) {
    			sectionStr.raiseReleaseFromCW();
    		}
    		
    		@Override
    		public void onReleaseToDivergentRaised( ) {
    			sectionDiv.raiseReleaseFromCW();
    		}
    	});
    	
    	sectionDiv.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    			turnout.raiseReserveFromDivergent();
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    			sectionDiv2.raiseReserveFromCW();
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    			turnout.raiseCanGoFromDivergent();
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    			sectionDiv2.raiseCanGoFromCW();
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    			turnout.raiseCannotGoFromDivergent();
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    			sectionDiv2.raiseCannotGoFromCW();
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    			turnout.raiseReleaseFromDivergent();
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    			sectionDiv2.raiseReleaseFromCW();
    		}
    	});
    	sectionDiv.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    	
    	sectionTop.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    			sectionTop2.raiseReserveFromCCW();
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    			turnout.raiseReserveFromTop();
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    			sectionTop2.raiseCanGoFromCCW();
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    			turnout.raiseCanGoFromTop();
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    			sectionTop2.raiseCannotGoFromCCW();
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    			turnout.raiseCannotGoFromTop();
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    			sectionTop2.raiseReleaseFromCCW();
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    			turnout.raiseReleaseFromTop();
    		}
    	});
    	sectionTop.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    	
    	sectionTop2.getSCIProtocolListeners().add(new SCIProtocolListener() {
    		@Override
    		public void onReserveToCWRaised( ) {
    		}
    		
    		@Override
    		public void onReserveToCCWRaised( ) {
    			sectionTop.raiseReserveFromCW();
    		}
    		
    		@Override
    		public void onCanGoToCWRaised( ) {
    		}
    		
    		@Override
    		public void onCanGoToCCWRaised( ) {
    			sectionTop.raiseCanGoFromCW();
    		}
    		
    		@Override
    		public void onCannotGoToCWRaised( ) {
    		}
    		
    		@Override
    		public void onCannotGoToCCWRaised( ) {
    			sectionTop.raiseCannotGoFromCW();
    		}
    		
    		@Override
    		public void onReleaseToCWRaised( ) {
    		}
    		
    		@Override
    		public void onReleaseToCCWRaised( ) {
    			sectionTop.raiseReleaseFromCW();
    		}
    	});
    	sectionTop2.getSCISectionListeners().add(new SCISectionListener() {
    		@Override
    		public void onEnableSectionRaised(long value) {
    		}
    		
    		@Override
    		public void onDisableSectionRaised( ) {
    		}
    	});
    }
    
    public SectionComponent getSectionDiv2() {
    	return sectionDiv2;
    }
    
    public SectionComponent getSectionStr() {
    	return sectionStr;
    }
    
    public SectionComponent getSectionStr2() {
    	return sectionStr2;
    }
    
    public TurnoutComponent getTurnout() {
    	return turnout;
    }
    
    public SectionComponent getSectionDiv() {
    	return sectionDiv;
    }
    
    public SectionComponent getSectionTop() {
    	return sectionTop;
    }
    
    public SectionComponent getSectionTop2() {
    	return sectionTop2;
    }
    
    private boolean areAllEventQueuesEmpty() {
    	return sectionDiv2.isEventQueueEmpty() && sectionStr.isEventQueueEmpty() && sectionStr2.isEventQueueEmpty() && turnout.isEventQueueEmpty() && sectionDiv.isEventQueueEmpty() && sectionTop.isEventQueueEmpty() && sectionTop2.isEventQueueEmpty();
    }
    
    public void runFullCycle() {
    	do {
    		runOneCycle();
    	}
    	while (!areAllEventQueuesEmpty());
    }
    
    public void raiseOccupyTop2( ) {
        sectionTop2.raiseOccupy();
    }
    
    public void raiseStraight( ) {
        turnout.raiseTurnoutStraight();
    }
    
    public void raiseUnoccupyDiv2( ) {
        sectionDiv2.raiseUnoccupy();
    }
    
    public void raiseOccupyDiv( ) {
        sectionDiv.raiseOccupy();
    }
    
    public void raiseUnoccupyStr( ) {
        sectionStr.raiseUnoccupy();
    }
    
    public void raiseOccupyStr( ) {
        sectionStr.raiseOccupy();
    }
    
    public void raiseUnoccupyDiv( ) {
        sectionDiv.raiseUnoccupy();
    }
    
    public void raiseOccupyDiv2( ) {
        sectionDiv2.raiseOccupy();
    }
    
    public void raiseOccupyTurnout( ) {
        turnout.raiseOccupy();
    }
    
    public void raiseDivergent( ) {
        turnout.raiseTurnoutDivergent();
    }
    
    public void raiseOccupyStr2( ) {
        sectionStr2.raiseOccupy();
    }
    
    public void raiseOccupyTop( ) {
        sectionTop.raiseOccupy();
    }
    
    public void raiseUnoccupyTop2( ) {
        sectionTop2.raiseUnoccupy();
    }
    
    public void raiseUnoccupyTop( ) {
        sectionTop.raiseUnoccupy();
    }
    
    public void raiseUnoccupyStr2( ) {
        sectionStr2.raiseUnoccupy();
    }
    
    public void raiseUnoccupyTurnout( ) {
        turnout.raiseUnoccupy();
    }
    
    public void runOneCycle() {		    	
	    sectionDiv2.changeEventQueue();
	    sectionStr.changeEventQueue();
	    sectionStr2.changeEventQueue();
	    turnout.changeEventQueue();
	    sectionDiv.changeEventQueue();
	    sectionTop.changeEventQueue();
	    sectionTop2.changeEventQueue();
	    sectionDiv2.runCycle();
	    sectionStr.runCycle();
	    sectionStr2.runCycle();
	    turnout.runCycle();
	    sectionDiv.runCycle();
	    sectionTop.runCycle();
	    sectionTop2.runCycle();
    }
}
