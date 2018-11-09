package sample;

public class Shiphr {

    private String cde = "";
    private String dcde = "";

    public String code(String string){
        String code_res = "", ch = "", nch = "";
        int tmp = 0;

        for (int i = 0; i < string.length(); i++) {
            tmp = i + 1;
            if((tmp%2) == 0){
                ch += string.charAt(i);
            }
            else {
                nch += string.charAt(i);
            }
        }
        code_res = nch + ch;
        cde = code_res;
        return cde;
    }

    public String decode(String string){

        String code_res = "", ch = "", nch = "";
        int tmp = 0;
        int fl = string.length()/2;
        boolean flag = false;

        if((string.length()%2) != 0) { flag = true; fl++; }

        for (int i = 0; i <= string.length()/2-1; i++) {
            tmp = i + 1;
            code_res += string.charAt(i);
            code_res += string.charAt(i+fl);

        }
        if(flag == true) { code_res += string.charAt(string.length()/2); }
        dcde = code_res;
        return dcde;
    }

}
