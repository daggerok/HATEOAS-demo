package software.sigma.switter.infrastructure;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by mak on 4/23/15.
 */
public class HttpBuilder {
    public static <T> HttpEntity<T> buildResponseOk(T entry) {
        return new ResponseEntity<T>(entry, HttpStatus.OK);
    }
}
