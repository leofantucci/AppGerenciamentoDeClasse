package main.telas;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import main.dados.Aluno;
import main.dados.Turma;

public class TelaCadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private Turma turma;
    private Color corFundo = new Color(240, 233, 255);
    private Color corBotao = new Color(0x95adf1);
    
    JTextField txtMatricula = new JTextField();
    JTextField txtNome = new JTextField();
    JTextField txtNota1 = new JTextField();
    JTextField txtNota2 = new JTextField();
    private int key;
    private int keyBusca;
    DefaultTableModel modelAluno = new DefaultTableModel();
    
    private int pessoaAdicionada = 0;
    private int encontradoBusca = 0;


    public TelaCadastro(int key, Turma turma) {
        this.turma = turma;
        this.key = key;
        
        
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraTela = (int) tela.getWidth();
        int alturaTela = (int) tela.getHeight();

        setUndecorated(true);
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(corFundo);
        mainPanel.setBorder(new LineBorder(Color.black, 3));
        setContentPane(mainPanel);

        JPanel panelHeader = new JPanel(null);
        panelHeader.setPreferredSize(new Dimension(500, 80));
        panelHeader.setBorder(new LineBorder(Color.black, 3));
        panelHeader.setBackground(new Color(0x4e64a5));
        mainPanel.add(panelHeader, BorderLayout.NORTH);

        JLabel lblTitulo = new JLabel("CADASTRO DE ALUNO");
        lblTitulo.setForeground(corFundo);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitulo.setBounds(500/2-125, 20, 250, 40);
        panelHeader.add(lblTitulo);
        
        JButton btnFechar = new JButton("X");
        btnFechar.setFocusPainted(false);
        btnFechar.setContentAreaFilled(false);
        btnFechar.setOpaque(true);
        btnFechar.setBackground(corBotao);
        btnFechar.setForeground(corFundo);
        btnFechar.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnFechar.setBounds(500 - 75, 0, 75, 80);
        btnFechar.setBorder(new LineBorder(Color.black, 3));
        btnFechar.setBorderPainted(true);
        panelHeader.add(btnFechar);
        
        JButton btnDiminuir = new JButton("-");
        btnDiminuir.setFocusPainted(false);
        btnDiminuir.setBorder(new LineBorder(Color.black, 3));
        btnDiminuir.setContentAreaFilled(false);
        btnDiminuir.setOpaque(true);
        btnDiminuir.setBackground(corBotao);
        btnDiminuir.setForeground(corFundo);
        btnDiminuir.setFont(new Font("Tahoma", Font.BOLD, 32));
        btnDiminuir.setBounds(0, 0, 75, 80);
        panelHeader.add(btnDiminuir);
        
        btnFechar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        btnDiminuir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setState(JFrame.ICONIFIED);
            }
        });
        
        contentPanel.setBackground(corFundo);
        contentPanel.setLayout(null);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        switch(key) {
        case 0:
        	JLabel lblMatricula = new JLabel("Matrícula");
            lblMatricula.setBounds(30, 30, 200, 25);
            lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 24));
            contentPanel.add(lblMatricula);

            txtMatricula.setBounds(30, 65, 250, 35);
            txtMatricula.setBorder(new LineBorder(Color.darkGray, 2));
            txtMatricula.setEditable(false);
            txtMatricula.setBackground(corBotao);
            txtMatricula.setText(Integer.toString(turma.getIdAtual()));
            contentPanel.add(txtMatricula);

            JLabel lblNome = new JLabel("Nome");
            lblNome.setBounds(30, 115, 200, 25);
            lblNome.setFont(new Font("Tahoma", Font.BOLD, 24));
            contentPanel.add(lblNome);

            txtNome.setBounds(30, 150, 250, 35);
            txtNome.setBackground(corBotao);
            txtNome.setBorder(new LineBorder(Color.darkGray, 2));
            txtNome.requestFocusInWindow();
            contentPanel.add(txtNome);

            JLabel lblNota1 = new JLabel("Nota 1");
            lblNota1.setBounds(30, 200, 120, 25);
            lblNota1.setFont(new Font("Tahoma", Font.BOLD, 24));
            contentPanel.add(lblNota1);

            txtNota1.setBounds(30, 235, 100, 35);
            txtNota1.setBackground(corBotao);
            txtNota1.setBorder(new LineBorder(Color.darkGray, 2));
            contentPanel.add(txtNota1);

            JLabel lblNota2 = new JLabel("Nota 2");
            lblNota2.setBounds(180, 200, 120, 25);
            lblNota2.setFont(new Font("Tahoma", Font.BOLD, 24));
            txtNota2.setBorder(new LineBorder(Color.darkGray, 2));
            contentPanel.add(lblNota2);
            
            txtNota2.setBounds(180, 235, 100, 35);
            txtNota2.setBackground(corBotao);
            contentPanel.add(txtNota2);

            JButton btnCadastrar = new JButton("Cadastrar");
            btnCadastrar.setBackground(corBotao);
            btnCadastrar.setBounds(500-300-33,333,150,44);
            btnCadastrar.setBorder(new LineBorder(Color.black, 2));
            btnCadastrar.setForeground(corFundo);
            btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 22));
            btnCadastrar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if(turma.getAlunosNome().contains(txtNome.getText().trim().toLowerCase())) {
    					JOptionPane.showMessageDialog(null, "Erro! Já existe um aluno com esse nome", "Erro", JOptionPane.ERROR_MESSAGE);
    				} else {
    					if(validaTextField(txtNome, "Nome") && validaTextField(txtNota1, "Nota 1") && validaTextField(txtNota2, "Nota2")) {
        					System.out.println("CADASTRANDO");
        					cadastrarAluno();
        				}
    				}
    			}	
    		});        
            
            JButton btnCancelar = new JButton("Cancelar");
            btnCancelar.setBounds(500-20-150,333,150,44);
            btnCancelar.setBorder(new LineBorder(Color.black, 2));
            btnCancelar.setBackground(corBotao);
            btnCancelar.setForeground(corFundo);
            btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 22));
            btnCancelar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    			}
    		});	
            
            contentPanel.add(btnCadastrar);
            contentPanel.add(btnCancelar);
            break;
            

        case 1:
        	setBounds(750/2,(larguraTela-750)/2-300,750, 750);
            larguraTela = (int) tela.getWidth();
        	lblTitulo = new JLabel("TABELA DE ALUNOS");
            lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 33));
            lblTitulo.setBounds(218, 20, 333, 40);         
            btnFechar.setBounds(750-75-3, 0, 75, 80);
            lblTitulo.setForeground(corFundo);

            java.awt.event.MouseAdapter hoverEfeito = new java.awt.event.MouseAdapter() {
    			Color normal = new Color(144, 144, 144);
    			Color hover = new Color(190, 190, 190);
    			
    			public void mouseEntered(java.awt.event.MouseEvent e) {
    				JButton btn = (JButton) e.getSource();
    				btn.setBackground(hover);
    				btn.setForeground(Color.BLACK);
    			}
    			public void mouseExited(java.awt.event.MouseEvent e) {
    				JButton btn = (JButton) e.getSource();
    				btn.setBackground(normal);
    				btn.setForeground(Color.WHITE);
    			}
    		};
    		
    		panelHeader.removeAll();
    		panelHeader.setLayout(null);
    		panelHeader.add(btnDiminuir);
    		panelHeader.add(lblTitulo);
    		panelHeader.add(btnFechar);
    		
    		JPanel painelTabela = new JPanel();
    		painelTabela.setBounds(0, 80, larguraTela, alturaTela-80);
    		painelTabela.setLayout(new BorderLayout());
    		
    		painelTabela.add(panelHeader, BorderLayout.NORTH);
    		
        	JTable tabelaCliente = new JTable();
    		tabelaCliente.setBackground(corFundo);
    		tabelaCliente.setForeground(Color.BLACK);
    		tabelaCliente.setSelectionBackground(new Color(90, 90, 90));
    		tabelaCliente.setSelectionForeground(Color.white);
    		tabelaCliente.getTableHeader().setBackground(new Color(50, 100, 220));
    		tabelaCliente.getTableHeader().setForeground(new Color(222, 222, 222));
    		tabelaCliente.getTableHeader().setFont(tabelaCliente.getTableHeader().getFont().deriveFont(Font.BOLD, 22));
    		tabelaCliente.setBounds(0, 0, 6, 6);
    		String[] colunas = {"Matricula", "Nome", "Nota 1", "Nota 2", "Media"};
    		modelAluno = new DefaultTableModel(colunas, 0) {
    			private static final long serialVersionUID = 1L;

    			@Override
    		    public boolean isCellEditable(int row, int column) {
    		        return false;
    		    }
    		};
    		tabelaCliente.setModel(modelAluno);
    		tabelaCliente.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    		tabelaCliente.setRowHeight(77);
    		
    		JScrollPane scrollPane = new JScrollPane(tabelaCliente);
    		scrollPane.getViewport().setBackground(new Color(111, 111, 111));
    		
    		painelTabela.add(BorderLayout.CENTER, scrollPane);				
    		JButton btnRemoverSelecao = new JButton("Remover Seleção");
    		btnRemoverSelecao.setVisible(false);
    		btnRemoverSelecao.setBounds(0, 400, larguraTela, 50);
    		btnRemoverSelecao.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				tabelaCliente.clearSelection();
    			}
    		});
    		
    		contentPanel.setLayout(new BorderLayout());
    		contentPanel.add(painelTabela, BorderLayout.CENTER);
    		contentPanel.add(btnRemoverSelecao, BorderLayout.SOUTH);
    		
    		btnRemoverSelecao.setBackground(corBotao);
    		btnRemoverSelecao.setForeground(Color.WHITE);
    		btnRemoverSelecao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    		btnRemoverSelecao.addMouseListener(hoverEfeito);
    		
    		tabelaCliente.getSelectionModel().addListSelectionListener(event -> {
    			if(tabelaCliente.getSelectedRow() != -1) {
    				btnRemoverSelecao.setVisible(true);
    			} else {
    				btnRemoverSelecao.setVisible(false);
    			}
    		});
    		break;
    		
        case 2:     	
        	contentPanel.setLayout(null);
        	contentPanel.removeAll();
        	lblTitulo.setText("CONSULTA DE ALUNO");
        	JPanel panelBusca = new JPanel();
        	panelBusca.setBackground(corBotao);
        	panelBusca.setBounds(20, 125, 500-44, 300);
        	panelBusca.setLayout(null);
        	panelBusca.setBorder(new LineBorder(Color.black, 3));
        	panelBusca.setVisible(false);
        	contentPanel.add(panelBusca);
        	
        	JLabel txtTituloBusca = new JLabel("");
        	txtTituloBusca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	txtTituloBusca.setForeground(corFundo);
        	panelBusca.add(txtTituloBusca);
        	
        	JTextField txtBusca = new JTextField();
        	txtBusca.setBounds(22, 71, 300, 40);
        	txtBusca.setForeground(Color.black);
        	txtBusca.setBorder(new LineBorder(Color.black, 2));
        	panelBusca.add(txtBusca);
        	
        	JButton btnPesquisaBusca = new JButton("Buscar 🔍");
        	btnPesquisaBusca.setOpaque(false);
        	btnPesquisaBusca.setBackground(corBotao);
        	btnPesquisaBusca.setForeground(corFundo);
        	btnPesquisaBusca.setBounds(333, 69, 100, 44);
        	btnPesquisaBusca.setBorder(new LineBorder(Color.black, 2));
        	
        	JLabel lblBotoes = new JLabel("Escolha como deseja buscar o aluno");
        	lblBotoes.setBounds((550-450)/2-10, 20, 450, 30);
            lblBotoes.setFont(new Font("Tahoma", Font.BOLD, 24));

        	contentPanel.add(lblBotoes);

        	JButton btnMatricula = new JButton("Matrícula");
        	btnMatricula.setBounds(80, 70, 150, 40);
      
            btnMatricula.setBorder(new LineBorder(Color.black, 2));
            btnMatricula.setBackground(corBotao);
            btnMatricula.setForeground(corFundo);
            btnMatricula.setFont(new Font("Tahoma", Font.BOLD, 22));
            btnMatricula.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    	        	txtTituloBusca.setBounds(20, 22, 420, 40);
            		txtTituloBusca.setText("Insira a matrícula que deseja buscar");
            		panelBusca.setVisible(true);
            		keyBusca = 0;
    			}
    		});	
        	contentPanel.add(btnMatricula);

        	JButton btnNome = new JButton("Nome");
        	btnNome.setBounds(500-250, 70, 150, 40);
            btnNome.setBorder(new LineBorder(Color.black, 2));
        	btnNome.setBackground(corBotao);
            btnNome.setForeground(corFundo);
            btnNome.setFont(new Font("Tahoma", Font.BOLD, 22));
            btnNome.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    	        	txtTituloBusca.setBounds(40, 22, 420, 40);
            		txtTituloBusca.setText("Insira o nome que deseja buscar");
            		panelBusca.setVisible(true);
            		keyBusca = 1;
    			}
    		});	
        	contentPanel.add(btnNome);
        	
        	JLabel lblMatriculaBusca = new JLabel();
        	lblMatriculaBusca.setBounds(20, 110, 500-10, 40);
        	lblMatriculaBusca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	panelBusca.add(lblMatriculaBusca);
        	
        	JLabel lblNomeBusca = new JLabel();
        	lblNomeBusca.setBounds(20, 140, 500-10-10, 40);
        	lblNomeBusca.setFont(new Font("Tahoma", Font.BOLD, 18));
        	panelBusca.add(lblNomeBusca);

        	JLabel lblNota1Busca = new JLabel();
        	lblNota1Busca.setBounds(20, 170, 540-44-22, 40);
        	lblNota1Busca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	panelBusca.add(lblNota1Busca);
        	
        	JLabel lblNota2Busca = new JLabel();
        	lblNota2Busca.setBounds(20, 200, 540-44-22, 40);
        	lblNota2Busca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	panelBusca.add(lblNota2Busca);

        	JLabel lblMediaBusca = new JLabel();
        	lblMediaBusca.setBounds(20, 230, 540-44-22, 40);
        	lblMediaBusca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	panelBusca.add(lblMediaBusca);
        	
        	JLabel lblErroBusca = new JLabel();
			lblErroBusca.setBounds(55, 140, 500-10-10, 40);
			lblErroBusca.setText("Nenhum aluno foi encontrado!");
			lblErroBusca.setVisible(false);
			lblErroBusca.setFont(new Font("Tahoma", Font.BOLD, 22));
        	panelBusca.add(lblErroBusca);
        	
        	btnPesquisaBusca.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    	        	if(validaTextField(txtBusca, "Busca")) {
    	        		
    	        		encontradoBusca = 0; 
    	                lblErroBusca.setVisible(false); 

    	                if (keyBusca == 0) { 
    	                    try {
    	                        int matriculaBuscada = Integer.parseInt(txtBusca.getText().trim());
    	                        
    	                        for (Aluno a : turma.getAlunos()) {
    	                            if (a.getMatricula() == matriculaBuscada) {
    	                                encontradoBusca = 1;
    	                                
    	                                lblMatriculaBusca.setText("Matrícula: " + a.getMatricula());
    	                                lblNomeBusca.setText("Nome: " + a.getNome());
    	                                lblNota1Busca.setText("Nota 1: " + a.getNota1());
    	                                lblNota2Busca.setText("Nota 2: " + a.getNota2());
    	                                lblMediaBusca.setText("Média: " + Double.toString(a.calcularMedia()));
    	                                
    	                                lblMatriculaBusca.setVisible(true);
    	                                lblNomeBusca.setVisible(true);
    	                                lblNota1Busca.setVisible(true);
    	                                lblNota2Busca.setVisible(true);
    	                                lblMediaBusca.setVisible(true);
    	                                
    	                                break; 
    	                            }
    	                        }
    	                    } catch (NumberFormatException ex) {
    	                        JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a matrícula.", "Erro", JOptionPane.ERROR_MESSAGE);
    	                    }

    	                } else if (keyBusca == 1) { 
    	                    String nomeBuscado = txtBusca.getText().toLowerCase().trim();
    	                    
    	                    for (Aluno a : turma.getAlunos()) {
    	                        if (a.getNome().toLowerCase().equals(nomeBuscado)) {
    	                            encontradoBusca = 1;
    	                            
    	                            lblMatriculaBusca.setText("Matrícula >> " + a.getMatricula());
    	                            lblNomeBusca.setText("Nome: " + a.getNome());
    	                            lblNota1Busca.setText("Nota 1: " + a.getNota1());
    	                            lblNota2Busca.setText("Nota 2: " + a.getNota2());
    	                            lblMediaBusca.setText("Média: " + Double.toString(a.calcularMedia()));
    	                            
    	                            lblMatriculaBusca.setVisible(true);
    	                            lblNomeBusca.setVisible(true);
    	                            lblNota1Busca.setVisible(true);
    	                            lblNota2Busca.setVisible(true);
    	                            lblMediaBusca.setVisible(true);
    	                            
    	                            break; 
    	                        }
    	                    }
    	                }

    	                if (encontradoBusca == 0) {
    	                    lblErroBusca.setVisible(true);
    	                    lblMatriculaBusca.setVisible(false);
    	                    lblNomeBusca.setVisible(false);
    	                    lblNota1Busca.setVisible(false);
    	                    lblNota2Busca.setVisible(false);
    	                    lblMediaBusca.setVisible(false);
    	                }
    	        	}
    			}
    		});	
        	panelBusca.add(btnPesquisaBusca);
        	break;
        }
    }
    
    public void atualizaTabela() {
    	modelAluno.setRowCount(0);
		for(Aluno a : turma.getAlunos()) {
			Object[] aluno = {
					a.getMatricula(),
					a.getNome(),
					a.getNota1(),
					a.getNota2(),
					a.calcularMedia()
			};
			modelAluno.addRow(aluno);
		}
    }
    
    public void cadastrarAluno() {
		Aluno a = new Aluno();
	    a.setMatricula(Integer.parseInt(txtMatricula.getText().trim()));
	    a.setNome(txtNome.getText().trim().toLowerCase());
	    a.setNota1(Double.parseDouble(txtNota1.getText().trim()));
	    a.setNota2(Double.parseDouble(txtNota2.getText().trim()));
		System.out.println("Pessoa adicionada!");

		if(validaTextField(txtNome, "nome") && validaTextField(txtNota1, "nota1") && validaTextField(txtNota2, "nota2")) {
			turma.adicionarAluno(a);
		}
		if(validaAlunoTurma(a)) {
			pessoaAdicionada = 1;
			JOptionPane.showMessageDialog(null, "Pessoa adicionada com sucesso");
		} else{
			pessoaAdicionada = 0;
			JOptionPane.showMessageDialog(null, "Erro na hora de botar", "Erro", JOptionPane.WARNING_MESSAGE);
		}		
		dispose();
	}
    
	public boolean validaAlunoTurma(Aluno a) {
		if(turma.getAlunos().contains(a)) {
			 return true;
		} else {
			return false;
		}		
	}
	
    public boolean validaTextField(JTextField t, String campo) {
		if(t.getText().trim().isEmpty()) {
			t.requestFocusInWindow();
			JOptionPane.showMessageDialog(t, "Preencha corretamente o campo " + campo +"!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
    }
    
    public int getPessoaAdicionada() {
    	return pessoaAdicionada;
    }
    
}