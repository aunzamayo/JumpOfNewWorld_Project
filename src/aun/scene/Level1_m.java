package aun.scene;

import java.util.ArrayList;

import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;
import com.badlogic.gdx.physics.box2d.Body;
import aun.activity.GameJumpActivity;
import aun.message.MessageConstance;
import aun.object.GameObject;
import aun.object.NormalPlatform;


public class Level1_m extends Scene implements IOnAreaTouchListener , MessageConstance {
//	public GameObject player_A,player_B ,player_A_simmulate,player_B_simmulate;
//	public Body b_player_A,b_player_B;
	
	public boolean mGameRuning = false  ;
	
//	public ArrayList<GameObject> playermap ;
//	public ArrayList<Body> playerbody ;
	
	public ArrayList<NormalPlatform> normallist ;
//	public STOP_STATEGAME typestate ;

	public Level1_m(GameJumpActivity gm) {
//		super(gm);
//		normallist = platformmanager.getNormalPlatformList();
//		typestate = STOP_STATEGAME.LEVEL1 ;
		createScene();
//		playermap = new ArrayList<GameObject>();
//		playerbody = new ArrayList<Body>();
	}
	

//	@Override
//	public void buildsingle() {
//		
////		player_A = playermanager.createplayer(this);		
////		player_A.setPosition(200, 685);
//////		player_A.setScale(2);	
////		attachChild(player_A);
////		
////		player_B = playermanager.createplayer(this);		
////		player_B.setPosition(300, 685);	
////		attachChild(player_B);
////		
////		playermap.add(PLAYER_HOST.getOwnerID(), player_A);
////		playermap.add(PLAYER_CLIENT.getOwnerID(), player_B);
//		
////		player_A_simmulate = playermanager.createplayer(this);		
////		player_A_simmulate.setPosition(0, 0);	
////		attachChild(player_A_simmulate);
////		
////		player_B_simmulate = playermanager.createplayer(this);		
////		player_B_simmulate.setPosition(440, 0);	
////		attachChild(player_B_simmulate);
////		
//
////		b_player_B = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_B_simmulate);
////		b_player_C = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_C_simmulate);
////		playerbody.add(PLAYER_HOST.getOwnerID(), b_player_B);
////		playerbody.add(PLAYER_CLIENT.getOwnerID(),b_player_C);
//		
////		registerTouchArea(player);
////		setTouchAreaBindingOnActionDownEnabled(true);
////		setOnAreaTouchListener(this);
//		
//	}

//	@Override
	public Scene createScene() {
		setBackground(new Background(Color.CYAN));
//		registerUpdateHandler(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld());
//        buildsingle();
		
		
		return this;
	}

//	@Override
//	public void Update() {
//		
//	}

	


	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			ITouchArea pTouchArea, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
//		player.setPosition(pSceneTouchEvent.getX() - player.getWidth() / 2, pSceneTouchEvent.getY() - player.getHeight() / 2);
		return true;
	}

}
