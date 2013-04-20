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
public class TestResult {
    
    private String m_message;
    private boolean m_result;
    private String m_command1;
    private String m_command2;
    private String m_directory1;
    private String m_directory2;
    private List<String> m_output1;
    private List<String> m_output2;
    private List<String> m_error1;
    private List<String> m_error2;
    
    public TestResult()
    {
        
    }
    
    public TestResult(String m_command1, String m_command2, String m_directory1, String m_directory2)
    {
        this.m_command1 = m_command1;
        this.m_command2 = m_command2;
        this.m_directory1 = m_directory1;
        this.m_directory2 = m_directory2;
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
     * @return the m_command1
     */
    public String getcommand1() {
        return m_command1;
    }

    /**
     * @param m_command1 the m_command1 to set
     */
    public void setcommand1(String m_command1) {
        this.m_command1 = m_command1;
    }

    /**
     * @return the m_command2
     */
    public String getcommand2() {
        return m_command2;
    }

    /**
     * @param m_command2 the m_command2 to set
     */
    public void setcommand2(String m_command2) {
        this.m_command2 = m_command2;
    }

    /**
     * @return the m_directory1
     */
    public String getdirectory1() {
        return m_directory1;
    }

    /**
     * @param m_directory1 the m_directory1 to set
     */
    public void setdirectory1(String m_directory1) {
        this.m_directory1 = m_directory1;
    }

    /**
     * @return the m_directory2
     */
    public String getdirectory2() {
        return m_directory2;
    }

    /**
     * @param m_directory2 the m_directory2 to set
     */
    public void setdirectory2(String m_directory2) {
        this.m_directory2 = m_directory2;
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
}
