package graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import SQL.SQLObject;

import javax.swing.JTable;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JButton connectButton;
	private JMenuItem connect;
	private SQLObject sql;
	private JLabel status;
	private JTextField request;
	private LinkedList<Object[]> data;
	private JTable table;
	private String[] names;
	
	public static void main(String[] args) {
		MainWindow m = new MainWindow();
		m.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Database query");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		connect = new JMenuItem("Connect");
		connect.addActionListener(new ConnectListener());
		mnFile.add(connect);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sql != null) {
					try {
						sql.closeConnection();
					} catch (SQLException e1) {
						status.setText("Impossible to close the connection");
					}
				}
				System.exit(1);
			}
		});
		
		JMenuItem disconnect = new JMenuItem("Disconnect");
		disconnect.addActionListener(new CloseListener());
		mnFile.add(disconnect);
		mnFile.add(exit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		connectButton = new JButton();
		connectButton.addActionListener(new ConnectListener());
		connectButton.setIcon(new ImageIcon("C:\\Users\\airclovis\\Documents\\Java2\\DataBase\\img\\connect.png"));
		toolBar.add(connectButton);
		
		JButton disconnectButton = new JButton("");
		disconnectButton.addActionListener(new CloseListener());
		disconnectButton.setIcon(new ImageIcon("C:\\Users\\airclovis\\Documents\\Java2\\DataBase\\img\\stock_disconnect.png"));
		toolBar.add(disconnectButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut);
		
		request = new JTextField();
		toolBar.add(request);
		
		JButton send = new JButton("");
		send.addActionListener(new SendListener());
		send.setIcon(new ImageIcon("C:\\Users\\airclovis\\Documents\\Java2\\DataBase\\img\\enterButton.png"));
		toolBar.add(send);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		status = new JLabel("status bar");
		status.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(status);
		
		JScrollPane resultPanel = new JScrollPane();
		contentPane.add(resultPanel, BorderLayout.CENTER);
		
		table = new JTable();
		resultPanel.setViewportView(table);
	}
	
	/**
	 * Class for connect Listener
	 */
	class ConnectListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Connection c = new Connection(null);
			HashMap<String,String> m = c.showDialog();
			if(m != null)
			{
				try {
					sql = new SQLObject(m.get("Server"),m.get("Database"),m.get("Login"),m.get("Password"));
					status.setText("Connection to " + m.get("Server") + " succed !");
				} catch (SQLException | ClassNotFoundException e1) {
					status.setText("Connection failed");
				}
			}
		}
		
	}
	
	/**
	 * Action listener for the button send
	 * @author clovis
	 *
	 */
	class SendListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				sql.executeQuery(request.getText());
				data = sql.getData();
				names = sql.getNames();
				TableModel dataModel = new TableModelSQL();
				table.setModel(dataModel);
				status.setText(sql.nbRows() + " rows matched ");
			} catch (SQLException e) {
				status.setText("Error getting data");
			}
			
		}
		
	}
	
	/**
	 * 
	 * Action listener to close the connection
	 * @author clovis
	 *
	 */
	class CloseListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (sql != null) {
				try {
					sql.closeConnection();
					status.setText("Connection closed");
				} catch (SQLException e) {
					status.setText("Impossible to close the connection");
				}
			}
			status.setText("No connection to close");
		}
		
	}

	/**
	 * SubClass from AbstractTableModel to print the different data in table
	 * @author clovis
	 *
	 */
	class TableModelSQL extends AbstractTableModel
	{
		
		@Override
		public String getColumnName(int c)
		{
			return names[c];
		}

		@Override
		public int getColumnCount() {
			return sql.nbColumns();
		}

		@Override
		public int getRowCount() {
			return sql.nbRows();
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			return (data.get(arg0))[arg1];
		}
		
	}
}
