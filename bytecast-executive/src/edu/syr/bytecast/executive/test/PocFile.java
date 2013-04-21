/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

/**
 *
 * @author dhrumin
 */
public class PocFile {
    private String m_command1;
    private String m_command2;
    private String m_directory1;
    private String m_directory2;
    
    public PocFile(String m_command1, String m_command2, String m_directory1, String m_directory2)
    {
        this.m_command1 = m_command1;
        this.m_command2 = m_command2;
        this.m_directory1 = m_directory1;
        this.m_directory2 = m_directory2;
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
    
}
