/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

import edu.syr.bytecast.amd64.BytecastAMD64Factory;
import edu.syr.bytecast.amd64.api.constants.IBytecastAMD64;
import edu.syr.bytecast.executive.main.BytecastExecutive;
import edu.syr.bytecast.executive.version.BytecastVersion;
import edu.syr.bytecast.interfaces.fsys.IBytecastFsys;
import edu.syr.bytecast.jimple.api.IJimple;
import edu.syr.bytecast.jimple.impl.Jimple;
import edu.syr.bytecast.util.Paths;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhrumin
 */
public class Tester {
        
    private String message;
    private boolean result;
    private boolean testFinished;
    private String inputProperty;
    private String outputFile;
    
    public Tester(String inputProperty, String outputFile)
    {
        this.inputProperty = inputProperty;
        this.outputFile = outputFile;
        testFinished = false;        
    }
       
    
    public void start()
    {     
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(baos);
        System.setOut(newStream);
        try {
            Paths.v().setRoot("../");
            Paths.v().parsePathsFile("bytecast-executive/config/paths.cfg");
            IBytecastFsys fsys = BytecastVersion.getFsys("product");
            //Have to Inject Product and Test Module here.
            IBytecastAMD64 amd64 = new BytecastAMD64Factory().createBytecastAMD64Builder(fsys, Paths.v().getPath(getInputProperty()));
            IJimple jimple = new Jimple();
            //Should create the jar path here.
            if(jimple.createJimple(amd64, getOutputFile()))
                result = true;
            else
                result = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        finally
        {
            testFinished = true;
            setMessage(baos.toString());
            System.setOut(old);
        }
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the result
     */
    public boolean isResult() {
        return result;
    }

    /**
     * @return the testFinished
     */
    public boolean isTestFinished() {
        return testFinished;
    }
    
    /**
     * @return the inputProperty
     */
    public String getInputProperty() {
        return inputProperty;
    }

    /**
     * @param inputProperty the inputProperty to set
     */
    public void setInputProperty(String inputProperty) {
        this.inputProperty = inputProperty;
    }

    /**
     * @return the outputFile
     */
    public String getOutputFile() {
        return outputFile;
    }

    /**
     * @param outputFile the outputFile to set
     */
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }
    
    
    
}
