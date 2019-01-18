package com.cbs.edu.spring.decoupled_runtime;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class FileLoaderMessageProvider implements MessageProvider {

    private String fileName;

    public FileLoaderMessageProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getMessage() {
        try {
            return Files.asCharSource(new File(fileName), Charsets.UTF_8).read();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
