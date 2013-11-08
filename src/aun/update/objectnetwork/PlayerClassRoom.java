package aun.update.objectnetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;

import aun.message.MessageConstance;

public class PlayerClassRoom extends ServerMessage implements MessageConstance {
	public float mX;
	public float mY;
	public int mPlayerID ;
	public String Ip_Server = " " ;
	
	public PlayerClassRoom() {
		// TODO Auto-generated constructor stub
	}
	public PlayerClassRoom(int mPlayerID ,  float mX,float mY , String Ip_Server) {
		this.mPlayerID = mPlayerID ;
		this.mX = mX ;
		this.mY = mY ;
		this.Ip_Server = Ip_Server ;
	}

	@Override
	public short getFlag() {
		
		return FLAG_PlayerID;
	}
	
	public void setY(final float pY) {	
		this.mY = pY;
	}
	public void setX(final float pX) {
		this.mX = pX;
	
	}
	public void setIp(final String Ip_Server) {
		this.Ip_Server = Ip_Server ;
	
	}
	
	@Override
	protected void onReadTransmissionData(DataInputStream pDataInputStream)
			throws IOException {
		this.mX = pDataInputStream.readFloat();
		this.mY = pDataInputStream.readFloat();
		this.Ip_Server = pDataInputStream.readUTF();
	}

	@Override
	protected void onWriteTransmissionData(DataOutputStream pDataOutputStream)
			throws IOException {
		pDataOutputStream.writeFloat(this.mX);
		pDataOutputStream.writeFloat(this.mY);
		pDataOutputStream.writeUTF(this.Ip_Server);
	}


			
}
