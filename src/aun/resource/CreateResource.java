package aun.resource;

import java.util.ArrayList;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;



import android.content.Context;


public  class CreateResource  {
	
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mTextureRegion;
	private ArrayList<TiledTextureRegion> mTextureRegionsList ;
	public CreateResource() {
       	mTextureRegionsList = new ArrayList<TiledTextureRegion>();
		
	}
    public TiledTextureRegion getTexture(int index){
    	
    	if(mTextureRegionsList!= null){
    		for(TiledTextureRegion m : mTextureRegionsList){
    		    m = mTextureRegionsList.get(index) ;
    			return 	m ;
    		}
    	}		
    	return null ;
    		
	}
	
	public void loadResources(Engine mEngine , Context context,int pwidth,int pheight
			, String texture ,int widthtexture,int heighttexture,int columns,int row) {
		
		this.mBitmapTextureAtlas = new BitmapTextureAtlas(mEngine.getTextureManager(), 
				pwidth, pheight,TextureOptions.BILINEAR);
		
		this.mTextureRegion = BitmapTextureAtlasTextureRegionFactory.
				createTiledFromAsset(this.mBitmapTextureAtlas, context, texture, widthtexture, heighttexture,columns, row); // 64x32
		this.mBitmapTextureAtlas.load();
		
		this.mTextureRegionsList.add(mTextureRegion);
		
	}
	

	




       
	


	

	

	

	
	
	
}
