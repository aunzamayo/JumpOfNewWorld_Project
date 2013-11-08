package aun.scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

import aun.activity.GameJumpActivity;
import aun.object.GameObject;
import aun.stategame.State_game.Statemenu;

public class Scene_multiplayersection extends BaseMenuScene {
	
	   private final int	MENU_global	= 0;
	   private final int	MENU_local	= MENU_global + 1;
	
		public Scene_multiplayersection(GameJumpActivity gm, Camera camera) {
			super(gm, camera);
			this.createScene();
			
			
		}

		@Override
		public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
				float pMenuItemLocalX, float pMenuItemLocalY) {
			
			switch (pMenuItem.getID())
			{
				case MENU_global:		
					break;
				case MENU_local:
//					activity.stategame.setStatemenu(Statemenu.Gameworldmenu);
					activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(1));
					break ;
			}
			return false;
		}

		@Override
		public Scene createScene() {

			final GameObject bg = new GameObject(activity.load.createResource.getTexture(28),activity.getVertexBufferObjectManager(), activity);
			attachChild(bg);
			
			final GameObject back = new GameObject(activity.load.createResource.getTexture(29),activity.getVertexBufferObjectManager(), activity){
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
//					activity.stategame.setStatemenu(Statemenu.Gameworldmenu);
					activity.scenmanager.setScene(activity.scenmanager.getmenuscene().get(0));
					return true;
		    	}
			};
			back.setPosition(-40,550);
			attachChild(back);
			
//            final GameObject global = new GameObject(activity.load.createResource.getTexture(30),activity.getVertexBufferObjectManager(), activity){
//				
//			};
//			global.setPosition((activity.getCameraWidth()/2) - global.getWidth()/2,(activity.getCamaraHeight()/2 ) - global.getHeight()/2);
//			attachChild(global);
			
			
			final IMenuItem global = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_global ,280, 170, activity.load.createResource.getTexture(30),
					activity.getVertexBufferObjectManager()), 1.1f, 1);
			
			final IMenuItem local = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_local ,280, 170, activity.load.createResource.getTexture(31),
					activity.getVertexBufferObjectManager()), 1.1f, 1);

			menuscene.addMenuItem(global);
			menuscene.addMenuItem(local);
			menuscene.buildAnimations();	
			menuscene.setBackgroundEnabled(false);
			menuscene.setOnMenuItemClickListener(this);
			setChildScene(menuscene);
			
	
			setTouchAreaBindingOnActionDownEnabled(true);
			registerTouchArea(back);
			
			return this;
		}

		@Override
		public void Update() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Scene getScene() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setScene(Scene sc) {
			// TODO Auto-generated method stub
			
		}

}
