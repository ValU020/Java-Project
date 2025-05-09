
# Example using encapsulation and polymorphism in Python

class User:
    def __init__(self, username):
        self.__username = username

    def get_username(self):
        return self.__username


class Message:
    def __init__(self, content, sender: User):
        self.__content = content
        self.__sender = sender

    def show(self):
        print(f"Message from {self.__sender.get_username()}: {self.__content}")


class MultimediaMessage(Message):
    def __init__(self, content, sender, file):
        super().__init__(content, sender)
        self.__file = file

    def show(self):
        print("Multimedia message:")
        super().show()
        print(f"Attached file: {self.__file}")


# Example usage
sender = User("john_doe")

msg1 = Message("Hi, how are you?", sender)
msg2 = MultimediaMessage("Check this out!", sender, "photo.jpg")

msg1.show()
print()
msg2.show()
