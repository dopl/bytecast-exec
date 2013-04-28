/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

import java.util.ArrayList;
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
    private List<String> m_error;
    private String[] m_arguments;
    private PocFile m_pocFile;
    
    public TestCase()
    {
        m_error = new ArrayList<String>()
        {

            @Override
            public String toString() {
                StringBuilder buff = new StringBuilder();
                for(String value : this)
                {
                    buff.append(value).append(",");
                }
                
                return buff.toString();
            }            
        };  
    }
    
    public void add(String type, String message)
    {
        if(type.equalsIgnoreCase("error"))
            m_error.add(message);
        else if(type.equalsIgnoreCase("output1"))
            m_output1.add(message);
        else if(type.equalsIgnoreCase("output2"))
            m_output2.add(message);
            
    }
    
    public TestCase(PocFile m_pocFile)
    {
        this.m_pocFile = m_pocFile;
        m_error = new ArrayList<String>()
        {

            @Override
            public String toString() {
                StringBuilder buff = new StringBuilder();
                for(String value : this)
                {
                    buff.append(value).append(",");
                }
                
                return buff.toString();
            }            
        };
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
    public List<String> getError() {
        return m_error;
    }

    /**
     * @param m_error1 the m_error1 to set
     */
    public void setError(List<String> m_error1) {
        this.m_error = m_error1;
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
