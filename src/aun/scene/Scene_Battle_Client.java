package aun.scene;

import java.io.DataOutputStream;
import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.score.Score;
import aun.update.objectnetwork.Client_Message;
import aun.update.objectnetwork.PlayerClassRoom;
import aun.update.objectnetwork.UpdatePlayerServerTest;

public class Scene_Battle_Client extends BaseMenuScene {

	GameJumpActivity activity ;
	public  GameObject character_server ;
	public Text  ip ;
	public Score ip_server ;
	Client_Message cc ;
	public GameObject character ;
	public Scene_Battle_Client(GameJumpActivity gm, Camera camera) {
		super(gm, camera);		
		cc = new Client_Message(1, 50, 50);	
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
        
           character = new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity){
        		
        	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
        		try {
        			
        			cc.setX(pSceneTouchEvent.getX() - this.getWidth() / 2);
        			cc.setY(pSceneTouchEvent.getY() - this.getHeight() / 2);
//					setPosition(pSceneTouchEvent.getX() - this.getWidth() / 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
        			activity.mServerConnector.sendClientMessage(cc);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//        		final UpdatePlayerServerTest classroomserver = (UpdatePlayerServerTest) activity.mserver.getMessagePool().obtainMessage(FLAG_PlayerID_1);
//        		classroomserver.setX(cc.grtX());
//			    classroomserver.setY(cc.getY());
//			    try {
//					activity.mserver.sendBroadcastServerMessage(classroomserver);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//        		final Client_Message client_message = (Client_Message) activity.mServerConnector.getMessagePool().obtainMessage(FLAG_Client);
//        		 this.setPosition(50, 500);
//        		activity.mServerConnector.s
//        		client_message.setX(105.0f);
//        		client_message.setY(200.0f);
//			    classroomserver.setIp(activity.mServerConnector.getConnection().getSocket().getInetAddress().getHostName());
        		return true ;
        	}
        };
        attachChild(character);
        character.setScale(3.5f);
        character.setPosition(225,500);
        
        ip  = new Text(0, 0,activity.load.getFont(), "Ip" + " " + activity.getIpwifi() , new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
        ip.setPosition(20,605);
        attachChild(ip);
	    ip.setScale(0.75f);
	    ip.setColor(Color.BLUE);
	    
	    ip_server  = new Score(0,0, activity.load.getFont(),"Ip" + "", 100, activity.getVertexBufferObjectManager());
	    ip_server.setPosition(20,305);
        attachChild(ip_server);
        ip_server.setScale(0.75f);
        ip_server.setColor(Color.RED);
	    
        
	    character_server = new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity){
	    	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
	    		final PlayerClassRoom classroomserver = (PlayerClassRoom) activity.mserver.getMessagePool().obtainMessage(FLAG_PlayerID);
	    		classroomserver.setX(pSceneTouchEvent.getX() - this.getWidth() / 2);
			    classroomserver.setY(pSceneTouchEvent.getY() - this.getHeight() / 2);
//			    classroomserver.setIp(activity.mServerConnector.getConnection().getSocket().getInetAddress().getHostName()); 
	    		
	    		try {
			   		 activity.mserver.sendBroadcastServerMessage(classroomserver);
					} catch (IOException e) {
						Debug.e(e);
					}
			   	 activity.mserver.getMessagePool().recycleMessage(classroomserver);
	    		
	    		return true ;
	    	}
	    };
        attachChild(character_server);
        character_server.setScale(3.5f);
        character_server.setPosition(225, 200 );
        registerTouchArea(character_server);
        registerTouchArea(character);
		setTouchAreaBindingOnActionDownEnabled(true);
	    
	    
        
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


