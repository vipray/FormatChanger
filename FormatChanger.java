import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.io.File;

public class FormatChanger {
	
	private JFrame frame;
	private JTextField path;
	private JTextField ext;
	private JButton button;
	private JLabel creditLabel;
	private JLabel lpath;
	private JLabel lext;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormatChanger window = new FormatChanger();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormatChanger() {
		initialize();
	}
	
	
	
	private void initialize() {
		frame = new JFrame("File Format Changer");
		frame.setBounds(100, 100, 585, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("0xD3C0F7"));
		
		lpath = new JLabel("Enter the path of the Folder eg-(C:/Users/JainVipray)");
		lpath.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//lpath.setHorizontalAlignment(SwingConstants.CENTER);
		lpath.setBounds(36, 13, 500, 38);
		//lpath.setForeground(Color.WHITE);
		frame.getContentPane().add(lpath);
		
		
		path = new JTextField();
		path.setBounds(36, 54, 500, 31);
		path.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(path);
		path.setColumns(10);
		
		lext = new JLabel("Extenstion eg-(.txt)");
		lext.setBackground(new Color(192, 192, 192));
		lext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lext.setBounds(36, 108, 500, 18);
		//lext.setForeground(Color.WHITE);
		frame.getContentPane().add(lext);
		
		ext = new JTextField();
		ext.setBounds(36, 139, 200, 31);
		ext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(ext);
		ext.setColumns(10);
		
		button = new JButton("Change");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n1,n2;
				try{
					n1=path.getText();
					n2=ext.getText();
					if(n2.charAt(0)!='.')
					{
						JOptionPane.showMessageDialog(null,"Enter Valid Extension");
					}
					else
					{
						n1.replace('\\', '/');
						
						File dir =new File(n1);
						File[] list = dir.listFiles();
						System.out.println(n1);
						for(File file : list)
						{
							System.out.println("in for");
							if(!(file.isDirectory()))
							{
								System.out.println("in if");
								String FilePath = file.getAbsolutePath();//path of file
								System.out.println(FilePath);
								FilePath=FilePath.substring(0,FilePath.lastIndexOf(File.separator)+1);
								System.out.println(FilePath);
								//Removed everything after dot(.)
								String FileName = file.getName();
								System.out.println(FileName);
								int a =FileName.indexOf(".");
								System.out.println(a);
								String s=FileName;
								if(a!=-1)
								s=FileName.substring(0, a);
									
								System.out.print(s);
								File nw =new File(FilePath+s+n2);//Adding path with name
								file.renameTo(nw);//renaming
							}
						}
						
						JOptionPane.showMessageDialog(null,"File Extension Changed Successfully");
					}
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Enter Valid Credentials");
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(36, 185, 80, 31);
		frame.getContentPane().add(button);
		
		
		creditLabel = new JLabel("By-JainVipRay");
		creditLabel.setBackground(new Color(192, 192, 192));
		creditLabel.setBounds(470, 224, 101, 16);
		frame.getContentPane().add(creditLabel);
		
		
	}
	
	

	

}
