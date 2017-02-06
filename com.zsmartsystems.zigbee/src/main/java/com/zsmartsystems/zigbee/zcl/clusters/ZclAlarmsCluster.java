package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.ZigBeeDeviceAddress;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.AlarmCommand;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.GetAlarmCommand;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.GetAlarmResponse;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.ResetAlarmCommand;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.ResetAlarmLogCommand;
import com.zsmartsystems.zigbee.zcl.clusters.alarms.ResetAllAlarmsCommand;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * <b>Alarms</b> cluster implementation (<i>Cluster ID 0x0009</i>).
 * <p>
 * Attributes and commands for sending alarm notifications and configuring alarm
 * functionality.
 * <br>
 * Alarm conditions and their respective alarm codes are described in individual
 * clusters, along with an alarm mask field. Where not masked, alarm notifications
 * are reported to subscribed targets using binding.
 * <br>
 * Where an alarm table is implemented, all alarms, masked or otherwise, are
 * recorded and may be retrieved on demand.
 * <br>
 * Alarms may either reset automatically when the conditions that cause are no
 * longer active, or may need to be explicitly reset.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclAlarmsCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0009;

    // Cluster Name
    public static final String CLUSTER_NAME = "Alarms";

    // Attribute constants
    public static final int ATTR_ALARMCOUNT = 0x0000;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(1);

        attributeMap.put(ATTR_ALARMCOUNT, new ZclAttribute(0, "AlarmCount", ZclDataType.UNSIGNED_16_BIT_INTEGER, false, true, false, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclAlarmsCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }


    /**
     * <p>
     * Get the <i>AlarmCount</i> attribute [Attribute ID <b>0</b>].
     * <p>
     * <p>
     * The AlarmCount attribute is 16-bits in length and specifies the number of entries
     * currently in the alarm table. This attribute shall be specified in the range 0x00 to
     * the maximum defined in the profile using this cluster.
     * <br>
     * If alarm logging is not implemented this attribute shall always take the value
     * 0x00.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getAlarmCountAsync() {
        return read(attributes.get(ATTR_ALARMCOUNT));
    }


    /**
     * <p>
     * Synchronously get the <i>AlarmCount</i> attribute [Attribute ID <b>0</b>].
     * <p>
     * <p>
     * The AlarmCount attribute is 16-bits in length and specifies the number of entries
     * currently in the alarm table. This attribute shall be specified in the range 0x00 to
     * the maximum defined in the profile using this cluster.
     * <br>
     * If alarm logging is not implemented this attribute shall always take the value
     * 0x00.
     * <p>
     * This method will block until the response is received or a timeout occurs.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getAlarmCount() {
        return (Integer) readSync(attributes.get(ATTR_ALARMCOUNT));
    }

    /**
     * The Reset Alarm Command
     *
     * @param alarmCode {@link Integer} Alarm code
     * @param clusterIdentifier {@link Integer} Cluster identifier
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> resetAlarmCommand(Integer alarmCode, Integer clusterIdentifier) {
        ResetAlarmCommand command = new ResetAlarmCommand();

        // Set the fields
        command.setAlarmCode(alarmCode);
        command.setClusterIdentifier(clusterIdentifier);

        return send(command);
    }

    /**
     * The Reset All Alarms Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> resetAllAlarmsCommand() {
        ResetAllAlarmsCommand command = new ResetAllAlarmsCommand();

        return send(command);
    }

    /**
     * The Get Alarm Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getAlarmCommand() {
        GetAlarmCommand command = new GetAlarmCommand();

        return send(command);
    }

    /**
     * The Reset Alarm Log Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> resetAlarmLogCommand() {
        ResetAlarmLogCommand command = new ResetAlarmLogCommand();

        return send(command);
    }

    /**
     * The Alarm Command
     *
     * @param alarmCode {@link Integer} Alarm code
     * @param clusterIdentifier {@link Integer} Cluster identifier
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> alarmCommand(Integer alarmCode, Integer clusterIdentifier) {
        AlarmCommand command = new AlarmCommand();

        // Set the fields
        command.setAlarmCode(alarmCode);
        command.setClusterIdentifier(clusterIdentifier);

        return send(command);
    }

    /**
     * The Get Alarm Response
     *
     * @param status {@link Integer} Status
     * @param alarmCode {@link Integer} Alarm code
     * @param clusterIdentifier {@link Integer} Cluster identifier
     * @param timestamp {@link Integer} Timestamp
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getAlarmResponse(Integer status, Integer alarmCode, Integer clusterIdentifier, Integer timestamp) {
        GetAlarmResponse command = new GetAlarmResponse();

        // Set the fields
        command.setStatus(status);
        command.setAlarmCode(alarmCode);
        command.setClusterIdentifier(clusterIdentifier);
        command.setTimestamp(timestamp);

        return send(command);
    }

    /**
     * Add a binding for this cluster to the local node
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> bind() {
        return bind();
    }

    @Override
    public ZclCommand getCommandFromId(int commandId) {
        switch (commandId) {
            case 0: // RESET_ALARM_COMMAND
                return new ResetAlarmCommand();
            case 1: // RESET_ALL_ALARMS_COMMAND
                return new ResetAllAlarmsCommand();
            case 2: // GET_ALARM_COMMAND
                return new GetAlarmCommand();
            case 3: // RESET_ALARM_LOG_COMMAND
                return new ResetAlarmLogCommand();
            default:
                return null;
        }
    }

    @Override
    public ZclCommand getResponseFromId(int commandId) {
        switch (commandId) {
            case 0: // ALARM_COMMAND
                return new AlarmCommand();
            case 1: // GET_ALARM_RESPONSE
                return new GetAlarmResponse();
            default:
                return null;
        }
    }
}