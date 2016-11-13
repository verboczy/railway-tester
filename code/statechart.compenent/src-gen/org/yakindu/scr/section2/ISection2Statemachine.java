package org.yakindu.scr.section2;
import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ISection2Statemachine extends IStatemachine {
	public interface SCISection {
		public static final long id = 0;
		public boolean isRaisedEnableSection();
		public long getEnableSectionValue();
		public boolean isRaisedDisableSection();
		public long getId();
		public long getLatestReserveDirection();
		public void setLatestReserveDirection(long value);
		public long getNegatedReserveDirection();
		public void setNegatedReserveDirection(long value);
		public List<SCISectionListener> getListeners();

	}

	public interface SCISectionListener {
		public void onEnableSectionRaised(long value);
		public void onDisableSectionRaised();
	}

	public SCISection getSCISection();

	public interface SCIProtocol {
		public void raiseReserveFromCW();
		public void raiseReserveFromCCW();
		public void raiseCanGoFromCW();
		public void raiseCanGoFromCCW();
		public void raiseCannotGoFromCW();
		public void raiseCannotGoFromCCW();
		public void raiseReleaseFromCW();
		public void raiseReleaseFromCCW();
		public void raiseRestartProtocol();
		public boolean isRaisedReserveToCW();
		public boolean isRaisedReserveToCCW();
		public boolean isRaisedCanGoToCW();
		public boolean isRaisedCanGoToCCW();
		public boolean isRaisedCannotGoToCW();
		public boolean isRaisedCannotGoToCCW();
		public boolean isRaisedReleaseToCW();
		public boolean isRaisedReleaseToCCW();
		public List<SCIProtocolListener> getListeners();

	}

	public interface SCIProtocolListener {
		public void onReserveToCWRaised();
		public void onReserveToCCWRaised();
		public void onCanGoToCWRaised();
		public void onCanGoToCCWRaised();
		public void onCannotGoToCWRaised();
		public void onCannotGoToCCWRaised();
		public void onReleaseToCWRaised();
		public void onReleaseToCCWRaised();
	}

	public SCIProtocol getSCIProtocol();

	public interface SCITrain {
		public void raiseOccupy();
		public void raiseUnoccupy();

	}

	public SCITrain getSCITrain();

	public interface SCIDirection {
		public static final long cW = 0;
		public static final long cCW = 1;
		public static final long uNSPECIFIED = 2;
		public long getCW();
		public long getCCW();
		public long getUNSPECIFIED();

	}

	public SCIDirection getSCIDirection();

}
