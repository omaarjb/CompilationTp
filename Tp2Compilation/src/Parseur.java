public class Parseur{
    private TokenManager tm;
    private char tc;

    public Parseur(TokenManager tm){
        this.tm=tm;
        avancer();
    }

    private void avancer(){
        tc=tm.suivant();
    }

    private void consommer(char att) {
        if (tc == att) {
            avancer();
        } else
            throw new RuntimeException("Token attendu : " + att + " Token trouvé : " + tc);
    }


    private void S(){
        if(tc=='b'){
            consommer('b');
            S();
            consommer('b');
        }else if(tc=='c'){
            consommer('c');
            A();
            consommer('c');
        }else{
            throw new RuntimeException(tc + " non attendu");
        }
    }
    private void A(){
        if(tc=='b'){
            A();
            A();
        }else if(tc=='c'){
            A();
            S();
            A();
            consommer('b');
        }else if(tc=='d'){
            consommer('d');
            consommer('c');
            consommer('b');
        }else{
            throw new RuntimeException(tc + " non attendu");
        }
    }



    public void parse(){
        S();
        if(tc!='#')
            throw new RuntimeException("Token non valide : " + tc);
    }
}