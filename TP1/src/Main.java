public class Main {
    public static void main(String[] args) {
        String ch="dbc";
        TokenManager tm=new TokenManager(ch);
        ParseurG2 parseur=new ParseurG2(tm);

        try{
            parseur.parse();
            System.out.println(ch + " est valide");
        }catch(RuntimeException ex){
            System.out.println(ch + " n'est pas valide");
            System.out.println(ex.getMessage());
        }
    }
}