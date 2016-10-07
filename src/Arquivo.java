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

/**
 *
 * @author Willian Soares
 */
public class Arquivo {
    private String nome;
    private String conteudo;
    private String criacao;
    private String isArq = "-";
    private String[] permissao = {"rwx","rwx","rwx"};
    
    public Arquivo(String nome){
        this.nome = nome;
        this.criacao = Sistema.getTime();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCriacao() {
        return criacao;
    }

    public String getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
    
    public String getPermissao(){
        return this.isArq + this.permissao[0] + this.permissao[1] + this.permissao[2];
    }
    
    public void setPermissao(String permissao){
        for (int i = 0; i < 3; i++) {
            switch (permissao.charAt(i)) {
                case '7':
                    this.permissao[i] = "rwx";
                    break;
                case '6':
                    this.permissao[i] = "rw-";
                    break;
                case '5':
                    this.permissao[i] = "r-x";
                    break;
                case '4':
                    this.permissao[i] = "r--";
                    break;
                case '3':
                    this.permissao[i] = "-wx";
                    break;
                case '2':
                    this.permissao[i] = "-w-";
                    break;
                case '1':
                    this.permissao[i] = "--x";
                    break;
                default:
                    System.out.println("Permissao inválida");
            }
        }
    }
}
