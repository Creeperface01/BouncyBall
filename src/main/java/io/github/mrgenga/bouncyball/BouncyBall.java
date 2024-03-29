package io.github.mrgenga.bouncyball;

import io.github.mrgenga.bouncyball.util.ProxyException;

/**
 * Main class
 */
public class BouncyBall implements Runnable{
    public final static String SOFTWARE_VERSION = "v1.1-SNAPSHOT";
    public final static String MCPE_VERSION = "0.14.0";
    public final static int MCPE_PROTOCOL = 45;

    public static MinecraftPEServer SERVER_INSTANCE;
    public static int PORT = 49256;

    private String[] programArgs;

    public BouncyBall(String[] args){
        this.programArgs = args;
    }

    public static void main(String[] args){
        BouncyBall ball = new BouncyBall(args);
        ball.run();
    }

    @Override
    public void run() {
        MinecraftPEServer server = new MinecraftPEServer(19132);
        SERVER_INSTANCE = server;
        server.setRunning(true);
        try {
            server.run();
        } catch (ProxyException e){
            server.getLogger().error("ProxyException: "+e.getMessage());
            e.printStackTrace();
        } catch(Exception e){
            server.getLogger().error("Exception: "+e.getMessage());
            e.printStackTrace();
        }
    }
}
