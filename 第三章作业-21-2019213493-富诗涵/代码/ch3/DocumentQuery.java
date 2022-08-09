package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * GUI,可以直接使用不同方法进行检索
 * update 0626
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class DocumentQuery extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentQuery frame = new DocumentQuery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//显示结果的框
	JTextPane resultShowTextPane = new JTextPane();
	//根据queryDocument搜索的选择栏
	JComboBox comboBox = new JComboBox();
	
	JComboBox comboBox_1 = new JComboBox();
	JTextPane resultShowTextPane_1 = new JTextPane();
	
	public DocumentQuery() {
		setFont(new Font("Cambria", Font.PLAIN, 20));
		setTitle("\u6587\u6863\u68C0\u7D22");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 33, 685, 598);
		contentPane.add(tabbedPane);
		
		//布尔检索模型
		JPanel panel1= new JPanel();
		tabbedPane.addTab("布尔检索模型", panel1);
	    panel1.setLayout(null);
	    
	    JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane_1.setBounds(25, 30, 626, 359);
	    panel1.add(tabbedPane_1);
	    
	    JPanel panel1_1= new JPanel();
		tabbedPane_1.addTab("按照query文档检索", panel1_1);
	    panel1_1.setLayout(null);
	    
	    
	    comboBox.setBounds(29, 178, 563, 30);
	    panel1_1.add(comboBox);
	    comboBox.addItem("q1: to ");
	    comboBox.addItem("q2: do ");
	    comboBox.addItem("q3: to do ");
	    comboBox.addItem("q4: I am ");
	    comboBox.addItem("q5: Let it ");
	    
	    JTextPane txtpnQTo = new JTextPane();
	    txtpnQTo.setText("\u8BF4\u660E\uFF1A\u9009\u62E9\u4F7F\u7528\u54EA\u4E2A\u6587\u4EF6\u8FDB\u884C\u68C0\u7D22\r\nq1: to \r\nq2: do \r\nq3: to do \r\nq4: I am \r\nq5: Let it ");
	    txtpnQTo.setBounds(29, 28, 562, 140);
	    panel1_1.add(txtpnQTo);
	    txtpnQTo.setEditable(false);
	    
	    //选择好使用哪个query检索后，点击的检索按钮
	    JButton btnNewButton = new JButton("\u5F00\u59CB\u68C0\u7D22");
	    btnNewButton.setBounds(254, 243, 97, 23);
	    panel1_1.add(btnNewButton);
	    btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 //int queryNo=comboBox.getSelectedIndex();
				 SearchByBoolean a = new SearchByBoolean();
				 String BooleanResult;
				 BooleanResult=a.BooleanModelSearchByQueryDocNo(comboBox.getSelectedIndex());
				 resultShowTextPane.setText(BooleanResult);
				 }
			 
			 });
	    
	    
	    JPanel panel1_2= new JPanel();
		tabbedPane_1.addTab("自定义文档检索", panel1_2);
	    panel1_2.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("AND");
	    lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
	    lblNewLabel.setBounds(29, 56, 39, 19);
	    panel1_2.add(lblNewLabel);
	    
	    JCheckBox chckbxNewCheckBox = new JCheckBox("to");
	    chckbxNewCheckBox.setBounds(90, 56, 49, 20);
	    panel1_2.add(chckbxNewCheckBox);
	    
	    JCheckBox chckbxDo = new JCheckBox("do");
	    chckbxDo.setBounds(152, 56, 49, 20);
	    panel1_2.add(chckbxDo);
	    
	    JCheckBox chckbxI = new JCheckBox("I");
	    chckbxI.setBounds(232, 56, 49, 20);
	    panel1_2.add(chckbxI);
	    
	    JCheckBox chckbxAm = new JCheckBox("am");
	    chckbxAm.setBounds(316, 56, 49, 20);
	    panel1_2.add(chckbxAm);
	    
	    JCheckBox chckbxLet = new JCheckBox("let");
	    chckbxLet.setBounds(399, 56, 49, 20);
	    panel1_2.add(chckbxLet);
	    
	    JCheckBox chckbxIt = new JCheckBox("it");
	    chckbxIt.setBounds(481, 56, 49, 20);
	    panel1_2.add(chckbxIt);
	    
	    JLabel lblOr = new JLabel("NOT");
	    lblOr.setFont(new Font("宋体", Font.PLAIN, 16));
	    lblOr.setBounds(29, 126, 39, 19);
	    panel1_2.add(lblOr);
	    
	    JCheckBox chckbxNewCheckBox_1 = new JCheckBox("to");
	    chckbxNewCheckBox_1.setBounds(90, 126, 49, 20);
	    panel1_2.add(chckbxNewCheckBox_1);
	    
	    JCheckBox chckbxDo_1 = new JCheckBox("do");
	    chckbxDo_1.setBounds(152, 126, 49, 20);
	    panel1_2.add(chckbxDo_1);
	    
	    JCheckBox chckbxI_1 = new JCheckBox("I");
	    chckbxI_1.setBounds(232, 126, 49, 20);
	    panel1_2.add(chckbxI_1);
	    
	    JCheckBox chckbxAm_1 = new JCheckBox("am");
	    chckbxAm_1.setBounds(316, 126, 49, 20);
	    panel1_2.add(chckbxAm_1);
	    
	    JCheckBox chckbxLet_1 = new JCheckBox("let");
	    chckbxLet_1.setBounds(399, 126, 49, 20);
	    panel1_2.add(chckbxLet_1);
	    
	    JCheckBox chckbxIt_1 = new JCheckBox("it");
	    chckbxIt_1.setBounds(481, 126, 49, 20);
	    panel1_2.add(chckbxIt_1);
	    
	    JLabel lblNewLabel_1 = new JLabel("\u63D0\u793A\uFF1A\u8BF7\u52FF\u91CD\u590D\u9009\u62E9AND\u548CNOT\uFF01");
	    lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
	    lblNewLabel_1.setBounds(182, 182, 303, 49);
	    panel1_2.add(lblNewLabel_1);
	    
	    JButton btnNewButton_1 = new JButton("\u5F00\u59CB\u68C0\u7D22");
	    btnNewButton_1.setBounds(254, 256, 97, 23);
	    panel1_2.add(btnNewButton_1);
	    btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 int[] search= {-1,-1,-1,-1,-1,-1};			  
				 //AND
				 if(chckbxNewCheckBox.isSelected()==true) {
					 search[0]=1;//to
				 }
				 if(chckbxDo.isSelected()==true) {
					 search[1]=1;//do
				 }
				 if(chckbxI.isSelected()==true) {
					 search[2]=1;//I
				 }
				 if(chckbxAm.isSelected()==true) {
					 search[3]=1;//am
				 }
				 if(chckbxLet.isSelected()==true) {
					 search[4]=1;//let
				 }
				 if(chckbxIt.isSelected()==true) {
					 search[5]=1;//it
				 }
				 //NOT
				 if(chckbxNewCheckBox_1.isSelected()==true) {
					 search[0]=0;//to
				 }
				 if(chckbxDo_1.isSelected()==true) {
					 search[1]=0;//do
				 }
				 if(chckbxI_1.isSelected()==true) {
					 search[2]=0;//I
				 }
				 if(chckbxAm_1.isSelected()==true) {
					 search[3]=0;//am
				 }
				 if(chckbxLet_1.isSelected()==true) {
					 search[4]=0;//let
				 }
				 if(chckbxIt_1.isSelected()==true) {
					 search[5]=0;//it
				 }
				 
				 SearchByBoolean a = new SearchByBoolean();
				 String BooleanResult;
				 BooleanResult=a.BooleanModelSearchByOneself(search);
				 resultShowTextPane.setText(BooleanResult);
				 
				 }
			 
			 });
	    
	    
	    resultShowTextPane.setText("\u68C0\u7D22\u7ED3\u679C");
	    resultShowTextPane.setBounds(25, 417, 626, 109);
	    resultShowTextPane.setEditable(false);
	    panel1.add(resultShowTextPane);
	    
	    //向量检索模型
	    JPanel panel2= new JPanel();
		tabbedPane.addTab("向量检索模型", panel2);
		panel2.setLayout(null);
		
		//向量检索模型的规则介绍
		JTextPane txtpnQTo_1 = new JTextPane();
		txtpnQTo_1.setText("\u8BF4\u660E\uFF1A\u9009\u62E9\u4F7F\u7528\u54EA\u4E2A\u6587\u4EF6\u8FDB\u884C\u68C0\u7D22\r\nq1: to \r\nq2: do \r\nq3: to do \r\nq4: I am \r\nq5: Let it ");
		txtpnQTo_1.setEditable(false);
		txtpnQTo_1.setBounds(51, 70, 562, 140);
		panel2.add(txtpnQTo_1);
		
		//向量检索模型的选择框
		
		comboBox_1.setBounds(51, 244, 563, 30);
		panel2.add(comboBox_1);
		comboBox_1.addItem("q1: to ");
	    comboBox_1.addItem("q2: do ");
	    comboBox_1.addItem("q3: to do ");
	    comboBox_1.addItem("q4: I am ");
	    comboBox_1.addItem("q5: Let it ");
	    
	  //向量检索模型的显示结果text field
	   
		resultShowTextPane_1.setText("\u68C0\u7D22\u7ED3\u679C");
		resultShowTextPane_1.setEditable(false);
		resultShowTextPane_1.setBounds(26, 355, 626, 190);
		panel2.add(resultShowTextPane_1);
	    
		
	    //向量检索模型的开始检索按钮
		JButton btnNewButton_2 = new JButton("\u5F00\u59CB\u68C0\u7D22");
		btnNewButton_2.setBounds(274, 306, 97, 23);
		panel2.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 //int queryNo=comboBox.getSelectedIndex();
				 SearchByVectorModel s = new SearchByVectorModel();			 
				 String VectorResult;
				 VectorResult=s.returnResult(comboBox_1.getSelectedIndex());				 
				 resultShowTextPane_1.setText(VectorResult);
				 }
			 
			 });
		
		
	    
	    JPanel panel3= new JPanel();
		tabbedPane.addTab("倒排索引", panel3);
		panel3.setLayout(null);
		
		JTextPane txtpnQTo_1_1 = new JTextPane();
		txtpnQTo_1_1.setText("\u8BF4\u660E\uFF1A\u9009\u62E9\u4F7F\u7528\u54EA\u4E2A\u6587\u4EF6\u8FDB\u884C\u68C0\u7D22\r\nq1: to \r\nq2: do \r\nq3: to do \r\nq4: I am \r\nq5: Let it ");
		txtpnQTo_1_1.setEditable(false);
		txtpnQTo_1_1.setBounds(44, 70, 562, 140);
		panel3.add(txtpnQTo_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(43, 240, 563, 30);
		panel3.add(comboBox_1_1);
		comboBox_1_1.addItem("q1: to ");
	    comboBox_1_1.addItem("q2: do ");
	    comboBox_1_1.addItem("q3: to do ");
	    comboBox_1_1.addItem("q4: I am ");
	    comboBox_1_1.addItem("q5: Let it ");
	    
	  //倒排索引模型的结果框
	    JTextPane resultShowTextPane_1_1 = new JTextPane();
		resultShowTextPane_1_1.setText("\u68C0\u7D22\u7ED3\u679C");
		resultShowTextPane_1_1.setEditable(false);
		resultShowTextPane_1_1.setBounds(26, 354, 626, 190);
		panel3.add(resultShowTextPane_1_1);
		
	    //倒排索引模型的开始检索按钮
		JButton btnNewButton_2_1 = new JButton("\u5F00\u59CB\u68C0\u7D22");
		btnNewButton_2_1.setBounds(272, 311, 97, 23);
		panel3.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 InvertedIndex s = new InvertedIndex();			 
				 String InvertedResult=s.returnResult(comboBox_1_1.getSelectedIndex());
				 System.out.println("NO:"+comboBox_1_1.getSelectedIndex());
				 //InvertedResult=				 
				 resultShowTextPane_1_1.setText(InvertedResult);
				 }
			 
			 });
		
		
	    
	}
}
