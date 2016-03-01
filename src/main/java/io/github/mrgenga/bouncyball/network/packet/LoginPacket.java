package io.github.mrgenga.bouncyball.network.packet;

import java.io.IOException;

import io.github.mrgenga.bouncyball.BouncyBall;

/**
 * MCPE Login Packet (0x8f).
 */
public class LoginPacket extends DataPacket{
    public String username;
    public int protocol;
    public int protocol2;
    public long clientID;
    public boolean isCorrect;

    @Override
    protected void _decode() {
        try{
            this.username = this.getString();
            this.protocol = this.getInt();
            this.protocol2 = this.getInt();
            this.clientID = this.getLong();
            this.getUUID(); //clientUUID
            this.getString(); //serverAddress
            this.getString(); //clientSecret
            this.getString(); //skinName
            this.getString(); //skin
            this.isCorrect = true;
        } catch(ArrayIndexOutOfBoundsException e){
            BouncyBall.SERVER_INSTANCE.getLogger().error("Not correct LoginPacket received!");
            this.isCorrect = false;
        }
    }
}
