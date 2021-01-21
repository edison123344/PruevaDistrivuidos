package clienteUniversidad.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class vista extends JFrame {

	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textTitulo;
	private JTextField textUniversida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vista frame = new vista();
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
	public vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCedula = new JTextField();
		textCedula.setText("");
		textCedula.setBounds(10, 24, 86, 20);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(10, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(139, 0, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(122, 24, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NombreTitulo");
		lblNewLabel_2.setBounds(238, 0, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(229, 24, 86, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Universida");
		lblNewLabel_3.setBounds(338, 0, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		textUniversida = new JTextField();
		textUniversida.setBounds(338, 24, 86, 20);
		contentPane.add(textUniversida);
		textUniversida.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar Est");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 agregarPersona();
			}
		});
		btnNewButton.setBounds(10, 84, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar Titulo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agregarTtulo();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(139, 84, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
			}
		});
		btnNewButton_2.setBounds(269, 84, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnNewButton_3.setBounds(386, 84, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(95, 149, 263, 101);
		contentPane.add(textPane);
	}
	 public void agregarPersona() {
		 try {

		       URL url = new URL("http://localhost:8080/CRUDUniversidad/ws/transacciones/IngresoPerona");
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type", "application/json");

		        String input = "{\"cedula\":"+"\""+textCedula.getText()+"\",\"nombre\":"+"\""+textNombre.getText()+"\""+"}";
                System.out.println(input);
		       OutputStream os = conn.getOutputStream();
		        os.write(input.getBytes());
		        os.flush();

		        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                + conn.getResponseCode());
		        }

		        BufferedReader br = new BufferedReader(new InputStreamReader(
		                (conn.getInputStream())));

		        String output;
		        System.out.println("Output from Server .... \n");
		        while ((output = br.readLine()) != null) {
		            System.out.println(output);
		        }

		        conn.disconnect();

		     } catch (MalformedURLException e) {

		        e.printStackTrace();

		      } catch (IOException e) {

		        e.printStackTrace();

	            }
	 }
	 public void agregarTtulo() throws ParseException {
		 try {

		        URL url = new URL("http://localhost:8080/CRUDUniversidad/ws/transacciones/IngresoTitulo");
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setDoOutput(true);
		        conn.setRequestMethod("POST");
		        conn.setRequestProperty("Content-Type", "application/json");

		        String input = "{\"codigo\":"+"\""+aleatorios()+"\""+",\"NomTitulo\":"+"\""+textTitulo.getText()+"\""+",\"NomUniversidad\":"+"\""+textUniversida.getText()+"\""+",\"Fecha\":"+"\""+fechaActual()+"\""+",\"PK_EstudianteDT\":"+"\""+textCedula.getText()+"\""+"}";
             System.out.println(input);
		        OutputStream os = conn.getOutputStream();
		        os.write(input.getBytes());
		        os.flush();

		        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
		            throw new RuntimeException("Failed : HTTP error code : "
		                + conn.getResponseCode());
		        }

		        BufferedReader br = new BufferedReader(new InputStreamReader(
		                (conn.getInputStream())));

		        String output;
		        System.out.println("Output from Server .... \n");
		        while ((output = br.readLine()) != null) {
		            System.out.println(output);
		        }

		        conn.disconnect();

		      } catch (MalformedURLException e) {

		        e.printStackTrace();

		      } catch (IOException e) {

		        e.printStackTrace();

	            } 
	 }
		public String aleatorios() {	
			 String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			     Random rand = new Random();
			     StringBuilder buf = new StringBuilder();
			     for (int i=0; i<10; i++) {
			       buf.append(banco.charAt(rand.nextInt(banco.length())));
			     }
			     return buf.toString();	
		}
		public Date fechaActual() throws ParseException {
			Date date = new Date();
		    SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			String fechaString = formato.format(date); 
			Date miFecha = formato.parse(fechaString); 
			return miFecha;
		}
		public void validarCedula(String cedula) {
			
		}
	 public void buscar() {
		 
	 }
	 public void Listar() {
		 
	 }
}
