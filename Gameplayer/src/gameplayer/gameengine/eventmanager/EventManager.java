/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplayer.gameengine.eventmanager;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Máté Pozsgay
 */
public class EventManager {

    private static final Map<String, EventChannel> EVENT_CHANNELS = new HashMap<>();
    private static final Map<EventChannel, Object> EVENT_CHANNEL_OWNERS = new HashMap<>();
    public static final EventRegistry EVENT_REGISTRY = new EventRegistry();

    public static EventChannel createEventChannel(Object channelOwner, String channelName) {
        EventChannel eventChannel = new EventChannel(channelName);
        EVENT_CHANNELS.put(channelName, eventChannel);
        EVENT_CHANNEL_OWNERS.put(eventChannel, channelOwner);
        return eventChannel;
    }

    public static void deleteEventChannel(Object sender, String channelName) throws EventChannelInvalidException, EventPermissionDeniedException {
        if (!EVENT_CHANNELS.containsKey(channelName)) {
            throw new EventChannelInvalidException("Event '" + channelName + "' does not exists! Delete failed.");
        }
        EventChannel channel = EVENT_CHANNELS.get(channelName);
        if(EVENT_CHANNEL_OWNERS.get(channel) != sender){
            throw new EventPermissionDeniedException("Object attempted to delete a channel, but this channel doesn't belongs to it.");
        }
    }

    public static EventChannel getEventChannel(String channelName) throws EventChannelInvalidException {
        if (!EVENT_CHANNELS.containsKey(channelName)) {
            throw new EventChannelInvalidException("Event '" + channelName + "' does not exists! Query failed.");
        }
        return EVENT_CHANNELS.get(channelName);
    }

}
