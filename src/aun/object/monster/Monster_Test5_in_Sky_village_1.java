package aun.object.monster;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.ai.Bullet;
import aun.ai.BulletManager;
import aun.object.GameObject;
import aun.object.Monster;

public class Monster_Test5_in_Sky_village_1 extends Monster {

	
	BulletManager bullet_AI  ;
	
	public Monster_Test5_in_Sky_village_1(
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
		
	}

	@Override
	public void move_y() {
		// TODO Auto-generated method stub
		
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
		if(time >= 12){
			bullet_AI.addbulletprojectile(this.getX(),this.getY(),activity.scenmanager.getsceneplay().get(0));
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
