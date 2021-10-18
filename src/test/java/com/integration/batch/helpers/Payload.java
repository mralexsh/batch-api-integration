package com.integration.batch.helpers;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class Payload {

    public static String fetch(String path) throws IOException {
        if (path == null) return null;
        return IOUtils.toString(Payload.class.getResourceAsStream("/data/" + path), "UTF-8");
    }

}
