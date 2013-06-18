public class GeradorDeNumerosAleatoriosParaLoteria {
    private static final int t_megasena = 0;
    private static final int t_timemania = 1;
    private static final int t_lotofacil = 2; 
    private static final int t_quina = 3; 
    private static final int t_lotomania = 4; 
    private static final int t_duplasena = 5; 
    private String numeros;
    private int quantidade;
    private double amostra;
    private double a = 3741260.0D;
    private double m = 493062245581.0D;
    private double x;
    private int n = 0;
    private int rand;
    private int i;
    private int j;
    int[] nAleatorio;
    int acrecimo;

    public int[] getNumerosAleatorios(int quantidade, int TipoJogo, int quantidadeNumerosJogo) {
        nAleatorio = new int[quantidade];
        n = 0;
        System.out.println("teste quantidade = " + quantidade);
        System.out.println("teste TipoJogo = " + TipoJogo);
        System.out.println("teste quantidadNumeroJogo = " + quantidadeNumerosJogo);
        x = System.currentTimeMillis();
        //
        if(TipoJogo==4)
            acrecimo = 0;
        else
            acrecimo = 1;
        System.out.println("teste acrecimo = " + acrecimo);
        while (n < quantidade) {
            x = (a * x % m);
            amostra = (x / m);
            rand = (int) (amostra * quantidadeNumerosJogo + acrecimo);
            nAleatorio[n] = rand;
            n += 1;
        }
        System.out.println();
        for (i = 0; i < quantidade; i += 1) {
            for (j = 0; j < quantidade; j += 1) {
                if ((nAleatorio[i] == nAleatorio[j]) && (i != j)){
                do {
                    x = (a * x % m);
                    amostra = (x / m);
                    rand = (int) (amostra * quantidadeNumerosJogo + 1.0D);
                    nAleatorio[i] = rand;
                } while (rand == nAleatorio[j]);
                i = 0;
                j = 0;
               }
            }
        }
        int k=0, m=0, temp = 0;
        for (k = 0; k < quantidade; k++) {
            temp = nAleatorio[k];
            m = k - 1;
            while ((m >= 0) && (nAleatorio[m] > temp)) {
                nAleatorio[m + 1] = nAleatorio[m];
                nAleatorio[m] = temp;
                m = m - 1;
            }
        }
        
        return nAleatorio;
    }
}
