package trabalhopo;

public class Nodo 
{
    private char[] letras = new char[26];
    private Nodo[] ligs = new Nodo[26];
    private int TL;
    private String palavra;

    public Nodo() {
        this.palavra = "";
        this.TL = 0;
    }

    public Nodo(int TL, String palavra) {
        this.TL = TL;
        this.palavra = palavra;
    }

    public char getLetras(int pos) {
        return letras[pos];
    }

    public void setLetras(int pos, char l) {
        this.letras[pos] = l;
    }

    public Nodo getLigs(int pos) {
        return ligs[pos];
    }

    public void setLig(int pos, Nodo n) {
        this.ligs[pos] = n;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    
    public boolean contem(char c)
    {
        for(char aux : letras) if(aux == c) return true;
        return false;
    }
    
    public int buscaPos(char c)
    {
        int i = 0;
        while(i < TL && letras[i] < c) i++;
            
        return i;
    }
    
    public void insereVetor(int pos, char c)
    {
        for(int i = pos; i < TL -1; i++) //remaneja
        {
            letras[i + 1] = letras[i];
            ligs[i + 1] = ligs[i];
        }
        letras[pos] = c;
        TL++;
    }
    
    public void removeVetor(int pos)
    {
        for(int i = pos; i < TL - 1; i++) //remaneja
        {
            letras[i] = letras[i + 1];
            ligs[i] = ligs[i + 1];
        }
        TL--;
    }
}
