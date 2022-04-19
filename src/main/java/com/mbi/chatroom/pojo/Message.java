package com.mbi.chatroom.pojo;

import org.springframework.stereotype.Component;

@Component
public class Message implements Comparable<Message>{

	private String message;
	private long epochMilliSec;
	private String chatRoomId;
	private String createdBy;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getEpochMilliSec() {
		return epochMilliSec;
	}
	public void setEpochMilliSec(long epochMilliSec) {
		this.epochMilliSec = epochMilliSec;
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
	public int compareTo(Message o) {
		if (this.getEpochMilliSec() < o.getEpochMilliSec()) {
			return 1;
		}
		return -1;
	}
	@Override
	public String toString() {
		return "Message [message=" + message + ", epochMilliSec=" + epochMilliSec + ", chatRoomId=" + chatRoomId
				+ ", createdBy=" + createdBy + "]";
	}

}
