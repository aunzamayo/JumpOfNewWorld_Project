package aun.manager;

import org.andengine.entity.scene.Scene;

import aun.activity.GameJumpActivity;

public class GameObjectManager {

	private Scene scene ;
	GameJumpActivity activity ;
	
//	PlayerManager playermanager ;
	public GameObjectManager(GameJumpActivity gm) {
		this.activity = gm ;
//		playermanager = new PlayerManager(activity);
	
	}

    public void createGameObject(){
    	
    	
    	
    }
    
    public void setscene(Scene scene){
    	this.scene = scene ;
    }
    public Scene getScene(){
    	return scene ;
    }
	
	
}
