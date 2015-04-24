package software.sigma.switter.services;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import software.sigma.switter.domain.Message;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static software.sigma.switter.infrastructure.HttpBuilder.buildResponseOk;

/**
 * Created by mak on 4/24/15.
 */
@Controller
@RequestMapping("/last")
public class LastService {
    @ResponseBody
    @RequestMapping("/last")
    public HttpEntity<Message> last() {
        Message message = new Message("sorry, but you died =( seems like God cooler than you. But wait, " +
                "you can try again, just tap on 'first'");

        message.add(linkTo(methodOn(HomeService.class).home()).withSelfRel().withRel("first"));
        return buildResponseOk(message);
    }
}
