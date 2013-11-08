package aun.character;

import java.io.IOException;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.GameObject;
import aun.object.Monster;
import aun.object.NormalPlatform;
import aun.object.Player;
import aun.object.Rune;
import aun.object.monster.Monster_Test3_in_Sky_village_1;
import aun.scene.level.Sky_village;
import aun.update.objectnetwork.UpdateServerPlayerMessage;

public class Jimmy extends Player {
    
	private float velocity ;
    private float product = 150.0f ;
	 
	public Jimmy(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		procressevent(this);
		animate(200);
//		this.createplayersimmulate();
	}

	@Override
	public void move_x() {
		  
		super.move_x();
	}
	

	@Override
	public void move_y() {
		 
//		 final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
//		 final float jinny =   activity.scenmanager.getsceneplay().get(0).getBodysimmulate().getPosition().y * physics_pixel - this.getWidth()/2  ;	
//		 updateServerPlayerMessage.setY(jinny);
//		 
//    	 try {
//    	 activity.mserver.sendBroadcastServerMessage(updateServerPlayerMessage);
//		} catch (IOException e) {
//			Debug.e(e);
//		}
//    	 activity.mserver.getMessagePool().recycleMessage(updateServerPlayerMessage);
		super.move_y();
	}

	@Override
	public void Jump() {
		Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
		float jinny_simmulateY =  activity.scenmanager.getsceneplay().get(0).getBodysimmulate().getPosition().y * physics_pixel ;
	    
		
		for (NormalPlatform Platform  :  basescene_connect.platformslist) {
			if (this.collidesWith(Platform)) {
			      if(jinny_simmulateY < Platform.getY() && basescene_connect.getBodysimmulate().getLinearVelocity().y > 0){
			    	 
			    	  basescene_connect.getBodysimmulate().setLinearVelocity(0.0f, -15.0f);
			      }
				
			}
			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&   basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
				Platform.move_y(300);	
	        }else if ( basescene_connect.realstate ==   basescene_connect.state_player[1]){
	        	Platform.move_y(-1000);
	        }else{
	        	Platform.move_y(0);
	        }
		}	
		for (Rune rune  :  basescene_connect.runeslist) {
			if (this.collidesWith(rune) && basescene_connect.runemanager.getrune_Id().size() < 3) {				
						rune.setPosition(0, -500);
						basescene_connect.runemanager.addIdlist(rune.getId());
						Log.w("getid", " "+ basescene_connect.runemanager.SummaryId_Rune.size());			
						basescene_connect.runemanager.mix_rune();				
			}
			
			
			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
				rune.move_y(300);	
	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
	        	rune.move_y(- 1000);
	        }else{
	        	rune.move_y(0);
	        }
			      
		}
		
		for (Monster monster  :  basescene_connect.monsterlist) {
			if (this.collidesWith(monster)) {				
														
			}
				
			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
				monster.move_y(300);
				 
				
	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
	        	monster.move_y(-1000);
	        }else{
	        	monster.move_y(0);
	        }
			      
		}
		for (Monster_Test3_in_Sky_village_1 monster  :  basescene_connect.specialmonsterlist) {
			if (this.collidesWith(monster)) {															
			}				
			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
				monster.move_y(300 );			
	        }
			else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
	        	monster.move_y(-1000 );
	        }	      
		}
		
//		for (Rune rune  :  basescene_connect.runeslist) {
//			if (this.collidesWith(rune)) {
//				rune.setPosition(0, -500);
//				skill = Stateskill[1];				
//			}
//			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
//				rune.move_y(300);	
//	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
//	        	rune.move_y(-1000);
//	        }else{
//	        	rune.move_y(0);
//	        }
//			      
//		}

		
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

	@Override
	public void procressevent(GameObject object) {
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
		
	}
	public void OutOfScreenY() {
		Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
		if(basescene_connect.getBodysimmulate().getPosition().y > activity.getCamaraHeight()/physics_pixel && basescene_connect.realstate == basescene_connect.state_player[0]){
			basescene_connect.getBodysimmulate().setTransform(basescene_connect.getBodysimmulate().getPosition().x, 0, 0);

			basescene_connect.realstate = basescene_connect.state_player[1];

		}
	}
	
    public void Update (){
//    	move_y() ;
    	move_x() ; 
    	Jump();
    	OutOfScreenX();
		OutOfScreenY();
		scoreup();
	//---- use skill --- // 
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
		
		super.Update();
		
    }
}
