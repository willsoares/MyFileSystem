/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import operatingSystem.Kernel;

/**
 * Kernel desenvolvido pelo aluno. 
 * Outras classes criadas pelo aluno podem ser utilizadas, como por exemplo:
 * - Arvores;
 * - Filas;
 * - Pilhas;
 * - etc...
 * @author nome do aluno...
 */
public class MyKernel implements Kernel{
    
    
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

    public String cd(String parameters) {
        //variavel result deverah conter o que vai ser impresso na tela apos comando do usuário
        String result = "";
        String currentDir = "";
        System.out.println("Chamada de Sistema: cd");
        System.out.println("\tParametros: " + parameters);
        
        //inicio da implementacao do aluno
        
        
        //indique o diretório atual. Por exemplo... /
        currentDir = "/";
        
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
        String name = "Fulano da Silva";
        //numero de matricula
        String registration = "2001.xx.yy.00.11";
        //versao do sistema de arquivos
        String version = "0.1";
                
        result += "Nome do Aluno:        " + name;
        result += "\nMatricula do Aluno:   " + registration;
        result += "\nVersao do Kernel:     " + version;
                       
        return result;
    }

}
