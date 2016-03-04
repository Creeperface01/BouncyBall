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
        this.message = this.getString();
        this.isCorrect = true;
    }

    @Override
    protected void _encode() {
        this.reset();
        this.putString(this.message);
    }
}
