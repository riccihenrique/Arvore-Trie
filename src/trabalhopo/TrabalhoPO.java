package trabalhopo;

public class TrabalhoPO 
{
    public static void main(String[] args) 
    {
        Trie t = new Trie();
        t.insere("acta");
        t.insere("acto");
        t.insere("actor");
        t.insere("ala");
        t.insere("galo");
        t.insere("gel");
        t.insere("sola");
        t.insere("solo");
        t.insere("sol");
        
        t.exibe();
        
        //t.excluir("sol");
        
        // Não deu tempo de encontrar o erro da exclusão. A ideia era: Todos os nodos que precisam ser excluidos e existe elementos subsequentes
        // basta retirar a palavra do nodo. Caso não exista elementos em sua sequencia, é necessário excluir todos os nodos acima dele até que
        // Encontre um que possua ligações;
            }
    
}
