package aun.gamephysicsworld;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;




import android.hardware.SensorManager;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;




public class GamePhysicsWorld  {

	private GameJumpActivity activity ;
	private PhysicsWorld mPhysicsWorld;
	private Body bodyplayer ;
	private static final FixtureDef FIXTURE_DEF = PhysicsFactory.createFixtureDef(1, 0.5f, 0.5f);
	public final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);	 
	
	
	public GamePhysicsWorld(GameJumpActivity gm){
	
		activity = gm ; 	
		initworldphysic();
//		getmPhysicsWorld().onUpdate(33.0f);
		
	}
	
	public void initworldphysic(){
		
		
		mPhysicsWorld = new PhysicsWorld(new Vector2(0, SensorManager.GRAVITY_EARTH), false);
		
		
	}
	
	public Body createbodyplayer(GameObject player_simmulate){
		bodyplayer = PhysicsFactory.createBoxBody(this.mPhysicsWorld, player_simmulate, BodyType.DynamicBody, FIXTURE_DEF);
		mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(player_simmulate, bodyplayer, true, true));
	    return bodyplayer ;
	}
	public Body getBody(){
		return bodyplayer ;
	}
	
	public PhysicsWorld getmPhysicsWorld(){
		return mPhysicsWorld ;
	}
	

}
