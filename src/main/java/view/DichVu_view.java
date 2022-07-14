package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import models.DichVuModel;
import services.DichVuService;
import utils.IoCContainer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DichVu_view extends JFrame {
	private static IoCContainer _ioCContainer = new IoCContainer();
	private static DichVuService _dichVuService = (DichVuService) _ioCContainer.getBean(DichVuService.class.toString());
	private ArrayList<DichVuModel> _listDichVuModels = new ArrayList<DichVuModel>();
	private int _sttDichVuEditing;
	private DichVuModel _dichVuModel;
	
	private JPanel contentPane;
	private JTextField txt_tenDichVu;
	private JTextField txt_giaNhap;
	private JTextField txt_giaBan;
	private JLabel lblTnDchV;
	private JLabel lblGiNhp;
	private JLabel lblGiBn;
	private JLabel lblSLng;
	private JTextField txt_soLuong;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu_view frame = new DichVu_view();
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
	public DichVu_view() {
		_dichVuService.updateListDichVuModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 1264, 64);
		contentPane.add(panel_1);
		
		JLabel lblQunLDch = new JLabel("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
		lblQunLDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLDch.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQunLDch.setBounds(0, 0, 1264, 64);
		panel_1.add(lblQunLDch);
		
		txt_tenDichVu = new JTextField();
		txt_tenDichVu.setBounds(36, 107, 291, 32);
		contentPane.add(txt_tenDichVu);
		txt_tenDichVu.setColumns(10);
		
		txt_giaNhap = new JTextField();
		txt_giaNhap.setColumns(10);
		txt_giaNhap.setBounds(36, 182, 291, 32);
		contentPane.add(txt_giaNhap);
		
		txt_giaBan = new JTextField();
		txt_giaBan.setColumns(10);
		txt_giaBan.setBounds(36, 256, 291, 32);
		contentPane.add(txt_giaBan);
		
		lblTnDchV = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblTnDchV.setBounds(36, 75, 211, 32);
		contentPane.add(lblTnDchV);
		
		lblGiNhp = new JLabel("Gi\u00E1 nh\u1EADp");
		lblGiNhp.setBounds(36, 150, 211, 32);
		contentPane.add(lblGiNhp);
		
		lblGiBn = new JLabel("Gi\u00E1 b\u00E1n");
		lblGiBn.setBounds(36, 225, 211, 32);
		contentPane.add(lblGiBn);
		
		lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setBounds(36, 299, 211, 32);
		contentPane.add(lblSLng);
		
		txt_soLuong = new JTextField();
		txt_soLuong.setColumns(10);
		txt_soLuong.setBounds(36, 330, 291, 32);
		contentPane.add(txt_soLuong);
		
		panel = new JPanel();
		panel.setBounds(350, 75, 914, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 894, 533);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				doClickOnTable();
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_dichVuModel = getInforFromFormIntoDichVuModel();
				_dichVuService.them(_dichVuModel);
				clearForm();
				updateTable();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(857, 631, 124, 28);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaDichVu();
				_dichVuModel.setTrangThai("Hoạt Động");
				_dichVuService.sua(_dichVuModel);
				clearForm();
				updateTable();
			}
		});
		btnSa.setBackground(Color.WHITE);
		btnSa.setBounds(991, 631, 124, 28);
		contentPane.add(btnSa);
		
		JButton btnNewButton_1_1 = new JButton("X\u00F3a");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaDichVu();
				_dichVuModel.setTrangThai("Không Hoạt Động");
				_dichVuService.xoa(_dichVuModel);
				clearForm();
				updateTable();
			}
		});
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(1125, 631, 124, 28);
		contentPane.add(btnNewButton_1_1);
		updateTable();
	}
	
	public void suaDichVu() {
		_dichVuModel = getInforFromFormIntoDichVuModel();
		_dichVuModel.setStt(_listDichVuModels.get(_sttDichVuEditing).getStt());
		_dichVuModel.setMaDichVu(_listDichVuModels.get(_sttDichVuEditing).getMaDichVu());
	}
	
	public void doClickOnTable() {
		_sttDichVuEditing = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0)+"");
		txt_tenDichVu.setText(_listDichVuModels.get(_sttDichVuEditing).getTenDichVu());
		txt_giaBan.setText(_listDichVuModels.get(_sttDichVuEditing).getGiaban()+"");
		txt_giaNhap.setText(_listDichVuModels.get(_sttDichVuEditing).getGiaNhap()+"");
		txt_soLuong.setText(_listDichVuModels.get(_sttDichVuEditing).getSoLuongTon()+"");
	}
	
	public void updateTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Stt");
		model.addColumn("Tên dịch vụ");
		model.addColumn("Giá nhập");
		model.addColumn("Giá bán");
		model.addColumn("Số lượng");
		_listDichVuModels = _dichVuService.getListDichVuModel();
		for (DichVuModel dichVuModel : _listDichVuModels) {
			model.addRow(new Object[] {dichVuModel.getStt(),dichVuModel.getTenDichVu(),dichVuModel.getGiaNhap(),dichVuModel.getGiaban(),dichVuModel.getSoLuongTon()});
		}
		table.setModel(model);
	}
	
	public void clearForm() {
		txt_giaBan.setText("");
		txt_giaNhap.setText("");
		txt_soLuong.setText("");
		txt_tenDichVu.setText("");
	}
	
	public DichVuModel getInforFromFormIntoDichVuModel() {
		String tenDichVu = txt_tenDichVu.getText().trim();
		String giaNhap = txt_giaNhap.getText().trim();
		String giaBan = txt_giaBan.getText().trim();
		String soLuongTon = txt_soLuong.getText().trim();
		
		
		long giaNhapLong = Long.parseLong(giaNhap);
		long giaBanLong = Long.parseLong(giaBan);
		int soLuongTonInt = Integer.parseInt(soLuongTon);
//		_dichVuModel = (DichVuModel) _ioCContainer.getBean(DichVuModel.class+"");
		_dichVuModel = new DichVuModel();
		_dichVuModel.setStt(0);
		_dichVuModel.setMaDichVu(0);
		_dichVuModel.setTenDichVu(tenDichVu);
		_dichVuModel.setGiaNhap(giaNhapLong);
		_dichVuModel.setGiaban(giaBanLong);
		_dichVuModel.setSoLuongTon(soLuongTonInt);
		_dichVuModel.setTrangThai("Hoạt Động");
		return _dichVuModel;
	}
	
	
}
