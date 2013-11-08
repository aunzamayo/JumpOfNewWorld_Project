package aun.object;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.R.integer;
import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;

public abstract class  Rune extends GameObject {
	Basescene_Coregame basescene_connect =  activity.scenmanager.getsceneplay().get(0) ;
	public Rune(ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			GameJumpActivity gm) {
		super(pTiledTextureRegion, pVertexBufferObjectManager, gm);
		// TODO Auto-generated constructor stub
	}
	public abstract void move_x();
	public abstract void move_y(float speed);
	public abstract void procressevent( GameObject object );
	public abstract  Integer getId();

	@Override
	public void Update() {
		OutOfScreenY();
		
//			if (this.collidesWith(this) && basescene_connect.runemanager.getrune_Id().size() < 3) {				
//						this.setPosition(0, -500);
//						basescene_connect.runemanager.addIdlist(this.getId());
//						Log.w("getid", " "+ basescene_connect.runemanager.SummaryId_Rune.size());			
//						basescene_connect.runemanager.mix_rune();				
//			}
//			
//			
//			if( basescene_connect.player.getY() < activity.getCamaraHeight()/2   &&  basescene_connect.realstate ==  basescene_connect.state_player[0] ){	
//				this.move_y(300);	
//	        }else if ( basescene_connect.realstate ==  basescene_connect.state_player[1]){
//	        	this.move_y(-1000);
//	        }else{
//	        	this.move_y(0);
//	        }
			      
	}
	
	
	public void OutOfScreenY() {
		if (mY > activity.getCamaraHeight()) { 
			mY = 0;
		}
	}
}
