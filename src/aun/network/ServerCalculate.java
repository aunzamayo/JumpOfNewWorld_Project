package aun.network;

import org.andengine.entity.scene.Scene;

import aun.activity.GameJumpActivity;
import aun.gamephysicsworld.GamePhysicsWorld;

public class ServerCalculate {

	public GamePhysicsWorld gamePhysicsWorld ;
	GameJumpActivity activity ;
	
	public ServerCalculate(GameJumpActivity gm){
		this.activity = gm ;
		gamePhysicsWorld = new GamePhysicsWorld(activity);
//		gamePhysicsWorld.createbodyplayer(activity.getGameObject());
	}
	
	public void simmulatebody(){
		
	}
	
	
	
}
