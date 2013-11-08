package aun.score;

import java.util.ArrayList;
import java.util.Collections;

import org.andengine.entity.scene.Scene;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Address;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import aun.activity.GameJumpActivity;

public class Highscore  {
	
	SharedPreferences preferences ;
	private String names[];
	private float score [];
	
	GameJumpActivity activity ;
	public ArrayList<Float> scorelist ;
	
	float score_preferrence [] ;
	float sc ;
	public Highscore (GameJumpActivity activity){
		
		this.activity = activity ;
		preferences = PreferenceManager.getDefaultSharedPreferences(activity);	 
		scorelist = new ArrayList<Float>();
		score = new float [5];
		score_preferrence = new float [5] ;
		
		for (int i = 0; i < score.length; i++){
			this.score[i] = preferences.getFloat("Highscore"+i,score[i]);
		}		
		scorelist.add(score[0]);
		scorelist.add(score[1]);
		scorelist.add(score[2]);
		scorelist.add(score[3]);
		scorelist.add(score[4]);
		Sortscore();
	}
	
	public void Sortscore(){
		Collections.sort(scorelist,Collections.reverseOrder());	
		
	}
	
    public void addscore(float value){
    	scorelist.add(value);
    	Sortscore();
    	if(scorelist.size() >= 5){
    		scorelist.remove(5);
    	}
    	for(int i = 0; i < scorelist.size(); i++){
    		save_Highscore(i,"Highscore",scorelist.get(i));
    	}
    	
    }
	
	public void save_Highscore(int index ,String key , float value){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		Editor edit = sp.edit();	
		edit.putFloat(key+index, value);
		score[index] = preferences.getFloat(key+index,value);		
		edit.commit();
//		Log.w(key, "score " + score[0]);		
	}

	public void load (){
		for(Float f : scorelist){
			Log.w("name", "score " +  f );
		}
	}
	public void loadpreferrence(){
		for (int i = 0; i < score.length; i++){
			Log.w("name", "score " +  score[i] );
		}
	}
	public float getscore(){
		return score[0];
	}
	
	
	
	
	

}
