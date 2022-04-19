package com.mbi.chatroom.database;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mbi.chatroom.exceptions.UnknownCreatorException;
import com.mbi.chatroom.pojo.ChatMessage;
import com.mbi.chatroom.pojo.Message;

@Repository
public class ChatRoomDB {
	
	private List<Message> chatRoomMessages = new ArrayList<Message>();
	
	public List<ChatMessage> getAllMessages() {
		// TODO Auto-generated method stub
		Function<Message, ChatMessage> function = p -> new ChatMessage(p.getMessage(), p.getChatRoomId(), p.getCreatedBy());
		return chatRoomMessages.stream().sorted(Message::compareTo).map(function::apply).collect(Collectors.toList());
	}
	
	public boolean isCreatorExist(String createdBy) {
		return chatRoomMessages.stream().parallel().anyMatch(chatMessage -> chatMessage.getCreatedBy().equalsIgnoreCase(createdBy));
	}
	
	public boolean isChatRoomExist(String chatRoomId) {
		return chatRoomMessages.stream().parallel().anyMatch(chatMessage -> chatMessage.getChatRoomId().equalsIgnoreCase(chatRoomId));
	}
	
	public List<ChatMessage> getAllMessages(String createdBy) throws UnknownCreatorException {
		Function<Message, ChatMessage> function = p -> new ChatMessage(p.getMessage(), p.getChatRoomId(), p.getCreatedBy());
		// TODO Auto-generated method stub
		return chatRoomMessages.stream().filter( message -> message.getCreatedBy()
					.equalsIgnoreCase(createdBy)).sorted(Message::compareTo)
					.map(function::apply).collect(Collectors.toList());
	}
	
	public List<ChatMessage> getAllMessages(String createdBy, String chatRoomId) throws UnknownCreatorException {
		Function<Message, ChatMessage> function = p -> new ChatMessage(p.getMessage(), p.getChatRoomId(), p.getCreatedBy());
		// TODO Auto-generated method stub
		return chatRoomMessages.stream().filter( message -> message.getCreatedBy()
					.equalsIgnoreCase(createdBy) && message.getChatRoomId().equalsIgnoreCase(chatRoomId)).sorted(Message::compareTo)
					.map(function::apply).collect(Collectors.toList());
	}
	
	public List<ChatMessage> getAllMessagesByChatRoomId(String chatRoomId) throws UnknownCreatorException {
		Function<Message, ChatMessage> function = p -> new ChatMessage(p.getMessage(), p.getChatRoomId(), p.getCreatedBy());
		// TODO Auto-generated method stub
		return chatRoomMessages.stream().filter( message -> message.getChatRoomId()
					.equalsIgnoreCase(chatRoomId)).sorted(Message::compareTo)
					.map(function::apply).collect(Collectors.toList());
	}

	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		message.setEpochMilliSec(Instant.now().toEpochMilli());
		chatRoomMessages.add(message);
	}
	
	

}
