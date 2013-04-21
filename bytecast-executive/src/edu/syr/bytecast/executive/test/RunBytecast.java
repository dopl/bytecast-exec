/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

import edu.syr.bytecast.amd64.BytecastAMD64Factory;
import edu.syr.bytecast.amd64.api.constants.IBytecastAMD64;
import edu.syr.bytecast.executive.version.BytecastVersion;
import edu.syr.bytecast.fsys.elf.ElfExeObjParser;
import edu.syr.bytecast.interfaces.fsys.IBytecastFsys;
import edu.syr.bytecast.jimple.api.IJimple;
import edu.syr.bytecast.jimple.impl.Jimple;
import edu.syr.bytecast.util.Paths;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author dhrumin
 */
public class RunBytecast {
        
    private String m_message;
    private boolean m_result;
    private boolean m_testFinished;
    private String m_inputProperty;
    private String m_outputFile;
    
    public RunBytecast(String inputProperty, String outputFile)
    {
        this.m_inputProperty = inputProperty;
        this.m_outputFile = outputFile;
        m_testFinished = false;
    }
       
    
    public void start()
    {     
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(baos);
        System.setOut(newStream);
        try {
            Paths.v().setRoot("../../");
            Paths.v().parsePathsFile("bytecast-exec/bytecast-executive/config/paths.cfg");
            //IBytecastFsys fsys = BytecastVersion.getFsys("product");
            IBytecastFsys fsys = new ElfExeObjParser();
            //Have to Inject Product and Test Module here.
            IBytecastAMD64 amd64 = new BytecastAMD64Factory().createBytecastAMD64Builder(fsys, Paths.v().getPath(getInputProperty()));
            IJimple jimple = new Jimple();
            //Should create the jar path here.
            if(jimple.createJimple(amd64, getOutputFile()))
                m_result = true;
            else
                m_result = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            m_result = false;
        } finally
        {
            m_testFinished = true;
            setMessage(baos.toString());
            System.setOut(old);
        }
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return m_message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.m_message = message;
    }

    /**
     * @return the result
     */
    public boolean isResult() {
        return m_result;
    }

    /**
     * @return the testFinished
     */
    public boolean isTestFinished() {
        return m_testFinished;
    }
    
    /**
     * @return the inputProperty
     */
    public String getInputProperty() {
        return m_inputProperty;
    }

    /**
     * @param inputProperty the inputProperty to set
     */
    public void setInputProperty(String inputProperty) {
        this.m_inputProperty = inputProperty;
    }

    /**
     * @return the outputFile
     */
    public String getOutputFile() {
        return m_outputFile;
    }

    /**
     * @param outputFile the outputFile to set
     */
    public void setOutputFile(String outputFile) {
        this.m_outputFile = outputFile;
    }
    
    
    
}
