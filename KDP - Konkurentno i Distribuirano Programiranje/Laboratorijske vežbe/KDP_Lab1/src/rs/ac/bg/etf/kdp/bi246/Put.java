package rs.ac.bg.etf.kdp.bi246;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Put extends JFrame
{
	MessageBox<String> buffer;
	private static final long serialVersionUID = 1L;
	private JTextArea txt;
	private JTextArea ttl;
	private JTextArea pri;
	private JButton btn;
	private JLabel txtlabel;
	private JLabel ttllabel;
	private JLabel prilabel;

	private void createLabel(JLabel label)
	{
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(100, 25));
	}
	public Put(MessageBox<String> buffer)
	{
		super("PUT");
		this.buffer = buffer;
		this.btn = new JButton("PUT");
		this.txt = new JTextArea();
		this.ttl = new JTextArea();
		this.pri = new JTextArea();
		this.txtlabel = new JLabel("Message input");
		this.ttllabel = new JLabel("Time To Live");
		this.prilabel = new JLabel("Priority");
		
		
		createLabel(txtlabel);
		createLabel(ttllabel);
		createLabel(prilabel);
		btn.setPreferredSize(new Dimension(150,50));
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Thread t = new Thread()
				{
					public void run()
					{
						Message<String> msg = new TextMessage();
						msg.setBody(txt.getText());
						long longttl;
						try
						{
							longttl = Long.parseLong(ttl.getText());
						} catch (NumberFormatException e)
						{
							longttl = 0;
						}
						long prior;
						try
						{
							prior = Long.parseLong(pri.getText());
						} catch (NumberFormatException e)
						{
							prior = 0;
						}
						msg.setTTL(longttl);
						msg.setPriority(prior);
						txt.setText("");
						ttl.setText("");
						pri.setText("");
						buffer.send(msg, longttl);
					}
				};
				t.start();
			}

		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));
		this.setBounds(400, 400, 500, 300);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2,1));
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		pan2.setLayout(new FlowLayout(FlowLayout.CENTER,60,30));
		GridLayout gridL = new GridLayout(1,3);
		gridL.setHgap(15);
		pan3.setLayout(gridL);
		pan4.setLayout(new FlowLayout(FlowLayout.CENTER,0,70));
		pan4.add(btn);
		this.add(pan4);
		pan2.add(txtlabel);
		pan2.add(ttllabel);
		pan2.add(prilabel);

		pan3.add(txt);
		pan3.add(ttl);
		pan3.add(pri);
		pan1.add(pan2);
		pan1.add(pan3);
		pan2.setBackground(new Color(200,200,200));
		pan3.setBackground(new Color(200,200,200));
		pan4.setBackground(new Color(200,200,200));
		this.add(pan1);
		this.setVisible(true);
	}


}
