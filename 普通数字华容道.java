package JFrame类;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class 普通数字华容道 extends JFrame implements ActionListener{
	JButton[] b=new JButton[16];
	ArrayList<Integer> list=new ArrayList<Integer>();
	 Random r=new Random(); 
	 boolean[] bool=new boolean[16]; 
	 int randInt=0; 
	 Font f=new Font("Courier",Font.ITALIC, 20);
	public 普通数字华容道() {
		setLayout(new GridLayout(4, 4));
		for (int i = 0; i <16; i++) {
			 do {
				 randInt = r.nextInt(16); 
				 }while(bool[randInt]); 
			 bool[randInt] = true;
			 list.add(randInt);
			 System.out.println(list);
			 b[i]=new JButton(String.valueOf(list.get(i)));
			 b[i].setFont(f);
			 add(b[i]);
			 b[i].addActionListener(this);
		}
		b[15].setText("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new 普通数字华容道();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 16; i++) {
			if(i+1<16&&e.getSource()==b[i]&&b[i+1].getText().equals("")) {
				b[i+1].setText(b[i].getText());
				b[i].setText("");
			}
			if(i-1>=0&&e.getSource()==b[i]&&b[i-1].getText().equals("")) {
				b[i-1].setText(b[i].getText());
				b[i].setText("");
			}
			if(i+4<16&&e.getSource()==b[i]&&b[i+4].getText().equals("")) {
				b[i+4].setText(b[i].getText());
				b[i].setText("");
			}
			if(i-4>=0&&e.getSource()==b[i]&&b[i-4].getText().equals("")) {
				b[i-4].setText(b[i].getText());
				b[i].setText("");
			}
		}
	}
}
