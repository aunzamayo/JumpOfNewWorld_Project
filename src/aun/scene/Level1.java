package aun.scene;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.NormalPlatform;
import aun.object.Rune;

public class Level1 extends BaseGameScene {

//	public GameObject player ;
//	public Body b_player ;
	
	
	
//	public ArrayList<NormalPlatform> normallist ;
	public STOP_STATEGAME typestate ;
	
	public Level1(GameJumpActivity gm) {
		super(gm);
//		createScene();
//		normallist = platformmanager.getNormalPlatformList();
//		registerUpdateHandler(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld());
		typestate = STOP_STATEGAME.LEVEL1 ;
//		this.createScene();
	}
	

	@Override
	public Scene createScene() {
		
		setBackground(new Background(Color.CYAN));
//		registerUpdateHandler(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld());
		
			this.buildsingle();
			bg_gameoverdialog = new GameObject(activity.load.createResource.getTexture(20),activity.getVertexBufferObjectManager(), activity);
		    bg_gameoverdialog.setScale(0.5f);
		    bg_gameoverdialog.setPosition(-250.0f, (activity.getCamaraHeight()/2)-225);
			attachChild(bg_gameoverdialog);
			bg_gameoverdialog.setVisible(false);
			
			bn_retry = new GameObject(activity.load.createResource.getTexture(21),activity.getVertexBufferObjectManager(), activity){
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(1));
					return true;
				}
			};
			bn_retry.setScale(0.75f);
			bn_retry.setPosition((activity.getCameraWidth()/2)-142, (activity.getCamaraHeight()/2)+70);
			bn_retry.setVisible(false);
			attachChild(bn_retry);
//			registerTouchArea(bn_retry);
			setTouchAreaBindingOnActionDownEnabled(true);
			
		return this;
	}

	public void createwall(){
		final VertexBufferObjectManager vertexBufferObjectManager = activity.getVertexBufferObjectManager();
		final Rectangle roof = new Rectangle(0, 200, activity.getCameraWidth(), 2, vertexBufferObjectManager);
		final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
		PhysicsFactory.createBoxBody(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld(), roof, BodyType.StaticBody, wallFixtureDef);
		attachChild(roof);
	}
	@Override
	public void Update() {
		
		
//		if(b_player.getPosition().y > activity.getCamaraHeight()/PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT){
//			b_player.setTransform(b_player.getPosition().x,0.0f, 0) ;
//		}
		
		if(mGameRuning == true){
			player.Update();
			for(NormalPlatform n : normallist){
				n.Update();	
			}
			for(Rune r :runeslist ){
				r.Update();	
			}
		}
	}


	
//	public void addplatfromlevel1(){
//		 platformmanager.createnormalplatform(this);
//		 platformmanager.createnormalplatform(this);
//		 platformmanager.createnormalplatform(this);	
//		 platformmanager.createnormalplatform(this);
//		 platformmanager.createnormalplatform(this);
//		 platformmanager.createnormalplatform(this);
//	}
//	public void playplatformlistlevel1(){
//		addplatfromlevel1();
//		for(NormalPlatform n : normallist){
//			attachChild(n);
//		}
//	}
	


	@Override
	public void buildsingle() {
			playplatformlistlevel1();
			
			final Text titleText = new Text(0, 0,activity.load.getFont(), "Go!", new TextOptions(HorizontalAlign.CENTER), activity.getVertexBufferObjectManager());
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
				    mGameRuning = true;
				    b_player_A.setLinearVelocity(0.0f, -30.0f);
				    b_player_A.setActive(true);
				}
			}));
			
//			onGameOver();
			
			player = playermanager.createplayer(this,1);
			player.setPosition(240, 685);
			attachChild(player);
			
//			GameObject player_simmulate =  new GameObject(activity.load.createResource.getTexture(8), activity.getVertexBufferObjectManager(), activity);
//			player_simmulate.setPosition(0, 680);
//			attachChild(player_simmulate);
			
			b_player_A = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_A_simmulate);
			b_player_A.setActive(false);
//			createwall();
		
	}





	



}
