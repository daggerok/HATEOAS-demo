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
 * Created by mak on 4/24/15.
 */
@Controller
@RequestMapping("/other")
public class OtherService {
    @ResponseBody
    @RequestMapping("/other")
    public HttpEntity<Message> other() {
        Message message = new Message("you almost God, but if you don't think that you aren't cool enough " +
                "press 'next' to be coolest at all, otherwise tap 'prev' and go cry...");

        message.add(linkTo(methodOn(NextService.class).next()).withSelfRel().withRel("prev"));
        message.add(linkTo(methodOn(LastService.class).last()).withSelfRel().withRel("next"));
        return HttpBuilder.buildResponseOk(message);
    }
}
