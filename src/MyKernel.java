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
import operatingSystem.Kernel;

/**
 * Kernel desenvolvido pelo aluno. 
 * Outras classes criadas pelo aluno podem ser utilizadas, como por exemplo:
 * - Arvores;
 * - Filas;
 * - Pilhas;
 * - etc...
 * @author Willian Soares
 */
public class MyKernel implements Kernel{
    
    private String result;
    private String dump;
    Sistema s = new Sistema();
    
    private ArrayList<Diretorio> dirRecursao = new ArrayList<Diretorio>();
    private ArrayList<Arquivo> arqRecursao = new ArrayList<Arquivo>();
    
    
    public MyKernel(){
        s.d.setPai(s.d);
        s.raiz = s.d;
        cd(s.d.getNome());
    }
    
    public Diretorio percorreDir(Diretorio diretorio, String parameters){
        Diretorio salva = diretorio;
        String caminho[] = parameters.split("/");
        boolean exists = false;
        if(parameters.startsWith("/home/")){
            diretorio = s.raiz;
        }
        if(parameters.equals("/home") || parameters.equals("/home/") || parameters.equals("~")||parameters.equals("~/")){
            return s.raiz;
        }
        if(parameters.equals("")||parameters.equals(" ")){
            exists=true;
        }
        if (parameters.equals(".") || parameters.equals("./")) {
            exists = true;
        } else if (parameters.equals("..") || parameters.equals("../")) {
            exists = true;
            diretorio = diretorio.pai;
        } else {
            for (int i = 0; i < caminho.length; i++) {
                exists = false;
                if (caminho[i].equals(".")) {
                    exists = true;
                    continue;
                } else if (caminho[i].equals("..")) {
                    diretorio = diretorio.pai;
                    exists = true;
                    continue;
                } else {
                    for (int j = 0; j < diretorio.subDirs.size(); j++) {
                        if (caminho[i].equals("") || caminho[i].equals(" ")) {
                            
                            continue;
                        } else if (caminho[i].equals(diretorio.subDirs.get(j).getNome())) {
                            exists = true;
                            diretorio = diretorio.subDirs.get(j);
                            break;
                        }
                    }
                }
            }
        }
        if (exists) {
            return diretorio;
        } else {
            result = "Diretório não encontrado";
            return salva;
        }
    }

    public void recursao(Diretorio inicio){
        this.dirRecursao.add(inicio);
        for(int i = 0; i < inicio.subDirs.size(); i++){
            this.dirRecursao.add(inicio.subDirs.get(i));
        }
        for(int contador = 0; contador < dirRecursao.size(); contador++){
            for(int i = 0; i < this.dirRecursao.get(contador).subDirs.size();i++){
                this.dirRecursao.add(this.dirRecursao.get(contador).subDirs.get(i));
            }
        }
        for(int i = 0; i < inicio.arquivos.size();i++){
            this.arqRecursao.add(inicio.arquivos.get(i));
        }
        for(int contador = 0; contador < dirRecursao.size(); contador++){
            for(int i = 0; i < this.dirRecursao.get(contador).arquivos.size();i++){
                this.arqRecursao.add(this.dirRecursao.get(contador).arquivos.get(i));
            }
        }
        
    }
    
    public String ls(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: ls");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        String[] par = parameters.split(" ");
        String path;
        
        if(par.length == 2){
            if(parameters.startsWith("-l"))
              path = par[1];
            else
              path = par[0];
        
            s.d = percorreDir(s.d, path);
            if(!result.equals("Diretório não encontrado")){
                this.dump += "ls" + parameters + "\\n";
                for(int i = 0; i < s.d.subDirs.size(); i++)
                    result += s.d.subDirs.get(i).getPermissao() + " " + s.d.subDirs.get(i).getCriacao()+ " " + s.d.subDirs.get(i).getNome() + "\n";
                for (int i = 0; i < s.d.arquivos.size(); i++)
                    result += s.d.arquivos.get(i).getPermissao() + " " + s.d.arquivos.get(i).getCriacao() + " " + s.d.arquivos.get(i).getNome() + "\n";
            }
        }
        else{
            this.dump += "ls " + parameters + "\\n";
            if((parameters==null) || parameters.equals("") || parameters.startsWith(" ")) {
                //Diretório continua sendo o 
                for (int i = 0; i < s.d.subDirs.size(); i++)
                    result += s.d.subDirs.get(i).getNome() + "\n";
                for (int i = 0; i < s.d.arquivos.size(); i++)
                    result += s.d.arquivos.get(i).getNome() + "\n";
            }
            else if(parameters.equals("-l")){
                for (int i = 0; i < s.d.subDirs.size(); i++)
                    result += s.d.subDirs.get(i).getPermissao() + " " + s.d.subDirs.get(i).getCriacao()+ " " + s.d.subDirs.get(i).getNome() + "\n";
                for (int i = 0; i < s.d.arquivos.size(); i++)
                    result += s.d.arquivos.get(i).getPermissao() + " " + s.d.arquivos.get(i).getCriacao()+ " " + s.d.arquivos.get(i).getNome() + "\n";
            }
            else{
                s.d = percorreDir(s.d, parameters);
                for (int i = 0; i < s.d.subDirs.size(); i++)
                    result += s.d.subDirs.get(i).getNome() + "\n";
                for (int i = 0; i < s.d.arquivos.size(); i++)
                    result += s.d.arquivos.get(i).getNome() + "\n";
            }
        }
        //fim da implementacao do aluno
        
        return result;
    }

    public String mkdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mkdir");
        System.out.println("\tParametros: " + parameters);
             
        //inicio da implementacao do aluno
        String parametros[] = parameters.split(" ");
        boolean exists = false;
        String par[] = parameters.split("/");
        String nome = par[par.length - 1];
        
        if((parameters.equals("")) ||(parameters.equals(" ")) || (parameters == null)) 
            return "Informe um nome para o diretório!";

        for(Diretorio dir : s.d.subDirs){
            if(dir.getNome().equals(nome))
                return "Diretório ja existe!";
        }
        
        for (int i = 0; i < parametros.length; i++)
            s.criaDiretorio(parametros[i]);
        
        this.dump += "mkdir " + parameters + "\\n";
        //fim da implementacao do aluno
        
        return result;
    }

    public String cd(String parameters){
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        String currentDir = "";
        System.out.println("Chamada de Sistema: cd");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        Diretorio origem = s.d;
        s.d = percorreDir(s.d, parameters);
        if (s.d.getPermissao().startsWith("d") && !s.d.getPermissao().contains("x")) {
            result = "Diretório não pode ser acessado";
            s.d = origem;
        }
        this.dump += "cd " + parameters + "\\n";
        currentDir = s.d.getPath();
        operatingSystem.fileSystem.FileSytemSimulator.currentDir = currentDir;
        //fim da implementacao do aluno
        return result;
    }

    public String rmdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rmdir");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        this.dump += "rmdir " + parameters + "\\n";
        Diretorio tempDir = percorreDir(s.d, parameters);
        
        if((tempDir.subDirs.isEmpty()) && (tempDir.arquivos.isEmpty()))
            tempDir.pai.subDirs.remove(tempDir);//sobe um nível e apaga a pasta
        else
            result = "Diretório não vazio";

        //fim da implementacao do aluno
        return result;
    }

    public String cp(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cp");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        String par[] = parameters.split(" ");
        if((par[0].equals("-R"))){
            if((!par[1].contains(".txt")) && (!par[2].contains(".txt"))){ //é um diretorio
                Diretorio inicio = s.d;
                Diretorio origem = percorreDir(s.d, par[1]);
                s.d = percorreDir(s.d, par[2]);//par[2] tem o caminho de destino
                s.criaDiretorio(origem.getNome());
                s.d = percorreDir(s.d, s.d + "/" + origem.getNome());//vai até o destino + a pasta criada acima
                recursao(origem);
                s.d.subDirs = origem.subDirs;//copia os subdiretorios da pasta
                s.d.arquivos = origem.arquivos;//copia os arqs da pasta
                s.d = inicio;//volta à pasta original
                this.dump += "cp " + parameters + "\\n";
            }
            else return "Erro na recursão";
        }
        else {//nao tem recursao
            if((!par[0].contains(".txt")) && (!par[1].contains(".txt"))){//é um dir
                Diretorio inicio = s.d;
                Diretorio origem = percorreDir(s.d, par[0]);
                s.d = percorreDir(s.d,par[1]);
                s.criaDiretorio(origem.getNome());
                s.d = percorreDir(s.d, s.d + "/" + origem.getNome());
                for(Diretorio dir : origem.subDirs)
                    s.criaDiretorio(dir.getNome());
                s.d = inicio;
                this.dump += "cp " + parameters + "\\n";
            }else if((par[0].contains(".txt")) && (!par[1].contains(".txt"))){//arquivo e uma pasta
                String path[] = par[0].split("/");
                String caminho = "";
                for(int i = 0; i < path.length - 1; i++)//aquela gambi 10/10 manera dos arq
                    caminho += path[i] + "/";
                
                String arq = path[path.length - 1];//aquela gambi 10/10 manera dos arq
                
                Diretorio origem = percorreDir(s.d, caminho);
                Diretorio destino = percorreDir(s.d, par[1]);
                
                String nome = "";
                String conteudo = "";
                
                for(Arquivo a : origem.arquivos){
                    if(a.getNome().equals(arq)){
                        nome = a.getNome();
                        conteudo = a.getConteudo();
                    }
                }
                if(!arq.equals("")){
                    this.createfile(destino.getPath()+ nome + " " + conteudo);
                    this.dump += "cp " + parameters + "\\n";
                }
                else result = "Arquivo não encontrado!";
            }
            else result = "Impossível copiar um diretorio em um arquivo";  
        }
        //fim da implementacao do aluno
        
        return result;
    }

    public String mv(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mv");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        this.dump += "mv " + parameters + "\\n";

        String par[] = parameters.split(" ");
        if(par[0].contains(".txt")){//move um arquivo para...
            Diretorio inicio = s.d;
            
            String diretorioOrigem[] = par[0].split("/");//aquela gambi 10/10 dos arq
            String origem = "";
            for(int i = 0; i < diretorioOrigem.length - 1; i++)
                origem += diretorioOrigem[i] +  "/";

            String diretorioDestino[] = par[1].split("/");
            String destino = "";
            if(par[1].contains(".txt")){//se o segundo arg for um arq, faz aquela gambi
                for(int i = 0; i < diretorioDestino.length - 1; i++){
                    destino += diretorioDestino[i] + "/";
                }
            }
            else destino = par[1];

            if(origem.equals(destino)){//Só renomeia
                s.d = percorreDir(s.d, origem);
                for(Arquivo a : s.d.arquivos){
                    if(a.getNome().equals(diretorioOrigem[diretorioOrigem.length -1]))
                        a.setNome(diretorioDestino[diretorioDestino.length - 1]);
                }
                this.dump += "mv " + parameters + "\\n";
                s.d = inicio;
            }
            else{
                Diretorio dirOrigem = percorreDir(s.d,origem);
                Diretorio dirDestino = percorreDir(s.d,destino);
                String nomeOrigem = "";
                String conteudoOrigem = "";
                
                for(Arquivo a : dirOrigem.arquivos){
                    if(a.getNome().equals(diretorioOrigem[diretorioOrigem.length - 1])){
                        nomeOrigem = a.getNome();
                        System.out.println(nomeOrigem);
                        conteudoOrigem = a.getConteudo();
                        System.out.println(conteudoOrigem);
                        dirOrigem.arquivos.remove(a);
                        this.createfile(dirDestino.getPath()+ nomeOrigem + " " + conteudoOrigem);
                        break;
                    }                    
                }
                this.dump += "mv " + parameters + "\\n";
            }
            
            
        }
        else{
            if(par[1].contains(".txt")){
                return "Você não pode mover um diretório para um arquivo!";
            }
            else{
                
                Diretorio dirInicial = s.d;
                Diretorio dirOrigem = percorreDir(s.d,par[0]);             
                Diretorio dirPaiOrigem = percorreDir(s.d,dirOrigem.pai.getPath());
                s.d = percorreDir(s.d,par[1]);
                
                s.criaDiretorio(dirOrigem.getNome());
                for(Diretorio dir: s.d.subDirs){
                    if(dir.getNome().equals(dirOrigem.getNome())){
                        dir.subDirs = dirOrigem.subDirs;
                        dir.arquivos = dirOrigem.arquivos;
                    }
                }
                for(Diretorio dir : dirPaiOrigem.subDirs){
                    if(dir.getNome().equals(dirOrigem.getNome())){
                        dirPaiOrigem.subDirs.remove(dir);
                        break;
                    }
                }
                this.dump += "mv " + parameters + "\\n";
                s.d = dirInicial;
            }
        }
        //fim da implementacao do aluno
        
        return result;
    }

    public String rm(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rm");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        String[] pars = parameters.split(" ");
        this.dump += "rm " + parameters + "\\n";
        if(pars.length == 1){
            if(pars[0].contains(".txt")){//arquivo
                String[] caminho = pars[0].split("/");
                String arq = caminho[caminho.length-1];
                String c = "";
                for(int i = 0; i < caminho.length -1; i++){
                    c += caminho[i]+"/" ;
                }
                Diretorio tempDir = percorreDir(s.d, c);
                for(Arquivo a : tempDir.arquivos){
                    if(a.getNome().equals(arq)){
                        tempDir.arquivos.remove(a);
                    }
                }
            }else{
                Diretorio tempDir = percorreDir(s.d, parameters);
                tempDir.pai.subDirs.remove(tempDir);
            }
        }
        //fim da implementacao do aluno
        return result;
    }

    public String chmod(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: chmod");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        Diretorio temp;
        this.dump += "chmod " + parameters + "\\n";
        String[] pars = parameters.split(" ");
        
        if(pars[0].equals("-R")){
            temp = percorreDir(s.d, pars[2]);
            this.recursao(temp);
            for(Diretorio dir: this.dirRecursao){
                System.out.println("Permissões:" + pars[1]);
                dir.setPermissao(pars[1]);
            }
            for(Arquivo arq: this.arqRecursao)
                arq.setPermissao(pars[1]);
        }
        else{
            String caminho = pars[1];
            temp = percorreDir(s.d, caminho); //Retorna ao diretorio
            temp.setPermissao(pars[0]);
        }
        //fim da implementacao do aluno
        
        return result;
    }

    public String createfile(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: createfile");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        String par[] = parameters.split(" ");
        String caminhoSeparado[] = par[0].split("/");
        String caminho = "";
        String conteudo = "";
        int tamanho = caminhoSeparado.length;
        
        for(int i = 0; i < tamanho - 1; i++)
            caminho += caminhoSeparado[i] + "/";
        
        for(int i = 1; i < par.length; i++)
            conteudo += par[i] + " ";

        Diretorio temp = percorreDir(s.d, caminho);
        boolean exists = false;
        for(Arquivo arq : temp.arquivos){
            if(arq.getNome().equals(caminhoSeparado[tamanho-1]))
                exists = true;
        }
        if(!exists){
            temp.adicionaArquivo(caminhoSeparado[tamanho - 1], conteudo);
            this.dump += "createfile " + parameters + "\n";
        }
        else result = "Arquivo já existe!";
        //fim da implementacao do aluno
        
        return result;
    }
    
    public String cat(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cat");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        String par[] = parameters.split("/");
        String caminho = "";
        String arquivo = "";
        
        for(int i = 0; i < par.length - 1; i++)//gambi dos arq
            caminho += par[i] + "/";
        arquivo = par[par.length - 1];
        Diretorio temp = percorreDir(s.d, caminho);//volta pro temp dps
        if(temp.getArquivo(arquivo) != null){
            this.dump += "cat " + parameters + "\\n";
            result = temp.getArquivo(arquivo).getConteudo();
        }
        else result = "Arquivo não existe!";
        //fim da implementacao do aluno
        
        return result;
    }    
    
    public String batch(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: batch");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        String conteudo = cat(parameters);
        this.dump += "batch " + parameters + "\\n";
        result = conteudo;
        //olhar mudanças no FILESIM
        //fim da implementacao do aluno
        
        return result;
    }

    public String info() {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: info");
        System.out.println("\tParametros: sem parametros" );
        
        //nome do aluno
        String name = "Willian de Souza Soares";
        //numero de matricula
        String registration = "2014.1.08.034";
        //versao do sistema de arquivos
        String version = "0.1";
                
        result += "Nome do Aluno:        " + name;
        result += "\nMatricula do Aluno:   " + registration;
        result += "\nVersao do Kernel:     " + version;
                       
        return result;
    }
    
    public String exit(){
        System.exit(0);
        return "bye";
    }

    public String dump(String parameters) {
        String result = "";
        System.out.println("Chamada de Sistema: dump");
        System.out.println("\tParametros: " + parameters);
        
        parameters += " ".concat(dump);
        createfile(parameters);
        result = "Dump criado com sucesso";
        return result;
    }

}
