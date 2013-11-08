package aun.object.monster;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.LoopModifier;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.GameObject;
import aun.object.Monster;

public class Monster_Test3_in_Sky_village_1 extends Monster {

	float centerX  = this.mX ;
	float centerY = this.mY ;
	double radius = 180;
	double angle = 0;
	float speed = 3f ;
	float time ;
	
	public Monster_Test3_in_Sky_village_1(
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		setScale(0.8f);
		animate(200);
		procressevent(this);
		 centerX  = this.mX ;
		 centerY = this.mY ;
		 
	}

	@Override
	public void move_x() {
		 x = radius * Math.cos(angle) + centerX;
		mHandler.setVelocityX((float) x);
		
	}
	@Override
	public void move_y() {
		 y = radius * Math.sin(angle) + centerY;		
		mHandler.setVelocityY((float) y);
//		Log.w(" Value_Y ", " " + y);
	}

	@Override
	public void move_x(float speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move_y(float speed) {
		
		mHandler.setVelocityY(speed);
	}

	@Override
	public void ability() {
		move_x();
		move_y();
		if(angle > 30){
			activity.scenmanager.getsceneplay().get(0).settime(0.0f);
		}
	}

	@Override
	public void procressevent(GameObject object) {
		// TODO Auto-generated method stub
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}
	@Override
	public void Update() {
		time = activity.scenmanager.getsceneplay().get(0).gettime() ; 
		angle += time * speed; 
		ability();
		
		Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
		
		if (this.collidesWith(basescene_connect.player)) {															
		}				
		if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
			this.move_y((float)y +300 );	
        }
		else if (basescene_connect.realstate ==  basescene_connect.state_player[1]){
        	this.move_y((float)y -1000 );
        }
		
		super.Update();
	}
	
}
