package io.github.mrgenga.bouncyball.network.packet;

import io.github.mrgenga.bouncyball.util.ProxyException;
import io.github.mrgenga.bouncyball.util.BinaryStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Represents a DataPacket
 */
public abstract class DataPacket extends BinaryStream {

    protected void _encode() {
        throw new UnsupportedOperationException("Encoding not implemented.");
    }
    protected void _decode() {
        throw new UnsupportedOperationException("Decoding not implemented.");
    }

    public byte[] encode(){
        _encode();
        return this.buffer;
    }

    public void decode(byte[] data){
        this.buffer = data;
        this.offset = 2;
        _decode();
    }
}
