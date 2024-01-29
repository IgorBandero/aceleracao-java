package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetsService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



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

    @GetMapping("")
    public ResponseEntity<List<TweetModel>> getTweets() {
        List<TweetModel> tweets = tweetsService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getTweetsByUserId(@PathVariable Long userId) {
        Optional<List<TweetModel>> tweets = tweetsService.findByUserId(userId);
        if (!tweets.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tweets not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }
    
    
    
}
