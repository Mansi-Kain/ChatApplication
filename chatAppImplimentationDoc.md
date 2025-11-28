Chat Application – Implementation Document

This document defines the complete specification for building the chat backend using Spring Boot (no DB, in-memory storage).
Windsurf should generate all classes, controllers, services, in-memory repositories, and WebSocket modules based on this file.

## 1. Project Overview

Build a backend for a chat application supporting:

- 1-1 and group chats
- Typing indicators via WebSocket
- Read receipts
- Search users by name
- Global search across users + messages
- In-memory dummy data (no database)
  - Production-style layered architecture

## 2. Entities (Domain Models)
    2.1 User
       class User {
       String userId;
       String name;
       String phoneNo;
       LocalDateTime lastSeenTimeStamp;
       }

     2.2 Chat
         class Chat {
         String chatId;
         List<String> participants;
         Boolean isGroup;
         String name; // only for group chats
         }
    
     2.3 Message
         class Message {
         String messageId;
         String chatId;
         String senderId;
         String content;
         LocalDateTime timestamp;
         Set<String> readByUserIds;
         }
  
## 3. In-Memory Database (Repositories)
Repositories will store dummy data so the APIs run without any DB.

    3.1 UserRepository
    Map<String, User> users = new HashMap<>();
    Preload 5 users.
    
    3.2 ChatRepository
    Map<String, Chat> chats = new HashMap<>();
    
    Preload:
    - One 1-1 chat 
    - One group chat
    
    3.3 MessageRepository
    Map<String, Message> messages = new HashMap<>();
    Preload 
    - 10 sample messages linked to chats.

## 4. Class Diagram (Text UML)

UserController ----------> UserService ----------> UserRepository

SearchController --------> SearchService -------->
                               |-------------> UserRepository
                               |-------------> MessageRepository

ReadReceiptController ----> ReadReceiptService --> MessageRepository

TypingController (WebSocket) ----> (Broadcasts directly — No Service / No Storage)


## 5. API Contracts

## 5.1 API to search User
Method : GET /api/users/search?name={name}

## Description

Returns list of users whose name matches the search keyword.
Success Response: 200

{
    "users": [
        {
        "userId": "U1",
        "name": "Mansi",
        "phoneNo": "9999999999",
        "lastSeenTimeStamp": "2025-01-01T10:00:00"
        }
    ]
}

Errors:
400 : { "error": "No users found" }
500 : { "error": "Unexpected server error" }

## 5.2 Global Search API 

Method : GET /api/search/global?keyword={keyword}

## Description

Searches across both:
- Users (search by name)
- Messages (search by content)

Response DTO: 

    class SearchResponse {
        List<Message> messages;
        List<User> users;
    }

Success Response: 200
{
"messages": [],
"users": []
}

Errors: 
404 : { "error": "No results found" }

## 5.3 Read Receipts API

1. Mark message as read

Method:
POST /api/messages/{messageId}/read/{userId}

Success Response: 200
{ "status": "marked_as_read" }

Errors
404 : { "error": "Message or User not found" }

2. Get read receipts

Method: GET /api/messages/{messageId}/read-receipts

Success Response: 200
{
"readByUserIds": ["U1", "U3"]
}

## 5.4 Typing Indicator API (WebSocket)
WebSocket Endpoint
/ws/typing

    Client → Server Event
    {
    "chatId": "C1",
    "userId": "U2",
    "typing": true
    }
    
    Server → Clients Broadcast
    {
    "chatId": "C1",
    "typingUsers": ["U2"]
    }


## 6. Services Definition
   ## 6.1 UserService
   - List<User> searchUsers(String query);
   - User getUser(String userId);

    ## 6.2 SearchService
    - SearchResponse globalSearch(String keyword);
    
    ## 6.3 ReadReceiptService
    - void markAsRead(String messageId, String userId);
    - Set<String> getReadReceipts(String messageId);
    
    ## 6.4 TypingService
    - void setTyping(String chatId, String userId, boolean typing);
    - Set<String> getTypingUsers(String chatId);

## 7. Error Handling Guidelines
All controllers must use:
Status Codes :
- 200 OK → success

- 400 Bad Request → missing params

- 404 Not Found → user/chat/message missing

- 500 Internal Server Error → any other issue

Example Controller Handling
try {
// logic
} catch (NotFoundException e) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
} catch (Exception e) {
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Something went wrong"));
}

## 8. Dummy Data Requirements

## Auto-generate dummy data inside repositories (in-memory).
Example:
5 users
2 chats
10 messages

All APIs should work directly using this sample data.

### DB Entities / DB Schema (Optional – for future DB connection)

1. users Table
   
        CREATE TABLE users (
        user_id VARCHAR(50) PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        phone_no VARCHAR(20),
        last_seen_timestamp TIMESTAMP
        );

2. chats Table
   
        CREATE TABLE chats (
        chat_id VARCHAR(50) PRIMARY KEY,
        is_group BOOLEAN NOT NULL,
        name VARCHAR(100)
        );

3.  chat_participants Table
  
        CREATE TABLE chat_participants (
        chat_id VARCHAR(50),
        user_id VARCHAR(50),
        PRIMARY KEY (chat_id, user_id),
        FOREIGN KEY (chat_id) REFERENCES chats(chat_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id)
        );

4.  messages Table

        CREATE TABLE messages (
        message_id VARCHAR(50) PRIMARY KEY,
        chat_id VARCHAR(50) NOT NULL,
        sender_id VARCHAR(50) NOT NULL,
        content TEXT,
        timestamp TIMESTAMP,
        FOREIGN KEY (chat_id) REFERENCES chats(chat_id),
        FOREIGN KEY (sender_id) REFERENCES users(user_id)
        );

6. read_receipts Table

        CREATE TABLE read_receipts (
        message_id VARCHAR(50),
        user_id VARCHAR(50),
        PRIMARY KEY (message_id, user_id),
        FOREIGN KEY (message_id) REFERENCES messages(message_id),
        FOREIGN KEY (user_id) REFERENCES users(user_id)
        
        );




