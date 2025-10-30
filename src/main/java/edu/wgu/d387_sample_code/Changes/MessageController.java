package edu.wgu.d387_sample_code.Changes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private WelcomeMessage welcomeMessage;

    @Autowired
    private TimeConverter timeConverter;

    public String welcomeMessageResult;

    public String presentationMessageResult;



    @RequestMapping("/welcomeMessage")
    public ResponseEntity<String> getWelcomeMessage() {
        welcomeMessage.run();
        welcomeMessageResult = String.join("\n", WelcomeMessage.message);
        return new ResponseEntity<>(welcomeMessageResult, HttpStatus.OK);
    }

    @RequestMapping("/presentationMessage")
    public ResponseEntity<String> getPresentationMessage() {
        presentationMessageResult = "Join us live for an online interactive presentation at " + timeConverter.convert();
        return new ResponseEntity<>(presentationMessageResult, HttpStatus.OK);
    }

}
