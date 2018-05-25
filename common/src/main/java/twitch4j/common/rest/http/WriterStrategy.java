/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package twitch4j.common.rest.http;

import javax.annotation.Nullable;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.client.HttpClientRequest;

/**
 * Strategy for encoding an object of type {@code <Req>} and writing the encoded stream of bytes to an {@link
 * reactor.ipc.netty.http.client.HttpClientRequest}.
 *
 * @param <Req> the type of object in the body
 */
public interface WriterStrategy<Req> {

	/**
	 * Whether the given object type is supported by this writer.
	 *
	 * @param type        the type of object to check
	 * @param contentType the content type for the write
	 * @return {@code true} if writable, {@code false} otherwise
	 */
	boolean canWrite(@Nullable Class<?> type, @Nullable String contentType);

	/**
	 * Write a given object to the output message.
	 *
	 * @param request the request to write to
	 * @param body    the object to write
	 * @return indicates completion or error
	 */
	Mono<Void> write(HttpClientRequest request, @Nullable Req body);
}
