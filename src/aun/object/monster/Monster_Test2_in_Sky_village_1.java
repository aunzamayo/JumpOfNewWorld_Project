package aun.object.monster;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.Monster;

public class Monster_Test2_in_Sky_village_1 extends Monster {

	float alpha = 10.0f ;
	public Monster_Test2_in_Sky_village_1(
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		animate(200);
		setScale(0.8f);
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
		mHandler.setVelocityY(speed);
	}

	@Override
	public void ability() {
		// TODO Auto-generated method stub
		alpha ++ ;
		setAlpha(alpha);
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
