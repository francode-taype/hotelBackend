package com.francode.hotelBackend.business.services.impl;

import com.francode.hotelBackend.business.services.interfaces.WebSocketService;
import com.francode.hotelBackend.domain.entity.Room;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void sendRoomUpdate(Room room) {
        messagingTemplate.convertAndSend("/topic/rooms", room);
    }

    @Override
    public void sendRoomDeletionNotification(Room room) {
        messagingTemplate.convertAndSend("/topic/rooms", "Room deleted: " + room.getId());
    }
}

