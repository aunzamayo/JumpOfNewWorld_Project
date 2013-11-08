package aun.ai;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.object.GameObject;

public class BulletManager  {
	
	GameJumpActivity activity ;
	private ArrayList<Bullet> bulletlist ;
	
	public BulletManager (GameJumpActivity activity){
		this.activity  = activity ;
		initbullet();
	}
	
	public void initbullet(){
		bulletlist = new ArrayList<Bullet>();
	}

	public ArrayList<Bullet> getBulletList(){
		return bulletlist ;
	}
	
	public void addbullet(float x , float y,Scene sc){
		Bullet object = new BulletAI(activity.load.createResource.getTexture(39), activity.getVertexBufferObjectManager(), activity);
		bulletlist.add(object);
		object.setPosition(x, y);
		Log.w("add", "getx " + x + "gety " + y);
		sc.attachChild(object);
		object.Update();
	}
	public void addbulletprojectile(float x , float y,Scene sc){
		Bullet object = new BulletProjectile(activity.load.createResource.getTexture(39), activity.getVertexBufferObjectManager(), activity);
		bulletlist.add(object);
		object.setPosition(x, y);
		sc.attachChild(object);
		object.Update();
	}
	public void addbulletplayer(float x , float y,Scene sc){
		Bullet object = new BulletPlayer(activity.load.createResource.getTexture(39), activity.getVertexBufferObjectManager(), activity);
		bulletlist.add(object);
		object.setPosition(x, y);
		sc.attachChild(object);
		object.Update();
	}
	
	public void removebullet(Bullet object){
		bulletlist.remove(object);
	}
}
