class Contact:
    def _init_(self, name, status):
        self.name = name
        self.status = status

    def display(self):
        print(f"Contact: {self.name} - Status: {self.status}")


class Call:
    def _init_(self, participants):
        self.participants = participants  # Lista de usuarios
        self.duration = 0  # en segundos
        self.active = False

    def start_call(self):
        self.active = True
        print("Call started.")

    def end_call(self):
        self.active = False
        print("Call ended.")

    def track_duration(self, seconds):
        if self.active:
            self.duration += seconds
            print(f"Call duration: {self.duration} seconds")