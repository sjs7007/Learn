// Link : http://cs.nyu.edu/~yap/classes/visual/03s/lect/l7/
// Works.

import javax.swing.*;

class MyFrame extends JFrame 
{
	public MyFrame() 
	{
		setTitle("My Empty Frame.");
		setSize(300,200);
		setLocation(10,200);
	}

	public static void main(String args[])
	{
		JFrame f = new MyFrame();
		f.show();
	}
}
