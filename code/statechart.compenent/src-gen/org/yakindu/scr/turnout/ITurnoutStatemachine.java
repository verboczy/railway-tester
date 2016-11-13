package org.yakindu.scr.turnout;
import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ITurnoutStatemachine extends IStatemachine {
	public interface SCITurnout {
		public static final long id = 0;
		public void raiseTurnoutStraight();
		public void raiseTurnoutDivergent();
		public long getId();

	}

	public SCITurnout getSCITurnout();

	public interface SCIProtocol {
		public void raiseReserveFromTop();
		public void raiseReserveFromStraight();
		public void raiseReserveFromDivergent();
		public void raiseCanGoFromTop();
		public void raiseCanGoFromStraight();
		public void raiseCanGoFromDivergent();
		public void raiseCannotGoFromTop();
		public void raiseCannotGoFromStraight();
		public void raiseCannotGoFromDivergent();
		public void raiseReleaseFromTop();
		public void raiseReleaseFromStraight();
		public void raiseReleaseFromDivergent();
		public boolean isRaisedReserveToTop();
		public boolean isRaisedReserveToStraight();
		public boolean isRaisedReserveToDivergent();
		public boolean isRaisedCanGoToTop();
		public boolean isRaisedCanGoToStraight();
		public boolean isRaisedCanGoToDivergent();
		public boolean isRaisedCannotGoToTop();
		public boolean isRaisedCannotGoToStraight();
		public boolean isRaisedCannotGoToDivergent();
		public boolean isRaisedReleaseToTop();
		public boolean isRaisedReleaseToStraight();
		public boolean isRaisedReleaseToDivergent();
		public List<SCIProtocolListener> getListeners();

	}

	public interface SCIProtocolListener {
		public void onReserveToTopRaised();
		public void onReserveToStraightRaised();
		public void onReserveToDivergentRaised();
		public void onCanGoToTopRaised();
		public void onCanGoToStraightRaised();
		public void onCanGoToDivergentRaised();
		public void onCannotGoToTopRaised();
		public void onCannotGoToStraightRaised();
		public void onCannotGoToDivergentRaised();
		public void onReleaseToTopRaised();
		public void onReleaseToStraightRaised();
		public void onReleaseToDivergentRaised();
	}

	public SCIProtocol getSCIProtocol();

	public interface SCITrain {
		public void raiseOccupy();
		public void raiseUnoccupy();

	}

	public SCITrain getSCITrain();

	public interface SCIDirection {
		public static final long tOP = 0;
		public static final long sTRAIGHT = 1;
		public static final long dIVERGENT = 2;
		public static final long uNSPECIFIED = 3;
		public long getTOP();
		public long getSTRAIGHT();
		public long getDIVERGENT();
		public long getUNSPECIFIED();

	}

	public SCIDirection getSCIDirection();

}
