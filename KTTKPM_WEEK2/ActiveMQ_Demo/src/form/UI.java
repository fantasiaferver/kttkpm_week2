package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queue.TopicPublisher;
import queue.TopicSubcriber;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Consumer;
	private JTextField txt_Message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TopicPublisher topicPublisher = new TopicPublisher();
		TopicSubcriber topicSubcriber = new TopicSubcriber();

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 418, 364);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name consumer");
		lblNewLabel.setBounds(10, 10, 104, 13);
		panel.add(lblNewLabel);

		txt_Consumer = new JTextField();
		txt_Consumer.setBounds(10, 33, 396, 27);
		panel.add(txt_Consumer);
		txt_Consumer.setColumns(10);

		JLabel lblEnterMessage = new JLabel("Enter Message");
		lblEnterMessage.setBounds(10, 69, 104, 13);
		panel.add(lblEnterMessage);

		txt_Message = new JTextField();
		txt_Message.setColumns(10);
		txt_Message.setBounds(10, 92, 396, 27);
		panel.add(txt_Message);

		JButton btn_Send = new JButton("Send");
		btn_Send.setBounds(163, 132, 85, 21);
		panel.add(btn_Send);

		JLabel txt_Status = new JLabel("");
		txt_Status.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Status.setBounds(111, 163, 197, 13);
		panel.add(txt_Status);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 187, 396, 167);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel txt_ValueMess = new JLabel("");
		txt_ValueMess.setBounds(10, 10, 45, 13);
		panel_1.add(txt_ValueMess);

		btn_Send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txt_Consumer.getText().length() == 0 && txt_Message.getText().length() == 0) {
					txt_Status.setText("Consumer or Message not null");
				} else {
					try {
						topicPublisher.Publisher(txt_Message.getText(), txt_Consumer.getText());
						topicSubcriber.Subcriber(txt_Consumer.getText());
						txt_Status.setText("Send success");
						txt_ValueMess.setText(txt_Message.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
