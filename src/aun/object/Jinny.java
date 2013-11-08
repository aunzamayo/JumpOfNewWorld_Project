package aun.object;

import java.io.IOException;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.scene.Level1;
import aun.update.objectnetwork.UpdateServerPlayerMessage;

public class Jinny extends Player {

	private float velocity ;
    private float product = 150.0f ;
    public float diference_p ; 
    float Height = 0 ;
    float distance =  0 ;
    private  Level1 level1 = (Level1) activity.scenmanager.getscene().get(0);
    
   
    
	public Jinny(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		Height = 0 ;
		procressevent(this);
		animate(200);
	}

	@Override
	public void move_x() {
//	       velocity = activity.control.getTilt() * product ;
//           mHandler.setVelocityX(-velocity);
//           setRotation(activity.control.getTilt() *7);
		
	}

	@Override
	public void move_y() {
		 final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
         final float jinny =   level1.b_player_A.getPosition().y * physics_pixel -  level1.player.getWidth()/2 ;
		 updateServerPlayerMessage.setY(jinny);
		 
    	 try {
    		 activity.mserver.sendBroadcastServerMessage(updateServerPlayerMessage);
		} catch (IOException e) {
			Debug.e(e);
		}
    	 activity.mserver.getMessagePool().recycleMessage(updateServerPlayerMessage);
	}
	
	@Override
	public void Jump() {
		  float jinny_simmulateY =  level1.b_player_A.getPosition().y * physics_pixel ;
		
		
		  for (NormalPlatform Platform  :  level1.normallist) {
			if (this.collidesWith(Platform)) {
			      if(jinny_simmulateY
			         < Platform.getY() &&  level1.b_player_A.getLinearVelocity().y > 0){
			    	  level1.b_player_A.setLinearVelocity(0.0f, -15.0f);
			      }
				
			}
			if( level1.getPlayer().getY() < activity.getCamaraHeight()/2   &&  level1.realstate ==  level1.state_player[0] ){	
				Platform.move_y(300);	
	        }else if ( level1.realstate ==  level1.state_player[1]){
	        	Platform.move_y(-1000);
	        }else{
	        	Platform.move_y(0);
	        }
		}	
		for (Rune rune  :  level1.runeslist) {
			if (this.collidesWith(rune)) {
				rune.setPosition(0, -500);
				skill = Stateskill[1];				
			}
			if( level1.getPlayer().getY() < activity.getCamaraHeight()/2   &&  level1.realstate ==  level1.state_player[0] ){	
				rune.move_y(300);	
	        }else if ( level1.realstate ==  level1.state_player[1]){
	        	rune.move_y(-1000);
	        }else{
	        	rune.move_y(0);
	        }
			      
		}
		
		  
		  
	}

	@Override
	public void procressevent(GameObject object) {
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}

	@Override
	public void Update() {
		 distance = Math.abs( level1.b_player_A.getLinearVelocity().y*60)  ;
		
		diference_p  =  (((activity.getCamaraHeight() / PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT)/2 -  level1.b_player_A.getPosition().y))/PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT ;
		move_y();
		move_x();	
		Jump();
		OutOfScreenX();
		OutOfScreenY();
		
		if (mY <= activity.getCamaraHeight()/2.5f &&  level1.realstate ==  level1.state_player[0] ) {
			 level1.b_player_A.setLinearVelocity(0.0f, 2);
			 Height += (distance)/100 ;
			 level1.score_game = (int) Height ;
			 level1.score.setText("Score"+ " " +  level1.score_game);
		}
		
//		if(activity.level1.score_game >= 100){
//			skill = Stateskill[1];
//		}
		
		if(skill == Stateskill[1] ){
			level1.b_player_A.setLinearVelocity(0.0f, -10.0f);
			this.registerUpdateHandler(new TimerHandler(3.0f, new ITimerCallback() {
				
				@Override
				public void onTimePassed(TimerHandler pTimerHandler) {             
											skill = Stateskill[0];
//											Log.w("stsate", skill);
					
				}
			}));
			
		}
		


	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	




	

}
