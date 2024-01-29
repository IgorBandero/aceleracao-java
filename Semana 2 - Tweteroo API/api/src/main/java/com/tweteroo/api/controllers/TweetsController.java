package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetsService;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tweets")
public class TweetsController {
    final TweetsService tweetsService;
    TweetsController(TweetsService tweetsService){
        this.tweetsService = tweetsService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createTweet (@RequestBody @Valid TweetDTO body) {
        Optional<TweetModel> tweet = tweetsService.save(body);
        if(!tweet.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to create tweet!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
    
}
