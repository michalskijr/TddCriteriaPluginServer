package net.bhpachulski.tddcriteriaserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.bhpachulski.tddcriteria.model.Eclemma.Classs;
import net.bhpachulski.tddcriteria.model.Eclemma.Counter;
import net.bhpachulski.tddcriteria.model.Eclemma.Methodd;
import net.bhpachulski.tddcriteria.model.Eclemma.Report;
import net.bhpachulski.tddcriteriaserver.dao.DaoAluno;
import net.bhpachulski.tddcriteriaserver.dao.DaoFile;
import net.bhpachulski.tddcriteriaserver.dao.DaoGeneric;
import net.mjunior.model.ModCadAluno;
import net.mjunior.model.ModCadSituacao;
import net.mjunior.model.SaveFile;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/tddCriteriaService")
public class TDDCriteriaService {
    
    private DaoGeneric dao;

    public TDDCriteriaService() throws SQLException {
        dao = new DaoGeneric();
        dao.init();
    }
    
//    @POST
//    @Path("/addStudent")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Student insertAluno(Student student) throws SQLException {
//        return dao.insertOrGetExistingStudent(student);
//    }
    
    @POST
    @Path("/addArquivo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String addArquivo(
            @FormDataParam("idAluno") int idAluno,
            @FormDataParam("idTipoArquivo") int idTipoArquivo,
            @FormDataParam("nomeProjeto") String nomeProjeto,
            @FormDataParam("nomeArquivo") String nomeArquivo,
            @FormDataParam("arquivo") File arquivoXml,
            @FormDataParam("dsEstagioTdd") String dsEstagioTdd) throws SQLException {

        SaveFile saveFile = new SaveFile();
        
        saveFile.setIdAlunoFile(idAluno);
        saveFile.setIdTipoArquivoFile(idTipoArquivo);
        saveFile.setNomeProjetoFile(nomeProjeto);
        saveFile.setNomeArquivoFile(nomeArquivo);
        saveFile.setArquivoFile(arquivoXml);
        saveFile.setEstagioTddFile(dsEstagioTdd);
        saveFile.setRealizadoLeitura(false);
        
        dao.salvar(saveFile);
        
        return nomeArquivo;
    }
    
    @GET
    @Path("/modelarDados")
    @Produces(MediaType.APPLICATION_JSON)
    public String modelarDados() throws SQLException {
        DaoFile daoFile = new DaoFile();
        DaoAluno daoAluno = new DaoAluno();
        
        ModCadAluno modAluno;
        
        List<SaveFile> files = daoFile.findAllUnread();
        
        for(SaveFile sf : files) {
            dao = new DaoGeneric();
            modAluno = new ModCadAluno();
            modAluno.setIdAluno(sf.getIdAlunoFile());
            modAluno.setSituacao(ModCadSituacao.ATIVO);
            
            System.out.println("Arquivo " + sf.getNomeArquivoFile());
            
            daoAluno.inserirAluno(modAluno);
            
            sf.setRealizadoLeitura(true);
            dao.update(sf);
        }
        
        return "Ok";
    }
    
    @GET
    @Path("/allFiles")
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllFiles () throws SQLException, ParseException {
        //ModCadAluno aluno = new ModCadAluno();
        
        return dao.consultaGeral(new SaveFile());
    }
    
    @GET
    @Path("/allFilesId")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFilesId () throws SQLException, ParseException {
        dao = new DaoGeneric();
        SaveFile saveFile;
        saveFile = (SaveFile) dao.consultaPorId(new SaveFile(), 1);
        
        return saveFile.getNomeArquivoFile();
    }
    
    @GET
    @Path("/teste")
    @Produces(MediaType.APPLICATION_JSON)
    public String teste() {
        return "Teste OK";
    }
    
    @GET
    @Path("/arquivo")
    @Produces(MediaType.APPLICATION_JSON)
    public String listArquivo() throws SQLException, FileNotFoundException {
        List<SaveFile> arquivo = dao.consultaGeral(new SaveFile());
        File file;
        
        for (SaveFile saveFile : arquivo) {
            try {
                byte[] bytes = saveFile.getArquivoXmlFile();
                String nome = saveFile.getNomeArquivoFile();

                file = new File("D:/test/" + nome);
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(bytes);
                }
            } catch (Exception e) {
            }
        }
        return "Arquivos salvos";
    }
    
    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String byteForString() throws SQLException, FileNotFoundException {
        String string;
        List<SaveFile> arquivo = dao.consultaGeral(new SaveFile()); //recupera os arquivos do banco de dados

        for (SaveFile saveFile : arquivo) {
            try {
                byte[] bytes = saveFile.getArquivoXmlFile();
                string = new String(bytes, "UTF-8"); //passa os xmls para string
                
                JacksonXmlModule module = new JacksonXmlModule();
                module.setDefaultUseWrapper(false);
                ObjectMapper xmlMapper = new XmlMapper(module);
                Report value = xmlMapper.readValue(string, Report.class); //passar string do xml para objeto
                
            } catch (Exception e) {
                System.out.println("Erro!!!" + e);
            }
        }
        return "Finalizado!!!";
    }
}