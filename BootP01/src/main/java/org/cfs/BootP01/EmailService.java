package org.cfs.BootP01;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService{
    @Override
    public String sendMessages() {
        return "EMAIL MESSAGE";
    }
}