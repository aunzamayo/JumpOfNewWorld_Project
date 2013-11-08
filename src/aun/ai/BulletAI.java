package aun.ai;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;

public class BulletAI extends Bullet {

	float force =  300 ;
	
	public BulletAI(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
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
//		mHandler.setVelocityY(100);
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
		move_y(force);
		
	}

	@Override
	public void procressevent(GameObject object) {
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}
	
	@Override
	public void Update() {
		ability();
//		if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
////			force = 1000 ;			
//        }
	}

}
