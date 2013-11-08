package aun.ai;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;

public class BulletProjectile extends Bullet {
	
	
	boolean count ;
	public BulletProjectile(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		count = true ;
		setScale(0.5f);
		procressevent(this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move_y(float speed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability() {
		
        
		mHandler.setVelocityY(200);
		if(count){
			mHandler.setVelocityX(50);
			count = false ;
		}

		mHandler.setAngularVelocity(360);
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
