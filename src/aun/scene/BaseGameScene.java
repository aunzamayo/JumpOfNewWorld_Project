package aun.scene;

import java.util.ArrayList;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.manager.PlatformManager;
import aun.manager.PlayerManager;
import aun.manager.RuneManager;
import aun.object.GameObject;
import aun.object.NormalPlatform;
import aun.object.Rune;
import aun.score.Score;

public abstract class BaseGameScene extends Scene {
	GameJumpActivity activity ;
	PlayerManager playermanager ;
	PlatformManager platformmanager ;
	RuneManager runemanager ;
	protected boolean issingle  ;
    protected	boolean ismulti  ;
    public  Body b_player_A,b_player_B , b_player_C;
    public GameObject player ;
    public STOP_STATEGAME typestate ;
    public ArrayList<NormalPlatform> normallist ;
    public  ArrayList<Rune> runeslist ;
    
    public GameObject player_A,player_B ,player_A_simmulate,player_B_simmulate ,player_C_simmulate ;
    public ArrayList<GameObject> playermap ;
	public ArrayList<Body> playerbody ;
    public Score score ;
    public int score_game  ;
    public String []  state_player = new String [2] ;
	public String realstate ;
	private Text mGameOverText;
	public boolean mGameRuning = false  ;
	int count = 0 ;
	
	
    GameObject  bg_gameoverdialog;
    GameObject  bn_retry;
	public BaseGameScene(GameJumpActivity gm) {
		playermap = new ArrayList<GameObject>();
		playerbody = new ArrayList<Body>();
		activity = gm ;
	    playermanager = new PlayerManager(activity) ;
	    platformmanager = new PlatformManager(activity);
	    runemanager = new RuneManager(activity);
	    issingle = false ;
	    ismulti = false ;
	    
	    normallist = platformmanager.getNormalPlatformList();
	    runeslist = runemanager.getrune();
	    
	    typestate = STOP_STATEGAME.LEVEL1 ;
	    
	    this.player_A_simmulate =  new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
	    player_A_simmulate.setPosition(0, 685);//680
		attachChild(player_A_simmulate);
		player_A_simmulate.setVisible(false);
		
		score = new Score(10,0, activity.load.getFont(),"Score"+ " " + score_game , 100, activity.getVertexBufferObjectManager());
		score.setColor(Color.RED);
		attachChild(score);
		
		
//		b_player_A = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_A_simmulate);
		
		
//		player_B_simmulate = playermanager.createplayer(this);		
//		player_B_simmulate.setPosition(440, 0);	
//		attachChild(player_B_simmulate);
		
//		player_C_simmulate = playermanager.createplayer(this);		
//		player_C_simmulate.setPosition(440, 0);	
//		attachChild(player_C_simmulate);
		
//		b_player_A = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_A_simmulate);
//		b_player_B = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_B_simmulate);
		
//		playerbody.add(PLAYER_HOST.getOwnerID(), b_player_A);
//		playerbody.add(PLAYER_CLIENT.getOwnerID(),b_player_B);
		
//		createwall();
		
		state_player[0] = "PLAY";
		state_player[1] = "GAMEOVER"; 
		realstate = state_player[0];
//	    createScene();
//		this.mGameOverText = new Text(0, 0, activity.load.getFont(), "Game\nOver", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
//		this.mGameOverText.setPosition((activity.getCameraWidth() - this.mGameOverText.getWidth()) * 0.5f, (activity.getCamaraHeight() - this.mGameOverText.getHeight()) * 0.5f);
//		this.mGameOverText.registerEntityModifier(new ScaleModifier(3, 0.1f, 2.0f));
//		this.mGameOverText.registerEntityModifier(new RotationModifier(3, 0, 720));
		
	}
	public enum STOP_STATEGAME{
		
	    LEVEL1 ,fistmenugame
	    
	}
	public GameObject getPlayer(){
		return player ;
	}
	public void createwall(){
		final VertexBufferObjectManager vertexBufferObjectManager = activity.getVertexBufferObjectManager();
		final Rectangle ground = new Rectangle(0, activity.getCamaraHeight() - 2, activity.getCameraWidth(), 2, vertexBufferObjectManager);
		final Rectangle roof = new Rectangle(0, 0, activity.getCameraWidth(), 2, vertexBufferObjectManager);
		final Rectangle left = new Rectangle(0, 0, 2, activity.getCamaraHeight(), vertexBufferObjectManager);
		final Rectangle right = new Rectangle(activity.getCameraWidth() - 2, 0, 2,activity.getCamaraHeight(), vertexBufferObjectManager);

//		final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), ground, BodyType.StaticBody, activity.mserver.servercalculate.gamePhysicsWorld.wallFixtureDef);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), roof, BodyType.StaticBody, activity.mserver.servercalculate.gamePhysicsWorld.wallFixtureDef);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), left, BodyType.StaticBody, activity.mserver.servercalculate.gamePhysicsWorld.wallFixtureDef);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), right, BodyType.StaticBody, activity.mserver.servercalculate.gamePhysicsWorld.wallFixtureDef);

		attachChild(ground);
		attachChild(roof);
		attachChild(left);
		attachChild(right);
		
//		final Text titleText = new Text(0, 0,activity.load.getFont(), "Game Over!", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
//		titleText.setPosition((activity.getCameraWidth() - titleText.getWidth()) * 0.5f, (activity.getCamaraHeight() - titleText.getHeight()) * 0.5f);
//		titleText.setScale(0.0f);
//		titleText.setColor(Color.RED);
//		titleText.registerEntityModifier(new ScaleModifier(2, 0.0f, 2.0f));
//		attachChild(titleText);
	}
	
	
	public abstract Scene createScene();
	public  void Update(){}
	public void buildsingle() {
		
	}
	public void addplatfromlevel1(){
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);	
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
		 platformmanager.createnormalplatform(this);
		 runemanager.createrune(this);
	}
	public void playplatformlistlevel1(){
		addplatfromlevel1();
		for(NormalPlatform n : normallist){
			attachChild(n);
		}
		for(Rune r : runeslist){
			attachChild(r);
		}
	}
	 public void onGameOver() {
		if(count == 0){
		this.mGameOverText = new Text(0, 0, activity.load.getFont(), "Game\nOver", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
		this.mGameOverText.setPosition((activity.getCameraWidth() - this.mGameOverText.getWidth()) * 0.5f, (activity.getCamaraHeight() - this.mGameOverText.getHeight()) * 0.5f);
		this.mGameOverText.setColor(Color.RED);
		this.mGameOverText.registerEntityModifier(new ScaleModifier(3, 0.1f, 2.0f));
		this.mGameOverText.registerEntityModifier(new RotationModifier(3, 0, 720));
		attachChild(this.mGameOverText);
		}
//		this.mGameRuning = false;
		b_player_A.setType(BodyType.KinematicBody);
	}
	
	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
//       if(realstate == state_player[0]){
		Update();
        activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld().onUpdate(pSecondsElapsed);
//        onGameOver();
//       }
        if(realstate == state_player[1]){
        	onGameOver();
        	bg_gameoverdialog.setVisible(true);
        	bn_retry.setVisible(true);
        	count ++ ;
        }
        
       
//
//			
//			
//			registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
//				@Override
//				public void onTimePassed(final TimerHandler pTimerHandler) {
//				    unregisterUpdateHandler(pTimerHandler);
//					detachChild(titleText);
//				    
//				}
//			}));
//		}
        
        super.onManagedUpdate(pSecondsElapsed);
       
	}
	
}
