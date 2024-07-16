package com.example.AnketYonetimi.api;

import com.example.AnketYonetimi.business.abstracts.ParticipationService;
import com.example.AnketYonetimi.business.abstracts.SurveyService;
import com.example.AnketYonetimi.business.dto.request.ParticipationRequest;
import com.example.AnketYonetimi.business.dto.response.ParticipationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/participation")
public class ParticipationController {
    private ParticipationService participationService;
    @PostMapping("/{surveyId}/participate")
    public ResponseEntity<Void> participateInSurvey(
            @PathVariable Long surveyId,
            @RequestParam Long userId,
            @RequestBody List<String> answers) {
        participationService.participateInSurvey(surveyId, userId, answers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ParticipationResponse addParticipation(@Valid @RequestBody ParticipationRequest participationRequest) {
//        return participationService.addParticipation(participationRequest);
//    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipationResponse> getAllParticipation() {
        return participationService.getAllParticipation();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParticipationResponse updateParticipation(@RequestBody() ParticipationRequest participationRequest) {
        return participationService.updateParticipation(participationRequest);
    }



    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParticipationResponse getParticipationById( @PathVariable int id ){
        return participationService.getParticipationById(id);
    }
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBrand(@PathVariable int id) {
        participationService.deleteParticipation(id);
    }
}
