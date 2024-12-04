public class Main {
    public static void main(String[] args) {
        String ch1="cdcbc";
        String ch2="bcdcbcb";
        String ch3="cbdcbdcbc";

        TokenManager tm=new TokenManager(ch1);
        Parseur parseur=new Parseur(tm);

        try{
            parseur.parse();
            System.out.println(ch1 + " est valide");
        }catch(RuntimeException ex){
            System.out.println(ch1 + " n'est pas valide");
            System.out.println(ex.getMessage());
        }
    }
}