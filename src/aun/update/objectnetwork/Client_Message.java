package aun.update.objectnetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;

import aun.message.MessageConstance;



public class Client_Message extends ClientMessage implements MessageConstance  {

	public int mPaddleID;
	public float mY;
	public float mX;
	
	public Client_Message() {

	}

	public Client_Message(final int pID, final float pX, final float pY) {
		this.mPaddleID = pID;
		this.mY = pY;
		this.mX = pX;
	}
	
	public short getFlag() {
		// TODO Auto-generated method stub
		return FLAG_Client;
	}
	public void setY(float mY){
		this.mY = mY ;
	}
	public void setX(float mX){
		this.mX = mX ;
	}
	public float getY(){
		return mY ;
	}
	public float grtX(){
		return mX;
	}
	
	@Override
	protected void onReadTransmissionData(DataInputStream pDataInputStream)
			throws IOException {
		
		this.mPaddleID = pDataInputStream.readInt();
		this.mY = pDataInputStream.readFloat();
		this.mX = pDataInputStream.readFloat();
	}

	@Override
	protected void onWriteTransmissionData(DataOutputStream pDataOutputStream)
			throws IOException {
		pDataOutputStream.writeInt(this.mPaddleID);
		pDataOutputStream.writeFloat(this.mY);
		pDataOutputStream.writeFloat(this.mX);
	}

}