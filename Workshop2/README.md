# 1. Conceptual Design Updates

This is a description of the changes and updates that were made to the document. Since we're working on the README in the repository, the changes are reflected there.

## Objectives

- Make an app where the users can send and receive messages and make voice calls.
- Implement a system or an authenticator where every user can have a personal account.
- Design a website that is intuitive and easy to use for everyone, with essential functionalities and a seamless user experience that enhances accessibility, responsiveness, and user engagement.

Being primarily a messaging application, the main objectives are precisely to add contacts with a specific user to communicate with them through the same.

## Application Overview

Be able to do calls is a prioritary task, but due to time the project will only have voice calls.
The proposed application is inspired by Skype and includes:
- User registration with email.
- Messaging and voice calls.
- Public and private group creation and management.
- Contact handling and user profile customization.
- Account control (temporary suspension, deletion).
- Invitation system for friends and groups.

## Requirements

### Functional Requirements:

- Register and log in with email and password.
- Send and receive private messages to other users.
- Make voice calls.
- Log out securely.
- Permanently delete an account.
- Create and/or delete groups.
- Personalize your account (photo, name, status).
- Delete messages, call history and full chats.

We decide to add an option to delete chats or messages, and a call history as a low priority requirements.

### Non-Functional Requirements:

- User data and communications must be protected.
- The system prevents duplicate usernames and email addresses when creating an account.
- Account changes must be saved and applied instantly.
- Multiple users can use the platform without causing it to crash.

## User Stories

- *As a new user, I want to be able to use my email to create a personal account in the app with a unique username and password.*
- *As a user, I want to be able to communicate with other users through messages and calls while maintaining private conversations.*
- *As a user, I want to create and delete public or private groups to chat with other users.*
- *As a user, I want to send messages in a group or chat and have other people see them instantly and be able to reply to them.*
- *As a user, I want to be able to join existing groups to participate in new conversations.*
- *As a goup owner, I want to be able to add or remove other users from a group.*
- *As a group owner, I want my groups to be manageable only by me or other users to whom I give permission.*
- *As a user, I want a user-friendly and customizable interface so I can adjust it to my liking.*
- *As a user, I want to temporarily close my account securely to protect it while I'm not using the app.*
- *As a user, I want to delete my account permanently.*

## Mockups

The first Mock-Ups designed are:
- Login page
![Login Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup1.jpg)
- Home screen with contact list and groups.
  ![Main Page Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup2.jpg)
- Profile interface.
![Profile Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup3.jpg)


## CRC Cards
Initially, each of the following classes was considered a parent class. Upon reviewing the document, it was decided that there would be a parent class from which the others would be derived and removing classes like message, as these could hinder the code.

Now, the main class is:
**User**
- **Responsibilities:** Register an log in, edit profile, add and remove contacts.
- **Collaborators:** Contact list, message, calls.

The subclasses are:

**1. Contact**
- **Responsibilities:** Represent another user the contact list, display contact name and status.
- **Collaborators:** User.
  
**2. Chat**
- **Responsibilities:** Manage a conversation between two or more users, store a list of messages, display messages in order,  keep a log of past calls, display past conversartions.
- **Collaborators** User, message.

**3. Call**
- **Responsibilities:** Start a call between two or more users, tract duration and participants, end the call.
- **Collaborators:** User, call history.
   **3.1 Call History**
   -**Responsibilities:**
   -**Colaborators:**
# Technical Design

Here you can find the UML diagram

![UML Diagram](https://github.com/ValU020/Java-Project/blob/main/Workshop2/UML.png)
