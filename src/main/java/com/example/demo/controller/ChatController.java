package com.example.demo.controller;

import com.example.demo.dto.ChatRoom;
import com.example.demo.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;


    @RequestMapping("/chatList")
    public String chatList(Model model){
        List<ChatRoom> roomList = chatService.findAllRoom();
        model.addAttribute("roomList",roomList);
        return "chat/chatList";
    }

    @Operation(summary = "Create a new chat", description = "create new chatroom")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "chat created successfully",
                    content = @Content(schema = @Schema(implementation = ChatRoom.class)),
                    headers = @Header(name = "Location", description = "The URI of the newly created member", schema = @Schema(type = "string"))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ChatRoom> createRoom(@RequestParam String location) {
        ChatRoom room = chatService.createRoomIfNotExist(location);
        return ResponseEntity.status(201).header("Location", "/chat/" ).body(room);  //만든사람이 채팅방에 먼저 들어감
    }

//    @GetMapping("/{location}")
//    public ResponseEntity<ChatRoom> chatRoom(Model model, @RequestParam String location){
//        ChatRoom room = chatService.findOrCreateChatRoom(location);
//
//        return ResponseEntity.ok();
//    }
}
