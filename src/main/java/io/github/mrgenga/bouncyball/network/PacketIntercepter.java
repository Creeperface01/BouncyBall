package io.github.mrgenga.bouncyball.network;

import io.github.mrgenga.bouncyball.MinecraftPEServer;
import io.github.mrgenga.bouncyball.network.packet.*;
import io.github.mrgenga.bouncyball.session.RemoteClientSession;
import io.github.mrgenga.bouncyball.util.ProxyException;
import io.github.mrgenga.bouncyball.util.*;

import static io.github.mrgenga.bouncyball.network.PacketIDs.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.*;
import java.util.*;

import io.github.jython234.jraklibplus.protocol.raknet.*;
import io.github.jython234.jraklibplus.protocol.raknet.CustomPackets.*;

/**
 *
 */
public class PacketIntercepter {
    private MinecraftPEServer server;

    public PacketIntercepter(MinecraftPEServer server){
        this.server = server;
    }

    public byte[] interceptPacket(byte[] buffer, RemoteClientSession session, boolean toServer){
        CustomPacket cp = null;
        try {
            ByteBuffer bb = ByteBuffer.wrap(buffer);
            byte pid = bb.get();

            //server.getLogger().debug("Intercepting packet "+ Util.toHex(pid)+" (ToServer: "+Boolean.toString(toServer)+")");

            if(pid <= RAKNET_CUSTOM_PACKET_MAX && pid >= RAKNET_CUSTOM_PACKET_MIN){ //Custom Packet
                switch(pid){
                    case (byte)0x80:
                        cp = new CustomPacket_0();
                        break;
                    case (byte)0x81:
                        cp = new CustomPacket_1();
                        break;
                    case (byte)0x82:
                        cp = new CustomPacket_2();
                        break;
                    case (byte)0x83:
                        cp = new CustomPacket_3();
                        break;
                    case (byte)0x84:
                        cp = new CustomPacket_4();
                        break;
                    case (byte)0x85:
                        cp = new CustomPacket_5();
                        break;
                    case (byte)0x86:
                        cp = new CustomPacket_6();
                        break;
                    case (byte)0x87:
                        cp = new CustomPacket_7();
                        break;
                    case (byte)0x88:
                        cp = new CustomPacket_8();
                        break;
                    case (byte)0x89:
                        cp = new CustomPacket_9();
                        break;
                    case (byte)0x8A:
                        cp = new CustomPacket_A();
                        break;
                    case (byte)0x8B:
                        cp = new CustomPacket_B();
                        break;
                    case (byte)0x8C:
                        cp = new CustomPacket_C();
                        break;
                    case (byte)0x8D:
                        cp = new CustomPacket_D();
                        break;
                    case (byte)0x8E:
                        cp = new CustomPacket_E();
                        break;
                    case (byte)0x8F:
                        cp = new CustomPacket_F();
                        break;
                }
                cp.decode(buffer);
                List<EncapsulatedPacket> pk = new ArrayList<>();
                for(EncapsulatedPacket ep: cp.packets){
                    pk.add(handleCustomPacket(ep, session, toServer));
                }
                cp.packets = pk;
                return cp.encode();
            }
        } catch (IOException e) {
            server.getLogger().error(e.getMessage()+", while intercepting custom packet (Packets "+cp.packets.size());
            //throw new ProxyException(e);
        }
        return buffer;
    }

    private EncapsulatedPacket handleCustomPacket(EncapsulatedPacket ep, RemoteClientSession session, boolean toServer) throws IOException {
        byte pid;
        if(ep.payload[0] == (byte)0x8e){
            pid = ep.payload[1]; //MCPE packet
        } else {
            pid = ep.payload[0]; //RakNet MC packet
        }
        //server.getLogger().debug("Intercepting packet "+ Util.toHex(pid)+" CustomPacket PID: "+Util.toHex(cPID)+"(ToServer: "+Boolean.toString(toServer)+")");

        if(ep.payload[0] == (byte)0x8e){
            switch(pid){
                case LOGIN_PACKET:
                    LoginPacket lp = new LoginPacket();
                    lp.decode(ep.payload);
                    if(!lp.isCorrect){
                        return ep;
                    }
                    server.getLogger().info(lp.username+"["+session.getAddress().toString()+"] logged into the proxy. (Protocol "+lp.protocol+")");

                    session.setUsername(lp.username);

                    InetSocketAddress socketAddress = (InetSocketAddress) session.getRemoteServer().getAddress();
                    InetAddress inetAddress = socketAddress.getAddress();
                    String ip = inetAddress.getHostAddress();
                    String port = Integer.toString(socketAddress.getPort());

                    lp.serverAddress = ip+":"+port;
                    lp.encode();
                    ep.payload = Binary.appendBytes((byte) 0x8e, Binary.appendBytes((byte) 0x8f, lp.getBuffer()));
                    //ep.payload = Binary.appendBytes((byte) 0x8e, lp.encode());

                    return ep;

                case MOVE_PLAYER_PACKET:
                    if(!session.hasSpawned()){
                        session.setSpawned(true);
                        server.getLogger().debug("Spawned!");
                    }
                    return ep;

                case DISCONNECT_PACKET:
                    DisconnectPacket dp = new DisconnectPacket();
                    dp.decode(ep.payload);

                    if(!dp.isCorrect){
                        return ep;
                    }

                    session.getRemoteServer().setRunning(false);

                    server.serverSessions.remove(session.getRemoteServer().getAddress().toString());
                    server.clientSessions.remove(session.getAddress().toString());

                    if(toServer) {
                        server.getLogger().info(session.getUsername() + "[" + session.getAddress().toString() + "] disconnected: disconnected by client: "+dp.message);
                    } else {
                      server.getLogger().info(session.getUsername() + "[" + session.getAddress().toString() + "] disconnected: disconnected by server: "+dp.message);
                    }
                    return ep;

              /*case MC_MESSAGE_PACKET:
                   if(toServer) { //To prevent private messages from being displayed.
                       MessagePacket mp = new MessagePacket();
                       mp.decode(ep.buffer);
                       if(server.logChat()) {
                           server.getLogger().info("[Server: " + session.getRemoteServer().getAddress().toString() + "] " + mp.message);
                       }
                   }
                   break;*/
            }
        }
        switch(pid){
            case MC_DISCONNECT_NOTIFICATION:
                session.getRemoteServer().setRunning(false);

                server.serverSessions.remove(session.getRemoteServer().getAddress().toString());
                server.clientSessions.remove(session.getAddress().toString());

                server.getLogger().info(session.getUsername() + "[" + session.getAddress().toString() + "] disconnected.");
                break;
        }
        return ep;
    }
}
