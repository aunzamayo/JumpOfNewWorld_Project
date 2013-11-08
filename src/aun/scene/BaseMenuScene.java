package aun.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import aun.activity.GameJumpActivity;

public abstract class BaseMenuScene extends Scene implements IOnMenuItemClickListener{

	GameJumpActivity activity ;
	MenuScene menuscene ;
//	public OUT_GAME typestate ;
	public BaseMenuScene(GameJumpActivity gm , Camera camera) {
		activity = gm ;
		menuscene = new MenuScene(camera);
//		typestate = OUT_GAME.fistmenugame;
	}
	public abstract Scene createScene();
	public abstract void Update();
	public abstract Scene getScene();
	public abstract void setScene(Scene sc);
	
	
	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {

        Update();
		super.onManagedUpdate(pSecondsElapsed);
	}
//    public enum OUT_GAME{
//		
//	    fistmenugame 
//	    
//	}
	
}
