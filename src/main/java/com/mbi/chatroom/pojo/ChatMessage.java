package com.mbi.chatroom.pojo;

public class ChatMessage {
		private String message;
		private String chatRoomId;
		private String createdBy;
		
		public ChatMessage(String message, String chatRoomId, String createdBy) {
			super();
			this.message = message;
			this.chatRoomId = chatRoomId;
			this.createdBy = createdBy;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getChatRoomId() {
			return chatRoomId;
		}
		public void setChatRoomId(String chatRoomId) {
			this.chatRoomId = chatRoomId;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		@Override
		public String toString() {
			return "ChatMessage [message=" + message + ", chatRoomId=" + chatRoomId + ", createdBy=" + createdBy + "]";
		}
		
}
