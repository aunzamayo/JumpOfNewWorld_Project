package aun.object;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import aun.activity.GameJumpActivity;

public class NormalPlatform extends Platform {


	public NormalPlatform(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		
		procressevent(this);
	}

	@Override
	public void move_x() {
		
		
	}

	@Override
	public void move_y(float speed) {
		mHandler.setVelocityY(speed);
		
	}

	@Override
	public void procressevent(GameObject object) {
		
		mHandler = new PhysicsHandler(object);
		object.registerUpdateHandler(mHandler);
	}
	
	@Override
	public void Update(){

	   OutOfScreenY();
//		float difference  =  (activity.getCamaraHeight() /2 - activity.level1.getPlayer().getY());  
//	   )
	   
	   
//		if(activity.level1.getPlayer().getY() < (activity.getCamaraHeight()/2)){	
//		      move_y(200);		
//	   }else{
//		   move_y(0);
//	   }
	
	   
//		if(activity.level1.getPlayer().getY() < (activity.getCamaraHeight()/4)){	
////		      move_y(difference);
//		      activity.level1.b_player.applyForce(activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld().getGravity().x* activity.level1.b_player.getMass(), 
//		    		  activity.mserver.servercalculate.gamePhysicsWorld.getmPhysicsWorld().getGravity().y* 0.2f, 
//		    		  activity.level1.b_player.getWorldCenter().x, 
//		    		  activity.level1.b_player.getWorldCenter().y);
////		      activity.level1.b_player.getPosition().y = (activity.getCamaraHeight()/4)/PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT ;
////		      activity.level1.b_player.setType(BodyType.StaticBody);
////		      activity.level1.b_player.getLinearVelocity().y = 0 ;
////		      activity.level1.b_player.getLinearVelocity().y *= -1;
//		}
	}
	
	

}
