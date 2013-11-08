package aun.resource;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;

import android.content.Context;
import android.graphics.Color;
import aun.activity.GameJumpActivity;

public class LoadResource {
	public CreateResource createResource ;
	
	private Font mFont;
	GameJumpActivity activity ;
	public LoadResource(GameJumpActivity gm,Engine mEngine , Context context) {
	    this.activity = gm ;
		createResource = new CreateResource();	
	    createResource.loadResources(mEngine, context, 1024, 1024, "BG1.png", 0, 0, 1, 1); //0
	    createResource.loadResources(mEngine, context,1024,128, "story.png", 0, 0, 1, 1);  //1
	    createResource.loadResources(mEngine, context, 1024, 128, "Mul.png", 0, 0, 1, 1);  //2
	    createResource.loadResources(mEngine, context, 1024, 128, "highscore.png", 0, 0, 1, 1);//3
	    createResource.loadResources(mEngine, context, 1024, 128, "shop.png", 0, 0, 1, 1); //4
	    createResource.loadResources(mEngine, context, 1024, 1024, "JON.png", 0, 0, 1, 1); //5
		createResource.loadResources(mEngine,context, 1024, 1024,"sound-open.png", 0, 0, 1, 1); //6
		createResource.loadResources(mEngine,context, 1024, 1024,"sound-close.png", 0, 0, 1, 1); //7
		createResource.loadResources(mEngine,context, 64, 64,"face_box_tiled.png", 0, 0, 2, 1); //8
		createResource.loadResources(mEngine,context, 64, 64,"platform.png", 0, 0, 1, 1); //9	
	    createResource.loadResources(mEngine,context, 256, 256,"s1.png", 0, 0, 2, 1);//10
	    createResource.loadResources(mEngine,context, 256, 256,"s2v.png", 0, 0, 2, 1);//11
	    createResource.loadResources(mEngine,context, 256, 256,"s3v.png", 0, 0, 2, 1);//12
	    createResource.loadResources(mEngine,context, 256, 256,"s4v.png", 0, 0, 2, 1);//13
	    createResource.loadResources(mEngine,context, 256, 256,"s5v.png", 0, 0, 2, 1);//14
	    createResource.loadResources(mEngine,context, 256, 256,"s6v.png", 0, 0, 2, 1);//15
	    createResource.loadResources(mEngine,context, 256, 256,"s7v.png", 0, 0, 2, 1);//16
	    createResource.loadResources(mEngine,context, 512, 512,"gem.png", 0, 0, 1, 1);//17
	    createResource.loadResources(mEngine,context, 1024, 1024,"background_world.jpg", 0, 0, 1, 1);//18
	    createResource.loadResources(mEngine,context, 64,64 ,"baserune.png", 0, 0, 1, 1);//19
	    createResource.loadResources(mEngine,context, 1024,1024,"bg_dialog.png", 0, 0, 1, 1);//20
	    createResource.loadResources(mEngine,context, 512,512,"retry.png", 0, 0, 1, 1);//21
	    createResource.loadResources(mEngine,context, 512,512,"bg_level1.png", 0, 0, 1, 1);//22
	    createResource.loadResources(mEngine,context, 128,128,"exit.png", 0, 0, 1, 1);//23
	    createResource.loadResources(mEngine,context, 128,128,"ok.png", 0, 0, 1, 1);//24
	    createResource.loadResources(mEngine,context, 512,512,"textbox.png", 0, 0, 1, 1);//25
	    createResource.loadResources(mEngine,context, 128,128,"Level.png", 0, 0, 1, 1);//26
	    createResource.loadResources(mEngine,context, 128,128,"quest.png", 0, 0, 1, 1);//27
	    createResource.loadResources(mEngine,context, 1024,1024,"mul_networkBG.png", 0, 0, 1, 1);//28
	    createResource.loadResources(mEngine,context, 256,256,"back_multi.png", 0, 0, 1, 1);//29
	    createResource.loadResources(mEngine,context, 512,512,"global.png", 0, 0, 1, 1);//30
	    createResource.loadResources(mEngine,context, 512,512,"Local.png", 0, 0, 1, 1);//31
	    createResource.loadResources(mEngine,context, 1024,1024,"battle.png", 0, 0, 1, 1);//32    
	    createResource.loadResources(mEngine,context, 128,128,"Blue_rune.png", 0, 0, 1, 1);//33
	    createResource.loadResources(mEngine,context, 128,128,"Green_rune.png", 0, 0, 1, 1);//34
	    createResource.loadResources(mEngine,context, 128,128,"Red_rune.png", 0, 0, 1, 1);//35
	    createResource.loadResources(mEngine,context, 128,128,"enemy.png", 0, 0, 3, 4);//36
	    createResource.loadResources(mEngine,context,256,64,"frog.png", 0, 0, 4, 1);//37
	    createResource.loadResources(mEngine,context,512,64,"bufterfly.png", 0, 0, 4, 1);//38
	    createResource.loadResources(mEngine,context,64,64,"bullet.png", 0, 0, 1, 1);//39 bird.png
	    createResource.loadResources(mEngine,context,512,64,"bird.png", 0, 0, 5, 1);//40 basuka.png
	    createResource.loadResources(mEngine,context,512,128,"basuka.png", 0, 0, 6, 1);//41 Character_Button.png
	    createResource.loadResources(mEngine,context,256,256,"right.png", 0, 0, 1, 1);//42
	    createResource.loadResources(mEngine,context,1024,1024,"left.png", 0, 0, 1, 1);//43
	    createResource.loadResources(mEngine,context,64,64,"face_hexagon_tiled.png", 0, 0, 2, 1);//44
	    createResource.loadResources(mEngine,context,64,64,"face_circle_tiled.png", 0, 0, 2, 1);//45
	    createResource.loadResources(mEngine,context,64,64,"face_triangle_tiled.png", 0, 0, 2, 1);//46
	    
	    this.mFont = FontFactory.createFromAsset(activity.getFontManager(), activity.getTextureManager()
				, 512, 512, TextureOptions.BILINEAR, activity.getAssets(), "Plok.ttf", 32, true, Color.WHITE);
		this.mFont.load();
	}

	public Font getFont(){
		return mFont ;
	}
	
	
}
