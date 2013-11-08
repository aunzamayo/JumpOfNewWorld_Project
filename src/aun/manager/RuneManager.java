package aun.manager;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.scene.Scene;

import android.R.integer;
import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.base_scene.Basescene_Coregame;
import aun.object.GameObject;
import aun.object.Rune;
import aun.object.RuneFire;
import aun.object.rune.Bluerune;
import aun.object.rune.Greenrune;
import aun.object.rune.Redrune;

public class RuneManager {
	
	GameJumpActivity activity ;
	private ArrayList<Rune> Runelist ;
	float x ;
    float y = 10.0f ;
    public  ArrayList<Integer> SummaryId_Rune ;
    private int  sum_id ;
    
//    Basescene_Coregame base = activity.scenmanager.getsceneplay().get(0);
 
	public RuneManager(GameJumpActivity gm){
		this.activity = gm ;  
		Runelist = new ArrayList<Rune>();
		SummaryId_Rune = new ArrayList<Integer>();
		
	}
	public GameObject createrune (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Rune r = new RuneFire(activity.load.createResource.getTexture(19), activity.getVertexBufferObjectManager(), activity);
		r.setPosition(x, y +=100);
		Runelist.add(r);	
		
		return r ;
	
	}
	
	public GameObject createrune_Red (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Rune r = new Redrune(activity.load.createResource.getTexture(35), activity.getVertexBufferObjectManager(), activity);
		r.setPosition(0, 300);
		Runelist.add(r);	
		
		return r ;
	
	}
	
	public GameObject createrune_Blue (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		Rune r = new Bluerune(activity.load.createResource.getTexture(33), activity.getVertexBufferObjectManager(), activity);
		r.setPosition(x, y +=100);
		Runelist.add(r);	
		
		return r ;
	
	}
	public GameObject createrune_Green (Scene sc){
		Random rx = new Random() ;
		x = rx.nextInt(420);
		
		Rune r = new Greenrune(activity.load.createResource.getTexture(34), activity.getVertexBufferObjectManager(), activity);
		r.setPosition(x, y +=100);
		Runelist.add(r);	
		
		return r ;
	
	}
	
	
	
	public ArrayList<Rune> getrune(){
		return Runelist ;
	}
	
	public void removeNormalPlatform (GameObject object){
      		Runelist.remove(object);
	}
	
	public void mix_rune(){
		if(SummaryId_Rune.size() == 3){
				Log.w("feedback", "Ready Skill");
				for (Integer i : SummaryId_Rune){
					sum_id += i;			
				}
//				Log.w("feedback", "sum " + sum_id);
				activity.scenmanager.getsceneplay().get(0).skillmanager.serchskill.useSkill(sum_id);
				SummaryId_Rune.clear();
				sum_id = 0 ;
//				Log.w("feedback", "size " + SummaryId_Rune.size());
						
		}
		
	}
	public void addIdlist (Integer id){	
			SummaryId_Rune.add(id);	
	}
	
	public ArrayList<Integer> getrune_Id (){
		return SummaryId_Rune ;
	}
	
	
	
	
}
