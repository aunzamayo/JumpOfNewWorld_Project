package aun.object;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;

public class RuneFire extends Rune {

	public RuneFire(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		procressevent(this);
	}
    
	
	@Override
	public void Update() {
		OutOfScreenY();
		super.Update();
	}
	
//	@Override
//	public void Update() {
//		 OutOfScreenY();
//		 
//		
//	}

	@Override
	public void move_x() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move_y(float speed) {
		// TODO Auto-generated method stub
		mHandler.setVelocityY(speed);
	}

	@Override
	public void procressevent(GameObject object) {
		// TODO Auto-generated method stub
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 0;
	}
    	
}
