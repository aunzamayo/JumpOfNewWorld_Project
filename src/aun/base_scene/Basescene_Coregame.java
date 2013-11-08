package aun.base_scene;

import java.util.ArrayList;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.ai.Bullet;
import aun.ai.BulletManager;

import aun.manager.MonsterManager;
import aun.manager.PlatformManager;
import aun.manager.PlayerManager;
import aun.manager.RuneManager;
import aun.manager.Skillmanager;
import aun.message.MessageConstance;
import aun.object.GameObject;
import aun.object.Jinny;
import aun.object.Monster;
import aun.object.NormalPlatform;
import aun.object.Player;
import aun.object.Rune;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.object.rune.Redrune;
import aun.scene.BaseGameScene.STOP_STATEGAME;
import aun.scene.level.Sky_village;
import aun.score.Score;


public abstract class Basescene_Coregame extends Scene implements IOnMenuItemClickListener , MessageConstance {
	
	protected GameJumpActivity activity ;	 
	public PlayerManager playermanager  ;
	protected PlatformManager platformmanager ;
	public RuneManager runemanager ;
	public Skillmanager skillmanager ;
	public MonsterManager monstermanager ;
	
	public ArrayList<Player>playerlist_multi ;
	
	public ArrayList<NormalPlatform> platformslist ;
	public ArrayList<Rune> runeslist ;
	public ArrayList<Monster> monsterlist ;
	public ArrayList<Monster_Test3_in_Sky_village_1> specialmonsterlist ;
	
	public ArrayList<Bullet> bulletlist ;
	
	public int score_game  ;
	public Score score ;
	
	public boolean mGameRuning = false  ;
	
	public Body b_player ;
	public GameObject player_simmulate ;
	public Player player ;
	
	public String  realstate;
	public String []  state_player = new String [2] ;
	
	float time ; 
	
	public BulletManager bullet ;
	
	private Text mGameOverText;
	private IMenuItem bn_retry ;
	
	protected static  final int  Button_Retry = 0 ;
	
	MenuScene menuscene;
	
	public STOP_STATEGAME typestate ;
	
	public Basescene_Coregame(GameJumpActivity activity){
		this.activity = activity ;
		typestate = STOP_STATEGAME.LEVEL1 ;
//		createplayersimmulate();
		playermanager = new PlayerManager(activity) ;
		platformmanager = new PlatformManager(activity);
		runemanager = new RuneManager(activity);
		skillmanager = new Skillmanager(activity);
		monstermanager = new MonsterManager(activity);
		bullet = new BulletManager(activity);
		
		platformslist = platformmanager.getNormalPlatformList();
		runeslist = runemanager.getrune();
		monsterlist = monstermanager.getMonsterList();
		specialmonsterlist = monstermanager.getspecialMonsterList();
		
		bulletlist = bullet.getBulletList();
		playerlist_multi = new ArrayList<Player>();
		
		menuscene = new MenuScene(activity.getCamera());		
		drawScore();
		createwall();		
		state_player[0] = "PLAY";
		state_player[1] = "GAMEOVER"; 
		realstate = state_player[0];
	}
	
	
	public  Scene createscene(){
		return this ;
	}
	public void Update(){
		
	}
	public  void addplatfromlevel(){
		
	}
	public  void playplatformlistlevel(){
		
	}
	
	
	public void createplayersimmulate (){
		player_simmulate  = playermanager.createplayer(this,1);
		player_simmulate.createsimmulate(player_simmulate);      
		attachChild(player_simmulate);
//        b_player = player_simmulate.b_player;
		b_player = getBodysimmulate();
	}
	
	public Body getBodysimmulate (){
		return b_player = player_simmulate.b_player;
	}
	
	
	public void startGame() {
		final Text 	titleText = new Text(0, 0,activity.load.getFont(), "Go!", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
		titleText.setPosition((activity.getCameraWidth() - titleText.getWidth()) * 0.5f, (activity.getCamaraHeight() - titleText.getHeight()) * 0.5f);
		titleText.setScale(0.0f);
		titleText.setColor(Color.RED);
		titleText.registerEntityModifier(new ScaleModifier(2, 0.0f, 2.0f));
		attachChild(titleText);	
		registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
			@Override
			public void onTimePassed(final TimerHandler pTimerHandler) {
			    unregisterUpdateHandler(pTimerHandler);
				detachChild(titleText);
				b_player.setActive(true);
				b_player.setLinearVelocity(0.0f, -30.0f);
				mGameRuning = true ;
				
			}
		}));
	}
	public void drawScore(){
		
		score = new Score(10,0, activity.load.getFont(),"Score"+ " " + score_game , 100, activity.getVertexBufferObjectManager());
		score.setPosition(-50, 0);
		score.setColor(Color.RED);
		score.setScale(0.5f);
		score.setPosition(-50f, 0.0f);
		attachChild(score);
	}

	public void createwall(){
		final VertexBufferObjectManager vertexBufferObjectManager = activity.getVertexBufferObjectManager();
		final Rectangle roof = new Rectangle(0, 200, activity.getCameraWidth(), 2, vertexBufferObjectManager);
		final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), roof, BodyType.StaticBody, wallFixtureDef);
		attachChild(roof);
		
//		final Rectangle a  = new Rectangle(200, 0, 50, 50, vertexBufferObjectManager);
//		final Rectangle b  = new Rectangle(250, 0, 50, 50, vertexBufferObjectManager);
//		final Rectangle c  = new Rectangle(300, 0, 50, 50, vertexBufferObjectManager);
//		getFirstChild().attachChild(a);
//		getFirstChild().attachChild(b);
//		getFirstChild().attachChild(c);
	}
	
	public void onGameOver() {
		if(this.mGameOverText == null){
			this.mGameOverText = new Text(0, 0, activity.load.getFont(), "Game\nOver", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
			this.mGameOverText.setPosition((activity.getCameraWidth() - this.mGameOverText.getWidth()) * 0.5f, (activity.getCamaraHeight() - this.mGameOverText.getHeight()) * 0.5f);
			this.mGameOverText.setColor(Color.RED);
			this.mGameOverText.registerEntityModifier(new ScaleModifier(3, 0.1f, 2.0f));
			this.mGameOverText.registerEntityModifier(new RotationModifier(3, 0, 720));
			attachChild(this.mGameOverText);
			bn_retry = new ScaleMenuItemDecorator(new SpriteMenuItem(Button_Retry, 200, 70, activity.load.createResource.getTexture(21),activity.getVertexBufferObjectManager()), 1.1f, 1);
			menuscene.addMenuItem(bn_retry);	
			menuscene.buildAnimations();	
			setChildScene(menuscene);
			menuscene.setBackgroundEnabled(false);
			menuscene.setOnMenuItemClickListener(this);
			bn_retry.setScale(0.75f);
			bn_retry.setPosition((activity.getCameraWidth()/2)-142, (activity.getCamaraHeight()/2)+70);
			this.bn_retry.registerEntityModifier(new ScaleModifier(3, 0.1f, 1.0f));
			this.bn_retry.registerEntityModifier(new RotationModifier(3, 0, 720));	
		}
		b_player.setType(BodyType.KinematicBody);
	}
	
	
	
	public float gettime (){
		return time ;
	}
	public void settime (float time){
		this.time = time  ;
	}
	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		time += pSecondsElapsed ;
		Update();
		activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld().onUpdate(pSecondsElapsed);
		if(realstate == state_player[1]){
			onGameOver();
//			activity.highscore.Sortscore(score_game, activity.highscore.scorelist.size()-1);
		}
//		Log.w("fdcdc",""+ (activity.highscore.scorelist.size()-1));
//		Log.w("position_x", "X" + activity.savegame.position_x) ;
//		Log.w("position_y", "Y" + activity.savegame.position_y) ;
//		player.Update();
		activity.mserver.test();
		super.onManagedUpdate(pSecondsElapsed);
	}
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
//		switch (pMenuItem.getID())
//		{
//			case Button_Retry:		
////				Log.w("suck", "555++++++++++++++++++");
//				break;
//		}
		return false;
	}
	
	public Basescene_Coregame getinstance (){
		return this ;
	}

}
