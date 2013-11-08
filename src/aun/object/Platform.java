package aun.object;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;

public abstract class Platform extends GameObject {

	public Platform(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract void move_x();
	public abstract void move_y(float speed);
	public abstract void procressevent( GameObject object );
	
	public void OutOfScreenY() {
		if (mY > activity.getCamaraHeight()) { // OutOfScreenX (right)
			mY = 0;
		}
	}
	
//	@Override
//	protected void onManagedUpdate(float pSecondsElapsed) {
//		Update();
//
//		super.onManagedUpdate(pSecondsElapsed);
//	}

}
