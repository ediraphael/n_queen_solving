package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;

import algo.Solver;

public class MainView 
{

	private JFrame frame;

	private JPanel mainPanel;
	private JPanel panMainSetting; 
	private JPanel panSeparatorTop;
	private JPanel panelSeparatorLow;
	private JPanel panelResult;
	private JPanel panelAction;
	private JPanel panelButton;
	private JPanel panelRun;
	private JPanel panContainRunBtn;
	private JPanel panelExit;
	private JPanel panContainExitBtn;
	private JPanel panNbDame;
	private JPanel panChoice;
	private JPanel panChoiceElement;
	private JPanel panChoiceNbDame;
	private JPanel panNbDameLeftSetting;
	private JPanel panNbDameSeparator;
	private JPanel panNbDaMeSeparatorLeftSetting;
	private JPanel panNbDameSeparatorRightSetting;
	private JPanel panTextFieldChoiceNbDame;
	private JPanel panChoiceNbResult;
	private JPanel mainPanTopSetting;
	private JPanel mainPanRightSetting;
	private JPanel mainPanLeftSetting;
	private JPanel panNbResult;
	private JPanel panNbResultLeftSetting;
	private JPanel panNbResultSeparator;
	private JPanel panAcSeparatorLeftSetting;
	private JPanel panAlcSeparatorRightSetting;
	private JPanel panNbResultTextFieldLeftSetting;
	private JPanel panNbResultTextFieldContainer;
	private JPanel panelTimeExecution;
	private JPanel panTextFieldChoiceNbResult;
	private JPanel panTopSettingNbDame;
	private JPanel panNbResultTopSetting;
	private JPanel panNbResultLowSetting;
	private JPanel panNbResultRightSetting;

	private Box vbLeftSettingExit;
	private Box vbRightSettingExit;
	private Box vbChoice;
	private Box vbChoiceLeftSetting;
	private Box hbChoiceTopSetting;
	private Box hbChoiceLowSetting;
	private Box hbChoiceContainer;
	private Box hbTopChoiceNbDame;
	private Box hbResult;
	private Box hbResultSetting;
	private Box vbLeftSettingRun;
	private Box hbResultContainer;
	private Box hbAction;
	private Box vbButton;
	private Box hbRun;
	private Box hbTopSettingRun;
	private Box hbLowSettingRun;
	private Box hbContainerRunBtn;
	private Box vbRightSettingRun;
	private Box hbExit;
	private Box hbTopSettingExit;
	private Box hbLowSettingExit;
	private Box hbContainerExitBtn;
	private Box hbLowChoiceNbDame;
	private Box hbTopChoiceNbResult;
	private Box hbLowChoiceNbResult;

	private JSeparator separatorTop;
	private JSeparator separatorLow;
	private JSeparator separatorNbDame;
	private JSeparator separatorAc;
	
	private JButton btnRun;
	private JButton btnExit;

	private JLabel lblNbDame;
	private JLabel lblNbResult;
	private JLabel lblTpsAlgo;

	private JTextField textFieldNbDame;
	private JTextField textFieldNbResult;
	
	private JScrollPane scrollPane;
	
	private JTextArea textAreaResult;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainView window = new MainView();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("EZ Solveur N-Dames");
		
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		hbResult = Box.createHorizontalBox();
		mainPanel.add(hbResult, BorderLayout.CENTER);
		
		panelResult = new JPanel();
		hbResult.add(panelResult);
		panelResult.setLayout(new BorderLayout(0, 0));
		
		hbResultSetting = Box.createHorizontalBox();
		hbResultSetting.setPreferredSize(new Dimension(0, 30));
		panelResult.add(hbResultSetting, BorderLayout.SOUTH);
		
		panMainSetting = new JPanel();
		hbResultSetting.add(panMainSetting);
		panMainSetting.setLayout(new BorderLayout(0, 0));
		
		panSeparatorTop = new JPanel();
		panSeparatorTop.setPreferredSize(new Dimension(0, 20));
		panMainSetting.add(panSeparatorTop, BorderLayout.NORTH);
		panSeparatorTop.setLayout(new BorderLayout(0, 0));
		
		separatorTop = new JSeparator();
		panSeparatorTop.add(separatorTop, BorderLayout.SOUTH);
		
		panelTimeExecution = new JPanel();
		panSeparatorTop.add(panelTimeExecution, BorderLayout.WEST);
		panelTimeExecution.setLayout(new BorderLayout(0, 0));
		
		lblTpsAlgo = new JLabel("");
		lblTpsAlgo.setForeground(new Color(0, 0, 128));
		lblTpsAlgo.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelTimeExecution.add(lblTpsAlgo, BorderLayout.CENTER);
		
		panelSeparatorLow = new JPanel();
		panelSeparatorLow.setPreferredSize(new Dimension(0, 10));
		panMainSetting.add(panelSeparatorLow, BorderLayout.SOUTH);
		panelSeparatorLow.setLayout(new BorderLayout(0, 0));
		
		separatorLow = new JSeparator();
		panelSeparatorLow.add(separatorLow, BorderLayout.SOUTH);
		
		hbResultContainer = Box.createHorizontalBox();
		panelResult.add(hbResultContainer, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		hbResultContainer.add(scrollPane);
		
		textAreaResult = new JTextArea();
		textAreaResult.setFont(new Font("Courier New", Font.PLAIN, 12));
		textAreaResult.setEditable(false);
		scrollPane.setViewportView(textAreaResult);
		
		hbAction = Box.createHorizontalBox();
		hbAction.setPreferredSize(new Dimension(0, 100));
		mainPanel.add(hbAction, BorderLayout.SOUTH);
		
		panelAction = new JPanel();
		hbAction.add(panelAction);
		panelAction.setLayout(new BorderLayout(0, 0));
		
		vbButton = Box.createVerticalBox();
		vbButton.setPreferredSize(new Dimension(130, 0));
		panelAction.add(vbButton, BorderLayout.EAST);
		
		panelButton = new JPanel();
		vbButton.add(panelButton);
		panelButton.setLayout(new BorderLayout(0, 0));
		
		hbRun = Box.createHorizontalBox();
		hbRun.setPreferredSize(new Dimension(0, 50));
		panelButton.add(hbRun, BorderLayout.NORTH);
		
		panelRun = new JPanel();
		hbRun.add(panelRun);
		panelRun.setLayout(new BorderLayout(0, 0));
		
		hbTopSettingRun = Box.createHorizontalBox();
		hbTopSettingRun.setPreferredSize(new Dimension(0, 15));
		panelRun.add(hbTopSettingRun, BorderLayout.NORTH);
		
		hbLowSettingRun = Box.createHorizontalBox();
		hbLowSettingRun.setPreferredSize(new Dimension(0, 8));
		panelRun.add(hbLowSettingRun, BorderLayout.SOUTH);
		
		hbContainerRunBtn = Box.createHorizontalBox();
		panelRun.add(hbContainerRunBtn, BorderLayout.CENTER);
		
		panContainRunBtn = new JPanel();
		panContainRunBtn.setMinimumSize(new Dimension(0, 0));
		hbContainerRunBtn.add(panContainRunBtn);
		panContainRunBtn.setLayout(new BorderLayout(0, 0));
		
		btnRun = new JButton("Lancer");
		btnRun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!textFieldNbDame.getText().matches("[0-9]*") || !textFieldNbResult.getText().matches("[0-9]*"))
				{
					JOptionPane.showMessageDialog(frame,"Les champs de saisie ne doivent contenir que des chiffres");
				}
				else if("".equals(textFieldNbDame.getText()))
				{
					JOptionPane.showMessageDialog(frame,"Veuillez saisir le nombre de dames");
				}
				else
				{
					Solver solver = new Solver(Integer.parseInt(textFieldNbDame.getText()));
					long start = System.currentTimeMillis();
					solver.solve();
					long end = System.currentTimeMillis();
					lblTpsAlgo.setText("Temps d'execution de l'algorithme : " + (end - start)  + "ms");
					textAreaResult.setText(solver.showResult());
				}
			}
		});
		panContainRunBtn.add(btnRun, BorderLayout.CENTER);
		
		vbLeftSettingRun = Box.createVerticalBox();
		vbLeftSettingRun.setPreferredSize(new Dimension(10, 0));
		panelRun.add(vbLeftSettingRun, BorderLayout.WEST);
		
		vbRightSettingRun = Box.createVerticalBox();
		vbRightSettingRun.setPreferredSize(new Dimension(10, 0));
		panelRun.add(vbRightSettingRun, BorderLayout.EAST);
		
		hbExit = Box.createHorizontalBox();
		hbExit.setPreferredSize(new Dimension(0, 50));
		panelButton.add(hbExit, BorderLayout.SOUTH);
		
		panelExit = new JPanel();
		hbExit.add(panelExit);
		panelExit.setLayout(new BorderLayout(0, 0));
		
		hbTopSettingExit = Box.createHorizontalBox();
		hbTopSettingExit.setPreferredSize(new Dimension(8, 10));
		panelExit.add(hbTopSettingExit, BorderLayout.NORTH);
		
		hbLowSettingExit = Box.createHorizontalBox();
		hbLowSettingExit.setPreferredSize(new Dimension(0, 15));
		panelExit.add(hbLowSettingExit, BorderLayout.SOUTH);
		
		hbContainerExitBtn = Box.createHorizontalBox();
		panelExit.add(hbContainerExitBtn, BorderLayout.CENTER);
		
		panContainExitBtn = new JPanel();
		panContainExitBtn.setMinimumSize(new Dimension(0, 0));
		hbContainerExitBtn.add(panContainExitBtn);
		panContainExitBtn.setLayout(new BorderLayout(0, 0));
		
		btnExit = new JButton("Quitter");
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}
		});
		panContainExitBtn.add(btnExit, BorderLayout.CENTER);
		
		vbLeftSettingExit = Box.createVerticalBox();
		vbLeftSettingExit.setPreferredSize(new Dimension(10, 0));
		panelExit.add(vbLeftSettingExit, BorderLayout.WEST);
		
		vbRightSettingExit = Box.createVerticalBox();
		vbRightSettingExit.setPreferredSize(new Dimension(10, 0));
		panelExit.add(vbRightSettingExit, BorderLayout.EAST);
		
		vbChoice = Box.createVerticalBox();
		panelAction.add(vbChoice, BorderLayout.CENTER);
		
		panChoice = new JPanel();
		vbChoice.add(panChoice);
		panChoice.setLayout(new BorderLayout(0, 0));
		
		vbChoiceLeftSetting = Box.createVerticalBox();
		vbChoiceLeftSetting.setPreferredSize(new Dimension(10, 0));
		panChoice.add(vbChoiceLeftSetting, BorderLayout.WEST);
		
		hbChoiceTopSetting = Box.createHorizontalBox();
		hbChoiceTopSetting.setPreferredSize(new Dimension(0, 15));
		panChoice.add(hbChoiceTopSetting, BorderLayout.NORTH);
		
		hbChoiceLowSetting = Box.createHorizontalBox();
		hbChoiceLowSetting.setPreferredSize(new Dimension(0, 15));
		panChoice.add(hbChoiceLowSetting, BorderLayout.SOUTH);
		
		hbChoiceContainer = Box.createHorizontalBox();
		panChoice.add(hbChoiceContainer, BorderLayout.CENTER);
		
		panChoiceElement = new JPanel();
		hbChoiceContainer.add(panChoiceElement);
		panChoiceElement.setLayout(new BorderLayout(0, 0));
		
		panChoiceNbDame = new JPanel();
		panChoiceNbDame.setPreferredSize(new Dimension(320, 10));
		panChoiceElement.add(panChoiceNbDame, BorderLayout.WEST);
		panChoiceNbDame.setLayout(new BorderLayout(0, 0));
		
		hbTopChoiceNbDame = Box.createHorizontalBox();
		hbTopChoiceNbDame.setPreferredSize(new Dimension(0, 25));
		panChoiceNbDame.add(hbTopChoiceNbDame, BorderLayout.NORTH);
		
		panNbDame = new JPanel();
		hbTopChoiceNbDame.add(panNbDame);
		panNbDame.setLayout(new BorderLayout(0, 0));
		
		lblNbDame = new JLabel("Nombre de dames");
		panNbDame.add(lblNbDame, BorderLayout.CENTER);
		
		panNbDameLeftSetting = new JPanel();
		panNbDameLeftSetting.setPreferredSize(new Dimension(95, 10));
		panNbDame.add(panNbDameLeftSetting, BorderLayout.WEST);
		
		panNbDameSeparator = new JPanel();
		panNbDameSeparator.setPreferredSize(new Dimension(10, 2));
		panNbDame.add(panNbDameSeparator, BorderLayout.SOUTH);
		panNbDameSeparator.setLayout(new BorderLayout(0, 0));
		
		panNbDaMeSeparatorLeftSetting = new JPanel();
		panNbDaMeSeparatorLeftSetting.setPreferredSize(new Dimension(5, 0));
		panNbDameSeparator.add(panNbDaMeSeparatorLeftSetting, BorderLayout.WEST);
		
		panNbDameSeparatorRightSetting = new JPanel();
		panNbDameSeparatorRightSetting.setPreferredSize(new Dimension(15, 0));
		panNbDameSeparator.add(panNbDameSeparatorRightSetting, BorderLayout.EAST);
		
		separatorNbDame = new JSeparator();
		panNbDameSeparator.add(separatorNbDame, BorderLayout.CENTER);
		
		hbLowChoiceNbDame = Box.createHorizontalBox();
		panChoiceNbDame.add(hbLowChoiceNbDame, BorderLayout.CENTER);
		
		panTextFieldChoiceNbDame = new JPanel();
		hbLowChoiceNbDame.add(panTextFieldChoiceNbDame);
		panTextFieldChoiceNbDame.setLayout(new BorderLayout(0, 0));
		
		textFieldNbDame = new JTextField();
		panTextFieldChoiceNbDame.add(textFieldNbDame, BorderLayout.CENTER);
		textFieldNbDame.setColumns(10);
		
		panTopSettingNbDame = new JPanel();
		panTextFieldChoiceNbDame.add(panTopSettingNbDame, BorderLayout.NORTH);
		
		JPanel panLeftSettingNbDame = new JPanel();
		panLeftSettingNbDame.setPreferredSize(new Dimension(5, 10));
		panTextFieldChoiceNbDame.add(panLeftSettingNbDame, BorderLayout.WEST);
		
		JPanel panLowSettingNbDame = new JPanel();
		panTextFieldChoiceNbDame.add(panLowSettingNbDame, BorderLayout.SOUTH);
		
		JPanel panRightSettingNbDame = new JPanel();
		panRightSettingNbDame.setPreferredSize(new Dimension(15, 10));
		panTextFieldChoiceNbDame.add(panRightSettingNbDame, BorderLayout.EAST);
		
		panChoiceNbResult = new JPanel();
		panChoiceNbResult.setMaximumSize(new Dimension(300, 10));
		panChoiceNbResult.setSize(new Dimension(100, 10));
		panChoiceNbResult.setPreferredSize(new Dimension(320, 10));
		panChoiceElement.add(panChoiceNbResult, BorderLayout.EAST);
		panChoiceNbResult.setLayout(new BorderLayout(0, 0));
		
		hbTopChoiceNbResult = Box.createHorizontalBox();
		hbTopChoiceNbResult.setPreferredSize(new Dimension(0, 25));
		panChoiceNbResult.add(hbTopChoiceNbResult, BorderLayout.NORTH);
		
		panNbResult = new JPanel();
		hbTopChoiceNbResult.add(panNbResult);
		panNbResult.setLayout(new BorderLayout(0, 0));
		
		lblNbResult = new JLabel("Nombre de résultats");
		panNbResult.add(lblNbResult, BorderLayout.CENTER);
		
		panNbResultLeftSetting = new JPanel();
		panNbResultLeftSetting.setPreferredSize(new Dimension(85, 10));
		panNbResult.add(panNbResultLeftSetting, BorderLayout.WEST);
		
		panNbResultSeparator = new JPanel();
		panNbResultSeparator.setPreferredSize(new Dimension(10, 2));
		panNbResult.add(panNbResultSeparator, BorderLayout.SOUTH);
		panNbResultSeparator.setLayout(new BorderLayout(0, 0));
		
		panAcSeparatorLeftSetting = new JPanel();
		panAcSeparatorLeftSetting.setPreferredSize(new Dimension(15, 0));
		panNbResultSeparator.add(panAcSeparatorLeftSetting, BorderLayout.WEST);
		
		panAlcSeparatorRightSetting = new JPanel();
		panAlcSeparatorRightSetting.setPreferredSize(new Dimension(15, 0));
		panNbResultSeparator.add(panAlcSeparatorRightSetting, BorderLayout.EAST);
		
		separatorAc = new JSeparator();
		separatorAc.setMaximumSize(new Dimension(20, 20));
		panNbResultSeparator.add(separatorAc, BorderLayout.CENTER);
		
		hbLowChoiceNbResult = Box.createHorizontalBox();
		panChoiceNbResult.add(hbLowChoiceNbResult, BorderLayout.CENTER);
		
		panTextFieldChoiceNbResult = new JPanel();
		hbLowChoiceNbResult.add(panTextFieldChoiceNbResult);
		panTextFieldChoiceNbResult.setLayout(new BorderLayout(0, 0));
		
		panNbResultTextFieldLeftSetting = new JPanel();
		panNbResultTextFieldLeftSetting.setPreferredSize(new Dimension(15, 0));
		panTextFieldChoiceNbResult.add(panNbResultTextFieldLeftSetting, BorderLayout.WEST);

		panNbResultTextFieldContainer = new JPanel();
		panTextFieldChoiceNbResult.add(panNbResultTextFieldContainer, BorderLayout.CENTER);
		panNbResultTextFieldContainer.setLayout(new BorderLayout(0, 0));
		
		textFieldNbResult = new JTextField();
		panNbResultTextFieldContainer.add(textFieldNbResult, BorderLayout.CENTER);
		textFieldNbResult.setColumns(10);
		
		panNbResultTopSetting = new JPanel();
		panNbResultTextFieldContainer.add(panNbResultTopSetting, BorderLayout.NORTH);
		
		panNbResultLowSetting = new JPanel();
		panNbResultTextFieldContainer.add(panNbResultLowSetting, BorderLayout.SOUTH);
		
		panNbResultRightSetting = new JPanel();
		panNbResultRightSetting.setPreferredSize(new Dimension(15, 10));
		panNbResultTextFieldContainer.add(panNbResultRightSetting, BorderLayout.EAST);

		mainPanTopSetting = new JPanel();
		mainPanel.add(mainPanTopSetting, BorderLayout.NORTH);

		mainPanRightSetting = new JPanel();
		mainPanRightSetting.setPreferredSize(new Dimension(10, 0));
		mainPanel.add(mainPanRightSetting, BorderLayout.WEST);
		mainPanRightSetting.setLayout(null);

		mainPanLeftSetting = new JPanel();
		mainPanel.add(mainPanLeftSetting, BorderLayout.EAST);
	}
}
