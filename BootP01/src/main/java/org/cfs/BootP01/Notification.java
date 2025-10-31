package org.cfs.BootP01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Notification {

    @Autowired
    public MessageService messageService;

    public Notification() {}
    public Notification(MessageService messageService) {}

    public void notifyUser(){
        System.out.println(messageService.sendMessages());
    }

}
