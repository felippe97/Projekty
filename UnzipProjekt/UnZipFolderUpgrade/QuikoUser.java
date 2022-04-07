package UnZipFolderUpgrade;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class QuikoUser extends JFrame {

	private JPanel contentPane;
	private JTextField nazovSuboru;
	private JTextField slovoVSubore;
	public String nazovSuboru1;
	public String slovoSubor;
	public int stav = 0;
	// private ImageIcon image;
	String[] pole = new String[10];
	String absolutnaCestaKSuboru = "";
	public static String riadokSubor = "";
	public static String slovoNaVymazanie = "";
	static String absolutnaCesta = "";
	static String novaAbsolutnaCesta = "";
	UnZipFolderUpgrade.ZipTester user;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) {

		System.out.println("Kliknite na subor ktory pozadujete extrahovat");
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("zip File", "zip");
		jfc.addChoosableFileFilter(filter1);
		jfc.setAcceptAllFileFilterUsed(false);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File suborNaExtrahovanie = jfc.getSelectedFile();
			absolutnaCesta = suborNaExtrahovanie.getAbsolutePath();
			novaAbsolutnaCesta = suborNaExtrahovanie.getParent();

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuikoUser frame = new QuikoUser();
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
	public QuikoUser() {

		super("Most friednly GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.getColor("#43B7BA"));

		setContentPane(contentPane);
		JButton btnOk = new JButton("Ok");
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnOk.setVerticalAlignment(SwingConstants.TOP);

		// image = new ImageIcon(getClass().getResource("zip.png"));
		// labell = new JLabel(image);
		// add(labell);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnOk) {
					nazovSuboru1 = nazovSuboru.getText();
					slovoSubor = slovoVSubore.getText();
					try {
						user = new UnZipFolderUpgrade.ZipTester(absolutnaCesta, novaAbsolutnaCesta, nazovSuboru1,
								slovoSubor);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Vsetko prebehlo");

				}

			}
		});
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnOk, -10, SpringLayout.SOUTH, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(btnOk);

		nazovSuboru = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nazovSuboru, 72, SpringLayout.NORTH, contentPane);
		contentPane.add(nazovSuboru);
		nazovSuboru.setColumns(10);

		slovoVSubore = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, nazovSuboru, 0, SpringLayout.WEST, slovoVSubore);
		contentPane.add(slovoVSubore);
		slovoVSubore.setColumns(10);

		JTextArea textArea = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, nazovSuboru);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, nazovSuboru);
		textArea.setText(
				"Napiste cely nazov txt suboru v ktorom chcete vymazat riadok \n!!Nezabudnite priponu .txt!! ");
		textArea.append(getNazovSuboru1());

		textArea.setEditable(false);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOk, 0, SpringLayout.EAST, textArea_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, slovoVSubore, 9, SpringLayout.SOUTH, textArea_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, slovoVSubore, 0, SpringLayout.WEST, textArea_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea_1, -83, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea_1, -58, SpringLayout.EAST, contentPane);
		textArea_1.setText(
				"Napiöte slovo ktore by sa malo nach·dzat v subore \n potvrdenim sa vymaûu riadky obsahuj˙ce dane kæuËove slovo \n Ak chcete zmazaù kaûdy riadok v subore napiöte 'all' ");
		textArea_1.append(getSlovoSubor());
		textArea_1.setEditable(false);

		contentPane.add(textArea_1);

	}

	public String getNazovSuboru1() {
		return nazovSuboru1;
	}

	public String getSlovoSubor() {
		return slovoSubor;
	}

	public String getAbsolutnaCesta() {
		return absolutnaCesta;
	}

	public String getNovaAbsolutnaCesta() {
		return novaAbsolutnaCesta;
	}

}
