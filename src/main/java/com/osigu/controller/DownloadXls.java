package com.osigu.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping(value = "/payment")
public class DownloadXls {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPaymentXls() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Deudas.xls").getFile());
        ResponseEntity response = ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=Deudas.xls")
                .body(new FileSystemResource(file));

        return response;
    }
}
