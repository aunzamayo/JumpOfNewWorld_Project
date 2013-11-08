package aun.network;

import java.net.UnknownHostException;

import org.andengine.extension.multiplayer.protocol.server.SocketServer;
import org.andengine.extension.multiplayer.protocol.server.SocketServer.ISocketServerListener;
import org.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector;
import org.andengine.extension.multiplayer.protocol.util.WifiUtils;
import org.andengine.util.debug.Debug;
import android.widget.Toast;
import aun.activity.GameJumpActivity;



public class ServerState implements ISocketServerListener<SocketConnectionClientConnector>{
    GameJumpActivity activity ;
	public ServerState(GameJumpActivity gm) {
		this.activity = gm ;
	}

	private void toast(final String pMessage) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(activity, pMessage, Toast.LENGTH_SHORT).show();
			}
		});
	}	
	
	
	@Override
	public void onStarted(final SocketServer<SocketConnectionClientConnector> pSocketServer) {
		try {
			this.toast("SERVER: Started. \n" + WifiUtils.getWifiIPv4Address(activity));
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTerminated(final SocketServer<SocketConnectionClientConnector> pSocketServer) {
		this.toast("SERVER: Terminated.");
	}

	@Override
	public void onException(final SocketServer<SocketConnectionClientConnector> pSocketServer, final Throwable pThrowable) {
		Debug.e(pThrowable);
		this.toast("SERVER: Exception: " + pThrowable);
	}

	
	
}
