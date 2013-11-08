package aun.message;

import aun.update.objectnetwork.Playeruserdata;



public interface MessageConstance {
	
	public static final int SERVER_PORT = 1234;
	
	public static final short FLAG_Gravity = 1;
	public static final short FLAG_Jump = FLAG_Gravity + 1;
	public static final short FLAG_PlayerID = FLAG_Jump + 1;
	public static final short FLAG_MESSAGE_SERVER_SET_PADDLEID = FLAG_PlayerID + 1;
	public static final short FLAG_PlayerID_1 = FLAG_MESSAGE_SERVER_SET_PADDLEID + 1;
	
	public static final short FLAG_MESSAGE_CLIENT_MOVE_PADDLE = 1 ;
	public static final short FLAG_Client = 1;
	
	
	public static final Playeruserdata PLAYER_HOST = new Playeruserdata(0, 1);
	public static final Playeruserdata PLAYER_CLIENT = new Playeruserdata(1, 0);
}
