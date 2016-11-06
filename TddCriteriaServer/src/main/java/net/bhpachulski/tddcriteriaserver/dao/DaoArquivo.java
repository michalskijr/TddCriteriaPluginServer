package net.bhpachulski.tddcriteriaserver.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import net.mjunior.model.ModCadArquivo;

/**
 *
 * @author mjunior
 */
public class DaoArquivo {
    
    private final DaoGeneric<ModCadArquivo> daoArquivo;
    private final ModCadArquivo modArquivo = new ModCadArquivo();

    public DaoArquivo() throws SQLException {
        this.daoArquivo = new DaoGeneric<>();
    }
    
    public boolean salvarArquivo(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            int offset = 0;
            int numRead = 0;
            
            while (offset < bytes.length 
                    && (numRead = inputStream.read(bytes, offset, 
                            bytes.length-offset)) >= 0) {                
                offset += numRead;
            }
            
            modArquivo.setNomeArquivo(file.getName());
            modArquivo.setArquivoXML(bytes);
            
            daoArquivo.salvar(modArquivo);
            
            return true;
        } catch (Exception ex) {

        }

        return false;
    }
}
