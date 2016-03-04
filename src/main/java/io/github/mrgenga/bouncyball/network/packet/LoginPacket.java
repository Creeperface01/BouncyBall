package io.github.mrgenga.bouncyball.network.packet;

import java.io.IOException;
import java.util.UUID;

import io.github.mrgenga.bouncyball.BouncyBall;
import io.github.mrgenga.bouncyball.util.*;

/**
 * MCPE Login Packet (0x8f).
 */
public class LoginPacket extends DataPacket{

    public String username;

    public int protocol;
    public int protocol2;

    public long clientID;
    public UUID clientUUID;

    public String serverAddress;
    public String clientSecret;

    public String skinName;
    public byte[] skin;

    public boolean isCorrect;

    @Override
    protected void _decode() {
        try{
            this.username = this.getString();
            this.protocol = this.getInt();
            this.protocol2 = this.getInt();
            this.clientID = this.getLong();
            this.clientUUID = this.getUUID();
            this.serverAddress = this.getString();
            this.clientSecret = this.getString();
            this.skinName = this.getString();
            this.skin = this.get(this.getShort());
            this.isCorrect = true;
        } catch(ArrayIndexOutOfBoundsException e){
            BouncyBall.SERVER_INSTANCE.getLogger().error("Not correct LoginPacket received!");
            this.isCorrect = false;
        }
    }

    @Override
    protected void _encode() {
        this.reset();
        this.putString(this.username);
        this.putInt(this.protocol);
        this.putInt(this.protocol2);
        this.putLong(this.clientID);
        this.putUUID(this.clientUUID);
        this.putString(this.serverAddress);
        this.putString(this.clientSecret);
        this.putString(this.skinName);
        this.putShort(this.skin.length);
        this.put(this.skin);
    }
}
