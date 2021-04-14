package Views;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class Menu {
	String[] data = {"um", "dois", "tres", "quatro", "cinco"}; //um array de String para a lista, cada elemento do array será uma opçao na lista
	
	//criando os componentns do meu programa
	private JFrame frame;
	private JList<String> lista;
	private JLabel label;
	private JLabel label1;
	private String selectedItem = "nada", selecao;	//item da minha lista
	private int index = 0;	//index da minha lista
	
	MouseAdapter mouseListener = new MouseAdapter() { //criando uma classe para capturar eventos do mouse, se eu quero clicar em um
													  //item da minha lista, eu faço isso com o mouse, entao eu preciso capturar o evento 
		
		public void mouseClicked(MouseEvent e) {	  //este é o método q recebe o evento do clique, ou seja, se eu clicar em cima da lista, ele executa este método
				
				selectedItem = lista.getSelectedValue();	//chamo o metodo getSelectedValue() para retornar o item q eu selecionei
				index = lista.getSelectedIndex();			//mesma coisa, só que agora com o index, ou seja, a posiçao do item na lista
				elecao = Integer.toString(index);	//convertendo a variavel index para string, para assim ser aceito no label
				label.setText(selectedItem);				//modificando o texto do label para o nome do item selecionado, ou seja, cada clique que eu der, ele muda o texto da label
				label1.setText(selecao);					//mesma coisa só que com o index

		}
	};
	
	public Menu() {	//construtor
		frame = new JFrame("MAIN");	//instanciando o frame e passando alguns parametros padrao
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		lista = new JList<>(data);	//dizendo pra minha lista qual é o array q ela vai percorrer para adicionar os itens
		lista.addMouseListener(mouseListener); //adicionando na minha lista o mouseListener, agora os clicks estao ligados diretamente na lista
		
		label = new JLabel(); //instanciando o label do item
		label1 = new JLabel(); //instanciando o label do index
		
		//aqui eu estou passando o texto padrao que aparece quando voce abre o programa, sem isso nao ia aparecer nada ate clicar em algum item na lista
		label.setText(selectedItem); 
		label1.setText(selecao);
		
		//aqui eu adiciono todos os meus contents no meu frame
		frame.add(lista);
		
		//aqui eu passo a posiçao do label
		frame.add(label, BorderLayout.SOUTH); 
		frame.add(label1, BorderLayout.SOUTH);
		
		frame.pack();	//sempre use este método para redimensionar sua janela de acordo com os contents que estao dentro dela
		frame.setVisible(true);		//mostrando a frame
	}
	
	
}
