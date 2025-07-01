# SKYPE

Este proyecto surge como una versión a pequeña escala de la aplicación Skype, basada en ella tanto en diseño como en funcionalidad, utilizando un sistema orientado a objetos.

---

## 🎯 Objetivos

- Crear una app donde los usuarios puedan enviar y recibir mensajes, realizar llamadas de voz y video, y compartir actividades con sus contactos.
- Implementar un sistema de autenticación para que cada usuario tenga una cuenta personal.
- Diseñar una web intuitiva y fácil de usar, con funcionalidades esenciales y una experiencia de usuario fluida, que mejore accesibilidad, responsividad y engagement.

---

## 📋 Visión General de la Aplicación

La aplicación propuesta, inspirada en Skype, incluye:

- Registro de usuarios mediante correo electrónico.
- Mensajería y llamadas de voz/video.
- Creación y gestión de grupos públicos y privados.
- Manejo de contactos y personalización de perfiles.
- Control de cuentas (suspensión temporal, eliminación).
- Sistema de invitaciones para amigos y grupos.

---

## 1. Requisitos

### 1.1 Requisitos Funcionales

- Registro e inicio de sesión con correo y contraseña.
- Enviar y recibir mensajes privados.
- Realizar llamadas de video o voz.
- Crear y eliminar grupos.
- Personalizar cuenta (foto, nombre, estado).
- Cerrar sesión de forma segura.
- Eliminar cuenta permanentemente.

### 1.2 Requisitos No Funcionales

- Protección de datos y comunicaciones del usuario.
- Evitar duplicados de nombres de usuario y correos.
- Aplicación instantánea de cambios en la cuenta.
- Soporte para múltiples usuarios sin fallos.

---

## 2. Historias de Usuario

- *Como usuario nuevo, quiero crear una cuenta personal con email, usuario y contraseña únicos.*
- *Como usuario, quiero comunicarme mediante mensajes y llamadas manteniendo privacidad.*
- *Como usuario, deseo crear y eliminar grupos públicos o privados para chatear.*
- *Como usuario, quiero enviar mensajes en grupos y que otros los vean y respondan al instante.*
- *Como usuario, quiero unirme a grupos existentes para participar en conversaciones.*
- *Como propietario de grupo, deseo añadir o eliminar usuarios del grupo.*
- *Como propietario, quiero que solo yo o usuarios autorizados gestionen mi grupo.*
- *Como usuario, quiero una interfaz amigable y personalizable.*
- *Como usuario, quiero cerrar mi cuenta temporalmente de forma segura.*
- *Como usuario, quiero eliminar mi cuenta de forma permanente.*

---

## 3. Mockups

Mockups preliminares diseñados para:

- **Página de inicio de sesión**  
  ![Login Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup1.jpg)

- **Pantalla principal con lista de contactos y grupos**  
  ![Main Page Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup2.jpg)

- **Interfaz de perfil**  
  ![Profile Mockup](https://raw.githubusercontent.com/ValU020/Java-Project/main/Mock-Ups/Mockup3.jpg)

*Los mockups son bocetos simples que justifican las elecciones básicas de diseño para apoyar el flujo del usuario.*

---

## 4. CRC Cards

### Clase Principal

**User**  
- **Responsabilidades:** Registrar e iniciar sesión, editar perfil, añadir y eliminar contactos.  
- **Colaboradores:** Lista de contactos, mensajes, llamadas.

### Subclases

**1. Contact**  
- **Responsabilidades:** Representar otro usuario en la lista de contactos, mostrar nombre y estado.  
- **Colaboradores:** User.

**2. Call**  
- **Responsabilidades:** Iniciar llamadas entre usuarios, registrar duración y participantes, finalizar llamada.  
- **Colaboradores:** User, historial de llamadas.

**3. Chat**  
- **Responsabilidades:** Gestionar conversaciones entre usuarios, almacenar y mostrar mensajes, mantener historial de llamadas y conversaciones.  
- **Colaboradores:** User, mensaje.

---

## UML Diagram

![UML Diagram](https://github.com/ValU020/Java-Project/blob/main/Workshop2/UML.png)

