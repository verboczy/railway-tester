package org.yakindu.scr.section2;
import java.util.LinkedList;
import java.util.List;

public class Section2Statemachine implements ISection2Statemachine {

	protected class SCISectionImpl implements SCISection {

		private List<SCISectionListener> listeners = new LinkedList<SCISectionListener>();

		public List<SCISectionListener> getListeners() {
			return listeners;
		}

		private boolean enableSection;

		private long enableSectionValue;

		public boolean isRaisedEnableSection() {
			return enableSection;
		}

		protected void raiseEnableSection(long value) {
			enableSection = true;
			enableSectionValue = value;
			for (SCISectionListener listener : listeners) {
				listener.onEnableSectionRaised(value);
			}
		}

		public long getEnableSectionValue() {
			if (!enableSection)
				throw new IllegalStateException("Illegal event value access. Event EnableSection is not raised!");
			return enableSectionValue;
		}

		private boolean disableSection;

		public boolean isRaisedDisableSection() {
			return disableSection;
		}

		protected void raiseDisableSection() {
			disableSection = true;
			for (SCISectionListener listener : listeners) {
				listener.onDisableSectionRaised();
			}
		}

		public long getId() {
			return id;
		}

		private long latestReserveDirection;

		public long getLatestReserveDirection() {
			return latestReserveDirection;
		}

		public void setLatestReserveDirection(long value) {
			this.latestReserveDirection = value;
		}

		private long negatedReserveDirection;

		public long getNegatedReserveDirection() {
			return negatedReserveDirection;
		}

		public void setNegatedReserveDirection(long value) {
			this.negatedReserveDirection = value;
		}

		protected void clearEvents() {
		}

		protected void clearOutEvents() {
			enableSection = false;
			disableSection = false;
		}
	}

	protected SCISectionImpl sCISection;

	protected class SCIProtocolImpl implements SCIProtocol {

		private List<SCIProtocolListener> listeners = new LinkedList<SCIProtocolListener>();

		public List<SCIProtocolListener> getListeners() {
			return listeners;
		}

		private boolean reserveFromCW;

		public void raiseReserveFromCW() {
			reserveFromCW = true;
		}

		private boolean reserveFromCCW;

		public void raiseReserveFromCCW() {
			reserveFromCCW = true;
		}

		private boolean canGoFromCW;

		public void raiseCanGoFromCW() {
			canGoFromCW = true;
		}

		private boolean canGoFromCCW;

		public void raiseCanGoFromCCW() {
			canGoFromCCW = true;
		}

		private boolean cannotGoFromCW;

		public void raiseCannotGoFromCW() {
			cannotGoFromCW = true;
		}

		private boolean cannotGoFromCCW;

		public void raiseCannotGoFromCCW() {
			cannotGoFromCCW = true;
		}

		private boolean releaseFromCW;

		public void raiseReleaseFromCW() {
			releaseFromCW = true;
		}

		private boolean releaseFromCCW;

		public void raiseReleaseFromCCW() {
			releaseFromCCW = true;
		}

		private boolean restartProtocol;

		public void raiseRestartProtocol() {
			restartProtocol = true;
		}

		private boolean reserveToCW;

		public boolean isRaisedReserveToCW() {
			return reserveToCW;
		}

		protected void raiseReserveToCW() {
			reserveToCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToCWRaised();
			}
		}

		private boolean reserveToCCW;

		public boolean isRaisedReserveToCCW() {
			return reserveToCCW;
		}

		protected void raiseReserveToCCW() {
			reserveToCCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToCCWRaised();
			}
		}

		private boolean canGoToCW;

		public boolean isRaisedCanGoToCW() {
			return canGoToCW;
		}

		protected void raiseCanGoToCW() {
			canGoToCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToCWRaised();
			}
		}

		private boolean canGoToCCW;

		public boolean isRaisedCanGoToCCW() {
			return canGoToCCW;
		}

		protected void raiseCanGoToCCW() {
			canGoToCCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToCCWRaised();
			}
		}

		private boolean cannotGoToCW;

		public boolean isRaisedCannotGoToCW() {
			return cannotGoToCW;
		}

		protected void raiseCannotGoToCW() {
			cannotGoToCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToCWRaised();
			}
		}

		private boolean cannotGoToCCW;

		public boolean isRaisedCannotGoToCCW() {
			return cannotGoToCCW;
		}

		protected void raiseCannotGoToCCW() {
			cannotGoToCCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToCCWRaised();
			}
		}

		private boolean releaseToCW;

		public boolean isRaisedReleaseToCW() {
			return releaseToCW;
		}

		protected void raiseReleaseToCW() {
			releaseToCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToCWRaised();
			}
		}

		private boolean releaseToCCW;

		public boolean isRaisedReleaseToCCW() {
			return releaseToCCW;
		}

		protected void raiseReleaseToCCW() {
			releaseToCCW = true;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToCCWRaised();
			}
		}

		protected void clearEvents() {
			reserveFromCW = false;
			reserveFromCCW = false;
			canGoFromCW = false;
			canGoFromCCW = false;
			cannotGoFromCW = false;
			cannotGoFromCCW = false;
			releaseFromCW = false;
			releaseFromCCW = false;
			restartProtocol = false;
		}

		protected void clearOutEvents() {
			reserveToCW = false;
			reserveToCCW = false;
			canGoToCW = false;
			canGoToCCW = false;
			cannotGoToCW = false;
			cannotGoToCCW = false;
			releaseToCW = false;
			releaseToCCW = false;
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

		public long getCW() {
			return cW;
		}

		public long getCCW() {
			return cCW;
		}

		public long getUNSPECIFIED() {
			return uNSPECIFIED;
		}

	}

	protected SCIDirectionImpl sCIDirection;

	private boolean initialized = false;

	public enum State {
		main_Free, main_Reserved, main_Occupied, main_Stop, main_Locking_protocol, main_Locking_protocol_inner_region_WaitForFirstResponse, main_Locking_protocol_inner_region_WaitForSecondResponse, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public Section2Statemachine() {

		sCISection = new SCISectionImpl();
		sCIProtocol = new SCIProtocolImpl();
		sCITrain = new SCITrainImpl();
		sCIDirection = new SCIDirectionImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCISection.setLatestReserveDirection(0);

		sCISection.setNegatedReserveDirection(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		enterSequence_main_default();
	}

	public void exit() {
		exitSequence_main();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
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
		sCISection.clearEvents();
		sCIProtocol.clearEvents();
		sCITrain.clearEvents();

	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCISection.clearOutEvents();
		sCIProtocol.clearOutEvents();
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_Free :
				return stateVector[0] == State.main_Free;
			case main_Reserved :
				return stateVector[0] == State.main_Reserved;
			case main_Occupied :
				return stateVector[0] == State.main_Occupied;
			case main_Stop :
				return stateVector[0] == State.main_Stop;
			case main_Locking_protocol :
				return stateVector[0].ordinal() >= State.main_Locking_protocol.ordinal() && stateVector[0]
						.ordinal() <= State.main_Locking_protocol_inner_region_WaitForSecondResponse.ordinal();
			case main_Locking_protocol_inner_region_WaitForFirstResponse :
				return stateVector[0] == State.main_Locking_protocol_inner_region_WaitForFirstResponse;
			case main_Locking_protocol_inner_region_WaitForSecondResponse :
				return stateVector[0] == State.main_Locking_protocol_inner_region_WaitForSecondResponse;
			default :
				return false;
		}
	}

	public SCISection getSCISection() {
		return sCISection;
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

	private boolean check_main_Free_tr0_tr0() {
		return sCIProtocol.reserveFromCW;
	}

	private boolean check_main_Free_tr1_tr1() {
		return sCIProtocol.reserveFromCCW;
	}

	private boolean check_main_Free_tr2_tr2() {
		return sCITrain.occupy;
	}

	private boolean check_main_Reserved_tr0_tr0() {
		return sCITrain.occupy;
	}

	private boolean check_main_Reserved_tr1_tr1() {
		return (sCIProtocol.releaseFromCW) && (sCIDirection.cW == sCISection.latestReserveDirection);
	}

	private boolean check_main_Reserved_tr2_tr2() {
		return (sCIProtocol.releaseFromCCW) && (sCIDirection.cCW == sCISection.latestReserveDirection);
	}

	private boolean check_main_Reserved_lr0_lr0() {
		return (sCIProtocol.reserveFromCW) && (sCIDirection.cW == sCISection.latestReserveDirection);
	}

	private boolean check_main_Reserved_lr1_lr1() {
		return (sCIProtocol.reserveFromCCW) && (sCIDirection.cCW == sCISection.latestReserveDirection);
	}

	private boolean check_main_Reserved_lr2_lr2() {
		return (sCIProtocol.reserveFromCW) && (sCIDirection.cW != sCISection.latestReserveDirection);
	}

	private boolean check_main_Reserved_lr3_lr3() {
		return (sCIProtocol.reserveFromCCW) && (sCIDirection.cCW != sCISection.latestReserveDirection);
	}

	private boolean check_main_Occupied_tr0_tr0() {
		return sCITrain.unoccupy;
	}

	private boolean check_main_Occupied_tr1_tr1() {
		return sCIProtocol.cannotGoFromCCW;
	}

	private boolean check_main_Occupied_tr2_tr2() {
		return sCIProtocol.cannotGoFromCW;
	}

	private boolean check_main_Occupied_lr1_lr1() {
		return sCIProtocol.reserveFromCCW;
	}

	private boolean check_main_Occupied_lr2_lr2() {
		return sCIProtocol.reserveFromCW;
	}

	private boolean check_main_Occupied_lr3_lr3() {
		return sCIProtocol.releaseFromCCW;
	}

	private boolean check_main_Occupied_lr4_lr4() {
		return sCIProtocol.releaseFromCW;
	}

	private boolean check_main_Stop_tr0_tr0() {
		return sCITrain.unoccupy;
	}

	private boolean check_main_Stop_tr1_tr1() {
		return sCIProtocol.releaseFromCCW;
	}

	private boolean check_main_Stop_tr2_tr2() {
		return sCIProtocol.releaseFromCW;
	}

	private boolean check_main_Stop_tr3_tr3() {
		return sCIProtocol.restartProtocol;
	}

	private boolean check_main_Stop_lr1_lr1() {
		return sCIProtocol.reserveFromCW;
	}

	private boolean check_main_Stop_lr2_lr2() {
		return sCIProtocol.reserveFromCCW;
	}

	private boolean check_main_Locking_protocol_tr0_tr0() {
		return sCIProtocol.reserveFromCW;
	}

	private boolean check_main_Locking_protocol_tr1_tr1() {
		return sCIProtocol.reserveFromCCW;
	}

	private boolean check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0_tr0() {
		return sCIProtocol.canGoFromCW;
	}

	private boolean check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1_tr1() {
		return sCIProtocol.cannotGoFromCW;
	}

	private boolean check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0_tr0() {
		return sCIProtocol.canGoFromCCW;
	}

	private boolean check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1_tr1() {
		return sCIProtocol.cannotGoFromCCW;
	}

	private void effect_main_Free_tr0() {
		exitSequence_main_Free();

		sCIProtocol.raiseCanGoToCW();

		sCISection.setLatestReserveDirection(sCIDirection.cW);

		sCISection.setNegatedReserveDirection(sCIDirection.cCW);

		enterSequence_main_Reserved_default();
	}

	private void effect_main_Free_tr1() {
		exitSequence_main_Free();

		sCIProtocol.raiseCanGoToCCW();

		sCISection.setLatestReserveDirection(sCIDirection.cCW);

		sCISection.setNegatedReserveDirection(sCIDirection.cW);

		enterSequence_main_Reserved_default();
	}

	private void effect_main_Free_tr2() {
		exitSequence_main_Free();

		enterSequence_main_Locking_protocol_default();
	}

	private void effect_main_Reserved_tr0() {
		exitSequence_main_Reserved();

		enterSequence_main_Locking_protocol_default();
	}

	private void effect_main_Reserved_tr1() {
		exitSequence_main_Reserved();

		enterSequence_main_Free_default();
	}

	private void effect_main_Reserved_tr2() {
		exitSequence_main_Reserved();

		enterSequence_main_Free_default();
	}

	private void effect_main_Reserved_lr0_lr0() {
		sCIProtocol.raiseCanGoToCW();
	}

	private void effect_main_Reserved_lr1_lr1() {
		sCIProtocol.raiseCanGoToCCW();
	}

	private void effect_main_Reserved_lr2_lr2() {
		sCIProtocol.raiseCannotGoToCW();
	}

	private void effect_main_Reserved_lr3_lr3() {
		sCIProtocol.raiseCannotGoToCCW();
	}

	private void effect_main_Occupied_tr0() {
		exitSequence_main_Occupied();

		sCIProtocol.raiseReleaseToCW();

		sCIProtocol.raiseReleaseToCCW();

		enterSequence_main_Free_default();
	}

	private void effect_main_Occupied_tr1() {
		exitSequence_main_Occupied();

		enterSequence_main_Stop_default();
	}

	private void effect_main_Occupied_tr2() {
		exitSequence_main_Occupied();

		enterSequence_main_Stop_default();
	}

	private void effect_main_Occupied_lr1_lr1() {
		sCIProtocol.raiseCanGoToCCW();
	}

	private void effect_main_Occupied_lr2_lr2() {
		sCIProtocol.raiseCanGoToCW();
	}

	private void effect_main_Occupied_lr3_lr3() {
		sCIProtocol.raiseReserveToCCW();
	}

	private void effect_main_Occupied_lr4_lr4() {
		sCIProtocol.raiseReserveToCW();
	}

	private void effect_main_Stop_tr0() {
		exitSequence_main_Stop();

		sCIProtocol.raiseReleaseToCW();

		sCIProtocol.raiseReleaseToCCW();

		enterSequence_main_Free_default();
	}

	private void effect_main_Stop_tr1() {
		exitSequence_main_Stop();

		enterSequence_main_Locking_protocol_default();
	}

	private void effect_main_Stop_tr2() {
		exitSequence_main_Stop();

		enterSequence_main_Locking_protocol_default();
	}

	private void effect_main_Stop_tr3() {
		exitSequence_main_Stop();

		enterSequence_main_Locking_protocol_default();
	}

	private void effect_main_Stop_lr1_lr1() {
		sCIProtocol.raiseCannotGoToCW();
	}

	private void effect_main_Stop_lr2_lr2() {
		sCIProtocol.raiseCannotGoToCCW();
	}

	private void effect_main_Locking_protocol_tr0() {
		exitSequence_main_Locking_protocol();

		sCIProtocol.raiseCannotGoToCW();

		enterSequence_main_Stop_default();
	}

	private void effect_main_Locking_protocol_tr1() {
		exitSequence_main_Locking_protocol();

		sCIProtocol.raiseCannotGoToCCW();

		enterSequence_main_Stop_default();
	}

	private void effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0() {
		exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();

		enterSequence_main_Locking_protocol_inner_region_WaitForSecondResponse_default();
	}

	private void effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1() {
		exitSequence_main_Locking_protocol();

		sCIProtocol.raiseReserveToCCW();

		enterSequence_main_Stop_default();
	}

	private void effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0() {
		exitSequence_main_Locking_protocol();

		enterSequence_main_Occupied_default();
	}

	private void effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1() {
		exitSequence_main_Locking_protocol();

		enterSequence_main_Stop_default();
	}

	/* Entry action for state 'Free'. */
	private void entryAction_main_Free() {
		sCISection.raiseEnableSection(sCISection.id);

		sCISection.setLatestReserveDirection(sCIDirection.uNSPECIFIED);

		sCISection.setNegatedReserveDirection(sCIDirection.uNSPECIFIED);
	}

	/* Entry action for state 'Occupied'. */
	private void entryAction_main_Occupied() {
		sCISection.raiseEnableSection(sCISection.id);
	}

	/* Entry action for state 'Stop'. */
	private void entryAction_main_Stop() {
		sCISection.raiseDisableSection();
	}

	/* Entry action for state 'WaitForFirstResponse'. */
	private void entryAction_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		sCIProtocol.raiseReserveToCW();
	}

	/* Entry action for state 'WaitForSecondResponse'. */
	private void entryAction_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		sCIProtocol.raiseReserveToCCW();
	}

	/* 'default' enter sequence for state Free */
	private void enterSequence_main_Free_default() {
		entryAction_main_Free();

		nextStateIndex = 0;
		stateVector[0] = State.main_Free;
	}

	/* 'default' enter sequence for state Reserved */
	private void enterSequence_main_Reserved_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_Reserved;
	}

	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_Occupied_default() {
		entryAction_main_Occupied();

		nextStateIndex = 0;
		stateVector[0] = State.main_Occupied;
	}

	/* 'default' enter sequence for state Stop */
	private void enterSequence_main_Stop_default() {
		entryAction_main_Stop();

		nextStateIndex = 0;
		stateVector[0] = State.main_Stop;
	}

	/* 'default' enter sequence for state Locking protocol */
	private void enterSequence_main_Locking_protocol_default() {
		enterSequence_main_Locking_protocol_inner_region_default();
	}

	/* 'default' enter sequence for state WaitForFirstResponse */
	private void enterSequence_main_Locking_protocol_inner_region_WaitForFirstResponse_default() {
		entryAction_main_Locking_protocol_inner_region_WaitForFirstResponse();

		nextStateIndex = 0;
		stateVector[0] = State.main_Locking_protocol_inner_region_WaitForFirstResponse;
	}

	/* 'default' enter sequence for state WaitForSecondResponse */
	private void enterSequence_main_Locking_protocol_inner_region_WaitForSecondResponse_default() {
		entryAction_main_Locking_protocol_inner_region_WaitForSecondResponse();

		nextStateIndex = 0;
		stateVector[0] = State.main_Locking_protocol_inner_region_WaitForSecondResponse;
	}

	/* 'default' enter sequence for region main */
	private void enterSequence_main_default() {
		react_main__entry_Default();
	}

	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_Locking_protocol_inner_region_default() {
		react_main_Locking_protocol_inner_region__entry_Default();
	}

	/* Default exit sequence for state Free */
	private void exitSequence_main_Free() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Reserved */
	private void exitSequence_main_Reserved() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Occupied */
	private void exitSequence_main_Occupied() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Stop */
	private void exitSequence_main_Stop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Locking protocol */
	private void exitSequence_main_Locking_protocol() {
		exitSequence_main_Locking_protocol_inner_region();
	}

	/* Default exit sequence for state WaitForFirstResponse */
	private void exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state WaitForSecondResponse */
	private void exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main */
	private void exitSequence_main() {
		switch (stateVector[0]) {
			case main_Free :
				exitSequence_main_Free();
				break;

			case main_Reserved :
				exitSequence_main_Reserved();
				break;

			case main_Occupied :
				exitSequence_main_Occupied();
				break;

			case main_Stop :
				exitSequence_main_Stop();
				break;

			case main_Locking_protocol_inner_region_WaitForFirstResponse :
				exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();
				break;

			case main_Locking_protocol_inner_region_WaitForSecondResponse :
				exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region inner region */
	private void exitSequence_main_Locking_protocol_inner_region() {
		switch (stateVector[0]) {
			case main_Locking_protocol_inner_region_WaitForFirstResponse :
				exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();
				break;

			case main_Locking_protocol_inner_region_WaitForSecondResponse :
				exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Free. */
	private void react_main_Free() {
		if (check_main_Free_tr0_tr0()) {
			effect_main_Free_tr0();
		} else {
			if (check_main_Free_tr1_tr1()) {
				effect_main_Free_tr1();
			} else {
				if (check_main_Free_tr2_tr2()) {
					effect_main_Free_tr2();
				}
			}
		}
	}

	/* The reactions of state Reserved. */
	private void react_main_Reserved() {
		if (check_main_Reserved_tr0_tr0()) {
			effect_main_Reserved_tr0();
		} else {
			if (check_main_Reserved_tr1_tr1()) {
				effect_main_Reserved_tr1();
			} else {
				if (check_main_Reserved_tr2_tr2()) {
					effect_main_Reserved_tr2();
				} else {
					if (check_main_Reserved_lr0_lr0()) {
						effect_main_Reserved_lr0_lr0();
					}

					if (check_main_Reserved_lr1_lr1()) {
						effect_main_Reserved_lr1_lr1();
					}

					if (check_main_Reserved_lr2_lr2()) {
						effect_main_Reserved_lr2_lr2();
					}

					if (check_main_Reserved_lr3_lr3()) {
						effect_main_Reserved_lr3_lr3();
					}
				}
			}
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_Occupied() {
		if (check_main_Occupied_tr0_tr0()) {
			effect_main_Occupied_tr0();
		} else {
			if (check_main_Occupied_tr1_tr1()) {
				effect_main_Occupied_tr1();
			} else {
				if (check_main_Occupied_tr2_tr2()) {
					effect_main_Occupied_tr2();
				} else {
					if (check_main_Occupied_lr1_lr1()) {
						effect_main_Occupied_lr1_lr1();
					}

					if (check_main_Occupied_lr2_lr2()) {
						effect_main_Occupied_lr2_lr2();
					}

					if (check_main_Occupied_lr3_lr3()) {
						effect_main_Occupied_lr3_lr3();
					}

					if (check_main_Occupied_lr4_lr4()) {
						effect_main_Occupied_lr4_lr4();
					}
				}
			}
		}
	}

	/* The reactions of state Stop. */
	private void react_main_Stop() {
		if (check_main_Stop_tr0_tr0()) {
			effect_main_Stop_tr0();
		} else {
			if (check_main_Stop_tr1_tr1()) {
				effect_main_Stop_tr1();
			} else {
				if (check_main_Stop_tr2_tr2()) {
					effect_main_Stop_tr2();
				} else {
					if (check_main_Stop_tr3_tr3()) {
						effect_main_Stop_tr3();
					} else {
						if (check_main_Stop_lr1_lr1()) {
							effect_main_Stop_lr1_lr1();
						}

						if (check_main_Stop_lr2_lr2()) {
							effect_main_Stop_lr2_lr2();
						}
					}
				}
			}
		}
	}

	/* The reactions of state WaitForFirstResponse. */
	private void react_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		if (check_main_Locking_protocol_tr0_tr0()) {
			effect_main_Locking_protocol_tr0();
		} else {
			if (check_main_Locking_protocol_tr1_tr1()) {
				effect_main_Locking_protocol_tr1();
			} else {
				if (check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0_tr0()) {
					effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0();
				} else {
					if (check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1_tr1()) {
						effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1();
					}
				}
			}
		}
	}

	/* The reactions of state WaitForSecondResponse. */
	private void react_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		if (check_main_Locking_protocol_tr0_tr0()) {
			effect_main_Locking_protocol_tr0();
		} else {
			if (check_main_Locking_protocol_tr1_tr1()) {
				effect_main_Locking_protocol_tr1();
			} else {
				if (check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0_tr0()) {
					effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0();
				} else {
					if (check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1_tr1()) {
						effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1();
					}
				}
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main__entry_Default() {
		enterSequence_main_Free_default();
	}

	/* Default react sequence for initial entry  */
	private void react_main_Locking_protocol_inner_region__entry_Default() {
		enterSequence_main_Locking_protocol_inner_region_WaitForFirstResponse_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_Free :
					react_main_Free();
					break;
				case main_Reserved :
					react_main_Reserved();
					break;
				case main_Occupied :
					react_main_Occupied();
					break;
				case main_Stop :
					react_main_Stop();
					break;
				case main_Locking_protocol_inner_region_WaitForFirstResponse :
					react_main_Locking_protocol_inner_region_WaitForFirstResponse();
					break;
				case main_Locking_protocol_inner_region_WaitForSecondResponse :
					react_main_Locking_protocol_inner_region_WaitForSecondResponse();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
