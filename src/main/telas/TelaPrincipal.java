package main.telas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import main.dados.Turma;
import main.telas.TelaCadastro;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {
	private Turma turma = new Turma();

    private static final long serialVersionUID = 1L;
    private Color corFundo = new Color(240, 233, 255);
    private Color corBotao = new Color(0x95adf1);
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaPrincipal frame = new TelaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TelaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int larguraTela = (int) tela.getWidth();
        int alturaTela = (int) tela.getHeight();

        setBounds(0, 0, larguraTela, alturaTela);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(corFundo);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton btnFechar = new JButton("X");
        btnFechar.setBackground(new Color(0x95adf1));
        btnFechar.setBounds(larguraTela - 99, 0, 99, 88);
        btnFechar.setFont(new Font("Tahoma", Font.BOLD, 50));
        btnFechar.setForeground(corFundo);
        btnFechar.setFocusPainted(false);
        btnFechar.setBorder(new LineBorder(Color.black, 3));
        btnFechar.setContentAreaFilled(false);
        btnFechar.setOpaque(true);
        contentPane.add(btnFechar);
        btnFechar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	System.exit(0);
            	
            }
        });

        JLabel lblTitulo = new JLabel("APP GERENCIAMENTO DE CLASSE (GC)");
        lblTitulo.setForeground(corFundo);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblTitulo.setBounds(larguraTela / 2 - (999 / 2), 4, 999, 78);
        contentPane.add(lblTitulo);

        JPanel panelHeader = new JPanel();
        panelHeader.setBounds(0, 0, larguraTela, 88);
        panelHeader.setBorder(new LineBorder(Color.black, 3));
        panelHeader.setBackground(new Color(0x4e64a5));
        contentPane.add(panelHeader);

        JButton btnDiminuir = new JButton("-");
        btnDiminuir.setFocusPainted(false);
        btnDiminuir.setBorder(new LineBorder(Color.black, 3));
        btnDiminuir.setContentAreaFilled(false);
        btnDiminuir.setOpaque(true);
        btnDiminuir.setBackground(new Color(0x95adf1));
        btnDiminuir.setBounds(0, 0, 99, 88);
        btnDiminuir.setFont(new Font("Tahoma", Font.BOLD, 50));
        btnDiminuir.setForeground(corFundo);
        contentPane.add(btnDiminuir);
        btnDiminuir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setState(JFrame.ICONIFIED);
            }
        });

        // Botão 1
        JPanel botaoCadastrar = new JPanel(null);
        botaoCadastrar.setBackground(new Color(0x95adf1));
        botaoCadastrar.setBounds(larguraTela / 2 - (444 / 2), 280, 444, 88);
        botaoCadastrar.setBorder(new LineBorder(Color.black, 3));
        
        JLabel lblCadastrar = new JLabel("Cadastrar Aluno");
        lblCadastrar.setForeground(corFundo);
        lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblCadastrar.setBounds(95, 15, 400, 55);
        botaoCadastrar.add(lblCadastrar);
        contentPane.add(botaoCadastrar);
        botaoCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	abrirCadastro();
            }
        });

        // Botão 2
        JPanel botaoListar = new JPanel(null);
        botaoListar.setBackground(new Color(0x95adf1));
        botaoListar.setBorder(new LineBorder(Color.black, 3));
        botaoListar.setBounds(larguraTela / 2 - (444 / 2), 430, 444, 88);
        botaoListar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	abrirTabela();
            }
        });
        JLabel lblListar = new JLabel("Listar Alunos");
        lblListar.setForeground(corFundo);
        lblListar.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblListar.setBounds(115, 15, 400, 55);
        botaoListar.add(lblListar);
        contentPane.add(botaoListar);

        // Botão 3
        JPanel botaoConsultar = new JPanel(null);
        botaoConsultar.setBorder(new LineBorder(Color.black, 3));
        botaoConsultar.setBackground(new Color(0x95adf1));
        botaoConsultar.setBounds(larguraTela / 2 - (444 / 2), 580, 444, 88);
        JLabel lblConsultar = new JLabel("Consultar Aluno");
        lblConsultar.setForeground(corFundo);
        lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblConsultar.setBounds(90, 15, 400, 55);
        botaoConsultar.add(lblConsultar);
        botaoConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	abrirConsulta();
            }
        });
        contentPane.add(botaoConsultar);
        

        // Efeitos de clique
        addBotaoEfeito(botaoCadastrar, lblCadastrar);
        addBotaoEfeito(botaoListar, lblListar);
        addBotaoEfeito(botaoConsultar, lblConsultar);
        
    }

    private void addBotaoEfeito(JPanel painel, JLabel label) {
        Color corNormal = new Color(0x95adf1);
        Color corPressionado = new Color(0xcfd6ea);
        painel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                label.setForeground(Color.BLACK);
                painel.setBackground(corPressionado);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setForeground(new Color(0xf4f1d4));
                painel.setBackground(corNormal);
            }
        });
    }
    
    private void abrirCadastro() {
    	TelaCadastro tela = new TelaCadastro(0, turma);
		tela.setVisible(true);
		tela.atualizaTabela();
    }
    
    private void abrirTabela() {
    	TelaCadastro tela = new TelaCadastro(1, turma);
		tela.setVisible(true);
		tela.atualizaTabela();
    }
    

    private void abrirConsulta() {
    	TelaCadastro tela = new TelaCadastro(2, turma);
		tela.setVisible(true);
		tela.atualizaTabela();
    }
}
