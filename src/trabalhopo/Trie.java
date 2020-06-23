package trabalhopo;

public class Trie 
{
    private Nodo raiz;

    public Trie() {raiz = new Nodo();}    
    
    public void insere(String p)
    {
        int i = 0, pos;
        Nodo aux = raiz;
        
        while(i < p.length()) //para cada char 
        {
            pos = aux.buscaPos(p.charAt(i));
            if(!aux.contem(p.charAt(i))) //se não contem insere o caractere
            {
                aux.insereVetor(pos, p.charAt(i));
                aux.setLig(pos, new Nodo());
            }
            
            aux = aux.getLigs(pos);
            i++;
        }
        
        if(aux.getPalavra().equals(p))
            System.out.println("Palavra existente!");
        else
            aux.setPalavra(p);
    }
    
    public void exibe()
    {
        exibeInOrdem(raiz, 0);
    }
    
    private void exibeInOrdem(Nodo aux, int pos)
    {
        if(aux.getLigs(0) != null)
            for(int i = 0; i < aux.getTL(); i++)
                exibeInOrdem(aux.getLigs(i), i);
        
        if(!aux.getPalavra().isEmpty())
            System.out.println(aux.getPalavra());
    }
    
    public void excluir(String p)
    {
        // Os problemas estão no busca pai e nodo
        Nodo aux = buscaNodo(p);
        Nodo auxPai = buscaPai(p, aux);
        int pos = auxPai.buscaPos(p.charAt(p.length() - 1));
        
        if(aux.getLigs(0) != null)
            aux.setPalavra("");
        else
        {
            
            while(aux.getLigs(0) != null)
            {
                pos = auxPai.buscaPos(p.charAt(p.length() - 1));
                auxPai.removeVetor(pos);

                aux = auxPai;
                auxPai = buscaPai(p, aux);
            }
        }        
    }
    
    public Nodo buscaNodo(String p)
    {
        int i = 0, j;
        Nodo aux = raiz;
        while(i < p.length())
        {
            j = 0;
            while(j < aux.getTL() && p.charAt(i) == aux.getLetras(j))
                j++;
            aux = aux.getLigs(j);
            
            i++;
        }
        
        if(aux.getPalavra().equals(p))
            return aux;
        return null;
    }
    
    public Nodo buscaPai(String p, Nodo n)
    {
        int i = 0, j;
        Nodo aux = raiz;
        while(i < p.length())
        {
            j = 0;
            while(j < aux.getTL() && p.charAt(i) == aux.getLetras(j))
                j++;
            
            if(aux.getLigs(j) == n)
                aux = aux.getLigs(j);
            
            i++;
        }
        
        return aux;
    }
}
