package appTransport;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
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
    JFrame frame;
    JTable table_1;
	private JComboBox combobox;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    accueil window = new accueil();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
    	frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1200, 750);
        cnx = ConnexionMysql.ConnectDb();
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        frame.setContentPane(contentPane);
        
        Panel panel = new Panel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        combobox = new JComboBox<Object>();
        combobox.setModel(new DefaultComboBoxModel<Object>(new String[] {"AJDIR", "AL HOCEIMA", "AIT KAMERA", "BENI BOUAYACH", "BOUKIDAN", "IMZOUREN", "ISSAGUEN", "MNOUD", "TAZA"}));
        combobox.setBounds(244, 310, 85, 22);
        panel.add(combobox);
        
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
        date.setBounds(443, 311, 86, 20);
        date.setColumns(10);
        panel.add(date);
        
//        String[] ville_arriver = {"AJDIR", "AL HOCEIMA", "AIT KAMERA", "BENI BOUAYACH", "BOUKIDAN", "IMZOUREN", "ISSAGUEN", "MNOUD", "TAZA"};
//        JComboBox<?> comboBox = new JComboBox<Object>(ville_arriver);
//        comboBox.setFont(new Font("Calibri", Font.PLAIN, 11));
//        
//        comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
//        comboBox.setBounds(241, 313, 86, 20);
//        panel.add(comboBox);
        
        
      
    
        prix = new JTextField();
        prix.setBounds(343, 311, 86, 20);
        prix.setColumns(10);
        panel.add(prix);
        
        ville_Depart = new JTextField();
        ville_Depart.setEditable(false);
        ville_Depart.setEnabled(false);
        ville_Depart.setBounds(134, 311, 86, 20);
        ville_Depart.setColumns(10);
        panel.add(ville_Depart);
        
        IDTaxi = new JTextField();
        IDTaxi.setBounds(40, 311, 74, 20);
        IDTaxi.setFont(new Font("Calibri", Font.BOLD, 12));
        IDTaxi.setColumns(10);
        panel.add(IDTaxi);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(606, 51, 494, 554);
        panel.add(scrollPane);
        
        table_1 = new JTable();
        table_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int i =table_1.getSelectedRow();
		  		try {
		  			
		  			IDTaxi.setText(table_1.getModel().getValueAt(i,1).toString());
		  			ville_Depart.setText(table_1.getModel().getValueAt(i,2).toString());
		  			combobox.setSelectedItem(table_1.getModel().getValueAt(i,3).toString());
		  			prix.setText(table_1.getModel().getValueAt(i,4).toString());

		  		}catch(Exception e1) {
		  			JOptionPane.showConfirmDialog(null, e1);
		  		   }
        	}
        });
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, new Integer(123), "ajdir", "AJDIR", new Integer(100), "BH123", null, null},
        		{null, new Integer(1000), "ajdir", "AJDIR", new Integer(1000), "bhhhhs", null, null},
        		{null, new Integer(1000), "ajdir", "AJDIR", new Integer(999), "ghj", null, null},
        		{null, new Integer(0), "ajdir", "AJDIR", new Integer(100), "dfvgbh", null, null},
        		{null, new Integer(1222), "alhoceima", "AJDIR", new Integer(1000), "", null, null},
        		{null, new Integer(99), "alhoceima", "AJDIR", new Integer(99), "", null, null},
        		{null, new Integer(7), "alhoceima", "AJDIR", new Integer(9), "", null, null},
        		{null, new Integer(22), "alhoceima", "AJDIR", new Integer(100), "", null, null},
        		{null, new Integer(224), "alhoceima", "IMZOUREN", new Integer(13), "chaimaa", null, null},
        	},
        	new String[] {
        		"ID", "ID_Taxi", "Ville_Depart", "Ville_Arriv\u00E9e", "Prix", "CIN_Courtier", "Date", "Heure"
        	}
        ));
        DefaultTableModel model = new DefaultTableModel();
        table_1.setModel(model);
        scrollPane.setColumnHeaderView(table_1);
        Table();
    		   // table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
       scrollPane.setViewportView(table_1);
        
  
        
    
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
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                java.sql.Timestamp sqlTime =new java.sql.Timestamp(timestamp.getTime());
                city=ville_Depart.getText();
                    String query = "INSERT INTO "+city+" (ID_Taxi, Ville_Depart, Ville_Arrivee, Prix ,CIN_Courtier,Date,heure) VALUES (?,?,?,?,?,NOW(),?)";
                      
                        prepared = cnx.prepareStatement(query);
                        prepared.setString(1, IDTaxi.getText());
                        prepared.setString(2, city);
                        prepared.setString(3, combobox.getSelectedItem().toString());
                        prepared.setString(4, prix.getText());
                        prepared.setString(5, k.getCIN());
                        prepared.setTimestamp(6, sqlTime);
                        prepared.execute();
                        Table();
                              
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
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
       {
        		int i= table_1.getSelectedRow();
        		String ville= ville_Depart.getText() ;
        		//String villee=table_1.getModel().getValueAt(i,2).toString();
	     		String s=" UPDATE "+ville+" SET ID_Taxi=?,Ville_Arrivee=?,Prix=? WHERE ID=? AND Ville_Depart=?";
		  		try {
		  			prepared=cnx.prepareStatement(s);
		  			
		  			prepared.setString(1,IDTaxi.getText().toString());
		  			prepared.setString(2,combobox.getSelectedItem().toString());
		  			prepared.setString(3,prix.getText().toString());
		  			prepared.setString(4,table_1.getModel().getValueAt(i,0).toString());
		  			prepared.setString(5,ville);
		  			prepared.executeUpdate();
		  			Table();
		  			dispose();
		  			
		  		}catch(SQLException e1)
		  		{
		  			e1.printStackTrace();
		  		}
       }
            
        });
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) 
        	{
        		int i =table_1.getSelectedRow();
		  		if(i>=0) 
		  		{
		  		String cell=table_1.getModel().getValueAt(i,0).toString();
		  		String ville=table_1.getModel().getValueAt(i,2).toString();
		  		
		  		String sq="DELETE FROM "+ville+" where ID="+cell;
		  		try 
		  		{
		  			prepared=cnx.prepareStatement(sq);
		  			prepared.execute();
		  			JOptionPane.showMessageDialog(null,"ligne supprimée");
		  			Table();
        			
		  		}catch(Exception e1) 
		  		{
		  			JOptionPane.showConfirmDialog(null, e1);
		  		   }
		  		
        		}else 
        		{
        			JOptionPane.showConfirmDialog(null, "selectionner une ligne");
        		}
		  		
		  		
        	}
        });



        lblNewLabel_4.setBounds(390, 379, 85, 34);
        panel.add(lblNewLabel_4);
        lblNewLabel_3.setBounds(102, 371, 74, 42);
        panel.add(lblNewLabel_3);
            
        
        addTaxi.setBounds(273, 371, 71, 42);
        panel.add(addTaxi);
        
        
        
        
        JLabel addtable = new JLabel("");
   
        addtable.setBounds(-5, 48, 601, 584);
        addtable.setIcon(new ImageIcon(accueil.class.getResource("/images/addtableau.png")));
        panel.add(addtable);
        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 22, 588, 610);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\uber\\page.png"));
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(534, 11, 613, 632);
        lblNewLabel_1.setBorder(null);
        lblNewLabel_1.setIcon(new ImageIcon(accueil.class.getResource("/images/2.png")));
        panel.add(lblNewLabel_1);
   
   }
	public void Table( ) 
	{
    String sql="SELECT ID AS ID ,ID_Taxi AS ID_Taxi,'ajdir' AS Ville_Depart, Ville_Arrivee AS Ville_Arrivée, Prix AS Prix,CIN_Courtier AS CIN_Courtier, Date AS Date ,heure AS Heure  FROM ajdir "
		+ "UNION ALL "
		+ "SELECT ID, ID_Taxi ,'alhoceima', Ville_Arrivee,Prix,CIN_Courtier,Date,heure FROM alhoceima";
    try 
    {
			prepared=cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(resultat));
			}catch(SQLException e1)
			{
			e1.printStackTrace();
			}
	}
}