package aun.object.monster;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.Monster;

public class Monster_in_Sky_village_1 extends Monster {

	float direction = 100.0f ;
	boolean check = false ;
	public Monster_in_Sky_village_1(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		procressevent(this);
		animate(200);
		setScale(2.0f);
	}

	@Override
	public void move_x() {
            	
	}
	
	@Override
	public void move_x(float speed) {
		 mHandler.setVelocityX(speed);      
	}
	@Override
	public void move_y() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability() {
		 if(mX < 0){
         	direction *= -1 ;
         }else if (mX > 300){
         	direction *= -1 ;
         } 
		move_x(direction);
	}
	
	@Override
	public void procressevent(GameObject object) {
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}	
	
	@Override
	public void move_y(float speed) {
		// TODO Auto-generated method stub
		mHandler.setVelocityY(speed);
	}

    @Override
    public void Update() {
//    	OutOfScreenY();
    	ability();
    	
    	super.Update();
    }

	

	
	
}
