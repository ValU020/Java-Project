class User:
    def _init_(self, username, password, email, age):
        self.username = username
        self.password = password
        self.email = email
        self.age = age

    def login(self):
        print(f"{self.username} ha iniciado sesión.")

    def logout(self):
        print(f"{self.username} ha cerrado sesión.")

# Clase Contact que hereda de User
class Contact(User):
    def _init_(self, username, password, email, age, status):
        super()._init_(username, password, email, age)
        self.status = status

    def show_info(self):
        print(f"Contacto: {self.username} - Estado: {self.status}")

# Clase Call que usa polimorfismo para interactuar con User o Contact
class Call:
    def _init_(self, participants):
        self.participants = participants
        self.active = False

    def start(self):




