package com.example.demo.service;

import com.example.demo.dto.ChatRoom;
import com.example.demo.entity.ChatRoomEntity;
import com.example.demo.repository.ChatRoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.logging.Slf4j;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;
@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    public ChatRoom createRoomIfNotExist(String location) {
        Optional<ChatRoomEntity> chatOptional=chatRoomRepository.findByLocation(location);
        if (chatOptional.isPresent()) {
            return chatRooms.get(location);
        } else {
            ChatRoom createdChatRoom = createRoom(location);
            return createdChatRoom;
        }
    }

    public ChatRoom createRoom(String location) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .location(location)
                .build();
        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
//            log.error(e.getMessage(), e);
        }
    }
}
