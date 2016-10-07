
import java.util.Date;

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
 * @author wills
 */
public class Sistema {
    Diretorio d = new Diretorio("home", null, "");
    Diretorio raiz = d;
    
    /**
     * Verifica se já existe um diretório com o nome passado e cria um diretório
     * @param nome diretório a ser criado
     */
    public void criaDiretorio(String nome){
        boolean exists = false;
        for(Diretorio dir: d.subDirs){
            if(dir.getNome().equals(nome))
                exists = true;
        }
        if(!exists){
            d.subDirs.add(new Diretorio(nome, d, d.getPath()));
        }
    }
    
    /**
     * Retorna data e hora do sistema formatados para atributos de diretorios e arquivos
     * @return Data e hora do sistema formatados para atributos de diretorios e arquivos
     */
    public static String getTime(){
        Date date = new Date();
        String stringData[] = date.toString().split(" ");
        String resultado = stringData[2].toString() +" "+ stringData[1].toString() +" "+ stringData[5].toString();
        return resultado;
        
    }
}
