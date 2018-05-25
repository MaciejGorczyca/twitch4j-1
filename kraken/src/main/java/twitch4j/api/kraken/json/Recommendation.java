package twitch4j.api.kraken.json;

import java.util.List;
import lombok.Data;

/**
 * Model representing a recommendation.
 * <p>
 * The recommendation is made on basis of a single channel.
 * If you watch channel x, then you will like the following streams.
 *
 * @author Philipp Heuer [https://github.com/PhilippHeuer]
 * @version %I%, %G%
 * @since 1.0
 */
@Data
public class Recommendation {
	/**
	 * Holds the Channel
	 */
	private Channel channel;

	/**
	 * Streams recommended for this channel
	 */
	private List<Stream> streams;

}
