package aun.ai;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.GameObject;
import aun.object.monster.Monster_Test3_in_Sky_village_1;

public abstract class Bullet extends GameObject  {

	private float time ;
	Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
	public Bullet(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		
		
	}
	
	public abstract void move_x();
	public abstract void move_y();
	public abstract void move_x(float speed);
	public abstract void move_y(float speed);
	public abstract void ability();
	public abstract void procressevent( GameObject object );
	
	public float getTime (){
		return time ;
	}
	public void setTime(float time){
		this.time = time ;
	}
	   @Override
	 protected void onManagedUpdate(float pSecondsElapsed) {
		time += pSecondsElapsed ;
//		for (Bullet b  :  basescene_connect.bullet.getBulletList()) {
//			if (this.collidesWith(b)) {															
//			}				
//			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
//				b.move_y(300);			
//	        }
//			else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
//	        	monster.move_y((float)y - 1000 );
//	        }	      
//		}	
		super.onManagedUpdate(pSecondsElapsed);
	}

}
