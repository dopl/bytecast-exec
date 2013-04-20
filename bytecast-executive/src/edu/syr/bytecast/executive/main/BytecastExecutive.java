/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.main;

import edu.syr.bytecast.executive.test.RunBytecast;

/**
 *
 * @author dhrumin
 */
public class BytecastExecutive {
    
    public BytecastExecutive()
    {
        
    }        
    
     
    public static void main(String[] args) {
        
        RunBytecast m_tester = new RunBytecast("BYTECAST_TEST_FSYS_SIMPLE_TEST_ELF_FILE", "outputjar/outputjar1.jar");
        m_tester.start();
        
        if(m_tester.isResult())
        {
            System.out.println("Succesfully Created Jar");
        }
        else
            System.out.println("Failed");
        
        System.out.println("Message" + m_tester.getMessage());
    }        
}