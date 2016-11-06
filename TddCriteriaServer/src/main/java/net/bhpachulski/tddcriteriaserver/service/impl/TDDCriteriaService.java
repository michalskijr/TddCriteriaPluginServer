package net.bhpachulski.tddcriteriaserver.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.bhpachulski.tddcriteriaserver.dao.DaoArquivo;
import net.bhpachulski.tddcriteriaserver.dao.DaoGeneric;
import net.bhpachulski.tddcriteriaserver.util.HibernateUtil;
import net.mjunior.model.ModCadAluno;
import net.mjunior.model.ModCadArquivo;
import net.mjunior.model.ModCadSemestre;
import net.mjunior.model.SaveFile;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.SessionFactory;

/**
 *
 * @author bhpachulski
 */
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
        
        dao.salvar(saveFile);
        
//        StudentFile sf = new StudentFile();
//        sf.setStudentId(idAluno);
//        sf.setFileIs(arquivoXml);
//        sf.setType(FileType.getFileType(idTipoArquivo));
//        sf.setFileName(nomeArquivo);
//        sf.setProjectName(nomeProjeto);
//        sf.setStage(TDDStage.getStageByString(dsEstagioTdd));
        
        return nomeArquivo;
    }
    
    @GET
    @Path("/allFiles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModCadAluno> getAllFiles () throws SQLException, ParseException {
        ModCadAluno aluno = new ModCadAluno();
        
        return dao.consultaGeral(aluno);
    }
    
    @GET
    @Path("/hibernate")
    @Produces(MediaType.APPLICATION_JSON)
    public String startHibernate () {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        return "Criação do Banco de Dados concluído!!!";
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
        File file = null;
        
        for (SaveFile saveFile : arquivo) {
            try {
                byte[] bytes = saveFile.getArquivoXmlFile();
                String nome = saveFile.getNomeArquivoFile();

                file = new File("D:/test/" + nome);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(bytes);
                fos.close();
                
                return nome;
            } catch (Exception e) {
            }
        }
        return "Erro";
    }
    
    @GET
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModCadSemestre> insert() throws SQLException {
        
        ModCadSemestre semestre = new ModCadSemestre();
        //DaoGeneric daoSemestre = new DaoGeneric();
        
        semestre.setDescSemestre("1º Semestre");
        
        dao.salvar(semestre);
        
        return dao.consultaGeral(semestre);
    }
}