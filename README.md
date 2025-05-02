# SKYPE

This is a project that emerges as a small-scale version of the Skype application, based on the same for its design and functionality based on an object-oriented system.

## Objectives

- Make an app where the users can send and receive messages, make voice and video calls and share activities with their partners.
- Implement a system or an authenticator where every user can have a personal account.
- Design a website that is intuitive and easy to use for everyone, with essential functionalities and a seamless user experience that enhances accessibility, responsiveness, and user engagement

## Application Overview

The proposed application is inspired by Skype and includes:
- User registration with email.
- Messaging and voice/video calls.
- Public and private group creation and management.
- Contact handling and user profile customization.
- Account control (temporary suspension, deletion).
- Invitation system for friends and groups.

## 1. Requirements

### Functional Requirements:

- Register and log in with email and password.
- Send and receive private messages to other users.
- Make video or voice calls.
- Create and/or delete groups.
- Personalize your account (photo, name, status).
- Log out securely.
- Permanently delete an account.

### Non-Functional Requirements:

- User data and communications must be protected.
- The system prevents duplicate usernames and email addresses when creating an account.
- Account changes must be saved and applied instantly.
- Multiple users can use the platform without causing it to crash.

## 2. User Stories

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

## 3. Mockups

Preliminary UI mockups were designed for:
- Login page
![Login Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup1.jpg)
- Home screen with contact list and groups.
  ![Main Page Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup2.jpg)
- Profile interface.
![Profile Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup3.jpg)
Mockups are provided as simple sketches and justify basic layout choices to support the user flow.

## 4. CRC Cards

Each main class is represented with:
**1. User**
- **Responsibilities:** Register an log in, edit profile, add and remove contacts.
- **Collaborators:** Contact list, message, calls.

**2. Contact**
- **Responsibilities:** Represent another user the contact list, display contact name and status.
- **Collaborators:** User.

**3. Message**
- **Responsibilities:** Store message content, record timestamp, know the sender and receiver
- **Collaborators:** User.
  
**4. Call**
- **Responsibilities:** Start a call between two or more users, tract duration and participants, end the call.
- **Collaborators:** User, call history.
  
**5. Chat**
- **Responsibilities:** Manage a conversation between two or more users, store a list of messages, display messages in order,  keep a log of past calls, display past conversartions.
- **Collaborators** User, message.



## 📁 Repository Structure
## Observations
My partner, Kevin Navarrete didn´t contribute at all in the construction of this project other than the Mock-Ups; if kevin do something, delete this sentence.\
Pd: Fuck you kevin :) <3
