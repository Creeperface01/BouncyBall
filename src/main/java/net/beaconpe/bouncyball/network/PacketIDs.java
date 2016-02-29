package net.beaconpe.bouncyball.network;

/**
 * Copyright 2015 BlockServerProject (https://github.com/BlockServerProject/BlockServer)
 * All rights reserved.
 */
public class PacketIDs {
    public static final int RAKNET_PROTOCOL_VERSION = 7;
    public static final byte[] MAGIC = new byte[] {
            0x00, (byte) 0xff, (byte) 0xff, 0x00,
            (byte) 0xfe, (byte) 0xfe, (byte) 0xfe, (byte) 0xfe,
            (byte) 0xfd, (byte) 0xfd, (byte) 0xfd, (byte) 0xfd,
            0x12, 0x34, 0x56, 0x78 };

    public static final byte RAKNET_CONNECTED_PING_OPEN_CONNECTIONS = 0x01;
    public static final byte RAKNET_UNCONNECTED_PING_OPEN_CONNECTIONS = 0x02;
    public static final byte RAKNET_OPEN_CONNECTION_REQUEST_1 = 0x05;
    public static final byte RAKNET_OPEN_CONNECTION_REPLY_1 = 0x06;
    public static final byte RAKNET_OPEN_CONNECTION_REQUEST_2 = 0x07;
    public static final byte RAKNET_OPEN_CONNECTION_REPLY_2 = 0x08;
    public static final byte RAKNET_INCOMPATIBLE_PROTOCOL_VERSION = 0x1A;
    public static final byte RAKNET_UNCONNECTED_PONG_OPEN_CONNECTIONS = 0x1C;
    public static final byte RAKNET_ADVERTISE_SYSTEM = 0x1D;

    public static final byte CUSTOM_PACKET_0 = (byte) 0x80;
    public static final byte CUSTOM_PACKET_1 = (byte) 0x81;
    public static final byte CUSTOM_PACKET_2 = (byte) 0x82;
    public static final byte CUSTOM_PACKET_3 = (byte) 0x83;
    public static final byte CUSTOM_PACKET_4 = (byte) 0x84;
    public static final byte CUSTOM_PACKET_5 = (byte) 0x85;
    public static final byte CUSTOM_PACKET_6 = (byte) 0x86;
    public static final byte CUSTOM_PACKET_7 = (byte) 0x87;
    public static final byte CUSTOM_PACKET_8 = (byte) 0x88;
    public static final byte CUSTOM_PACKET_9 = (byte) 0x89;
    public static final byte CUSTOM_PACKET_A = (byte) 0x8A;
    public static final byte CUSTOM_PACKET_B = (byte) 0x8B;
    public static final byte CUSTOM_PACKET_C = (byte) 0x8C;
    public static final byte CUSTOM_PACKET_D = (byte) 0x8D;
    public static final byte CUSTOM_PACKET_E = (byte) 0x8E;
    public static final byte CUSTOM_PACKET_F = (byte) 0x8F;

    public static final byte RAKNET_CUSTOM_PACKET_MIN = (byte) 0x80;
    public static final byte RAKNET_CUSTOM_PACKET_MAX = (byte) 0x8F;
    public static final byte RAKNET_CUSTOM_PACKET_DEFAULT = (byte) 0x84;

    public static final byte RAKNET_ACK = (byte) 0xA0;
    public static final byte RAKNET_NACK = (byte) 0xC0;

    public final static byte[] RAKNET_HAS_MESSAGE_RELIABILITIES = {
            0x02, 0x03, 0x04, 0x06, 0x07
    };
    public final static byte[] RAKNET_HAS_ORDER_RELIABILITIES = {
            0x01, 0x03, 0x04, 0x07
    };

    public static final byte MC_PING = 0x00;
    public static final byte MC_PONG = 0x03;

    public static final byte MC_CLIENT_CONNECT = 0x09;
    public static final byte MC_SERVER_HANDSHAKE = 0x10;
    public static final byte MC_CLIENT_HANDSHAKE = 0x13;
    public static final byte MC_DISCONNECT_NOTIFICATION = 0x15;

    public static final byte LOGIN_PACKET = (byte) 0x8f;
    public static final byte PLAY_STATUS_PACKET = (byte) 0x90;
    public static final byte DISCONNECT_PACKET = (byte) 0x91;
    public static final byte BATCH_PACKET = (byte) 0x92;
    public static final byte TEXT_PACKET = (byte) 0x93;
    public static final byte SET_TIME_PACKET = (byte) 0x94;
    public static final byte START_GAME_PACKET = (byte) 0x95;
    public static final byte ADD_PLAYER_PACKET = (byte) 0x96;
    public static final byte REMOVE_PLAYER_PACKET = (byte) 0x97;
    public static final byte ADD_ENTITY_PACKET = (byte) 0x98;
    public static final byte REMOVE_ENTITY_PACKET = (byte) 0x99;
    public static final byte ADD_ITEM_ENTITY_PACKET = (byte) 0x9a;
    public static final byte TAKE_ITEM_ENTITY_PACKET = (byte) 0x9b;
    public static final byte MOVE_ENTITY_PACKET = (byte) 0x9c;
    public static final byte MOVE_PLAYER_PACKET = (byte) 0x9d;
    public static final byte REMOVE_BLOCK_PACKET = (byte) 0x9e;
    public static final byte UPDATE_BLOCK_PACKET = (byte) 0x9f;
    public static final byte ADD_PAINTING_PACKET = (byte) 0xa0;
    public static final byte EXPLODE_PACKET = (byte) 0xa1;
    public static final byte LEVEL_EVENT_PACKET = (byte) 0xa2;
    public static final byte BLOCK_EVENT_PACKET = (byte) 0xa3;
    public static final byte ENTITY_EVENT_PACKET = (byte) 0xa4;
    public static final byte MOB_EFFECT_PACKET = (byte) 0xa5;
    public static final byte UPDATE_ATTRIBUTES_PACKET = (byte) 0xa6;
    public static final byte MOB_EQUIPMENT_PACKET = (byte) 0xa7;
    public static final byte MOB_ARMOR_EQUIPMENT_PACKET = (byte) 0xa8;
    public static final byte INTERACT_PACKET = (byte) 0xa9;
    public static final byte USE_ITEM_PACKET = (byte) 0xaa;
    public static final byte PLAYER_ACTION_PACKET = (byte) 0xab;
    public static final byte HURT_ARMOR_PACKET = (byte) 0xac;
    public static final byte SET_ENTITY_DATA_PACKET = (byte) 0xad;
    public static final byte SET_ENTITY_MOTION_PACKET = (byte) 0xae;
    public static final byte SET_ENTITY_LINK_PACKET = (byte) 0xaf;
    public static final byte SET_HEALTH_PACKET = (byte) 0xb0;
    public static final byte SET_SPAWN_POSITION_PACKET = (byte) 0xb1;
    public static final byte ANIMATE_PACKET = (byte) 0xb2;
    public static final byte RESPAWN_PACKET = (byte) 0xb3;
    public static final byte DROP_ITEM_PACKET = (byte) 0xb4;
    public static final byte CONTAINER_OPEN_PACKET = (byte) 0xb5;
    public static final byte CONTAINER_CLOSE_PACKET = (byte) 0xb6;
    public static final byte CONTAINER_SET_SLOT_PACKET = (byte) 0xb7;
    public static final byte CONTAINER_SET_DATA_PACKET = (byte) 0xb8;
    public static final byte CONTAINER_SET_CONTENT_PACKET = (byte) 0xb9;
    public static final byte CRAFTING_DATA_PACKET = (byte) 0xba;
    public static final byte CRAFTING_EVENT_PACKET = (byte) 0xbb;
    public static final byte ADVENTURE_SETTINGS_PACKET = (byte) 0xbc;
    public static final byte BLOCK_ENTITY_DATA_PACKET = (byte) 0xbd;
    public static final byte PLAYER_INPUT_PACKET = (byte) 0xbe;
    public static final byte FULL_CHUNK_DATA_PACKET = (byte) 0xbf;
    public static final byte SET_DIFFICULTY_PACKET = (byte) 0xc0;
    public static final byte CHANGE_DIMENSION_PACKET = (byte) 0xc1;
    public static final byte SET_PLAYER_GAMETYPE_PACKET = (byte) 0xc2;
    public static final byte PLAYER_LIST_PACKET = (byte) 0xc3;
    public static final byte TELEMETRY_EVENT_PACKET = (byte) 0xc4;
    public static final byte SPAWN_EXPERIENCE_ORB_PACKET = (byte) 0xc5;
    public static final byte CLIENTBOUND_MAP_ITEM_DATA_PACKET = (byte) 0xc6;
    public static final byte MAP_INFO_REQUEST_PACKET = (byte) 0xc7;
    public static final byte REQUEST_CHUNK_RADIUS_PACKET = (byte) 0xc8;
    public static final byte CHUNK_RADIUS_UPDATE_PACKET = (byte) 0xc9;
    public static final byte ITEM_FRAME_DROP_ITEM_PACKET = (byte) 0xca;
    public static final byte REPLACE_SELECTED_ITEM_PACKET = (byte) 0xcb;
}
