/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.serializer.EzspSerializer;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EmberApsFrame;

/**
 * Class to implement the Ember EZSP command <b>sendReply</b>.
 * <p>
 * Sends a reply to a received unicast message. The incomingMessageHandler callback for the
 * unicast being replied to supplies the values for all the parameters except the reply itself.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSendReplyRequest extends EzspFrameRequest {
    public static final int FRAME_ID = 0x39;

    /**
     * Value supplied by incoming unicast.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int sender;

    /**
     * Value supplied by incoming unicast.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     */
    private EmberApsFrame apsFrame;

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int messageTag;

    /**
     * The reply message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] messageContents;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspSendReplyRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * Value supplied by incoming unicast.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current sender as {@link int}
     */
    public int getSender() {
        return sender;
    }

    /**
     * Value supplied by incoming unicast.
     *
     * @param sender the sender to set as {@link int}
     */
    public void setSender(int sender) {
        this.sender = sender;
    }

    /**
     * Value supplied by incoming unicast.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     *
     * @return the current apsFrame as {@link EmberApsFrame}
     */
    public EmberApsFrame getApsFrame() {
        return apsFrame;
    }

    /**
     * Value supplied by incoming unicast.
     *
     * @param apsFrame the apsFrame to set as {@link EmberApsFrame}
     */
    public void setApsFrame(EmberApsFrame apsFrame) {
        this.apsFrame = apsFrame;
    }

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current messageTag as {@link int}
     */
    public int getMessageTag() {
        return messageTag;
    }

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     *
     * @param messageTag the messageTag to set as {@link int}
     */
    public void setMessageTag(int messageTag) {
        this.messageTag = messageTag;
    }

    /**
     * The reply message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current messageContents as {@link int[]}
     */
    public int[] getMessageContents() {
        return messageContents;
    }

    /**
     * The reply message.
     *
     * @param messageContents the messageContents to set as {@link int[]}
     */
    public void setMessageContents(int[] messageContents) {
        this.messageContents = messageContents;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeUInt16(sender);
        serializer.serializeEmberApsFrame(apsFrame);
        serializer.serializeUInt8(messageTag);
        serializer.serializeUInt8(messageContents.length);
        serializer.serializeUInt8Array(messageContents);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(148);
        builder.append("EzspSendReplyRequest [sender=");
        builder.append(sender);
        builder.append(", apsFrame=");
        builder.append(apsFrame);
        builder.append(", messageTag=");
        builder.append(messageTag);
        builder.append(", messageContents=");
        for (int c = 0; c < messageContents.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", messageContents[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}
