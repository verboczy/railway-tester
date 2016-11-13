package org.yakindu.scr.turnout;
import java.util.LinkedList;
import java.util.List;

public class TurnoutStatemachine implements ITurnoutStatemachine {

	protected class SCITurnoutImpl implements SCITurnout {

		private boolean turnoutStraight;

		public void raiseTurnoutStraight() {
			turnoutStraight = true;
		}

		private boolean turnoutDivergent;

		public void raiseTurnoutDivergent() {
			turnoutDivergent = true;
		}

		public long getId() {
			return id;
		}

		protected void clearEvents() {
			turnoutStraight = false;
			turnoutDivergent = false;
		}

	}

	protected SCITurnoutImpl sCITurnout;

	protected class SCIProtocolImpl implements SCIProtocol {

		private List<SCIProtocolListener> listeners = new LinkedList<SCIProtocolListener>();

		public List<SCIProtocolListener> getListeners() {
			return listeners;
		}

		private boolean reserveFromTop;

		public void raiseReserveFromTop() {
			reserveFromTop = true;
		}

		private boolean reserveFromStraight;

		public void raiseReserveFromStraight() {
			reserveFromStraight = true;
		}

		private boolean reserveFromDivergent;

		public void raiseReserveFromDivergent() {
			reserveFromDivergent = true;
		}

		private boolean canGoFromTop;

		public void raiseCanGoFromTop() {
			canGoFromTop = true;
		}

		private boolean canGoFromStraight;

		public void raiseCanGoFromStraight() {
			canGoFromStraight = true;
		}

		private boolean canGoFromDivergent;

		public void raiseCanGoFromDivergent() {
			canGoFromDivergent = true;
		}

		private boolean cannotGoFromTop;

		public void raiseCannotGoFromTop() {
			cannotGoFromTop = true;
		}

		private boolean cannotGoFromStraight;

		public void raiseCannotGoFromStraight() {
			cannotGoFromStraight = true;
		}

		private boolean cannotGoFromDivergent;

		public void raiseCannotGoFromDivergent() {
			cannotGoFromDivergent = true;
		}

		private boolean releaseFromTop;

		public void raiseReleaseFromTop() {
			releaseFromTop = true;
		}

		private boolean releaseFromStraight;

		public void raiseReleaseFromStraight() {
			releaseFromStraight = true;
		}

		private boolean releaseFromDivergent;

		public void raiseReleaseFromDivergent() {
			releaseFromDivergent = true;
		}

		private boolean reserveToTop;

		public boolean isRaisedReserveToTop() {
			return reserveToTop;
		}

		protected void raiseReserveToTop() {
			reserveToTop = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToTopRaised();
			}
		}

		private boolean reserveToStraight;

		public boolean isRaisedReserveToStraight() {
			return reserveToStraight;
		}

		protected void raiseReserveToStraight() {
			reserveToStraight = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToStraightRaised();
			}
		}

		private boolean reserveToDivergent;

		public boolean isRaisedReserveToDivergent() {
			return reserveToDivergent;
		}

		protected void raiseReserveToDivergent() {
			reserveToDivergent = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToDivergentRaised();
			}
		}

		private boolean canGoToTop;

		public boolean isRaisedCanGoToTop() {
			return canGoToTop;
		}

		protected void raiseCanGoToTop() {
			canGoToTop = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToTopRaised();
			}
		}

		private boolean canGoToStraight;

		public boolean isRaisedCanGoToStraight() {
			return canGoToStraight;
		}

		protected void raiseCanGoToStraight() {
			canGoToStraight = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToStraightRaised();
			}
		}

		private boolean canGoToDivergent;

		public boolean isRaisedCanGoToDivergent() {
			return canGoToDivergent;
		}

		protected void raiseCanGoToDivergent() {
			canGoToDivergent = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToDivergentRaised();
			}
		}

		private boolean cannotGoToTop;

		public boolean isRaisedCannotGoToTop() {
			return cannotGoToTop;
		}

		protected void raiseCannotGoToTop() {
			cannotGoToTop = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToTopRaised();
			}
		}

		private boolean cannotGoToStraight;

		public boolean isRaisedCannotGoToStraight() {
			return cannotGoToStraight;
		}

		protected void raiseCannotGoToStraight() {
			cannotGoToStraight = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToStraightRaised();
			}
		}

		private boolean cannotGoToDivergent;

		public boolean isRaisedCannotGoToDivergent() {
			return cannotGoToDivergent;
		}

		protected void raiseCannotGoToDivergent() {
			cannotGoToDivergent = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToDivergentRaised();
			}
		}

		private boolean releaseToTop;

		public boolean isRaisedReleaseToTop() {
			return releaseToTop;
		}

		protected void raiseReleaseToTop() {
			releaseToTop = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToTopRaised();
			}
		}

		private boolean releaseToStraight;

		public boolean isRaisedReleaseToStraight() {
			return releaseToStraight;
		}

		protected void raiseReleaseToStraight() {
			releaseToStraight = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToStraightRaised();
			}
		}

		private boolean releaseToDivergent;

		public boolean isRaisedReleaseToDivergent() {
			return releaseToDivergent;
		}

		protected void raiseReleaseToDivergent() {
			releaseToDivergent = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToDivergentRaised();
			}
		}

		protected void clearEvents() {
			reserveFromTop = false;
			reserveFromStraight = false;
			reserveFromDivergent = false;
			canGoFromTop = false;
			canGoFromStraight = false;
			canGoFromDivergent = false;
			cannotGoFromTop = false;
			cannotGoFromStraight = false;
			cannotGoFromDivergent = false;
			releaseFromTop = false;
			releaseFromStraight = false;
			releaseFromDivergent = false;
		}

		protected void clearOutEvents() {
			reserveToTop = false;
			reserveToStraight = false;
			reserveToDivergent = false;
			canGoToTop = false;
			canGoToStraight = false;
			canGoToDivergent = false;
			cannotGoToTop = false;
			cannotGoToStraight = false;
			cannotGoToDivergent = false;
			releaseToTop = false;
			releaseToStraight = false;
			releaseToDivergent = false;
		}
	}

	protected SCIProtocolImpl sCIProtocol;

	protected class SCITrainImpl implements SCITrain {

		private boolean occupy;

		public void raiseOccupy() {
			occupy = true;
		}

		private boolean unoccupy;

		public void raiseUnoccupy() {
			unoccupy = true;
		}

		protected void clearEvents() {
			occupy = false;
			unoccupy = false;
		}

	}

	protected SCITrainImpl sCITrain;

	protected class SCIDirectionImpl implements SCIDirection {

		public long getTOP() {
			return tOP;
		}

		public long getSTRAIGHT() {
			return sTRAIGHT;
		}

		public long getDIVERGENT() {
			return dIVERGENT;
		}

		public long getUNSPECIFIED() {
			return uNSPECIFIED;
		}

	}

	protected SCIDirectionImpl sCIDirection;

	private boolean initialized = false;

	public enum State {
		main_region_Straight, main_region_Straight_listening_to_top_Waiting, main_region_Straight_listening_to_top_ReservationFromTop, main_region_Straight_listening_to_straight_Waiting, main_region_Straight_listening_to_straight_ReservationFromStraight, main_region_Straight_listening_to_occupy_Free, main_region_Straight_listening_to_occupy_Occupied, main_region_Straight_listening_to_release_TransferReleases, main_region_Divergent, main_region_Divergent_listening_to_top_Waiting, main_region_Divergent_listening_to_top_ReservationFromTop, main_region_Divergent_listening_to_divergent_Waiting, main_region_Divergent_listening_to_divergent_ReservationFromDivergent, main_region_Divergent_listening_to_occupy_Free, main_region_Divergent_listening_to_occupy_Occupied, main_region_Divergent_listening_to_release_TransferReleases, $NullState$
	};

	private final State[] stateVector = new State[4];

	private int nextStateIndex;

	public TurnoutStatemachine() {

		sCITurnout = new SCITurnoutImpl();
		sCIProtocol = new SCIProtocolImpl();
		sCITrain = new SCITrainImpl();
		sCIDirection = new SCIDirectionImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 4; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$
				|| stateVector[2] != State.$NullState$ || stateVector[3] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal()
	 */
	public boolean isFinal() {
		return false;
	}

	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCITurnout.clearEvents();
		sCIProtocol.clearEvents();
		sCITrain.clearEvents();

	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCIProtocol.clearOutEvents();
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_Straight :
				return stateVector[0].ordinal() >= State.main_region_Straight.ordinal() && stateVector[0]
						.ordinal() <= State.main_region_Straight_listening_to_release_TransferReleases.ordinal();
			case main_region_Straight_listening_to_top_Waiting :
				return stateVector[0] == State.main_region_Straight_listening_to_top_Waiting;
			case main_region_Straight_listening_to_top_ReservationFromTop :
				return stateVector[0] == State.main_region_Straight_listening_to_top_ReservationFromTop;
			case main_region_Straight_listening_to_straight_Waiting :
				return stateVector[1] == State.main_region_Straight_listening_to_straight_Waiting;
			case main_region_Straight_listening_to_straight_ReservationFromStraight :
				return stateVector[1] == State.main_region_Straight_listening_to_straight_ReservationFromStraight;
			case main_region_Straight_listening_to_occupy_Free :
				return stateVector[2] == State.main_region_Straight_listening_to_occupy_Free;
			case main_region_Straight_listening_to_occupy_Occupied :
				return stateVector[2] == State.main_region_Straight_listening_to_occupy_Occupied;
			case main_region_Straight_listening_to_release_TransferReleases :
				return stateVector[3] == State.main_region_Straight_listening_to_release_TransferReleases;
			case main_region_Divergent :
				return stateVector[0].ordinal() >= State.main_region_Divergent.ordinal() && stateVector[0]
						.ordinal() <= State.main_region_Divergent_listening_to_release_TransferReleases.ordinal();
			case main_region_Divergent_listening_to_top_Waiting :
				return stateVector[0] == State.main_region_Divergent_listening_to_top_Waiting;
			case main_region_Divergent_listening_to_top_ReservationFromTop :
				return stateVector[0] == State.main_region_Divergent_listening_to_top_ReservationFromTop;
			case main_region_Divergent_listening_to_divergent_Waiting :
				return stateVector[1] == State.main_region_Divergent_listening_to_divergent_Waiting;
			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent :
				return stateVector[1] == State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
			case main_region_Divergent_listening_to_occupy_Free :
				return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Free;
			case main_region_Divergent_listening_to_occupy_Occupied :
				return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Occupied;
			case main_region_Divergent_listening_to_release_TransferReleases :
				return stateVector[3] == State.main_region_Divergent_listening_to_release_TransferReleases;
			default :
				return false;
		}
	}

	public SCITurnout getSCITurnout() {
		return sCITurnout;
	}
	public SCIProtocol getSCIProtocol() {
		return sCIProtocol;
	}
	public SCITrain getSCITrain() {
		return sCITrain;
	}
	public SCIDirection getSCIDirection() {
		return sCIDirection;
	}

	private boolean check_main_region_Straight_tr0_tr0() {
		return sCITurnout.turnoutDivergent;
	}

	private boolean check_main_region_Straight_lr0_lr0() {
		return sCIProtocol.reserveFromDivergent;
	}

	private boolean check_main_region_Straight_listening_to_top_Waiting_tr0_tr0() {
		return sCIProtocol.reserveFromTop;
	}

	private boolean check_main_region_Straight_listening_to_top_ReservationFromTop_tr0_tr0() {
		return sCIProtocol.canGoFromStraight;
	}

	private boolean check_main_region_Straight_listening_to_top_ReservationFromTop_tr1_tr1() {
		return sCIProtocol.cannotGoFromStraight;
	}

	private boolean check_main_region_Straight_listening_to_straight_Waiting_tr0_tr0() {
		return sCIProtocol.reserveFromStraight;
	}

	private boolean check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0_tr0() {
		return sCIProtocol.canGoFromTop;
	}

	private boolean check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1_tr1() {
		return sCIProtocol.cannotGoFromTop;
	}

	private boolean check_main_region_Straight_listening_to_occupy_Free_tr0_tr0() {
		return sCITrain.occupy;
	}

	private boolean check_main_region_Straight_listening_to_occupy_Occupied_tr0_tr0() {
		return sCITrain.unoccupy;
	}

	private boolean check_main_region_Straight_listening_to_release_TransferReleases_lr0_lr0() {
		return sCIProtocol.releaseFromStraight;
	}

	private boolean check_main_region_Straight_listening_to_release_TransferReleases_lr1_lr1() {
		return sCIProtocol.releaseFromTop;
	}

	private boolean check_main_region_Divergent_tr0_tr0() {
		return sCITurnout.turnoutStraight;
	}

	private boolean check_main_region_Divergent_lr0_lr0() {
		return sCIProtocol.reserveFromStraight;
	}

	private boolean check_main_region_Divergent_listening_to_top_Waiting_tr0_tr0() {
		return sCIProtocol.reserveFromTop;
	}

	private boolean check_main_region_Divergent_listening_to_top_ReservationFromTop_tr0_tr0() {
		return sCIProtocol.canGoFromDivergent;
	}

	private boolean check_main_region_Divergent_listening_to_top_ReservationFromTop_tr1_tr1() {
		return sCIProtocol.cannotGoFromDivergent;
	}

	private boolean check_main_region_Divergent_listening_to_divergent_Waiting_tr0_tr0() {
		return sCIProtocol.reserveFromDivergent;
	}

	private boolean check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0_tr0() {
		return sCIProtocol.canGoFromTop;
	}

	private boolean check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1_tr1() {
		return sCIProtocol.cannotGoFromTop;
	}

	private boolean check_main_region_Divergent_listening_to_occupy_Free_tr0_tr0() {
		return sCITrain.occupy;
	}

	private boolean check_main_region_Divergent_listening_to_occupy_Occupied_tr0_tr0() {
		return sCITrain.unoccupy;
	}

	private boolean check_main_region_Divergent_listening_to_release_TransferReleases_lr0_lr0() {
		return sCIProtocol.releaseFromDivergent;
	}

	private boolean check_main_region_Divergent_listening_to_release_TransferReleases_lr1_lr1() {
		return sCIProtocol.releaseFromTop;
	}

	private void effect_main_region_Straight_tr0() {
		exitSequence_main_region_Straight();

		sCIProtocol.raiseReleaseToTop();

		sCIProtocol.raiseReleaseToDivergent();

		sCIProtocol.raiseCannotGoToStraight();

		enterSequence_main_region_Divergent_default();
	}

	private void effect_main_region_Straight_lr0_lr0() {
		sCIProtocol.raiseCannotGoToDivergent();
	}

	private void effect_main_region_Straight_listening_to_top_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_top_Waiting();

		sCIProtocol.raiseReserveToStraight();

		enterSequence_main_region_Straight_listening_to_top_ReservationFromTop_default();
	}

	private void effect_main_region_Straight_listening_to_top_ReservationFromTop_tr0() {
		exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();

		sCIProtocol.raiseCanGoToTop();

		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_top_ReservationFromTop_tr1() {
		exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();

		sCIProtocol.raiseCannotGoToTop();

		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_straight_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_straight_Waiting();

		sCIProtocol.raiseReserveToTop();

		enterSequence_main_region_Straight_listening_to_straight_ReservationFromStraight_default();
	}

	private void effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0() {
		exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();

		sCIProtocol.raiseCanGoToStraight();

		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1() {
		exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();

		sCIProtocol.raiseCannotGoToStraight();

		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_occupy_Free_tr0() {
		exitSequence_main_region_Straight_listening_to_occupy_Free();

		enterSequence_main_region_Straight_listening_to_occupy_Occupied_default();
	}

	private void effect_main_region_Straight_listening_to_occupy_Occupied_tr0() {
		exitSequence_main_region_Straight_listening_to_occupy_Occupied();

		enterSequence_main_region_Straight_listening_to_occupy_Free_default();
	}

	private void effect_main_region_Straight_listening_to_release_TransferReleases_lr0_lr0() {
		sCIProtocol.raiseReleaseToTop();
	}

	private void effect_main_region_Straight_listening_to_release_TransferReleases_lr1_lr1() {
		sCIProtocol.raiseReleaseToStraight();
	}

	private void effect_main_region_Divergent_tr0() {
		exitSequence_main_region_Divergent();

		sCIProtocol.raiseReleaseToTop();

		sCIProtocol.raiseReleaseToStraight();

		sCIProtocol.raiseCannotGoToDivergent();

		enterSequence_main_region_Straight_default();
	}

	private void effect_main_region_Divergent_lr0_lr0() {
		sCIProtocol.raiseCannotGoToStraight();
	}

	private void effect_main_region_Divergent_listening_to_top_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_top_Waiting();

		sCIProtocol.raiseReserveToDivergent();

		enterSequence_main_region_Divergent_listening_to_top_ReservationFromTop_default();
	}

	private void effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr0() {
		exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();

		sCIProtocol.raiseCanGoToTop();

		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr1() {
		exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();

		sCIProtocol.raiseCannotGoToTop();

		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_divergent_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_divergent_Waiting();

		sCIProtocol.raiseReserveToTop();

		enterSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_default();
	}

	private void effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0() {
		exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();

		sCIProtocol.raiseCanGoToDivergent();

		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1() {
		exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();

		sCIProtocol.raiseCannotGoToDivergent();

		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_occupy_Free_tr0() {
		exitSequence_main_region_Divergent_listening_to_occupy_Free();

		enterSequence_main_region_Divergent_listening_to_occupy_Occupied_default();
	}

	private void effect_main_region_Divergent_listening_to_occupy_Occupied_tr0() {
		exitSequence_main_region_Divergent_listening_to_occupy_Occupied();

		enterSequence_main_region_Divergent_listening_to_occupy_Free_default();
	}

	private void effect_main_region_Divergent_listening_to_release_TransferReleases_lr0_lr0() {
		sCIProtocol.raiseReleaseToTop();
	}

	private void effect_main_region_Divergent_listening_to_release_TransferReleases_lr1_lr1() {
		sCIProtocol.raiseReleaseToDivergent();
	}

	/* Entry action for state 'Free'. */
	private void entryAction_main_region_Straight_listening_to_occupy_Free() {
		sCIProtocol.raiseReleaseToStraight();

		sCIProtocol.raiseReleaseToTop();
	}

	/* Entry action for state 'Occupied'. */
	private void entryAction_main_region_Straight_listening_to_occupy_Occupied() {
		sCIProtocol.raiseReserveToStraight();

		sCIProtocol.raiseReserveToTop();
	}

	/* Entry action for state 'Free'. */
	private void entryAction_main_region_Divergent_listening_to_occupy_Free() {
		sCIProtocol.raiseReleaseToDivergent();

		sCIProtocol.raiseReleaseToTop();
	}

	/* Entry action for state 'Occupied'. */
	private void entryAction_main_region_Divergent_listening_to_occupy_Occupied() {
		sCIProtocol.raiseReserveToDivergent();

		sCIProtocol.raiseReserveToTop();
	}

	/* 'default' enter sequence for state Straight */
	private void enterSequence_main_region_Straight_default() {
		enterSequence_main_region_Straight_listening_to_top_default();

		enterSequence_main_region_Straight_listening_to_straight_default();

		enterSequence_main_region_Straight_listening_to_occupy_default();

		enterSequence_main_region_Straight_listening_to_release_default();
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_top_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromTop */
	private void enterSequence_main_region_Straight_listening_to_top_ReservationFromTop_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_top_ReservationFromTop;
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_straight_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromStraight */
	private void enterSequence_main_region_Straight_listening_to_straight_ReservationFromStraight_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_straight_ReservationFromStraight;
	}

	/* 'default' enter sequence for state Free */
	private void enterSequence_main_region_Straight_listening_to_occupy_Free_default() {
		entryAction_main_region_Straight_listening_to_occupy_Free();

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;
	}

	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_region_Straight_listening_to_occupy_Occupied_default() {
		entryAction_main_region_Straight_listening_to_occupy_Occupied();

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Straight_listening_to_occupy_Occupied;
	}

	/* 'default' enter sequence for state TransferReleases */
	private void enterSequence_main_region_Straight_listening_to_release_TransferReleases_default() {
		nextStateIndex = 3;
		stateVector[3] = State.main_region_Straight_listening_to_release_TransferReleases;
	}

	/* 'default' enter sequence for state Divergent */
	private void enterSequence_main_region_Divergent_default() {
		enterSequence_main_region_Divergent_listening_to_top_default();

		enterSequence_main_region_Divergent_listening_to_divergent_default();

		enterSequence_main_region_Divergent_listening_to_occupy_default();

		enterSequence_main_region_Divergent_listening_to_release_default();
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_top_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromTop */
	private void enterSequence_main_region_Divergent_listening_to_top_ReservationFromTop_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_top_ReservationFromTop;
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromDivergent */
	private void enterSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
	}

	/* 'default' enter sequence for state Free */
	private void enterSequence_main_region_Divergent_listening_to_occupy_Free_default() {
		entryAction_main_region_Divergent_listening_to_occupy_Free();

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Divergent_listening_to_occupy_Free;
	}

	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_region_Divergent_listening_to_occupy_Occupied_default() {
		entryAction_main_region_Divergent_listening_to_occupy_Occupied();

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Divergent_listening_to_occupy_Occupied;
	}

	/* 'default' enter sequence for state TransferReleases */
	private void enterSequence_main_region_Divergent_listening_to_release_TransferReleases_default() {
		nextStateIndex = 3;
		stateVector[3] = State.main_region_Divergent_listening_to_release_TransferReleases;
	}

	/* 'default' enter sequence for region main_region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_top */
	private void enterSequence_main_region_Straight_listening_to_top_default() {
		react_main_region_Straight_listening_to_top__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_straight */
	private void enterSequence_main_region_Straight_listening_to_straight_default() {
		react_main_region_Straight_listening_to_straight__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_occupy */
	private void enterSequence_main_region_Straight_listening_to_occupy_default() {
		react_main_region_Straight_listening_to_occupy__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_release */
	private void enterSequence_main_region_Straight_listening_to_release_default() {
		react_main_region_Straight_listening_to_release__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_top */
	private void enterSequence_main_region_Divergent_listening_to_top_default() {
		react_main_region_Divergent_listening_to_top__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_divergent */
	private void enterSequence_main_region_Divergent_listening_to_divergent_default() {
		react_main_region_Divergent_listening_to_divergent__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_occupy */
	private void enterSequence_main_region_Divergent_listening_to_occupy_default() {
		react_main_region_Divergent_listening_to_occupy__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_release */
	private void enterSequence_main_region_Divergent_listening_to_release_default() {
		react_main_region_Divergent_listening_to_release__entry_Default();
	}

	/* Default exit sequence for state Straight */
	private void exitSequence_main_region_Straight() {
		exitSequence_main_region_Straight_listening_to_top();

		exitSequence_main_region_Straight_listening_to_straight();

		exitSequence_main_region_Straight_listening_to_occupy();

		exitSequence_main_region_Straight_listening_to_release();
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_top_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromTop */
	private void exitSequence_main_region_Straight_listening_to_top_ReservationFromTop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_straight_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromStraight */
	private void exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Free */
	private void exitSequence_main_region_Straight_listening_to_occupy_Free() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Occupied */
	private void exitSequence_main_region_Straight_listening_to_occupy_Occupied() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state TransferReleases */
	private void exitSequence_main_region_Straight_listening_to_release_TransferReleases() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state Divergent */
	private void exitSequence_main_region_Divergent() {
		exitSequence_main_region_Divergent_listening_to_top();

		exitSequence_main_region_Divergent_listening_to_divergent();

		exitSequence_main_region_Divergent_listening_to_occupy();

		exitSequence_main_region_Divergent_listening_to_release();
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_top_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromTop */
	private void exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_divergent_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromDivergent */
	private void exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Free */
	private void exitSequence_main_region_Divergent_listening_to_occupy_Free() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state Occupied */
	private void exitSequence_main_region_Divergent_listening_to_occupy_Occupied() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state TransferReleases */
	private void exitSequence_main_region_Divergent_listening_to_release_TransferReleases() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for region main_region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_Straight_listening_to_top_Waiting :
				exitSequence_main_region_Straight_listening_to_top_Waiting();
				break;

			case main_region_Straight_listening_to_top_ReservationFromTop :
				exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
				break;

			case main_region_Divergent_listening_to_top_Waiting :
				exitSequence_main_region_Divergent_listening_to_top_Waiting();
				break;

			case main_region_Divergent_listening_to_top_ReservationFromTop :
				exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case main_region_Straight_listening_to_straight_Waiting :
				exitSequence_main_region_Straight_listening_to_straight_Waiting();
				break;

			case main_region_Straight_listening_to_straight_ReservationFromStraight :
				exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
				break;

			case main_region_Divergent_listening_to_divergent_Waiting :
				exitSequence_main_region_Divergent_listening_to_divergent_Waiting();
				break;

			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent :
				exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case main_region_Straight_listening_to_occupy_Free :
				exitSequence_main_region_Straight_listening_to_occupy_Free();
				break;

			case main_region_Straight_listening_to_occupy_Occupied :
				exitSequence_main_region_Straight_listening_to_occupy_Occupied();
				break;

			case main_region_Divergent_listening_to_occupy_Free :
				exitSequence_main_region_Divergent_listening_to_occupy_Free();
				break;

			case main_region_Divergent_listening_to_occupy_Occupied :
				exitSequence_main_region_Divergent_listening_to_occupy_Occupied();
				break;

			default :
				break;
		}

		switch (stateVector[3]) {
			case main_region_Straight_listening_to_release_TransferReleases :
				exitSequence_main_region_Straight_listening_to_release_TransferReleases();
				break;

			case main_region_Divergent_listening_to_release_TransferReleases :
				exitSequence_main_region_Divergent_listening_to_release_TransferReleases();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_top */
	private void exitSequence_main_region_Straight_listening_to_top() {
		switch (stateVector[0]) {
			case main_region_Straight_listening_to_top_Waiting :
				exitSequence_main_region_Straight_listening_to_top_Waiting();
				break;

			case main_region_Straight_listening_to_top_ReservationFromTop :
				exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_straight */
	private void exitSequence_main_region_Straight_listening_to_straight() {
		switch (stateVector[1]) {
			case main_region_Straight_listening_to_straight_Waiting :
				exitSequence_main_region_Straight_listening_to_straight_Waiting();
				break;

			case main_region_Straight_listening_to_straight_ReservationFromStraight :
				exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_occupy */
	private void exitSequence_main_region_Straight_listening_to_occupy() {
		switch (stateVector[2]) {
			case main_region_Straight_listening_to_occupy_Free :
				exitSequence_main_region_Straight_listening_to_occupy_Free();
				break;

			case main_region_Straight_listening_to_occupy_Occupied :
				exitSequence_main_region_Straight_listening_to_occupy_Occupied();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_release */
	private void exitSequence_main_region_Straight_listening_to_release() {
		switch (stateVector[3]) {
			case main_region_Straight_listening_to_release_TransferReleases :
				exitSequence_main_region_Straight_listening_to_release_TransferReleases();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_top */
	private void exitSequence_main_region_Divergent_listening_to_top() {
		switch (stateVector[0]) {
			case main_region_Divergent_listening_to_top_Waiting :
				exitSequence_main_region_Divergent_listening_to_top_Waiting();
				break;

			case main_region_Divergent_listening_to_top_ReservationFromTop :
				exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_divergent */
	private void exitSequence_main_region_Divergent_listening_to_divergent() {
		switch (stateVector[1]) {
			case main_region_Divergent_listening_to_divergent_Waiting :
				exitSequence_main_region_Divergent_listening_to_divergent_Waiting();
				break;

			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent :
				exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_occupy */
	private void exitSequence_main_region_Divergent_listening_to_occupy() {
		switch (stateVector[2]) {
			case main_region_Divergent_listening_to_occupy_Free :
				exitSequence_main_region_Divergent_listening_to_occupy_Free();
				break;

			case main_region_Divergent_listening_to_occupy_Occupied :
				exitSequence_main_region_Divergent_listening_to_occupy_Occupied();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region listening_to_release */
	private void exitSequence_main_region_Divergent_listening_to_release() {
		switch (stateVector[3]) {
			case main_region_Divergent_listening_to_release_TransferReleases :
				exitSequence_main_region_Divergent_listening_to_release_TransferReleases();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_top_Waiting() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}

			if (check_main_region_Straight_listening_to_top_Waiting_tr0_tr0()) {
				effect_main_region_Straight_listening_to_top_Waiting_tr0();
			}
		}
	}

	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Straight_listening_to_top_ReservationFromTop() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}

			if (check_main_region_Straight_listening_to_top_ReservationFromTop_tr0_tr0()) {
				effect_main_region_Straight_listening_to_top_ReservationFromTop_tr0();
			} else {
				if (check_main_region_Straight_listening_to_top_ReservationFromTop_tr1_tr1()) {
					effect_main_region_Straight_listening_to_top_ReservationFromTop_tr1();
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_straight_Waiting() {
		if (check_main_region_Straight_listening_to_straight_Waiting_tr0_tr0()) {
			effect_main_region_Straight_listening_to_straight_Waiting_tr0();
		}
	}

	/* The reactions of state ReservationFromStraight. */
	private void react_main_region_Straight_listening_to_straight_ReservationFromStraight() {
		if (check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0_tr0()) {
			effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0();
		} else {
			if (check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1_tr1()) {
				effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1();
			}
		}
	}

	/* The reactions of state Free. */
	private void react_main_region_Straight_listening_to_occupy_Free() {
		if (check_main_region_Straight_listening_to_occupy_Free_tr0_tr0()) {
			effect_main_region_Straight_listening_to_occupy_Free_tr0();
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_Straight_listening_to_occupy_Occupied() {
		if (check_main_region_Straight_listening_to_occupy_Occupied_tr0_tr0()) {
			effect_main_region_Straight_listening_to_occupy_Occupied_tr0();
		}
	}

	/* The reactions of state TransferReleases. */
	private void react_main_region_Straight_listening_to_release_TransferReleases() {
		if (check_main_region_Straight_listening_to_release_TransferReleases_lr0_lr0()) {
			effect_main_region_Straight_listening_to_release_TransferReleases_lr0_lr0();
		}

		if (check_main_region_Straight_listening_to_release_TransferReleases_lr1_lr1()) {
			effect_main_region_Straight_listening_to_release_TransferReleases_lr1_lr1();
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_top_Waiting() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}

			if (check_main_region_Divergent_listening_to_top_Waiting_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_top_Waiting_tr0();
			}
		}
	}

	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Divergent_listening_to_top_ReservationFromTop() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}

			if (check_main_region_Divergent_listening_to_top_ReservationFromTop_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr0();
			} else {
				if (check_main_region_Divergent_listening_to_top_ReservationFromTop_tr1_tr1()) {
					effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr1();
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_divergent_Waiting() {
		if (check_main_region_Divergent_listening_to_divergent_Waiting_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_divergent_Waiting_tr0();
		}
	}

	/* The reactions of state ReservationFromDivergent. */
	private void react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent() {
		if (check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1_tr1()) {
				effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1();
			}
		}
	}

	/* The reactions of state Free. */
	private void react_main_region_Divergent_listening_to_occupy_Free() {
		if (check_main_region_Divergent_listening_to_occupy_Free_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_occupy_Free_tr0();
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_Divergent_listening_to_occupy_Occupied() {
		if (check_main_region_Divergent_listening_to_occupy_Occupied_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_occupy_Occupied_tr0();
		}
	}

	/* The reactions of state TransferReleases. */
	private void react_main_region_Divergent_listening_to_release_TransferReleases() {
		if (check_main_region_Divergent_listening_to_release_TransferReleases_lr0_lr0()) {
			effect_main_region_Divergent_listening_to_release_TransferReleases_lr0_lr0();
		}

		if (check_main_region_Divergent_listening_to_release_TransferReleases_lr1_lr1()) {
			effect_main_region_Divergent_listening_to_release_TransferReleases_lr1_lr1();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Straight_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_top__entry_Default() {
		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_straight__entry_Default() {
		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_occupy__entry_Default() {
		enterSequence_main_region_Straight_listening_to_occupy_Free_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_release__entry_Default() {
		enterSequence_main_region_Straight_listening_to_release_TransferReleases_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_top__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_divergent__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_occupy__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_occupy_Free_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_release__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_release_TransferReleases_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Straight_listening_to_top_Waiting :
					react_main_region_Straight_listening_to_top_Waiting();
					break;
				case main_region_Straight_listening_to_top_ReservationFromTop :
					react_main_region_Straight_listening_to_top_ReservationFromTop();
					break;
				case main_region_Straight_listening_to_straight_Waiting :
					react_main_region_Straight_listening_to_straight_Waiting();
					break;
				case main_region_Straight_listening_to_straight_ReservationFromStraight :
					react_main_region_Straight_listening_to_straight_ReservationFromStraight();
					break;
				case main_region_Straight_listening_to_occupy_Free :
					react_main_region_Straight_listening_to_occupy_Free();
					break;
				case main_region_Straight_listening_to_occupy_Occupied :
					react_main_region_Straight_listening_to_occupy_Occupied();
					break;
				case main_region_Straight_listening_to_release_TransferReleases :
					react_main_region_Straight_listening_to_release_TransferReleases();
					break;
				case main_region_Divergent_listening_to_top_Waiting :
					react_main_region_Divergent_listening_to_top_Waiting();
					break;
				case main_region_Divergent_listening_to_top_ReservationFromTop :
					react_main_region_Divergent_listening_to_top_ReservationFromTop();
					break;
				case main_region_Divergent_listening_to_divergent_Waiting :
					react_main_region_Divergent_listening_to_divergent_Waiting();
					break;
				case main_region_Divergent_listening_to_divergent_ReservationFromDivergent :
					react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
					break;
				case main_region_Divergent_listening_to_occupy_Free :
					react_main_region_Divergent_listening_to_occupy_Free();
					break;
				case main_region_Divergent_listening_to_occupy_Occupied :
					react_main_region_Divergent_listening_to_occupy_Occupied();
					break;
				case main_region_Divergent_listening_to_release_TransferReleases :
					react_main_region_Divergent_listening_to_release_TransferReleases();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
