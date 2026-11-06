public class ADO3{
    //1. Monte as funções recursivas e iterativas dos exemplos 3 e 4;
    public static int potenInterativo(int base, int exp)
    {
        int res = base;
        int i = 1;
        while(i < exp)
        {
            res *= base;
            i++;
        }
        return  res;
    }

    public static int potenRecursivo(int base, int exp)
    {
        int res = 1;
        if(exp == 0)
        {
            return res;
        }
        res = base * potenRecursivo(base, exp - 1);
        return res;
    }
    public static int somaInterativo(int x, int y)
    {
        int res = x;
        for(int i = x; i < y; i++)
        {
            res += i + 1;
        }
        return  res;
    }

    public static int somaRecursivo(int x, int y)
    {
        int res = 0;
        if (x == y)
        {
            return x;
        }
        res = x + somaRecursivo(x + 1, y);
        return res;
    }
    //===============================================================
    //2. Função recursiva para somar uma lista de números reais entre x e y
    public static double somaInterativoDouble(int x, int y)
    {
        double res = x;
        for(int i = x; i < y; i++)
        {
            res += i + 1;
        }
        return  res;
    }

    public static double somaRecursivoDouble(int x, int y)
    {
        double res = 0;
        if (x == y)
        {
            return x;
        }
        res = x + somaRecursivo(x + 1, y);
        return res;
    }
    //2. Função recursiva para somar uma lista de números reais entre x e y

    //=======================================================
    //3. Função recursiva para retornar o fatorial duplo de um número
    public static int fatorDuplo(int n)
    {
        int res = 0;
        if (n == 1 || n == 0) 
        {
            return 1;   
        }
        res = n * fatorDuplo(n - 2);
        return res;
    }
    //========================================================
    //4. Processo recursivo para gerar a série de Fibonacci até um Limite dado.
    public static int Fibonacci(int n, int proximo, int limit)
    {
        int res = n + proximo;
        if (res > limit)
        {
            return n;
        }
        res = Fibonacci(proximo, res, limit);
        return res;
    }


    public static void main(String[] args)
    {
        int base = 2;
        int exp = 4;
        System.out.println(potenInterativo( base,  exp));
        System.out.println(potenRecursivo( base,  exp));

        int x = 3;
        int y = 6;
        System.out.println(somaInterativo(x,  y));
        System.out.println(somaRecursivo (x, y));

        int fatorduplo = 5;
        System.out.println(fatorDuplo(fatorduplo));
        
    }
}