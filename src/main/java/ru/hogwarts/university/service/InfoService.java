package ru.hogwarts.university.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    Logger logger = LoggerFactory.getLogger(InfoService.class);

//    @Value("${server.port}")
    final int port;

    public InfoService(@Value("${server.port}") int port) {
        this.port = port;
    }

    public int getPort() {
        logger.info("Port: " + port);
        return port;
    }
}
