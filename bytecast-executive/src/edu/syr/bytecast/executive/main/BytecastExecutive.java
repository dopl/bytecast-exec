/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.main;

import edu.syr.bytecast.executive.test.PocFile;
import edu.syr.bytecast.executive.test.RunBytecast;
import edu.syr.bytecast.executive.test.TestCase;
import edu.syr.bytecast.executive.test.Tester;
import java.util.List;

/**
 *
 * @author dhrumin
 */
public class BytecastExecutive {
    
    public BytecastExecutive()
    {
        
    }        
    
     
    public static void main(String[] args) {        
        RunBytecast m_tester = new RunBytecast("BYTECAST_TEST_FSYS_SIMPLE_TEST_ELF_FILE", "outputjar/outputclass.class");
        m_tester.start();
        
        if(m_tester.isResult())
        {
            System.out.println("Succesfully Created Class File");
            Tester tester = new Tester();            
            tester.addTestCase(new PocFile("./a.out", null, "../../bytecast-documents/AsciiManip01Prototype", null), new String[]{"2", "3"});
            tester.startTest();
            TestCase result = tester.getResults().get(0);
            for(String output : result.getOutput1())
                System.out.println(output);
            
        }
        else
        {
            System.out.println("Failed");
            System.out.println("Message" + m_tester.getMessage());
        }                        
    }        
}