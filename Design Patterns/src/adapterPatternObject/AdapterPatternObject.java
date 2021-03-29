package adapterPatternObject;

//============================================================================
//Name        : AdapterPattern.cpp
//
//The classes and/or objects participating in this pattern are:
//	1. Target   (NASocket)
//			Defines the domain-specific interface that Client (VCR)  uses.
//	2. Adapter   (ConnectorAdapterNAtoEUR)
//			Adapts the interface Adaptee to the Target interface.
//	3. Adaptee   (EURSocket)
//			Defines an existing interface that needs adapting.
//	4. Client   (VCR)
//			Collaborates with objects conforming to the Target (EURSocket)
//			interface.
//
//This uses Objects Adapter.
//============================================================================

//This the  "Target" class.
//North America Socket. Our
//device is manufactured for to be
//used with a North American Socket.

interface NASocket {
	int usingNASocket();
}
//This is the "Adaptee" class. Continential Europe Socket
//The device will be used in Europe which has different sockets.

class EURSocket {
	public int usingEURSocket() {
		System.out.println(
				"Giving you 220 Volt using Europe Connection.");
		return 220;
	}
}

//This is the "Adapter" class. ConnectorAdapterNAtoEUR.
//We need a connector so our device works.

class ConnectorAdapterNAtoEUR implements NASocket {
	public int usingNASocket() {
		// Possibly do some other work and then call
		// usingEURSocket from the European socket.
		int voltage = _adaptee.usingEURSocket();
		return voltage;
	}
	ConnectorAdapterNAtoEUR (EURSocket adaptee) {
		_adaptee = adaptee;
	}
	private EURSocket _adaptee;
}
//Utility Class.

class VCR {
	public void powerUp(int voltage) { System.out.println("Powered up");}
}

//This is our client which will be using
//the Target (NASocket) Interface.

public class AdapterPatternObject {
	public static void main(String[] args) {

		// Create adapter and place a request
		NASocket socket = new ConnectorAdapterNAtoEUR (
									new EURSocket()
						  );
		// socket is-a North American socket. So our North
		// American device can connect.
		int voltage = socket.usingNASocket();
		VCR vcr = new VCR();
		vcr.powerUp(voltage);
	}
} 
