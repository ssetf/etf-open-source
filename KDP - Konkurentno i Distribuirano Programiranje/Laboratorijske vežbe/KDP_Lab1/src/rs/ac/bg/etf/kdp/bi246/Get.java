
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

public class Get extends JFrame
{
	MessageBox<String> buffer;
	private static final long serialVersionUID = 1L;
	private JTextArea txt;
	private JTextArea ttl;
	private JButton btn;
	private JLabel txtlabel;
	private JLabel ttllabel;

	public Get(MessageBox<String> buffer)
	{
		super("GET");
		this.buffer = buffer;
		this.txt = new JTextArea();
		this.btn = new JButton("GET");
		this.ttl = new JTextArea();
		this.txtlabel = new JLabel("Message output");
		this.ttllabel = new JLabel("Time To Wait");

		btn.setPreferredSize(new Dimension(150, 50));
		txt.setEditable(false);
		
		txtlabel.setOpaque(true);
		txtlabel.setBackground(Color.white);
		txtlabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtlabel.setPreferredSize(new Dimension(100, 25));

		ttllabel.setOpaque(true);
		ttllabel.setBackground(Color.white);
		ttllabel.setHorizontalAlignment(SwingConstants.CENTER);
		ttllabel.setPreferredSize(new Dimension(100, 25));
		
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Thread t = new Thread()
				{
					public void run()
					{
						long longttl;
						try
						{
							longttl = Long.parseLong(ttl.getText());
						} catch (NumberFormatException e)
						{
							longttl = 0;
						}
						ttl.setText("");
						IntStatus status = new IntStatus();
						Message<String> msg = buffer.receive(longttl, status);
						if(msg != null)
							txt.setText(status.getMessage() + ":\n"+msg.getBody());
						else
							txt.setText(status.getMessage());
					}
				};
				t.start();
			}

		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));
		this.setBounds(900, 400, 300, 300);
		JPanel pan1 = new JPanel();
		pan1.setLayout(new GridLayout(2, 1));
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
		pan2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
		GridLayout gridL = new GridLayout(1, 2);
		gridL.setHgap(15);
		pan3.setLayout(gridL);
		pan4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
		pan4.add(btn);
		this.add(pan4);
		pan2.add(txtlabel);
		pan2.add(ttllabel);

		pan3.add(txt);
		pan3.add(ttl);

		pan1.add(pan2);
		pan1.add(pan3);
		pan2.setBackground(new Color(200, 200, 200));
		pan3.setBackground(new Color(200, 200, 200));
		pan4.setBackground(new Color(200, 200, 200));
		this.add(pan1);
		this.setVisible(true);
	}

}
