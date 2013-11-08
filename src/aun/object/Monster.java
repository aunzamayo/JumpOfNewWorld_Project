package aun.object;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.monster.Monster_Test3_in_Sky_village_1;

public abstract class Monster extends GameObject {

	
	public 	double y ;
	public  double x ;
//	public Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
	public float time ;
	 
	public Monster(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		// TODO Auto-generated constructor stub
	}
	public abstract void move_x();
	public abstract void move_y();
	public abstract void move_x(float speed);
	public abstract void move_y(float speed);
	public abstract void ability();
	public abstract void procressevent( GameObject object );	
	
	public void OutOfScreenY() {
			if (mY > activity.getCamaraHeight()) { // OutOfScreenX (right)
				mY = 0;
			}
		}
	@Override
	public void Update() {
		OutOfScreenY();
						
	}
	
	 @Override
	    protected void onManagedUpdate(float pSecondsElapsed) {
		 	time += pSecondsElapsed ;
//		 	Log.w(" Value_Y ", " " + y);
		 	super.onManagedUpdate(pSecondsElapsed);
	    	
	    }
}
