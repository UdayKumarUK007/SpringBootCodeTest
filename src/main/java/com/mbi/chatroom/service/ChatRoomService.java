package com.mbi.chatroom.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbi.chatroom.database.ChatRoomDB;
import com.mbi.chatroom.exceptions.InvalidRequestException;
import com.mbi.chatroom.exceptions.UnknownCreatorException;
import com.mbi.chatroom.pojo.ChatMessage;
import com.mbi.chatroom.pojo.Message;

@Service
public class ChatRoomService {
	private static final Logger logger = LoggerFactory.getLogger(ChatRoomService.class);
	@Autowired
	private ChatRoomDB chatRoomDB;

	public List<ChatMessage> getMessages(String createdBy, String chatRoomId) throws UnknownCreatorException, InvalidRequestException {
		// TODO Auto-generated method stub
		List<ChatMessage> chatRoomMessages = null;
		logger.debug("Received following parameters : createdBy:  {} , chatRoomId : {}", createdBy, chatRoomId);
		if(StringUtils.isBlank(chatRoomId) && StringUtils.isBlank(createdBy)) {
			chatRoomMessages = chatRoomDB.getAllMessages();
		}else if(StringUtils.isBlank(createdBy) && StringUtils.isNotBlank(chatRoomId)){
			if(chatRoomDB.isChatRoomExist(chatRoomId))
				chatRoomMessages = chatRoomDB.getAllMessagesByChatRoomId(chatRoomId);

		} else if(StringUtils.isNotBlank(createdBy) && StringUtils.isBlank(chatRoomId)){
			if(chatRoomDB.isCreatorExist(createdBy))
				chatRoomMessages = chatRoomDB.getAllMessages(createdBy);
		}else{
			if(chatRoomDB.isCreatorExist(createdBy) && chatRoomDB.isChatRoomExist(chatRoomId))
				chatRoomMessages = chatRoomDB.getAllMessages(createdBy, chatRoomId);
		}
		if(chatRoomMessages != null) {
			return chatRoomMessages;
		}else {
			logger.error("Invalid Content. Received Following Parameters : createdBy: {}, ChatRoomId: {}", createdBy, chatRoomId );
			throw new InvalidRequestException("Invalid Content");
		}
	}

	private boolean isValidMessage(Message message) {
		return !(StringUtils.isBlank(message.getChatRoomId()) || StringUtils.isBlank(message.getCreatedBy())
				|| StringUtils.isBlank(message.getMessage()));
	}	
	public void saveMessage(Message message) throws InvalidRequestException {
		// TODO Auto-generated method stub
		if(!isValidMessage(message)) {
			logger.error("Recieved message is Invalid message {}", message);
			throw new InvalidRequestException("Invalid Message Request Object");
		}
		chatRoomDB.saveMessage(message);
	}
}
