## Project Description

ChatApplication is a fully functional in-memory chat backend designed with production-like layering and sample data preloaded at startup.
It focuses on clean separation of concerns, high readability, and extensibility for future database integration.

The backend exposes REST APIs for:
- Searching users
- Fetching chats/messages
- Managing read receipts
- Global search operations
- And WebSockets for:
  -Broadcasting typing events in real-time

All data is stored in lightweight, thread-safe HashMap repositories, making the application extremely fast and easy to run without any external setup.
## Core Features
1. User & Chat Management
- Preloaded user profiles
- Support for both 1-1 and group conversations
- Clean domain models representing User, Chat, and Message

2. Messaging
- In-memory message storage
- Timestamped messages
- Searchable by content

3. Read Receipts

- Track which users have read a message
- API to update and retrieve read status

4. Typing Indicators (WebSocket)

- Notifies chat participants when someone is typing
- Broadcast mechanism for all members in a chat

5. Search

- Search users by name
- Global search combining user name + message content

## API Contracts

Below are the primary REST and WebSocket interfaces exposed by the service.

🔹 Search Users
GET /api/users/search?name={query}

Returns a list of users whose names partially match the query string.

Successful Response (200)

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


Errors

400 – Invalid/missing search term

404 – No matching users

🔹 Global Search
GET /api/search/global?keyword={keyword}

Searches across:

User names
Message content

Success (200)

    {
      "users": [...],
      "messages": [...]
    }


Error (404)

{ "error": "No results found" }

🔹 Mark a Message as Read
POST /api/messages/{messageId}/read/{userId}

Marks a message as read by a specific user.

Success (200)

{ "status": "marked_as_read" }


Error (404)

{ "error": "Message or User not found" }

🔹 Get Read Receipt List
GET /api/messages/{messageId}/read-receipts

Success (200)

{
  "readByUserIds": ["U1", "U3"]
}

 ## Real-Time Typing Indicator (WebSocket)
WebSocket Endpoint
/ws/typing

Client → Server
{
  "chatId": "C1",
  "userId": "U2",
  "typing": true
}

Server → All Chat Participants
{
  "chatId": "C1",
  "typingUsers": ["U2"]
}

The server keeps track of typing status in an in-memory map:
Map<String, Set<String>> chatTypingMap

## Architecture

A clean 3-layer design:

Controller ---> Service ---> Repository (in-memory)

Repositories store:

1. Users
2. Chats (1-1 and group)
3. Messages
4. Typing activity
5. Read receipts

All data is preloaded into memory at startup so that the system is functional without a database.

## Testing API 
<img width="1753" height="672" alt="image" src="https://github.com/user-attachments/assets/e4e16a67-0bbe-410d-b994-bceead5b9045" />

<img width="1380" height="380" alt="image" src="https://github.com/user-attachments/assets/a873902d-babf-483f-bc59-cb03cfa0d925" />

<img width="1376" height="820" alt="image" src="https://github.com/user-attachments/assets/6d6b425b-deb1-4b12-a812-8fb45f24d086" />



