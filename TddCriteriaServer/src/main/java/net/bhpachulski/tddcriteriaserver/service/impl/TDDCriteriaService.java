package net.bhpachulski.tddcriteriaserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import net.bhpachulski.tddcriteria.model.junit.TestCase;
import net.bhpachulski.tddcriteria.model.junit.TestSuiteSession;
import net.bhpachulski.tddcriteriaserver.dao.DaoAluno;
import net.bhpachulski.tddcriteriaserver.dao.DaoArquivo;
import net.bhpachulski.tddcriteriaserver.dao.DaoClasse;
import net.bhpachulski.tddcriteriaserver.dao.DaoClasseCounter;
import net.bhpachulski.tddcriteriaserver.dao.DaoExecProjeto;
import net.bhpachulski.tddcriteriaserver.dao.DaoFile;
import net.bhpachulski.tddcriteriaserver.dao.DaoGeneric;
import net.bhpachulski.tddcriteriaserver.dao.DaoMetodo;
import net.bhpachulski.tddcriteriaserver.dao.DaoMetodoCounter;
import net.bhpachulski.tddcriteriaserver.dao.DaoProjeto;
import net.bhpachulski.tddcriteriaserver.dao.DaoTestCases;
import net.mjunior.model.ModCadAluno;
import net.mjunior.model.ModCadArquivo;
import net.mjunior.model.ModCadClasse;
import net.mjunior.model.ModCadClasseCounter;
import net.mjunior.model.ModCadEstagioTdd;
import net.mjunior.model.ModCadExecProjeto;
import net.mjunior.model.ModCadMetodo;
import net.mjunior.model.ModCadMetodoCounter;
import net.mjunior.model.ModCadProjeto;
import net.mjunior.model.ModCadSituacao;
import net.mjunior.model.ModCadTestCases;
import net.mjunior.model.ModCadTipoArquivo;
import net.mjunior.model.ModCadTipoClasse;
import net.mjunior.model.ModCadTypeCounter;
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
        DaoAluno daoAluno;
        DaoProjeto daoProjeto;
        DaoExecProjeto daoExecProjeto;
        DaoMetodo daoMetodo;
        DaoTestCases daoTestCases;
                
        ModCadAluno modAluno;
        ModCadProjeto modProjeto;
        ModCadExecProjeto modExecProjeto;
        ModCadClasse modClasse;
        ModCadMetodo modMetodo;
        ModCadTestCases modTestCases;
        
        List<SaveFile> files = daoFile.findAllUnread();
        for(SaveFile sf : files) {
            dao = new DaoGeneric();
            daoAluno = new DaoAluno();
            daoProjeto = new DaoProjeto();
            daoExecProjeto = new DaoExecProjeto();
            
            //Aluno
            modAluno = new ModCadAluno();
            modAluno.setIdAluno(sf.getIdAlunoFile());
            modAluno.setSituacao(ModCadSituacao.ATIVO);
            //ao salvar verifica se já existe no banco
            daoAluno.inserirAluno(modAluno);
            
            //Projeto
            modProjeto = new ModCadProjeto();
            modProjeto.setNomeProjeto(sf.getNomeProjetoFile());
            modProjeto.setSituacao(ModCadSituacao.ATIVO);
            modProjeto.setAluno(modAluno);
            //ao salvar verifica se já existe no banco
            daoProjeto.salvarProjeto(modProjeto);
            
            //ExecuçãoProjeto
            //Arquivo
            modExecProjeto = new ModCadExecProjeto();
            switch (sf.getIdTipoArquivoFile()) {
                case 0: //Coverage
                    if(daoExecProjeto.verificarExecDataHoraExata(modProjeto,
                            stringForDate(sf.getNomeArquivoFile())) == null){

                        modExecProjeto = setExecProjeto(modProjeto, sf);
                        setArquivo(modExecProjeto, sf, 0);
                        
                        setCoverage(sf, modProjeto, modExecProjeto);
                        
                        sf.setRealizadoLeitura(true);
                        dao.update(sf);
                    }
                    break;
                case 1: //Junit
                    modExecProjeto = daoExecProjeto.verificarExecDataHoraExata(
                            modProjeto, stringForDate(sf.getNomeArquivoFile()));
                    if(modExecProjeto == null) {
                        modExecProjeto = daoExecProjeto.verificarExecDataHoraProximo(
                                stringForDate(sf.getNomeArquivoFile()), modProjeto);
                    }

                    if(modExecProjeto != null) {
                        setArquivo(modExecProjeto, sf, 1);
                        TestSuiteSession junit = new TestSuiteSession();
                        //passa o xml do Junit para o modelo
                        try {
                            junit = xmlMapperJunit(sf);
                            
                            for(TestCase t : junit.getTestCases()) {
                                DaoGeneric<ModCadClasse> genericClasse = new DaoGeneric<>();
                                modClasse = new ModCadClasse();
                                modClasse = genericClasse.consultaDoisParametros(new ModCadClasse(), 
                                        "projeto.idProjeto", modExecProjeto.getProjeto().getIdProjeto(),
                                        "dsClasse", t.getClassName());
                                
                                if(modClasse != null) {
                                    DaoGeneric<ModCadMetodo> genericMetodo = new DaoGeneric<>();
                                    modMetodo = new ModCadMetodo();
                                    modMetodo = genericMetodo.consultaTresParametros(new ModCadMetodo(), 
                                            "execProjeto.idExecucaoProjeto", modExecProjeto.getIdExecucaoProjeto(),
                                            "classe.idClasse", modClasse.getIdClasse(),
                                            "dsMetodo", t.getMethodName());
                                    
                                    if(modMetodo != null) {
                                        daoTestCases = new DaoTestCases();
                                        modTestCases = new ModCadTestCases();
                                        modTestCases.setFailed(t.isFailed());
                                        daoTestCases.salvar(modTestCases);
                                        
                                        modMetodo.setTestCases(modTestCases);
                                        daoMetodo = new DaoMetodo();
                                        daoMetodo.update(modMetodo);
                                    }
                                }
                            }
                        } catch (SQLException | IOException e) {
                            System.out.println("Erro exportação Junit!!! " + e);
                        }
                        sf.setRealizadoLeitura(true);
                        dao.update(sf);
                    }
                    break;
                case 2: //Source
                    modExecProjeto = daoExecProjeto.verificarExecDataHoraExata(
                            modProjeto, stringForDate(sf.getNomeArquivoFile()));
                    if(modExecProjeto == null) {
                        modExecProjeto = daoExecProjeto.verificarExecDataHoraProximo(
                                stringForDate(sf.getNomeArquivoFile()), modProjeto);
                    }

                    if(modExecProjeto != null) {
                        setArquivo(modExecProjeto, sf, 2);
                    
                        sf.setRealizadoLeitura(true);
                        dao.update(sf);
                    }
                    break;
                default:
                    System.out.println("Tipo de arquivo inválido!!!");
                    break;
            }
        }
        return "Ok";
    }
    
    public ModCadExecProjeto setExecProjeto(ModCadProjeto modProjeto, SaveFile sf) throws SQLException {
        ModCadExecProjeto modExecProjeto = new ModCadExecProjeto();
        DaoExecProjeto daoExecProjeto = new DaoExecProjeto();
        
        modExecProjeto.setProjeto(modProjeto);
        if(sf.getEstagioTddFile().equalsIgnoreCase("REFACTOR"))
            modExecProjeto.setEstagioTdd(ModCadEstagioTdd.REFACTOR);
        else if(sf.getEstagioTddFile().equalsIgnoreCase("GREEN"))
            modExecProjeto.setEstagioTdd(ModCadEstagioTdd.GREEN);
        else
            modExecProjeto.setEstagioTdd(ModCadEstagioTdd.RED);
            
        modExecProjeto.setDataHora(stringForDate(sf.getNomeArquivoFile()));
        daoExecProjeto.salvarExecProjeto(modExecProjeto);
        
        return modExecProjeto;
    }
    
    public void setArquivo(ModCadExecProjeto modExecProjeto, SaveFile sf, int tipo) throws SQLException {
        ModCadArquivo modArquivo = new ModCadArquivo();
        DaoArquivo daoArquivo = new DaoArquivo();
        
        modArquivo.setExecucaoProjeto(modExecProjeto);
        switch(tipo) {
            case 0:
                modArquivo.setTipoArquivo(ModCadTipoArquivo.COVERAGE);
                break;
            case 1:
                modArquivo.setTipoArquivo(ModCadTipoArquivo.JUNIT);
                break;
            case 2:
                modArquivo.setTipoArquivo(ModCadTipoArquivo.SOURCE);
                break;
        }
        modArquivo.setNomeArquivo(sf.getNomeArquivoFile());
        modArquivo.setArquivoXML(sf.getArquivoXmlFile());
        daoArquivo.salvarArquivo(modArquivo);
    }
    
    public void setCoverage(SaveFile sf, ModCadProjeto modProjeto, ModCadExecProjeto modExecProjeto) {
        Report report = new Report();
        
        DaoClasse daoClasse;
        DaoClasseCounter daoClasseCounter;
        DaoMetodo daoMetodo;
        DaoMetodoCounter daoMetodoCounter;
        
        ModCadClasse modClasse;
        ModCadClasseCounter modClasseCounter;
        ModCadMetodo modMetodo;
        ModCadMetodoCounter modMetodoCounter;
        
        try {
            //passa o xml para o modelo Eclemma
            report = xmlMapper(sf); 
                
            //Classe
            for(Classs c : report.getGroup().getGroup().getPack().getClasss()) {
                daoClasse = new DaoClasse();
                modClasse = new ModCadClasse();
                DaoGeneric<ModCadClasse> daoGenClasse = new DaoGeneric<>();
                modClasse = daoGenClasse.consultaDoisParametros(modClasse,
                    "projeto.idProjeto", modProjeto.getIdProjeto(),
                    "dsClasse", c.getName());

                if(modClasse == null) {
                    modClasse = new ModCadClasse();
                    modClasse.setProjeto(modProjeto);
                    if(c.getName().contains("est")) {
                        modClasse.setTipoClasse(ModCadTipoClasse.TESTE);
                    } else {
                        modClasse.setTipoClasse(ModCadTipoClasse.IMPLEMENTACAO);
                    }
                    modClasse.setDsClasse(c.getName());
                    daoClasse.salvarClasse(modClasse);
                }
                    
                //ClasseExecucaoProjeto
//                daoClasseExecProjeto = new DaoClasseExecProjeto();
//                modClasseExecProjeto = new ModCadClasseExecProjeto();
//                modClasseExecProjeto.setExecucaoProjeto(modExecProjeto);
//                modClasseExecProjeto.setClasse(modClasse);
//                daoClasseExecProjeto.salvar(modClasseExecProjeto);
                    
                //ClasseCounter
                for(Counter counter : c.getCounter()) {
                    daoClasseCounter = new DaoClasseCounter();
                    modClasseCounter = new ModCadClasseCounter();
                    modClasseCounter.setClasse(modClasse);
                    switch(counter.getType().name()) {
                        case "INSTRUCTION":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.INSTRUCTION);
                            break;
                        case "LINE":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.LINE);
                            break;
                        case "COMPLEXITY":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.COMPLEXITY);
                            break;
                        case "METHOD":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.METHOD);
                            break;
                        case "CLASS":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.CLASS);
                            break;
                        case "BRANCH":
                            modClasseCounter.setTypeCounter(ModCadTypeCounter.BRANCH);
                            break;
                    }
                    modClasseCounter.setExecucaoProjeto(modExecProjeto);
                    modClasseCounter.setMissed(counter.getMissed());
                    modClasseCounter.setCovered(counter.getCovered());
                    daoClasseCounter.salvar(modClasseCounter);
                }
                    
                //Metodo
                for(Methodd m : c.getMethodd()) {
                    daoMetodo = new DaoMetodo();
                    modMetodo = new ModCadMetodo();
                    modMetodo.setExecProjeto(modExecProjeto);
                    modMetodo.setClasse(modClasse);
                    modMetodo.setDsMetodo(m.getName());
                    daoMetodo.salvarMetodo(modMetodo);
                        
                    //MetodoCounter
                    for(Counter mCounter : m.getCounter()) {
                        daoMetodoCounter = new DaoMetodoCounter();
                        modMetodoCounter = new ModCadMetodoCounter();
                        modMetodoCounter.setMetodo(modMetodo);
                        modMetodoCounter.setTypeCounter(ModCadTypeCounter.valueOf(mCounter.getType().name()));
                        modMetodoCounter.setExecucaoProjeto(modExecProjeto);
                        modMetodoCounter.setMissed(mCounter.getMissed());
                        modMetodoCounter.setCovered(mCounter.getCovered());
                        daoMetodoCounter.salvar(modMetodoCounter);
                    }
                }
            }
                
        } catch (SQLException | IOException e) {
            System.out.println("Erro exportação eclemma!!!" + e);
        }
    }
    
    public Date stringForDate(String data) {
        data = data.replace(".xml", "");
        char chars[] = data.toCharArray();
        chars[4] = '/';
        chars[7] = '/';
        chars[10] = ' ';
        chars[13] = ':';
        chars[16] = ':';
        data = new String(chars);
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date newData = new Date();
            
        try {
            newData = sdf.parse(data);
        } catch (Exception e) {
            System.out.println("Erro Data!!! " + e);
        }
        
        return newData;
    }

    public Report xmlMapper(SaveFile saveFile) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        byte[] bytes = saveFile.getArquivoXmlFile();
        String string = new String(bytes, "UTF-8"); //passa os xmls para string
              
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        ObjectMapper xmlMapper = new XmlMapper(module);
        Report value = xmlMapper.readValue(string, Report.class); //passar string do xml para objeto
        
        return value;
    }
    
    public TestSuiteSession xmlMapperJunit(SaveFile saveFile) throws SQLException, FileNotFoundException, UnsupportedEncodingException, IOException {
        byte[] bytes = saveFile.getArquivoXmlFile();
        String string = new String(bytes, "UTF-8"); //passa os xmls para string
              
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        ObjectMapper xmlMapper = new XmlMapper(module);
        TestSuiteSession value = xmlMapper.readValue(string, TestSuiteSession.class); //passar string do xml para objeto
        
        return value;
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
        saveFile = (SaveFile) dao.consultaUmParametro(
                new SaveFile(), "idFile", 1);
        
        return saveFile.getNomeArquivoFile();
    }
    
    @GET
    @Path("/teste")
    @Produces(MediaType.APPLICATION_JSON)
    public String teste() throws SQLException, ParseException {
//        DaoGeneric<ModCadExecProjeto> dao = new DaoGeneric<>();
//        ModCadExecProjeto modExecProjeto = new ModCadExecProjeto();
//        ModCadProjeto modProjeto = new ModCadProjeto();
//        modProjeto.setIdProjeto(1);
//        
//        modExecProjeto = dao.consultaData(new ModCadExecProjeto(), modProjeto, stringForDate("2015_10_23_19_47_35.xml"));
//        
//        if(modExecProjeto != null)
//            System.out.println("Data: " + modExecProjeto.getDataHora());
//        else
//            System.out.println("Nada!!!");
        
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
}