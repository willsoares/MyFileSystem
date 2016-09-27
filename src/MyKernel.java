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

import java.io.File;
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
    
    private File dir;
    public MyKernel(){

    }
    

    public String ls(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: ls");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String mkdir(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mkdir");
        System.out.println("\tParametros: " + parameters);
             
        //inicio da implementacao do aluno
        
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
        String path = parameters;
        
        currentDir = "/";
        
        if(!path.isEmpty()){
            dir = new File(currentDir + path);
            if (dir.isDirectory()){
                currentDir = currentDir.concat(path);
            }
            else{
                result = "Not a directory";
            }
        }
        //setando parte gráfica do diretorio atual
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
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String cp(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cp");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String mv(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: mv");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String rm(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: rm");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String chmod(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: chmod");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }

    public String createfile(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: createfile");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }
    
    public String cat(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: cat");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        //fim da implementacao do aluno
        
        return result;
    }    
    
    public String batch(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        System.out.println("Chamada de Sistema: batch");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
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

}
