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
@RequestMapping("/next")
public class NextService {
    @ResponseBody
    @RequestMapping("/next")
    public HttpEntity<Message> next() {
        Message message = new Message("hello again! I think you much more cooler, isn't? tap 'next' if so " +
                "or 'prev' if not");

        message.add(linkTo(methodOn(HomeService.class).home()).withSelfRel().withRel("prev"));
        message.add(linkTo(methodOn(OtherService.class).other()).withSelfRel().withRel("next"));
        return HttpBuilder.buildResponseOk(message);
    }
}
