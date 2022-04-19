package com.mbi.chatroom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbi.chatroom.exceptions.InvalidRequestException;
import com.mbi.chatroom.exceptions.UnknownCreatorException;
import com.mbi.chatroom.pojo.ChatMessage;
import com.mbi.chatroom.pojo.Message;
import com.mbi.chatroom.service.ChatRoomService;

@RestController
@RequestMapping("/api/")
public class ChatRoomRestController {
	
	@Autowired
	private ChatRoomService chatRoomService;

	@PostMapping("/v1/chatbot/addmessage")
	public void postMessageToChatRoom(@RequestBody Message message) throws InvalidRequestException {
		chatRoomService.saveMessage(message);
		
	}
	
	@GetMapping("/v1/chatbot/getmessages")
	@ExceptionHandler(UnknownCreatorException.class)
	public List<ChatMessage> getMessages(@RequestParam(name="createdby", required =false) String createdBy, 
			@RequestParam(name="chatroomid", required=false) String chatRoomId) throws UnknownCreatorException, InvalidRequestException{
		return chatRoomService.getMessages(createdBy, chatRoomId);
	}
	
}
