package io.nuwe.csvtojson.service;

import io.nuwe.csvtojson.exception.InvalidFormatException;
import io.nuwe.csvtojson.utils.CSVParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CSVToJSONService {

    private final CSVParser parser;

    public String convert(MultipartFile file) {

        //Check correct format
        if (!"text/csv".equals(file.getContentType())) {
            throw new InvalidFormatException("The file needs to have a CSV format");
        }

        return parser.parseFile(file);
    }
}