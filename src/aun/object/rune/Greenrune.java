package aun.object.rune;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.Rune;

public class Greenrune extends Rune {

	public Greenrune(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		procressevent(this);
		setScale(0.45f);
	}

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
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}

	

	@Override
	public void Update() {
		OutOfScreenY();
	}


	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 2;
	}

}
