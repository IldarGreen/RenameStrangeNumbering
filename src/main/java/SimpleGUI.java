import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI extends JFrame {
	private JButton button = new JButton("Press");
	private JTextField input = new JTextField("", 5);
	private JLabel label = new JLabel("Input: ");

	private JButton OpenDir = new JButton("open directory");
	private JFileChooser fileChooser = new JFileChooser();

	public SimpleGUI() {
		super("Simple Example");
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 4, 2, 2));
		container.add(label);
		container.add(input);

		button.addActionListener(new ButtonEventListener());
		container.add(button);

		fileChooser.addActionListener(new FileChooserListener());
		container.add(fileChooser);
	}

	class ButtonEventListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String message = "Done, " + input.getText();
			JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
		}
	}

	class FileChooserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fileChooser.setDialogTitle("Выбор директории");
			// Определение режима - только каталог
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = fileChooser.showOpenDialog(SimpleGUI.this);
			// Если директория выбрана, покажем ее в сообщении
			if (result == JFileChooser.APPROVE_OPTION )
				JOptionPane.showMessageDialog(SimpleGUI.this,
						fileChooser.getSelectedFile());

		}
	}
}