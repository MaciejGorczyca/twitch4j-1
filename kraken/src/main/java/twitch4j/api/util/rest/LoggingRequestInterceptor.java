package twitch4j.api.util.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Spring Rest: Logging Request Interceptor
 * <p>
 * The logging request interceptor can be applied to a {@link org.springframework.web.client.RestTemplate} and
 * will log the final request generated by all **previously** added interceptors.
 *
 * @author Philipp Heuer
 * @version %I%, %G%
 * @since 1.0
 */
@Slf4j
public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		String bodyString = new ObjectMapper().readValue(body, String.class);
		log.info("Request:");
		log.info("\tMethod: {}", request.getMethod());
		log.info("\tURI: \"{}\"", request.getURI());
		log.info("\tHeaders: {}", request.getHeaders());
		log.info("\tBody: {}", (bodyString == null) ? null : "\"" + bodyString + "\"");

		return execution.execute(request, body);
	}
}
