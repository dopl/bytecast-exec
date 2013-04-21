/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

import java.util.List;

/**
 *
 * @author dhrumin
 */
public class TestCase {
    
    private String m_message;
    private boolean m_result;
    private List<String> m_output1;
    private List<String> m_output2;
    private List<String> m_error1;
    private List<String> m_error2;
    private String[] m_arguments;
    private PocFile m_pocFile;
    
    public TestCase()
    {
        
    }
    
    public TestCase(PocFile m_pocFile)
    {
        this.m_pocFile = m_pocFile;
    }
       
    /**
     * @return the m_message
     */
    public String getMessage() {
        return m_message;
    }
    /**
     * @param m_message the m_message to set
     */
    public void setMessage(String m_message) {
        this.m_message = m_message;
    }

    /**
     * @return the m_result
     */
    public boolean getResult() {
        return m_result;
    }

    /**
     * @param m_result the m_result to set
     */
    public void setResult(boolean m_result) {
        this.m_result = m_result;
    }

    /**
     * @return the m_output1
     */
    public List<String> getOutput1() {
        return m_output1;
    }

    /**
     * @param m_output1 the m_output1 to set
     */
    public void setOutput1(List<String> m_output1) {
        this.m_output1 = m_output1;
    }

    /**
     * @return the m_output2
     */
    public List<String> getOutput2() {
        return m_output2;
    }

    /**
     * @param m_output2 the m_output2 to set
     */
    public void setOutput2(List<String> m_output2) {
        this.m_output2 = m_output2;
    }

    /**
     * @return the m_error1
     */
    public List<String> getError1() {
        return m_error1;
    }

    /**
     * @param m_error1 the m_error1 to set
     */
    public void setError1(List<String> m_error1) {
        this.m_error1 = m_error1;
    }

    /**
     * @return the m_error2
     */
    public List<String> getError2() {
        return m_error2;
    }

    /**
     * @param m_error2 the m_error2 to set
     */
    public void setError2(List<String> m_error2) {
        this.m_error2 = m_error2;
    
    }       

    /**
     * @return the m_arguments
     */
    public String[] getArguments() {
        return m_arguments;
    }

    /**
     * @param m_arguments the m_arguments to set
     */
    public void setArguments(String[] m_arguments) {
        this.m_arguments = m_arguments;
    }        

    /**
     * @return the m_pocFile
     */
    public PocFile getPocFile() {
        return m_pocFile;
    }

    /**
     * @param m_pocFile the m_pocFile to set
     */
    public void setPocFile(PocFile m_pocFile) {
        this.m_pocFile = m_pocFile;
    }
}
