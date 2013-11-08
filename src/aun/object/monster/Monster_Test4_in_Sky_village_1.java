package aun.object.monster;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.ai.Bullet;
import aun.ai.BulletAI;
import aun.ai.BulletManager;
import aun.object.GameObject;
import aun.object.Monster;

public class Monster_Test4_in_Sky_village_1 extends Monster {
	
	BulletManager bullet_AI  ;
	float direction = 100.0f ;
	
	public Monster_Test4_in_Sky_village_1(
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		setScale(-1, 1);
		bullet_AI = new BulletManager(activity);
	    procressevent(this);
		animate(200);
	}

	@Override
	public void move_x() {
		// TODO Auto-generated method stub
		if(mX < 0){
	         	direction *= -1 ;
	         	 setScale(-1, 1);
	    }else if (mX > activity.getCameraWidth()-64){
	         	direction *= -1 ;
	         	setScale(1, 1);
	    } 
		move_x(direction);
	}

	@Override
	public void move_y() {
		
	}

	@Override
	public void move_x(float speed) {
		 mHandler.setVelocityX(speed); 
	}

	@Override
	public void move_y(float speed) {
		mHandler.setVelocityY(speed);
	}

	@Override
	public void ability() {
		move_x();
		if(time >= 7){
//			bullet_AI.addbullet(this.getX(),this.getY(),activity.scenmanager.getsceneplay().get(0));
			bullet_AI.addbullet(this.getX(),this.getY(),activity.scenmanager.getsceneplay().get(0));
			time = 0 ;
		}
		
		for(Bullet bullet : bullet_AI.getBulletList() ){
			if(bullet.getY() > activity.getCamaraHeight()){
				
					bullet_AI.removebullet(bullet);
					Log.w("remove", " " + bullet_AI.getBulletList().size());
				
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
		ability();
		super.Update();
	}

}
