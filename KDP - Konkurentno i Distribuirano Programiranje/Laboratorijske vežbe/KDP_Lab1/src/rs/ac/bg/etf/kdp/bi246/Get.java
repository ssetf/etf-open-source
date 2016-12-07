
package rs.ac.bg.etf.kdp.bi246;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

public class Get extends JFrame
{
	MessageBox<String> buffer;
	private static final long serialVersionUID = 1L;
	private JTextArea txt;
	private JButton btn;

	public Get(MessageBox<String> buffer)
	{
		super("GET");
		this.buffer = buffer;
		this.txt = new JTextArea();
		this.btn = new JButton("GET");

		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Thread t = new Thread()
				{
					public void run()
					{
						
						Message<String> msg =buffer.receive(0, null);
						txt.setText(msg.getBody());
					}
				};
				t.start();
			}

		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		this.setBounds(700, 400, 300, 400);
		this.add(btn);
		this.add(txt);
		this.setVisible(true);
	}


}
