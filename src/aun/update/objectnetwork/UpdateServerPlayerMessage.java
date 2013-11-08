package aun.update.objectnetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;
import aun.message.MessageConstance;

public class UpdateServerPlayerMessage extends ServerMessage implements MessageConstance {
    
	public float mX;
	public float mY;
	public int mPlayerID ;
	public UpdateServerPlayerMessage() {
		// TODO Auto-generated constructor stub
	}
	public UpdateServerPlayerMessage(int mPlayerID ,  float mX,float mY) {
		this.mPlayerID = mPlayerID ;
		this.mX = mX ;
		this.mY = mY ;
	}

	@Override
	public short getFlag() {
		
		return FLAG_Gravity;
	}
	
	public void setY(final float pY) {	
		this.mY = pY;
	}
	public void setX(final float pX) {
		this.mX = pX;
	
	}
	@Override
	protected void onReadTransmissionData(DataInputStream pDataInputStream)
			throws IOException {
		this.mX = pDataInputStream.readFloat();
		this.mY = pDataInputStream.readFloat();
		
	}

	@Override
	protected void onWriteTransmissionData(DataOutputStream pDataOutputStream)
			throws IOException {
		pDataOutputStream.writeFloat(this.mX);
		pDataOutputStream.writeFloat(this.mY);
		
	}

}
