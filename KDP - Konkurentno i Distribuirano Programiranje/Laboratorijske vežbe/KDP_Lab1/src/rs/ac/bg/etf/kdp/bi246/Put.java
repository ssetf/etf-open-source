package rs.ac.bg.etf.kdp.bi246;

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
	private JButton btn;

	public Put(MessageBox<String> buffer)
	{
		super("PUT");
		this.buffer = buffer;
		this.txt = new JTextArea();
		this.btn = new JButton("PUT");

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
						buffer.send(msg, null, 0);
					}
				};
				t.start();
			}

		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		this.setBounds(400, 400, 300, 400);
		this.add(btn);
		this.add(txt);
		this.setVisible(true);
	}


}
