package com.daggerok.hateoas.god.services;

import com.daggerok.hateoas.god.infrastructure.HttpBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.daggerok.hateoas.god.domain.Message;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by mak on 4/24/15.
 */
@Controller
@RequestMapping("/last")
public class LastService {
    @ResponseBody
    @RequestMapping("/last")
    public HttpEntity<Message> last() {
        Message message = new Message("sorry, but you died =( seems like God cooler than you. but wait, " +
                "you can try again, just tap on 'first'");

        message.add(linkTo(methodOn(HomeService.class).home()).withSelfRel().withRel("first"));
        return HttpBuilder.buildResponseOk(message);
    }
}
