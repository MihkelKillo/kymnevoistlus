package killo.kymnevoistlus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import killo.kymnevoistlus.dto.SkooridDto;
import killo.kymnevoistlus.dto.TulemusedDto;
import killo.kymnevoistlus.service.KymnevoistlusService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@CrossOrigin
@Slf4j
public class KymnevoistlusController {
    
    @Autowired
    private KymnevoistlusService kymnevoistlusService;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> getGreeting() {
        return new ResponseEntity<String>("See on kümnevõistluse punktide kalkulaator", HttpStatus.OK);
    }

    @PostMapping(value = "/kymnevoistlus", consumes="application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<SkooridDto> postTulemused(@RequestBody TulemusedDto tulemused) {
        log.debug("Tulemused: " + tulemused.toString());
        SkooridDto skoorid =  kymnevoistlusService.getSkoorid(tulemused);
        return new ResponseEntity<SkooridDto>(skoorid, HttpStatus.OK);
    }

}
