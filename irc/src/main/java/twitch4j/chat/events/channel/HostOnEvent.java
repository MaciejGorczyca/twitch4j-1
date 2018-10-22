package twitch4j.chat.events.channel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import twitch4j.chat.domain.ChatChannel;
import twitch4j.chat.events.AbstractChannelEvent;

/**
 * This event gets called when the user starts hosting someone.
 */
@Value
@Getter
@EqualsAndHashCode(callSuper = false)
public class HostOnEvent extends AbstractChannelEvent {

	/**
	 * Event Target ChatChannel
	 */
	private ChatChannel targetChannel;

	/**
	 * Event Constructor
	 *
	 * @param channel       The channel that this event originates from.
	 * @param targetChannel The channel that was hosted.
	 */
	public HostOnEvent(ChatChannel channel, ChatChannel targetChannel) {
		super(channel);
		this.targetChannel = targetChannel;
	}

}
