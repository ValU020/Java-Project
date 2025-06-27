package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Classes.UserStorage;
import org.json.JSONObject;


public class Register extends JFrame {
    private JTextField nameField, emailField, phoneField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;
    private JCheckBox termsCheckBox;
    private JComboBox<String> countryComboBox;
    
    // Mismos colores que el login
    private final Color SYNKRO = new Color(180, 66, 235);
    private final Color BACKGROUND_COLOR = new Color(255, 255, 255);
    
    public Register() {
        initializeRegisterFrame();
        createRegisterComponents();
        setupRegisterLayout();
        addRegisterEventListeners();
    }
    
    private void initializeRegisterFrame() {
        setTitle("Synkro - Crear Cuenta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(BACKGROUND_COLOR);
    }
    
    private void createRegisterComponents() {
        // Campos de texto
        nameField = createStyledTextField("Nombre completo");
        emailField = createStyledTextField("Email");
        phoneField = createStyledTextField("Teléfono (opcional)");
        
        // Combobox para país
        String[] countries = {"Colombia", "México", "España", "Argentina", "Chile", "Perú"};
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        countryComboBox.setPreferredSize(new Dimension(300, 45));
        
        // Campos de contraseña
        passwordField = createStyledPasswordField();
        confirmPasswordField = createStyledPasswordField();
        
        // Botones
        registerButton = createStyledButton("Crear cuenta", SYNKRO);
        backButton = createStyledButton("Volver", Color.WHITE, SYNKRO);
        
        // Checkbox términos
        termsCheckBox = new JCheckBox("<html>Acepto los <a href='#'>términos de servicio</a> y la <a href='#'>política de privacidad</a></html>");
        termsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        termsCheckBox.setBackground(BACKGROUND_COLOR);
    }
    
    private JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        field.setPreferredSize(new Dimension(300, 45));
        
        // Placeholder
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
        
        return field;
    }
    
    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.LIGHT_GRAY, 1),
            new EmptyBorder(10, 15, 10, 15)
        ));
        field.setPreferredSize(new Dimension(300, 45));
        return field;
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
    
    private void setupRegisterLayout() {
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        
        // Título
        JLabel titleLabel = new JLabel("Crear cuenta");
        titleLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 28));
        titleLabel.setForeground(SYNKRO);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("Únete a la comunidad de Synkro");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.DARK_GRAY);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Campos
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(subtitleLabel);
        mainPanel.add(Box.createVerticalStrut(30));
        
        mainPanel.add(createLabeledField("Nombre completo *", nameField));
        mainPanel.add(createLabeledField("Email *", emailField));
        mainPanel.add(createLabeledField("País", countryComboBox));
        mainPanel.add(createLabeledField("Teléfono", phoneField));
        mainPanel.add(createLabeledField("Contraseña *", passwordField));
        mainPanel.add(createLabeledField("Confirmar contraseña *", confirmPasswordField));
        
        mainPanel.add(Box.createVerticalStrut(15));
        termsCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(termsCheckBox);
        mainPanel.add(Box.createVerticalStrut(20));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(registerButton);
        mainPanel.add(Box.createVerticalStrut(10));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(backButton);
        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

    }
    
    private JPanel createLabeledField(String label, JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jLabel.setForeground(Color.DARK_GRAY);
        jLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(jLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(component);
        panel.add(Box.createVerticalStrut(15));
        
        return panel;
    }
    
    private void addRegisterEventListeners() {
        registerButton.addActionListener(e -> performRegistration());
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            this.dispose();
        });
        
        getRootPane().setDefaultButton(registerButton);
    }
    
    private void performRegistration() {
        // Validaciones
        if (!validateRegistrationFields()) {
            return;
        }
        // Si pasa la validación, guardar el usuario:
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        UserStorage.saveUser(name, email, password);
        
        
        // Simular registro exitoso
        JOptionPane.showMessageDialog(this,
            "¡Registro exitoso!\nPuedes iniciar sesión con tu nueva cuenta.",
            "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // Volver al login
        new Login().setVisible(true);
        this.dispose();
    }
    
    private boolean validateRegistrationFields() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        if (name.equals("Nombre completo") || name.trim().isEmpty()) {
            showError("El nombre es obligatorio");
            return false;
        }
        
        if (email.equals("Email") || email.trim().isEmpty()) {
            showError("El email es obligatorio");
            return false;
        }
        
        if (!email.contains("@") || !email.contains(".")) {
            showError("Por favor ingresa un email válido");
            return false;
        }
        
        if (password.length() < 6) {
            showError("La contraseña debe tener al menos 6 caracteres");
            return false;
        }
        
        if (!password.equals(confirmPassword)) {
            showError("Las contraseñas no coinciden");
            return false;
        }
        
        if (!termsCheckBox.isSelected()) {
            showError("Debes aceptar los términos y condiciones");
            return false;
        }
        
        return true;
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
