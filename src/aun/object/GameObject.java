package aun.object;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.physics.box2d.Body;



import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.message.MessageConstance;



public class GameObject extends AnimatedSprite implements MessageConstance {
	
	protected GameJumpActivity activity ;
	public PhysicsHandler mHandler ;
	 
	public  Body b_player ;
	private GameObject player_simmulate ; 
	
	public final float physics_pixel =   PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT ;

	
	public GameObject(final ITiledTextureRegion pTiledTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager , GameJumpActivity gm ) {
		super(0, 0, pTiledTextureRegion, pVertexBufferObjectManager);		
	    this.activity = gm ;
	   
	}
	public void Update(){
		
	}
	public void createsimmulate (GameObject player_simmulate ){
		this.player_simmulate = player_simmulate ;
		player_simmulate.setPosition(0,685);
		b_player = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_simmulate);
		b_player.setActive(false);		
	}
	public void createsimmulate_load (GameObject player_simmulate ){
		this.player_simmulate = player_simmulate ;
		player_simmulate.setPosition(0,685);
		b_player = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_simmulate);
		b_player.setActive(false);		
	}
	public GameObject getsimmulate(){
		return  player_simmulate ;
	}
	public Body getBody(){
		return  b_player = activity.mserver.servercalculate.gamePhysicsWorld.createbodyplayer(player_simmulate) ;
	}
	
	
	
	
	
//	@Override
//	protected void onManagedUpdate(float pSecondsElapsed) {
////		Update();
//
//		super.onManagedUpdate(pSecondsElapsed);
//	}
	
	
	
	
}
