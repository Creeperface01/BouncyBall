package io.github.mrgenga.bouncyball.network.packet;

import java.io.IOException;

import io.github.mrgenga.bouncyball.BouncyBall;

/**
 * MCPE Disconnect Packet (0x92).
 */
public class DisconnectPacket extends DataPacket{
    public String message;
    public boolean isCorrect;

    @Override
    protected void _decode() {
        try{
            this.message = this.getString();
            if(this.message.length > 32){
                BouncyBall.SERVER_INSTANCE.getLogger().error("Not correct DisconnectPacket received!");
                this.isCorrect = false;
            }
            this.isCorrect = true;
        } catch(ArrayIndexOutOfBoundsException e){
            BouncyBall.SERVER_INSTANCE.getLogger().error("Not correct DisconnectPacket received!");
            this.isCorrect = false;
        }
    }

    @Override
    protected void _encode() {
        this.reset();
        this.putString(this.message);
    }
}
