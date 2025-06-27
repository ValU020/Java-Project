package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.UserStorage;
import org.json.JSONObject;


public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JCheckBox rememberCheckBox;
    
    // Colores estilo Skype
    private final Color SYNKRO = new Color(180, 66, 235);
    private final Color BACKGROUND_COLOR = new Color(255, 255, 255);
    private final Color FIELD_COLOR = Color.WHITE;
    
    public Login() {
        initializeLoginFrame();
        createLoginComponents();
        setupLoginLayout();
        addLoginEventListeners();
    }
    
    private void initializeLoginFrame() {
        setTitle("Synkro - Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(BACKGROUND_COLOR);
    }
    
    private void createLoginComponents() {
        // Email field con placeholder
        emailField = createStyledTextField("Email o teléfono");
        
        // Password field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        passwordField.setPreferredSize(new Dimension(300, 45));
        
        // Botones
        loginButton = createStyledButton("Iniciar sesión", SYNKRO);
        registerButton = createStyledButton("Crear cuenta", Color.WHITE, SYNKRO);
        
        // Checkbox
        rememberCheckBox = new JCheckBox("Recordarme");
        rememberCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        rememberCheckBox.setBackground(BACKGROUND_COLOR);
        rememberCheckBox.setForeground(Color.DARK_GRAY);
    }
    
    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        field.setPreferredSize(new Dimension(300, 45));
        
        // Efecto placeholder
        setupPlaceholder(field, placeholder);
        
        return field;
    }
    
    private void setupPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);
        
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        return createStyledButton(text, bgColor, Color.WHITE);
    }
    
    private JButton createStyledButton(String text, Color bgColor, Color textColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setBorder(new EmptyBorder(12, 20, 12, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(300, 45));
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBorderPainted(false);

        
        // Efecto hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (bgColor.equals(SYNKRO)) {
                    button.setBackground(SYNKRO.darker());
                } else {
                    button.setBackground(new Color(245, 245, 245));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void setupLoginLayout() {
        setLayout(new BorderLayout());
        
        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(40, 50, 40, 50));
        
        JLabel subtitleLabel = new JLabel("Inicia sesión en tu cuenta");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitleLabel.setForeground(new Color(100, 100, 100));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Cargar y redimensionar la imagen
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/Logo.png"));
        Image image = icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Agregar imagen al panel principal
        mainPanel.add(imageLabel);
        mainPanel.add(Box.createVerticalStrut(20)); // Espacio debajo de la imagen

 
        // Espaciado y componentes
        mainPanel.add(subtitleLabel);
        mainPanel.add(Box.createVerticalStrut(40));
        
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(10));
        
        // Panel para checkbox y "¿Olvidaste tu contraseña?"
        JPanel optionsPanel = new JPanel(new BorderLayout());
        optionsPanel.setBackground(BACKGROUND_COLOR);
        optionsPanel.add(rememberCheckBox, BorderLayout.WEST);
        
        JLabel forgotLabel = new JLabel("¿Olvidaste tu contraseña?");
        forgotLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        forgotLabel.setForeground(SYNKRO);
        forgotLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        optionsPanel.add(forgotLabel, BorderLayout.EAST);
        
        mainPanel.add(optionsPanel);
        mainPanel.add(Box.createVerticalStrut(25));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(15));
        
        // Separador
        JPanel separatorPanel = new JPanel(new BorderLayout());
        separatorPanel.setBackground(BACKGROUND_COLOR);
        separatorPanel.add(new JSeparator(), BorderLayout.CENTER);
        JLabel orLabel = new JLabel(" o ");
        orLabel.setBackground(BACKGROUND_COLOR);
        orLabel.setOpaque(true);
        separatorPanel.add(orLabel, BorderLayout.CENTER);
        
        mainPanel.add(separatorPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(registerButton);
        
        JScrollPane scrollPane = new JScrollPane(mainPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // suaviza el scroll
        add(scrollPane, BorderLayout.CENTER);

    }
    
    private void addLoginEventListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterFrame();
            }
        });
        
        // Permitir login con Enter
        getRootPane().setDefaultButton(loginButton);
    }
    
    private void performLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        
        // Validaciones básicas
        if (email.equals("Email o teléfono") || email.isEmpty()) {
            showError("Por favor ingresa tu email o teléfono");
            return;
        }
        
        if (password.isEmpty()) {
            showError("Por favor ingresa tu contraseña");
            return;
        }
        
        // Aquí implementarías la lógica de autenticación
        // Por ahora simulamos un login exitoso
        if (authenticateUser(email, password)) {
            JOptionPane.showMessageDialog(this, 
                "¡Inicio de sesión exitoso!\nBienvenido: " + email,
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Aquí abrirías la ventana principal de la aplicación
            // new MainApp().setVisible(true);
            // this.dispose();
        } else {
            showError("Email o contraseña incorrectos");
        }
    }
    
   private boolean authenticateUser(String email, String password) {
    JSONObject user = UserStorage.findUserByEmail(email);
    if (user != null && user.getString("contraseña").equals(password)) {
        return true;
    }
    return false;
}

    
    private void openRegisterFrame() {
        new Register().setVisible(true);
        this.setVisible(false);
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

