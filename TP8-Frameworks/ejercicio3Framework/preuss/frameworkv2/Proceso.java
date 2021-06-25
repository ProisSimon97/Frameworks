package preuss.frameworkv2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Proceso {

	private List<Accion> acciones = new ArrayList<Accion>();

	public Proceso(String url) {

		Properties prop = new Properties();

		try (InputStream file = getClass().getResourceAsStream(url);) {

			prop.load(file);

			String clases = prop.getProperty("acciones");

			String[] clase = clases.split(";");

			for (int i = 0; i < clase.length; i++) {

				Class cla = Class.forName(clase[i]);
				this.acciones.add((Accion) cla.getDeclaredConstructor().newInstance());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No puede crear una intancia de Accion.", e);
		}
	}

	@SuppressWarnings("resource")
	public void menu() {

		Terminal terminal;
		Panel buttonPanel;
		try {
			terminal = new DefaultTerminalFactory().createTerminal();

			Screen screen = new TerminalScreen(terminal);
			screen.startScreen();
			BasicWindow window = new BasicWindow();
			window.setHints(Arrays.asList(Window.Hint.CENTERED));
			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
					new EmptySpace(TextColor.ANSI.BLUE));

			buttonPanel = new Panel();
			buttonPanel.setLayoutManager(new GridLayout(2).setHorizontalSpacing(1));

			WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

			for (int i = 0; i < acciones.size(); i++) {

				int e = i;

				buttonPanel.addComponent(new Button(acciones.get(i).nombreItemMenu(), new Runnable() {
					@Override
					public void run() {
						// Actions go here
						try {
							acciones.get(e).ejecutar();

							new MessageDialogBuilder().setTitle(acciones.get(e).descripcionItemMenu())
									.setText("Se realizo la ejecucion con exito").build().showDialog(textGUI);

						} catch (Exception ex) {

							new MessageDialogBuilder().setTitle(acciones.get(e).descripcionItemMenu())
									.setText("Ocurrio un error " + ex.getMessage()).build().showDialog(textGUI);
						}
					}
				}));
			}

			buttonPanel.addComponent(new Button("Salir", new Runnable() {
				@Override
				public void run() {
					// Actions go here
					try {
						terminal.exitPrivateMode();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}));

			window.setComponent(buttonPanel);
			gui.addWindowAndWait(window);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}