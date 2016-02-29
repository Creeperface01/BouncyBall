package net.beaconpe.bouncyball.network.packet;

import java.io.IOException;

/**
 * MCPE Login Packet (0x8f).
 */
public class LoginPacket extends DataPacket{
    public String username;
    public int protocol;
    public int protocol2;
    public long clientID;

    @Override
    protected void _decode() {
        this.username = this.getString();
        this.protocol = this.getInt();
        this.protocol2 = this.getInt();
        this.clientID = this.getLong();
        this.getUUID(); //clientUUID
        this.getString(); //serverAddress
        this.getString(); //clientSecret
        this.getString(); //skinName
        this.getString(); //skin
    }
}
