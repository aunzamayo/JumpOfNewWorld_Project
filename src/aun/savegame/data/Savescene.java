package aun.savegame.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import aun.activity.GameJumpActivity;

public class Savescene  {
	
	public int scoresave  ;
	
	public float r_position_x [] ;
	public float r_position_y [] ;
	
	public float position_x ; 
	public float position_y ;
	
	public float m_position_x [] ; 
	public float m_position_y [] ;
	
	public float sm_position_x[] ; 
	public float sm_position_y[] ;
	
	public float n_position_x[] ; 
	public float n_position_y[] ;
	
	GameJumpActivity activity ;
	SharedPreferences preferences ;
	
	public Savescene(GameJumpActivity activity) {
		this.activity = activity ;
		preferences = PreferenceManager.getDefaultSharedPreferences(activity);	
		
		scoresave = preferences.getInt("S",0);
		
		position_x = preferences.getFloat("p_X", 0);
		position_y = preferences.getFloat("p_Y", 0);
		
		m_position_x = new float[activity.sceneplay.get(0).monsterlist.size()];
		m_position_y = new float[activity.sceneplay.get(0).monsterlist.size()];
		
		sm_position_x = new float[activity.sceneplay.get(0).specialmonsterlist.size()];
		sm_position_y = new float[activity.sceneplay.get(0).specialmonsterlist.size()];
		
		n_position_x = new float[activity.sceneplay.get(0).platformslist.size()];
		n_position_y = new float[activity.sceneplay.get(0).platformslist.size()];
		
		r_position_x  = new float[activity.sceneplay.get(0).runeslist.size()] ;
		r_position_y  = new float[activity.sceneplay.get(0).runeslist.size()];
		
		for (int i = 0; i < m_position_x.length; i++){
			this. m_position_x [i] = preferences.getFloat("m_X"+i,m_position_x [i]);
			this. m_position_y [i] = preferences.getFloat("m_Y"+i,m_position_y [i]);
		}
		
		for (int i = 0; i < sm_position_x.length; i++){
			this.sm_position_x [i] = preferences.getFloat("sm_X"+i,sm_position_x[i]);
			this.sm_position_y [i] = preferences.getFloat("sm_Y"+i,sm_position_y[i]);
		}
		for (int i = 0; i < n_position_x.length; i++){
			this.n_position_x [i] = preferences.getFloat("n_X"+i,n_position_x[i]);
			this.n_position_y [i] = preferences.getFloat("n_Y"+i,n_position_y[i]);
		}
		for (int i = 0; i < r_position_x.length; i++){
			this.r_position_x [i] = preferences.getFloat("r_X"+i,r_position_x[i]);
			this.r_position_y [i] = preferences.getFloat("r_Y"+i,r_position_y[i]);
		}
	}
	
	public void save_Score(int id,String key , int value){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		Editor edit = sp.edit();	
		edit.putInt(key, value);		
		edit.commit();
		
	}
	public void save_entity(int id,String key , float value){
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(activity);
		Editor edit = sp.edit();	
		edit.putFloat(key, value);		
		edit.commit();
	}

}
