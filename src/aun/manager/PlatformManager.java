package aun.manager;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.scene.Scene;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.object.Jinny;
import aun.object.NormalPlatform;

public class PlatformManager {
    
	GameJumpActivity activity ;
	private ArrayList<NormalPlatform> normalplatformlist ;
	float x ;
    float y = 10.0f ;
	
    public PlatformManager(GameJumpActivity gm) {	
		this.activity = gm ;   
	    normalplatformlist = new ArrayList<NormalPlatform>();
	}
	
	public GameObject createnormalplatform (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		NormalPlatform normalplatform = new NormalPlatform(activity.load.createResource.getTexture(9), activity.getVertexBufferObjectManager(), activity);
		normalplatform.setPosition(x, y +=100);
		normalplatformlist.add(normalplatform);	
		
		return normalplatform ;
	
	}
	
	public ArrayList<NormalPlatform> getNormalPlatformList(){
		return normalplatformlist ;
	}
	
	public void removeNormalPlatform (GameObject object){
      		normalplatformlist.remove(object);
	}
	
	
	
}
