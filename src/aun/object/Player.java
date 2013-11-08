package aun.object;

import java.io.IOException;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.list.SmartList;
import org.andengine.util.debug.Debug;

import com.badlogic.gdx.physics.box2d.Body;

import android.graphics.SumPathEffect;
import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.ai.BulletManager;
import aun.ai.BulletPlayer;
import aun.base_scene.Basescene_Coregame;
import aun.manager.Skillmanager;
import aun.scene.Level1;
import aun.update.objectnetwork.UpdateServerPlayerMessage;

public abstract class Player extends GameObject {
	public Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
//	Basescene_Coregame basescene_connect =  activity.getScenegame() ;
	public   String [] Stateskill = {"normal","flying"}; 
	public   String  skill = Stateskill[0] ;
	private  Level1 level1 ;
	float Height = 0 ;
	float distance =  0 ;
//	Skillmanager skillmanager ;
	private float velocity ;
	private float product = 150.0f ;
	String a = basescene_connect.skillmanager.serchskill.getSkill() ;
	
	BulletManager bullet_player  ;
	public Player(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		
		level1 = (Level1)activity.scenmanager.getscene().get(0);
		bullet_player = new BulletManager(activity);
	}
	public void Controlx(){
		
		
		  velocity = activity.control.getTilt() * product ;
          mHandler.setVelocityX(-velocity);
          setRotation(activity.control.getTilt() *7);
		
	}
	public  void move_x(){
		

        final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
        final SmartList<SocketConnectionClientConnector> clientConnectors = activity.mserver.getmClientConnectors();
		
		for(int i = 0; i < clientConnectors.size(); i++) {
			final ClientConnector<SocketConnection> clientConnector = clientConnectors.get(i);
			try {
				clientConnector.sendServerMessage(updateServerPlayerMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public  void move_y(){
//		 final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
//		 final float jinny =   activity.scenmanager.getsceneplay().get(0).getBodysimmulate().getPosition().y * physics_pixel - this.getWidth()/2  ;	
////		 final float jinnyload =   activity.scenmanager.getsceneload().get(0).getBodysimmulate().getPosition().y * physics_pixel - this.getWidth()/2  ;	
//		 updateServerPlayerMessage.setY(jinny);
//		 
//	   	 try {
//	   	 activity.mserver.sendBroadcastServerMessage(updateServerPlayerMessage);
//			} catch (IOException e) {
//				Debug.e(e);
//			}
//	   	 activity.mserver.getMessagePool().recycleMessage(updateServerPlayerMessage);
		final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
		
		final SmartList<SocketConnectionClientConnector> clientConnectors = activity.mserver.getmClientConnectors();
		
		for(int i = 0; i < clientConnectors.size(); i++) {
			final float jinny =   activity.scenmanager.getsceneplay().get(1).playermanager.getbodySimmulate().get(i).getPosition().y * physics_pixel - this.getWidth()/2  ;	
			updateServerPlayerMessage.setY(jinny);
			final ClientConnector<SocketConnection> clientConnector = clientConnectors.get(i);
			try {
				clientConnector.sendServerMessage(updateServerPlayerMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
		
	}
	public abstract void Jump();	
	public abstract int getId();
	public abstract int setId(int id);	
	public abstract void procressevent( GameObject object );	
	
	
	public void scoreup (){
		Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
		distance = Math.abs( basescene_connect.getBodysimmulate().getLinearVelocity().y * 60)  ;
		
		if (mY <= activity.getCamaraHeight()/2.5f &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ) {
			 basescene_connect.getBodysimmulate().setLinearVelocity(0.0f, 2);
			 Height += (distance)/100 ;
			 basescene_connect.score_game = (int) Height ;
			 if(activity.save_state == false){
			 	basescene_connect.score.setText("Score"+ " " +  basescene_connect.score_game);
			 }else if(activity.save_state == true){
				 basescene_connect.score.setText("Score"+ " " +  (basescene_connect.score_game+activity.savegame.scoresave)); 
			 }
//			 Log.w("score", " " + basescene_connect.score_game );
		}
	}
	
	public void OutOfScreenX() {
		if (mX > activity.getCameraWidth()) { // OutOfScreenX (right)
			mX = 0;
		} else if (mX < 0) { // OutOfScreenX (left)
			mX = activity.getCameraWidth();
		}
	}
	public void OutOfScreenY() {

		if(level1.b_player_A.getPosition().y > activity.getCamaraHeight()/physics_pixel && level1.realstate == level1.state_player[0]){
			level1.b_player_A.setTransform(level1.b_player_A.getPosition().x, 0, 0);

			level1.realstate = level1.state_player[1];

		}
	}
	@Override
	public void Update() {
		move_x();
		move_y();	

//		for (Rune rune  :  basescene_connect.runeslist) {
//			if (this.collidesWith(rune) && basescene_connect.runemanager.getrune_Id().size() < 3) {				
//						rune.setPosition(0, -500);
//						basescene_connect.runemanager.addIdlist(rune.getId());
//						Log.w("getid", " "+ basescene_connect.runemanager.SummaryId_Rune.size());			
//						basescene_connect.runemanager.mix_rune();				
//			}
//			
//			
//			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
//				rune.move_y(300);	
//	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
//	        	rune.move_y(- 1000);
//	        }else{
//	        	rune.move_y(0);
//	        }
//			      
//		}
//		
//		for (Monster monster  :  basescene_connect.monsterlist) {
//			if (this.collidesWith(monster)) {				
//														
//			}
//				
//			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
//				monster.move_y(300);
//				 
//				
//	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
//	        	monster.move_y(-1000);
//	        }else{
//	        	monster.move_y(0);
//	        }
//			      
//		}
		
		//------ time down -------
//		if(skill == Stateskill[1] ){
//			activity.scenmanager.getsceneplay().get(0).getBodysimmulate().setLinearVelocity(0.0f, -10.0f);
//			this.registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
//				
//				@Override
//				public void onTimePassed(TimerHandler pTimerHandler) {             
//											skill = Stateskill[0];
////											Log.w("stsate", skill);
//					
//				}
//			}));
//			
//		}
		
		if(basescene_connect.skillmanager.serchskill.getSkill() == basescene_connect.skillmanager.serchskill.getstateSkill()[1] ){
			activity.scenmanager.getsceneplay().get(0).getBodysimmulate().setLinearVelocity(0.0f, -10.0f);
			this.registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler) {             
					basescene_connect.skillmanager.serchskill.setSkill(basescene_connect.skillmanager.serchskill.getstateSkill()[0]);
//											Log.w("stsate", skill);
					
				}
			}));
			
		}else if (basescene_connect.skillmanager.serchskill.getSkill() == basescene_connect.skillmanager.serchskill.getstateSkill()[2]){
			bullet_player.addbulletplayer(this.getX(), this.getY(), activity.scenmanager.getsceneplay().get(0));
			basescene_connect.skillmanager.serchskill.setSkill(basescene_connect.skillmanager.serchskill.getstateSkill()[0]);
		}else if (basescene_connect.skillmanager.serchskill.getSkill() == basescene_connect.skillmanager.serchskill.getstateSkill()[3]){
				if(basescene_connect.getBodysimmulate().getLinearVelocity().y > 0){
					basescene_connect.getBodysimmulate().setLinearDamping(2.0f);
				}else{
					basescene_connect.getBodysimmulate().setLinearDamping(0.0f);
				}
				this.registerUpdateHandler(new TimerHandler(10.0f, new ITimerCallback() {				
					@Override
					public void onTimePassed(TimerHandler pTimerHandler) {             
						basescene_connect.getBodysimmulate().setLinearDamping(0.0f);
						basescene_connect.skillmanager.serchskill.setSkill(basescene_connect.skillmanager.serchskill.getstateSkill()[0]);						
					}
				}));
		}
		
	}
	


	
	

	

	

}
