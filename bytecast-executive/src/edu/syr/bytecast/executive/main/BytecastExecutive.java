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
            PocFile pocfile = new PocFile("./a.out", "java outputclass", "../../bytecast-documents/AsciiManip01Prototype", "outputjar/outputclass.class");
            tester.addTestCase(pocfile, new String[]{"2", "3"});
            tester.addTestCase(pocfile, new String[]{"2", "2"});
            tester.addTestCase(pocfile, new String[]{"4", "5"});
            tester.addTestCase(pocfile, new String[]{"23", "122"});
            tester.addTestCase(pocfile, new String[]{"-2", "5"});
            
            tester.startTest();            
            int testCount = 0;
            for(TestCase result : tester.getResults())
            {
                System.out.println("Running Test " + ++testCount);
                String[] arguments = result.getArguments();
                System.out.print("Arguments : ");
                
                for(String argument : arguments)
                    System.out.print(" " + argument);
                
                System.out.println();
                if(result.getResult())
                    System.out.println("Test Passed");
                else
                    System.out.println("Test Failed");
                
                System.out.println("Expected Output " + result.getOutput1());
                System.out.println("Generated Output " + result.getOutput2());
                if(result.getError().size() > 0)
                    System.out.println("Error Message" + result.getError().toString());
            }
            
        }
        else
        {
            System.out.println("Failed");
            System.out.println("Message" + m_tester.getMessage());
        }                        
    }        
}