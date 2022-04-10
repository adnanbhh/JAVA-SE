package appTransport;

import java.awt.BorderLayout;
import java.util.Date;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class accueil extends LogCoursier{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    Connection cnx = null;
    ResultSet resultat = null;
    PreparedStatement prepared = null;
    public JFrame frame = new JFrame();
    
    protected JTextField IDTaxi;
    protected JTextField ville_Depart;
    protected JTextField prix;
    protected JTextField date;
    protected JTable table;
    
    protected JLabel name;
    protected JTextField textField;
    protected JTextField textField_1;
    protected JLabel lblNewLabel_2;
    protected JTextField dell;
    protected JLabel test;
    LogCoursier k = new LogCoursier();
    protected String city;
    private JTextField idtaxi;
    private JTextField matricule;
    private JTextField cciinn;
    private JTextField permis;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogCoursier frame = new LogCoursier();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void Table( ) 
    {
    	String topo="select * from "+city;
    	try {
    			prepared=cnx.prepareStatement(topo);
    			resultat=prepared.executeQuery();
    			table.setModel(DbUtils.resultSetToTableModel(resultat));
    		 }
    	catch(SQLException e1)
    		 {
    	  	e1.printStackTrace();
    	     }
    }
  
    
    /**
     * Create the frame.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public accueil() {
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 750);
        cnx = ConnexionMysql.ConnectDb();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        Panel panel = new Panel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        idtaxi = new JTextField();
        idtaxi.setBackground(new Color(88, 113, 155));
        idtaxi.setBorder(null);
        idtaxi.setBounds(210, 462, 252, 17);
        panel.add(idtaxi);
        idtaxi.setColumns(10);
        
        matricule = new JTextField();
        matricule.setBackground(new Color(88, 113, 155));
        matricule.setBorder(null);
        matricule.setBounds(210, 496, 252, 17);
        panel.add(matricule);
        matricule.setColumns(10);
        
        cciinn = new JTextField();
        cciinn.setBackground(new Color(88, 113, 155));
        cciinn.setBorder(null);
        cciinn.setBounds(210, 529, 252, 17);
        panel.add(cciinn);
        cciinn.setColumns(10);
        
        permis = new JTextField();
        permis.setBackground(new Color(88, 113, 155));
        permis.setBorder(null);
        permis.setBounds(210, 563, 252, 17);
        panel.add(permis);
        permis.setColumns(10);
    // afficher la photo de profile    
        JLabel photo_de_profile = new JLabel("");
        photo_de_profile.setBounds(427, 38, 134, 131);
        panel.add(photo_de_profile);
        // String CIN = k.getCIN();
        String dd = "Select * FROM courtier WHERE CIN = '"+k.getCIN()+"'";
        
        try {
            prepared = cnx.prepareStatement(dd);
            resultat = prepared.executeQuery();
            byte[] img = null;
            while(resultat.next()) {
                img = resultat.getBytes("PDP");
                }
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(photo_de_profile.getWidth(), photo_de_profile.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imm = new ImageIcon(myImg);
                photo_de_profile.setIcon(imm);
                
            
        } catch (SQLException e2) {
            System.out.println("dd");
            e2.printStackTrace();
        }
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setFont(new Font("Calibri", Font.BOLD, 27));
        textField.setOpaque(false);
        textField.setEnabled(false);
        textField.setDisabledTextColor(Color.WHITE);
        textField.setCaretColor(new Color(0, 0, 0));
        textField.setBorder(null);
        textField.setEditable(false);
        textField.setBounds(195, 46, 175, 34);
        panel.add(textField);
        textField.setColumns(10);
        
        
        textField_1 = new JTextField();
        textField_1.setBorder(null);
        textField_1.setOpaque(false);
        textField_1.setEditable(false);
        textField_1.setForeground(Color.WHITE);
        textField_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
        textField_1.setBounds(123, 86, 123, 26);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        date = new JTextField();
        date.setDisabledTextColor(Color.WHITE);
        date.setEditable(false);
        date.setBounds(461, 311, 86, 20);
        date.setColumns(10);
        panel.add(date);
        
        String[] ville_arriver = {"AJDIR", "AL HOCEIMA", "AIT KAMERA", "BENI BOUAYACH", "BOUKIDAN", "IMZOUREN", "ISSAGUEN", "MNOUD", "TAZA"};
        JComboBox<?> comboBox = new JComboBox<Object>(ville_arriver);
        comboBox.setFont(new Font("Calibri", Font.PLAIN, 11));
        
        comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
        comboBox.setBounds(259, 313, 86, 20);
        panel.add(comboBox);
        
    /*  JComboBox ville_arriver = new JComboBox();
        ville_arriver.setBounds(260, 310, 85, 22);
        ville_arriver.setModel(new DefaultComboBoxModel(new String[] {"AJDIR", "AL HOCEIMA", "AIT KAMERA", "BENI BOUAYACH", "BOUKIDAN", "IMZOUREN", "ISSAGUEN", "MNOUD", "TAZA", "", ""}));
        panel.add(ville_arriver);
    */  
        prix = new JTextField();
        prix.setBounds(361, 311, 86, 20);
        prix.setColumns(10);
        panel.add(prix);
        
        ville_Depart = new JTextField();
        ville_Depart.setBounds(152, 311, 86, 20);
        ville_Depart.setColumns(10);
        panel.add(ville_Depart);
        
        IDTaxi = new JTextField();
        IDTaxi.setBounds(58, 311, 74, 20);
        IDTaxi.setFont(new Font("Calibri", Font.BOLD, 12));
        IDTaxi.setColumns(10);
        panel.add(IDTaxi);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(606, 51, 494, 554);
        panel.add(scrollPane);
    		   // table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    		    Table();
        
        
        
        /*try
        {
          String sql = "SELECT * FROM courtier WHERE CIN = '"+k.getCIN()+"'";
          prepared = cnx.prepareStatement(sql);
          resultat = prepared.executeQuery();
          
          
          // iterate through the java resultset
          while (resultat.next())
          {
            city = resultat.getString("Ville");
          }
          resultat.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
      */
    
        
    
        JLabel addTaxi = new JLabel("");
        addTaxi.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                try {
                
                if(IDTaxi.equals("") || prix.equals("")) 
                {
                    JOptionPane.showMessageDialog(null , "Veillez remplir les champs vide !!");
                }
                else 
                {
                java.util.Date date1=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
                
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                java.sql.Timestamp sqlTime =new java.sql.Timestamp(timestamp.getTime());
                
                    String query = "INSERT INTO "+city+"(ID_Taxi, Ville_Depart, Ville_Arrivee, Prix, CIN_Courtier , Date, heure) VALUES (?,?,?,?,?,?,?)";
                    
                        prepared = cnx.prepareStatement(query);
                        prepared.setString(1, IDTaxi.getText());
                        prepared.setString(2, city);
                        prepared.setString(3, comboBox.getSelectedItem().toString());
                        prepared.setString(4, prix.getText());
                        prepared.setString(5, k.getCIN());
                        prepared.setDate(6,sqlDate);
                        prepared.setTimestamp(7,sqlTime);
                        prepared.execute();         
                        
                        JOptionPane.showMessageDialog(null , "New TAXI Add");
                }     
                        prix.setText("");
                        IDTaxi.setText("");
                        
                        
               	} 
                        catch (SQLException e1) 
                        {
                            e1.printStackTrace();
                        }

                    }       
        
                
        });
            
        
        addTaxi.setBounds(273, 371, 71, 42);
        panel.add(addTaxi);
        
        
        
        
        JLabel addtable = new JLabel("");
        addtable.setBounds(10, 46, 601, 584);
        addtable.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\uber\\addtableau.png"));
        panel.add(addtable);
        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 22, 588, 610);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\uber\\page.png"));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(534, 11, 613, 632);
        lblNewLabel_1.setBorder(null);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\uber\\leftblue.png"));
        panel.add(lblNewLabel_1);
        
        table = new JTable();
        table.setBounds(606, 56, 492, 0);
        panel.add(table);
        table.setModel(new DefaultTableModel(
    		  	new Object[][] {
    		  	
    		  	},
    		  	new String[] {
    		  		"ID", "ID_Taxi", "Ville_Depart", "Ville_Arrivee", "Prix", "CIN_Courtier", "Date", "heure"
    		  	}
    		  ));
      
    }
    
    
}
