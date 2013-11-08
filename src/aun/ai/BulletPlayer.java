package aun.ai;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;

public class BulletPlayer extends Bullet{
   
	float shoot = -1000.0f ;
	public BulletPlayer(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
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
		mHandler.setVelocityY(speed);
	}

	@Override
	public void ability() {
		move_y(shoot);
		
	}

	@Override
	public void procressevent(GameObject object) {
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}
	@Override
	public void Update() {
		ability();
	}
}
