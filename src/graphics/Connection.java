/**
 * @author Clovis Delarue
 * class to build the connection graphic form
 */

package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.BoxLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.Dialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Connection extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField loginField;
	private JPasswordField passwordField;
	private JTextField serverField;
	private JTextField databaseField;
	private JLabel lblNewLabel;
	private JLabel lblDatabase;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private HashMap<String,String> map;


	/**
	 * Create the dialog.
	 */
	public Connection(Dialog o) {
		super(o,"Connection",true);
		setTitle("Connection");
		setBounds(100, 100, 468, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{212, 212, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 27, 27, 27, 27, 27, 27, 27, 27, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNewLabel = new JLabel("Server");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\airclovis\\Documents\\Java2\\DataBase\\img\\bigConnect.png"));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 0;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		{
			serverField = new JTextField();
			serverField.setColumns(10);
		}
		GridBagConstraints gbc_serverField = new GridBagConstraints();
		gbc_serverField.fill = GridBagConstraints.BOTH;
		gbc_serverField.insets = new Insets(0, 0, 5, 0);
		gbc_serverField.gridx = 1;
		gbc_serverField.gridy = 1;
		contentPanel.add(serverField, gbc_serverField);
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 2;
			contentPanel.add(label, gbc_label);
		}
		{
			lblDatabase = new JLabel("Database");
			lblDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		}
		GridBagConstraints gbc_lblDatabase = new GridBagConstraints();
		gbc_lblDatabase.fill = GridBagConstraints.BOTH;
		gbc_lblDatabase.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatabase.gridx = 0;
		gbc_lblDatabase.gridy = 3;
		contentPanel.add(lblDatabase, gbc_lblDatabase);
		{
			databaseField = new JTextField();
			databaseField.setColumns(10);
		}
		GridBagConstraints gbc_databaseField = new GridBagConstraints();
		gbc_databaseField.fill = GridBagConstraints.BOTH;
		gbc_databaseField.insets = new Insets(0, 0, 5, 0);
		gbc_databaseField.gridx = 1;
		gbc_databaseField.gridy = 3;
		contentPanel.add(databaseField, gbc_databaseField);
		{
			lblPassword = new JLabel("Password");
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 4;
			contentPanel.add(label, gbc_label);
		}
		{
			loginField = new JTextField();
			loginField.setColumns(10);
		}
		{
			lblLogin = new JLabel("Login");
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		}
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.fill = GridBagConstraints.BOTH;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 5;
		contentPanel.add(lblLogin, gbc_lblLogin);
		GridBagConstraints gbc_loginField = new GridBagConstraints();
		gbc_loginField.fill = GridBagConstraints.BOTH;
		gbc_loginField.insets = new Insets(0, 0, 5, 0);
		gbc_loginField.gridx = 1;
		gbc_loginField.gridy = 5;
		contentPanel.add(loginField, gbc_loginField);
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 6;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 6;
			contentPanel.add(label, gbc_label);
		}
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 7;
		contentPanel.add(lblPassword, gbc_lblPassword);
		{
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
		}
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 7;
		contentPanel.add(passwordField, gbc_passwordField);
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 8;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.gridx = 1;
			gbc_label.gridy = 8;
			contentPanel.add(label, gbc_label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						map = new HashMap<String,String>();
						map.put("Server", serverField.getText());
						map.put("Database", databaseField.getText());
						map.put("Login", loginField.getText());
						map.put("Password",new String(passwordField.getPassword()));
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public synchronized HashMap<String,String> showDialog()
	{
		this.setVisible(true);
		return this.map;
	}

}
