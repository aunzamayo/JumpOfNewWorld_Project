package aun.manager;

import java.util.ArrayList;

import org.andengine.entity.scene.Scene;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.scene.BaseGameScene;
import aun.scene.BaseMenuScene;
import aun.scene.level.Sky_village;


public class SceneManager {

	private Scene scene ;
	GameJumpActivity activity ;
	ArrayList<BaseMenuScene> scenelist;
	ArrayList<BaseGameScene> scenelistplay;
	ArrayList<Basescene_Coregame> sceneplaylist , sceneLoad ;
	
	public SceneManager(GameJumpActivity gm , ArrayList<BaseMenuScene> sc_list , ArrayList<BaseGameScene> scenelistplay , ArrayList<Basescene_Coregame> sceneplaylist ) { 
		activity = gm ; 
		this.scenelist =  sc_list;
		this.scenelistplay = scenelistplay ;
		this.sceneplaylist = sceneplaylist ;
		sceneLoad = new ArrayList<Basescene_Coregame>();
    }
	public ArrayList<BaseMenuScene> getmenuscene(){
		return scenelist ;
	}
	public ArrayList<BaseGameScene> getscene(){
		return scenelistplay ;
	}
	public ArrayList<Basescene_Coregame> getsceneplay(){
		return sceneplaylist ;
	}
	public ArrayList<Basescene_Coregame> getsceneload(){
		return sceneLoad ;
	}
	public void setScene(Scene sc){
		this.scene = sc ;
		activity.getEngine().setScene(this.scene);
	}	
	public Scene getScene(){
		return scene ;
	}
	public void resetScene(int index){
		activity.sceneplay.add(0,new Sky_village(activity));
		Log.w("suck", "size" + activity.sceneplay.size() );
//		activity.sceneplay.remove(base);
		
//		for(Basescene_Coregame s :activity.sceneplay){
//			s = null ;
//			Log.w("suck", "size" + activity.sceneplay.size() );
//		}
	}
	

}
