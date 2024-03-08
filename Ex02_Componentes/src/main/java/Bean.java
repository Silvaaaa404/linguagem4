import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "ct")
@SessionScoped

public class Bean implements Serializable {
    
    private String cpNome;
    private String cpCurso;
    private String cpSexo;
    private String cpSenha;
    private Boolean cpInfo;
    
    public Bean() {
        limpar();
    }//builder
    
    public String btEx01(ActionEvent a){
        limpar();
        return "ex01";
    }
    
    public void btLimpar (ActionEvent a){
        limpar();
    }
    
    public String btCadastrar(ActionEvent a){
        cadastrar();
        return "ex01res";
    }
    
    public void cadastrar(){
        setCpNome(getCpNome()+"XXXXXXXXXX");
    }
    
    public void limpar() {
        setCpNome("");
        setCpCurso("");
        setCpSexo("");
        setCpSenha("");
        setCpInfo(false);
    }
    
    
    
    
    
    
    
    
    
    
    /////////////////////////////////////////////////GET SET

    public String getCpNome() {
        return cpNome;
    }

    public void setCpNome(String cpNome) {
        this.cpNome = cpNome;
    }

    public String getCpCurso() {
        return cpCurso;
    }

    public void setCpCurso(String cpCurso) {
        this.cpCurso = cpCurso;
    }

    public String getCpSexo() {
        return cpSexo;
    }

    public void setCpSexo(String cpSexo) {
        this.cpSexo = cpSexo;
    }

    public String getCpSenha() {
        return cpSenha;
    }

    public void setCpSenha(String cpSenha) {
        this.cpSenha = cpSenha;
    }

    public Boolean getCpInfo() {
        return cpInfo;
    }

    public void setCpInfo(Boolean cpInfo) {
        this.cpInfo = cpInfo;
    }
    
}//class
