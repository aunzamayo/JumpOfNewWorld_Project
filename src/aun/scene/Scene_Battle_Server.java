package aun.scene;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import aun.activity.GameJumpActivity;
import aun.message.MessageConstance;
import aun.object.GameObject;
import aun.update.objectnetwork.PlayerClassRoom;
import aun.update.objectnetwork.UpdateServerPlayerMessage;

public class Scene_Battle_Server extends BaseMenuScene implements MessageConstance {

	GameJumpActivity activity ;
	public  GameObject character_client ;
	public GameObject character ;
	public Text  ip_Blue ;
	public Scene_Battle_Server(GameJumpActivity gm, Camera camera) {
		super(gm, camera);	
//		createScene();
		activity = gm ;
		this.createScene();
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Scene createScene() {
        final GameObject room_battle = new GameObject(activity.load.createResource.getTexture(32), activity.getVertexBufferObjectManager(), activity)  ;
        attachChild(room_battle);
        
        character = new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity) {
        	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
	        	final PlayerClassRoom classroomserver = (PlayerClassRoom) activity.mserver.getMessagePool().obtainMessage(FLAG_PlayerID);
				classroomserver.setX(225.0f);
			    classroomserver.setY(200.0f);
			    classroomserver.setIp(activity.getMserverIp()); 
	    		
	    		try {
			   		 activity.mserver.sendBroadcastServerMessage(classroomserver);
					} catch (IOException e) {
						Debug.e(e);
					}
			   	 activity.mserver.getMessagePool().recycleMessage(classroomserver);
//        		character.setPosition(100, 100);
	        	
	    		return true ;
        	} 
        };
        attachChild(character);
        character.setScale(3.5f);
        character.setPosition(225, 200 );
        
        final Text  ip  = new Text(0, 0,activity.load.getFont(), "Ip" + " " + activity.getIpwifi() , new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
        ip.setPosition(20,305);
        attachChild(ip);
	    ip.setScale(0.75f);
	    ip.setColor(Color.RED);
	    
	    character_client = new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
        
	    attachChild(character_client);
        character_client.setScale(3.5f);
        registerTouchArea(character);
		setTouchAreaBindingOnActionDownEnabled(true);
        
        ip_Blue  = new Text(0, 0,activity.load.getFont(), "Ip" + " "  , new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
        ip_Blue.setPosition(20,605);
        attachChild(ip_Blue);
        ip_Blue.setScale(0.75f);
        ip_Blue.setColor(Color.BLUE);			
  
    
	    

//        
	   	 return this;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScene(Scene sc) {
		// TODO Auto-generated method stub
		
	}

}
