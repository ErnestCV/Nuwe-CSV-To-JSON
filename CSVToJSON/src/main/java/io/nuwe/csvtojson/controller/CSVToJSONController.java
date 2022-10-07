package io.nuwe.csvtojson.controller;

import io.nuwe.csvtojson.response.MessageResponse;
import io.nuwe.csvtojson.service.CSVToJSONService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CSVToJSONController {

    private final CSVToJSONService csvToJSONService;

    @PostMapping(value = "/csvtojson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> csvToJSON(@RequestParam("file") MultipartFile file) {

        //Check empty file
        if (file.isEmpty()) {
            return new ResponseEntity<>(new MessageResponse("The file has no content"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(csvToJSONService.convert(file), HttpStatus.OK);
    }
}