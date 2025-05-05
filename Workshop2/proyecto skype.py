class user:
    def __init__(self, username, password, email, age):
        self.username = username
        self.password = password
        self.email = email
        self.age = age
    
    def login(self):
        print("Iniciando sesión...")
    def logout(self):
        print("Cerrando sesión...")
        
username = input("Ingrese su nombre de usuario: ")
password = input("Ingrese su contraseña: ")
email = input("Ingrese su email: ")
age = input("Ingrese su edad: ")

user1 = user(username, password, email, age)

print(f"""
        Datos del usuario: \n\n
        Nombre de usuario: {user1.username} \n
        Contraseña: {user1.password} \n
        Email: {user1.email} \n
        Edad: {user1.age} \n
        """)


while True: 
    login = input()
    if (login.lower() == "login"): 
        user1.login()

      
    while True:
        logout = input()
        if (logout.lower() == "logout"): 
            user1.logout()
    