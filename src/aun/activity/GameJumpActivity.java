package aun.activity;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.extension.multiplayer.protocol.util.WifiUtils;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;
import com.badlogic.gdx.physics.box2d.Body;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import aun.base_scene.Basescene_Coregame;
import aun.control.Control;
import aun.loadgame.data.Loadgame;
import aun.manager.SceneManager;
import aun.message.MessageConstance;
import aun.network.ClientConnectorListener;
import aun.network.Server;
import aun.network.ServerAndClient;
import aun.network.ServerConnectorListener;
import aun.network.ServerState;
import aun.object.GameObject;
import aun.object.Monster;
import aun.object.NormalPlatform;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.resource.LoadResource;
import aun.savegame.data.Savescene;
import aun.scene.BaseGameScene;
import aun.scene.BaseMenuScene;
import aun.scene.FirstMenuIndexScene;
import aun.scene.GameWorldHighscore;
import aun.scene.GameWorldMultiplayyer;
import aun.scene.GameWorldSceneMenu;
import aun.scene.Level1;
import aun.scene.Level1_m;
import aun.scene.Scene_Battle_Client;
import aun.scene.Scene_Battle_Server;
import aun.scene.Scene_multiplayersection;
import aun.scene.level.Sky_village;
import aun.scene.level.Testmulti;
import aun.score.Highscore;
import aun.stategame.State_game;
import aun.stategame.State_game.Statemenu;
import aun.update.objectnetwork.PlayerClassRoom;



public class GameJumpActivity extends SimpleBaseGameActivity implements MessageConstance , IUpdateHandler {

	private Camera mCamera;
	private final int CAMERA_WIDTH = 480;
	private final int CAMERA_HEIGHT = 720;
	
	private Scene scene ;
	public LoadResource load ;
	
	
	
	public boolean save_state = false ;
	
	private float time ;
//	public BaseMenuScene  fistIndexMenuscene , gameworldMenuScene, gameworldmultiplayer , gameworldhighscore , multiplayerfirst   ;
//	public BaseGameScene level1 ;
//    public Scene_Battle_Client roombattle_Client ;
//    public Scene_Battle_Server roombattle_Server ;
	private ArrayList<BaseMenuScene> scenemenulist ;
	private ArrayList<BaseGameScene> scenelist ;
	public ArrayList<Basescene_Coregame> sceneplay ;
	
	public Level1_m level1m ;
	
	public SceneManager scenmanager ;
	
	public Control control ;
	
	private static final int Serverport = 1234 ;
	
	private String IpWifi ;
	private static final String LOCALHOST_IP = "127.0.0.1";
	private String mServerIP = LOCALHOST_IP;
	public Server mserver ;
//	public Server mserver_multi ;
	public ServerAndClient mServerConnector ;
	
	public Highscore highscore ;
	
	private GameObject player_simmulate ;
	public State_game stategame ;
	
	Builder alert ,alert_savegame ;
	String textip ;
	
	private Basescene_Coregame curentScene ;
	
	public Loadgame loadgame ;
	public Savescene savegame ;
	public int statescene = 0 ;
	
	int NOT_ID = -1 ;
	int ID = NOT_ID ;
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public GameJumpActivity(){
		 this.mCamera = new Camera(0, 0,CAMERA_WIDTH, CAMERA_HEIGHT);
		 stategame = new State_game() ;
		 scenemenulist = new ArrayList<BaseMenuScene>();
		 scenelist = new ArrayList<BaseGameScene>();
		 sceneplay = new ArrayList<Basescene_Coregame>();
		 
//         curentScene = new Basescene_Coregame(this);
		
		 
		 if (android.os.Build.VERSION.SDK_INT > 9) {
				StrictMode.ThreadPolicy policy = 
				        new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
		}
		 
	}
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		
		control = new Control(this);
		initServerAndClient();
		highscore = new Highscore(this);
		
		
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new FillResolutionPolicy(), this.mCamera);
	}

	@Override
	protected void onCreateResources() {
		 alert =  new AlertDialog.Builder(this);
		 alert_savegame =  new AlertDialog.Builder(this);
		 
		 FontFactory.setAssetBasePath("font/");	
		 BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		 load = new LoadResource(this,mEngine, this);
	}

	
	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		
		
		scenemenulist.add(new FirstMenuIndexScene(this , mCamera)); //0
		scenemenulist.add(new GameWorldSceneMenu(this,mCamera)); //1
		scenemenulist.add(new GameWorldMultiplayyer(this, mCamera));//2
		scenemenulist.add(new GameWorldHighscore(this, mCamera));//3
		scenemenulist.add(new Scene_multiplayersection(this, mCamera));//4
		scenemenulist.add(new Scene_Battle_Client(this, mCamera));//5

		
		scenelist.add(new Level1(this));//0
		
		sceneplay.add(new Sky_village(this));//0
		sceneplay.add(new Testmulti(this)); //1
//		sceneplay.add(new Loadgame(this));// 1
		scenmanager = new SceneManager(this,scenemenulist,scenelist,sceneplay);
		
		scene = scenemenulist.get(0) ;
		Level1 l = (Level1) scenelist.get(0);
		l.createScene();	
		
		
		curentScene = (Basescene_Coregame) scenmanager.getsceneplay().get(0).createscene();      
		scenmanager.getsceneplay().get(1).createscene();  
//		scenmanager.getsceneplay().get(1).createscene();
		
		savegame = new Savescene(this);
		return scene ;
	}
	public Body getbodysimmulate(){
		return mserver.servercalculate.gamePhysicsWorld.getBody() ;
	}
	
	public GameObject getGameObject(){
		return player_simmulate; 
	}
	
	public float getCameraWidth(){
		return CAMERA_WIDTH ;
	}
	public float getCamaraHeight(){
		return CAMERA_HEIGHT ;
	}
	public Engine getEngine(){
		return mEngine;
	}
    public void initServer() {
		
        ClientConnectorListener c = new ClientConnectorListener(this);	
		ServerState s = new ServerState(this);
		this.mserver = new Server(Serverport,c,s,this);
		
//		textip = c.getClientConnector();
		this.mserver.start();
        
//		this.mEngine.registerUpdateHandler(this.mserver);
	}
    public void initClient() {
		ServerConnectorListener s_connector = new ServerConnectorListener(this);
	     try {
		
		this.mServerConnector = new ServerAndClient(this.mServerIP, s_connector,this);
		this.mServerConnector.getConnection().start();
	    } catch (final Throwable t) {
		Debug.e(t);
	  }
    }
   
    public void initServerAndClient() {
		this.initServer();

		/* Wait some time after the server has been started, so it actually can start up. */
		try {
			Thread.sleep(500);
		} catch (final Throwable t) {
			Debug.e(t);
		}

		this.initClient();
	}
    
	@Override
	protected void onDestroy() {
		if(this.mserver != null) {
			try {
				this.mserver.sendBroadcastServerMessage(new ConnectionCloseServerMessage());
			} catch (final IOException e) {
				Debug.e(e);
			}
			this.mserver.terminate();
		}

		if(this.mServerConnector != null) {
			this.mServerConnector.terminate();
		}

		super.onDestroy();
	}
	public String getMserverIp(){
		return mServerIP ;
	}
	public void setMserverIp(String s){
		mServerIP = s ;
	}
	@Override
	public boolean onKeyDown(final int pKeyCode, final KeyEvent pEvent) {

		if(pKeyCode == KeyEvent.KEYCODE_MENU && pEvent.getAction() == KeyEvent.ACTION_DOWN && this.stategame.getStatemenu() == Statemenu.Gameplay  ){
			if(this.mEngine.isRunning()) {
				this.mEngine.stop();
			} else {
				this.mEngine.start();
			}
			return true;
		}
		else if (pKeyCode == KeyEvent.KEYCODE_BACK && pEvent.getAction() == KeyEvent.ACTION_DOWN && this.stategame.getStatemenu() == Statemenu.Menuindex){
			this.finish();
			return true ;
		}	
		else if (pKeyCode == KeyEvent.KEYCODE_BACK && pEvent.getAction() == KeyEvent.ACTION_DOWN &&  this.stategame.getStatemenu() == Statemenu.Gameplay){		
			dialogsavegame();
			if(this.mEngine.isRunning()) {
				this.mEngine.stop();
			}else {
				this.mEngine.start();
			}
//			savegame.save_entity(0,"p",);
//			this.scenmanager.setScene(scenemenulist.get(0));
			return true ;
		}	
//		else if (pKeyCode == KeyEvent.KEYCODE_BACK && pEvent.getAction() == KeyEvent.ACTION_DOWN &&  this.stategame.getStatemenu() == Statemenu.Gameplay){		
//			stategame.setStatemenu(Statemenu.Menuindex);
//			this.scenmanager.setScene(scenemenulist.get(0));
//			return true ;
//		}	
		else {
			return super.onKeyDown(pKeyCode, pEvent);
		}
	}
	
	public void dialogsavegame(){
		runOnUiThread(new Runnable() {
				@Override
				public void run() {
						alert_savegame.setPositiveButton("Save",new OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									savegame.save_Score(0, "S", GameJumpActivity.this.scenmanager.getsceneplay().get(0).score_game);
									savegame.save_entity(0,"p_X",GameJumpActivity.this.scenmanager.getsceneplay().get(0).player.getX());
									savegame.save_entity(0,"p_Y",GameJumpActivity.this.scenmanager.getsceneplay().get(0).player.getY());
									
									for(int i = 0 ; i < GameJumpActivity.this.scenmanager.getsceneplay().get(0).monsterlist.size(); i++){
										savegame.save_entity(0,"m_X"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).monsterlist.get(i).getX());
										savegame.save_entity(0,"m_Y"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).monsterlist.get(i).getY());
										
//										Log.w("XXX"+ i, ""+GameJumpActivity.this.scenmanager.getsceneplay().get(0).monsterlist.get(i).getX());
//										Log.w("YYY" + i, ""+GameJumpActivity.this.scenmanager.getsceneplay().get(0).monsterlist.get(i).getY());
									}
									for(int i = 0 ; i < GameJumpActivity.this.scenmanager.getsceneplay().get(0).specialmonsterlist.size() ; i++){
										savegame.save_entity(0,"sm_X"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).specialmonsterlist.get(i).getX());
										savegame.save_entity(0,"sm_Y"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).specialmonsterlist.get(i).getY());
									}
									for(int i = 0 ; i < GameJumpActivity.this.scenmanager.getsceneplay().get(0).platformslist.size() ; i++){
										savegame.save_entity(0,"n_X"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).platformslist.get(i).getX());
										savegame.save_entity(0,"n_Y"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).platformslist.get(i).getY());
									}
									for(int i = 0 ; i < GameJumpActivity.this.scenmanager.getsceneplay().get(0).runeslist.size() ; i++){
										savegame.save_entity(0,"r_X"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).runeslist.get(i).getX());
										savegame.save_entity(0,"r_Y"+i,GameJumpActivity.this.scenmanager.getsceneplay().get(0).runeslist.get(i).getY());
									}	
//									Log.w("XXX", ""+GameJumpActivity.this.scenmanager.getsceneplay().get(0).player.getX());
//									Log.w("YYY", ""+GameJumpActivity.this.scenmanager.getsceneplay().get(0).player.getY());
//									GameJumpActivity.this.finish();								
								}
						});
						alert_savegame.setNegativeButton("Cancle",new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								
								GameJumpActivity.this.finish();
								
							}
					});
						alert_savegame.show();
				}
				
		});
	
	}
	public void showdialog(){
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				final EditText ipEditText = new EditText(GameJumpActivity.this);
				alert.setTitle("Enter your Ip");
				alert.setCancelable(true);
				alert.setView(ipEditText);
				alert.setPositiveButton("Connect",new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						GameJumpActivity.this.mServerIP = ipEditText.getText().toString();
						GameJumpActivity.this.initClient();
						GameJumpActivity.this.scenmanager.setScene(sceneplay.get(1));
						
						
//---					 
//						final PlayerClassRoom classroomserver = (PlayerClassRoom) mserver.getMessagePool().obtainMessage(FLAG_PlayerID);
//							classroomserver.setX(225.0f);
//						    classroomserver.setY(200.0f);
////						    classroomserver.setIp(getIpwifi());
//						    classroomserver.setIp(ipEditText.getText().toString());
//						    
////						    try {
////								classroomserver.setIp(WifiUtils.getWifiIPv4Address(GameJumpActivity.this));
////							} catch (UnknownHostException e1) {
////								// TODO Auto-generated catch block
////								e1.printStackTrace();
////							}
//							 
//						   	 try {
//						   		 mserver.sendBroadcastServerMessage(classroomserver);
//								} catch (IOException e) {
//									Debug.e(e);
//								}
//						   	 mserver.getMessagePool().recycleMessage(classroomserver);
////--					
					}
				});				
				alert.setNegativeButton("Cancle", new OnClickListener() {
					
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
                       
						
					}
				});
				
              
			   alert.show();	
              
			}		
    
	   });
	}
    
	public String getIpwifi(){
		
		try {
		   IpWifi =  WifiUtils.getWifiIPv4Address(this);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IpWifi ;
	}

	public float gettime (){
		return time ;
	}
	@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		time += pSecondsElapsed ;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	public Camera getCamera (){
		return mCamera ;
	}
	
	public void onRestart() {
		super.onRestart();
		Intent intent=new Intent();
	    intent.setClass(this, this.getClass());
	    finish();
	    this.mserver.terminate();
	    this.startActivity(intent);    
	}
	public Basescene_Coregame getScenegame(){
		curentScene.createscene();
		return curentScene;
	}
	public void setScene(Basescene_Coregame scene){
		curentScene = scene ;
	}
	public void SetID( int ID){
		this.ID = ID ; 
	}
   
	
}
