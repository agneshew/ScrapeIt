package com.agnes.ScrapeIt.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileResponse {

    String fileName;
    String fileType;
    String fileUri;
}
