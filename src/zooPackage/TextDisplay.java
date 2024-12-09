package zooPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TextDisplay {
	public static void showTextPane(String textContent, String imagePath, float opacity, String title) {
		final BufferedImage[] imgContainer = new BufferedImage[1];

		try {
			BufferedImage originalImg = ImageIO.read(new File(imagePath));
			BufferedImage resizedImage = new BufferedImage(1000, 493, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImage.createGraphics();
			g2.setComposite(AlphaComposite.SrcOver.derive(opacity));
			g2.drawImage(originalImg, 0, 0, 1000, 493, null);
			g2.dispose();
			imgContainer[0] = resizedImage;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		JTextArea textArea = new JTextArea(textContent);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, 16f));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		JPanel panel = new JPanel(new BorderLayout()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (imgContainer[0] != null) {
					g.drawImage(imgContainer[0], 0, 0, this);
				}
			}
		};
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(1000, 493));

		Object[] options = { "OK" };
		JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
				options, options[0]);
		JDialog dialog = optionPane.createDialog(null, title);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setIconImage(null);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

		Object selectedValue = optionPane.getValue();
		if (selectedValue != null && selectedValue.equals("OK")) {
			dialog.dispose();
		}
	}
}