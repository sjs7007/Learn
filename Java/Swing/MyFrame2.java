//Link : http://cs.nyu.edu/~yap/classes/visual/03s/lect/l7/
// MyFrame with quit button. Works.

import java.awt.event.*;
import javax.swing.*;

class MyFrame2 extends JFrame
{
	public MyFrame2()
	{
		setTitle("My closeable frame.");
		setSize(300,200);
		setLocation(10,200);

		//window listener. It will contain the listener for the window closing event.

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0); //window closing
			}
		});
	}

	public static void main(String args[])
	{
		JFrame f = new MyFrame2();
		f.show(); // equivalent to f.setVisible(true)
	}
}
