/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.main;

import edu.syr.bytecast.executive.test.Tester;

/**
 *
 * @author dhrumin
 */
public class BytecastExecutive {
    
    public BytecastExecutive()
    {
        
    }        
    
     
    public static void main(String[] args) {
        
        Tester tester = new Tester("BYTECAST_TEST_FSYS_SIMPLE_TEST_ELF_FILE", "outputjar/outputjar1.jar");
        tester.start();
        
        if(tester.isResult())
        {
            System.out.println("Succesfully Created Jar");
        }
        else
            System.out.println("Failed");
        
        System.out.println("Message" + tester.getMessage());
    }        
}