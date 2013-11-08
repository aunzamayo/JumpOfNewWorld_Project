package aun.update.objectnetwork;

public class Playeruserdata {
	
	
	// ===========================================================
		// Constants
		// ===========================================================

		// ===========================================================
		// Fields
		// ===========================================================

		private final int mOwnerID;
		private final int mOpponentID;

		// ===========================================================
		// Constructors
		// ===========================================================

		public Playeruserdata(final int pOwnerID, final int pOpponentID) {
			this.mOwnerID = pOwnerID;
			this.mOpponentID = pOpponentID;
		}

		// ===========================================================
		// Getter & Setter
		// ===========================================================

		public int getOwnerID() {
			return this.mOwnerID;
		}

		public int getOpponentID() {
			return this.mOpponentID;
		}
		
		

		// ===========================================================
		// Methods for/from SuperClass/Interfaces
		// ===========================================================

		// ===========================================================
		// Methods
		// ===========================================================

		// ===========================================================
		// Inner and Anonymous Classes
		// ===========================================================
	
}
