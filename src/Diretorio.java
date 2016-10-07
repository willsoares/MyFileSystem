

/*
 * Copyright 2016 Willian Soares.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;

/**
 *
 * @author Willian Soares
 */
public class Diretorio {
    private String nome;
    private String path = "";
    private String isDir = "d";
    private String[] permissoes = {"rwx", "r-x", "--x"};//Permissao Padrão
    private String criacao;
    ArrayList <Arquivo> arquivos = new ArrayList<Arquivo>();
    ArrayList<Diretorio> subDirs = new ArrayList<Diretorio>();
    Diretorio pai;

    public Diretorio(){}
    
    public Diretorio(String nome, Diretorio pai, String path) {
        this.nome = nome;
        this.path = path+nome+"/";
        this.pai = pai;
        this.criacao = Sistema.getTime();
    }
    
    /**
     * Adiciona um arquivo para o ArrayList dos diretórios
     * @param nome nome do arquivo
     * @param conteudo conteudo do arquivo
     */
    public void adicionaArquivo(String nome, String conteudo){
        boolean exists = false;
        for(Arquivo a : this.arquivos){
            if(a.getNome().equals(nome))
                exists = true;
        }
        if(!exists){
            Arquivo arq = new Arquivo(nome);
            arq.setConteudo(conteudo);
            this.arquivos.add(arq);
        }
    }
    
    /**
     * Recupera um arquivo no ArrayList do diretório
     * @param nome do arquivo
     * @return arquivo
     */
    public Arquivo getArquivo(String nome){
        for(Arquivo a : arquivos){
            if(a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }
    
    /**
     * Define a nova permissao do diretório
     * @param permissao String com o código octal da nova permissao do diretório
     */
    public void setPermissao(String permissao){
        for (int i = 0; i < 3; i++) {
            switch (permissao.charAt(i)) {
                case '7':
                    this.permissoes[i] = "rwx";
                    break;
                case '6':
                    this.permissoes[i] = "rw-";
                    break;
                case '5':
                    this.permissoes[i] = "r-x";
                    break;
                case '4':
                    this.permissoes[i] = "r--";
                    break;
                case '3':
                    this.permissoes[i] = "-wx";
                    break;
                case '2':
                    this.permissoes[i] = "-w-";
                    break;
                case '1':
                    this.permissoes[i] = "--x";
                    break;
                default:
                    System.out.println("Permissao inválida");
            }
        }
    }
    
    /**
     * Retorna as permissões do diretório formatada para o terminal
     * @return Permissao do diretório formatada para o terminal
     */
    public String getPermissao(){
        return this.isDir + this.permissoes[0] + this.permissoes[1] + this.permissoes[2];
    }

    /**
     * Retorna a data de criação do diretorio
     * @return Retorna a data de criação do diretorio
     */
    public String getCriacao() {
        return this.criacao;
    }
    
    /**
     * Define o novo pai do diretorio
     * @param pai O novo diretório pai 
     */
    public void setPai(Diretorio pai) {
        this.pai = pai;
    }
    
    /**
     * Retorna o nome do diretório
     * @return nome do diretório
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Retorna o caminho do diretório
     * @return caminho do diretório
     */
    public String getPath() {
        return path;
    }
    
    
    
    
    
    
    
}
