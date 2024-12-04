public class ParseurG2 {
    private TokenManager tm;
    private char tc;

    public ParseurG2(TokenManager tm){
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
    if(tc=='d'){
        consommer('d');
        B();
        C();
    }else
        throw new RuntimeException(tc + " non attendu");
    }
    private void B(){
        if(tc=='d'){
            consommer('d');
            C();
        }else if(tc=='b'){
            consommer('b');
        }else
            throw new RuntimeException(tc + " non attendu");
    }

    private void C(){
        if(tc=='b'){
            consommer('b');
            B();
        }else if(tc=='c'){
            consommer('c');
        }else
            throw new RuntimeException(tc + " non attendu");
    }

    public void parse(){
        S();
        if(tc!='#')
            throw new RuntimeException("Token non valide : " + tc);
    }
}