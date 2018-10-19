import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class createMine{
	private int rows;
	private int columns;
	createMine(int r, int c){
		rows=r;
		columns=c;
	}
	public void go() {
		JFrame f1= new JFrame(" MINESWEEPER ");
			JPanel p1=new JPanel();
			Cell [][]c=new Cell[rows][columns];
			p1.setLayout(new GridLayout(rows,columns));
			p1.setBackground(Color.black);
		//	p1.addMouseListener(new MouseAdapter() {
		//		@Override
		//		public void mouseClicked(MouseEvent e) {
		//			if(e.getModifiers()==MouseEvent.BUTTON3)
		//			{
		//				c[1][1].setColor();
		//			}
		//		}
		//		
		//	});
			for(int i=0;i<10;i++)
			{
				for(int j=0;j<10;j++)
				{
					c[i][j]=new Cell();
					int random=(int)(Math.random()*100);
					//System.out.println(random+"\n");
					if(random>80)
					{
						c[i][j].setBomb(1);
						//System.out.println("YES");
					}
					else
					{
						c[i][j].setBomb(0);
						//System.out.println("NO");
					}
					p1.add(c[i][j].getButton());
				}
			}
			for(int i=0;i<10;i++)
			{
				for(int j=0;j<10;j++)
				{
					
					if((i-1)>=0 && (i+1)<=9)
					{
						if((j-1)>=0 && (j+1)<=9)
						{
							if(c[i-1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j+1].getBomb()==1)
								c[i][j].addVal();
						}
						else if((j-1)<0)
						{
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j+1].getBomb()==1)
								c[i][j].addVal();
						}
						else if((j+1)>9)
						{
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j-1].getBomb()==1)
								c[i][j].addVal();
						}
						
					}
					else if((i-1)<0)
					{
						if((j-1)<0)
						{
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j+1].getBomb()==1)
								c[i][j].addVal();
						}
						else if((j+1)>9)
						{
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j-1].getBomb()==1)
								c[i][j].addVal();
						}
						else
						{
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i+1][j+1].getBomb()==1)
								c[i][j].addVal();
						}
					}
					else if((i+1>9))
					{
						if((j-1)<0)
						{
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j+1].getBomb()==1)
								c[i][j].addVal();
						}
						else if((j+1)>9)
						{
							if(c[i-1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
						}
						else
						{
							if(c[i-1][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j+1].getBomb()==1)
								c[i][j].addVal();
							if(c[i-1][j].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j-1].getBomb()==1)
								c[i][j].addVal();
							if(c[i][j+1].getBomb()==1)
								c[i][j].addVal();
						}
					}
					
				}
			}
			JPanel wrapper = new JPanel(new GridBagLayout());
			GridBagConstraints cons = new GridBagConstraints();
			cons.gridx=0;
			cons.gridy=0;
			cons.weightx=0.5;
			wrapper.add(p1,cons);
			f1.add(wrapper, BorderLayout.CENTER);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(200,200);
		f1.setVisible(true);
		f1.pack();
	}
	public void setBomb() {
		
	}
}
class Cell implements MouseListener{
	private JButton button;
	int bomb;
	int val;
	Popup popup;
	Cell()
	{
		button=new JButton("");
		button.setPreferredSize(new Dimension(45,45));
		button.addMouseListener(this);
		val=0;
	}
	public void setColor() {
		button.setBackground(Color.GREEN);
	}
	public JButton getButton() {
		return button;
	}
	public void addVal()
	{
		val=val+1;
	}
	public void setBomb(int a)
	{
		bomb=a;
	}
	public int getBomb()
	{
		return bomb;
	}
	public void mouseClicked(MouseEvent e){
		if(SwingUtilities.isLeftMouseButton(e))
		{
			if(bomb==1)
			{
				button.setBackground(Color.RED);
			}
			else
			{
				button.setText(String.valueOf(val));
			}
		}
		else if(SwingUtilities.isRightMouseButton(e))
		{
			if(button.getBackground()!=Color.RED || button.getText().equals(String.valueOf(val)))
			button.setBackground(Color.BLUE);
		}
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
		//JLabel text= new JLabel("Thinking about it?");
		//popup=PopupFactory.getSharedInstance().getPopup(e.getComponent(), text, e.getXOnScreen(),e.getYOnScreen());
		//popup.show();
	}
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	
}
class Minesweeper{
	public static void main(String args[])
	{
		Scanner one=new Scanner(System.in);
		System.out.println("CHOOSE: \n 1: 6x6 \n2: 8x8 \n3: 10x10");
		createMine c1=new createMine(10,10);
		c1.go();
	}
}
