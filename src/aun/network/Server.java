package aun.network;

import java.io.IOException;


import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.multiplayer.protocol.adt.message.IMessage;
import org.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.andengine.extension.multiplayer.protocol.server.IClientMessageHandler;
import org.andengine.extension.multiplayer.protocol.server.SocketServer;
import org.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector;
import org.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector.ISocketConnectionClientConnectorListener;
import org.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.andengine.extension.multiplayer.protocol.util.MessagePool;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.andengine.util.adt.list.SmartList;
import org.andengine.util.debug.Debug;
import org.andengine.util.math.MathUtils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import android.util.Log;
import aun.activity.GameJumpActivity;
import aun.message.MessageConstance;
import aun.scene.Scene_Battle_Client;
import aun.update.objectnetwork.Client_Message;
import aun.update.objectnetwork.PlayerClassRoom;
import aun.update.objectnetwork.SetPaddleIDServerMessage;
import aun.update.objectnetwork.UpdatePlayerServerTest;
import aun.update.objectnetwork.UpdateServerPlayerMessage;





public class Server extends SocketServer<SocketConnectionClientConnector> implements MessageConstance  {
	
	private final MessagePool<IMessage> mMessagePool = new MessagePool<IMessage>();
	public ServerCalculate servercalculate ;
	  
	
    GameJumpActivity activity ;	
	public Server(int serverport,final ISocketConnectionClientConnectorListener 
			pSocketConnectionClientConnectorListener
			,final ISocketServerListener<SocketConnectionClientConnector> pSocketServerListener,GameJumpActivity gm){	
		
		super(serverport, pSocketConnectionClientConnectorListener,pSocketServerListener );
		
		activity = gm ;
		servercalculate = new  ServerCalculate(activity);
		initMessagePool();
			
	}
	public void initMessagePool(){
		this.mMessagePool.registerMessage(FLAG_Gravity,UpdateServerPlayerMessage.class);
		this.mMessagePool.registerMessage(FLAG_Jump,UpdateServerPlayerMessage.class);
		this.mMessagePool.registerMessage(FLAG_PlayerID,PlayerClassRoom.class);
		this.mMessagePool.registerMessage(FLAG_PlayerID_1,UpdatePlayerServerTest.class);
	}
	public MessagePool<IMessage> getMessagePool(){
    	return mMessagePool ;
    }
	public void test (){
//		final UpdateServerPlayerMessage updateServerPlayerMessage = (UpdateServerPlayerMessage) activity.mserver.getMessagePool().obtainMessage(FLAG_Gravity);
//		final float jinny =   activity.scenmanager.getsceneplay().get(0).getBodysimmulate().getPosition().y * physics_pixel - this.getWidth()/2  ;	
//		final SmartList<SocketConnectionClientConnector> clientConnectors = this.mClientConnectors;
//		for(int i = 0; i < clientConnectors.size(); i++) {
////			Log.w("id"," "+clientConnectors.size() );
//			final ClientConnector<SocketConnection> clientConnector = clientConnectors.get(i);
//			clientConnector.sendServerMessage(updateScoreServerMessage);
//		}
////		Log.w("id"," "+clientConnectors.size() );
	}
	
	public SmartList<SocketConnectionClientConnector> getmClientConnectors(){
		return mClientConnectors ;
	}

	@Override
	protected SocketConnectionClientConnector newClientConnector(SocketConnection pSocketConnection) throws IOException {
		
		final SocketConnectionClientConnector clientConnector = new SocketConnectionClientConnector(pSocketConnection);
		clientConnector.registerClientMessage(FLAG_Client, Client_Message.class, new IClientMessageHandler<SocketConnection>(){
			@Override
			public void onHandleMessage(final ClientConnector<SocketConnection> pClientConnector, final IClientMessage pClientMessage) throws IOException {
				final Client_Message client_message = (Client_Message) pClientMessage;
//			   	activity.roombattle_Client.character.setPosition(client_message.mX , client_message.mY);
				Scene_Battle_Client  scenbatleClient = (Scene_Battle_Client) activity.scenmanager.getmenuscene().get(5);
				scenbatleClient.character.setPosition(client_message.mX , client_message.mY);
        		final UpdatePlayerServerTest classroomserver = (UpdatePlayerServerTest) activity.mserver.getMessagePool().obtainMessage(FLAG_PlayerID_1);
        		classroomserver.setX(client_message.mX);
			    classroomserver.setY(client_message.mY);
			    try {
					activity.mserver.sendBroadcastServerMessage(classroomserver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
				
			}
		});
	
        clientConnector.sendServerMessage(new SetPaddleIDServerMessage(mClientConnectors.size()));
		return clientConnector;
	}
	
	
	
		

}

