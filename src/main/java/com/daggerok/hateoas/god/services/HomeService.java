package com.daggerok.hateoas.god.services;

import com.daggerok.hateoas.god.domain.Message;
import com.daggerok.hateoas.god.infrastructure.HttpBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by mak on 4/23/15.
 */
@Controller
public class HomeService {
    @ResponseBody
    @RequestMapping("/")
    public HttpEntity<Message> home() {
        Message message = new Message("hi! press 'next' if you are cool guy :)");

        message.add(linkTo(methodOn(NextService.class).next()).withSelfRel().withRel("next"));
        return HttpBuilder.buildResponseOk(message);
    }
}
