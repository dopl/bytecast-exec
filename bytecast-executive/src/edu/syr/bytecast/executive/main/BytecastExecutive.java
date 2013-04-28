/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.main;

import edu.syr.bytecast.executive.test.PocFile;
import edu.syr.bytecast.executive.test.RunBytecast;
import edu.syr.bytecast.executive.test.TestCase;
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
        
        RunBytecast m_tester1 = new RunBytecast("BYTECAST_TEST_FSYS_SIMPLE_TEST_ELF_FILE", "output1");
        m_tester1.start();
        
//        RunBytecast m_tester2 = new RunBytecast("BYTECAST_TEST_FSYS_POC3_TEST_ELF_FILE", "output2");
//        m_tester2.start();
        
        if(m_tester1.isResult())
        {
            System.out.println("Succesfully Created Class File for Test 1");            
            Tester tester = new Tester();            
            PocFile pocfile = new PocFile("./a.out", "java output1", "../../bytecast-documents/AsciiManip01Prototype", "sootOutput");
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
            System.out.println("Test 1 Failed");
            System.out.println("Message" + m_tester1.getMessage());            
        }
        
//        if(m_tester2.isResult())
//        {
//            System.out.println("Succesfully Created Class File for Test 2");            
//            Tester tester = new Tester();  
//            PocFile pocfile2 = new PocFile("./a.out", "java output2.class", "../../bytecast-documents/AsciiManip01Prototype", "outputjar/output2.class");
//            tester.addTestCase(pocfile2, new String[]{"2", "3"});
//            tester.addTestCase(pocfile2, new String[]{"2", "2"});
//            tester.addTestCase(pocfile2, new String[]{"4", "5"});
//            tester.addTestCase(pocfile2, new String[]{"23", "122"});
//            tester.addTestCase(pocfile2, new String[]{"-2", "5"});
//            
//            tester.startTest();            
//            int testCount = 0;
//            for(TestCase result : tester.getResults())
//            {
//                System.out.println("Running Test " + ++testCount);
//                String[] arguments = result.getArguments();
//                System.out.print("Arguments : ");
//                
//                for(String argument : arguments)
//                    System.out.print(" " + argument);
//                
//                System.out.println();
//                if(result.getResult())
//                    System.out.println("Test Passed");
//                else
//                    System.out.println("Test Failed");
//                
//                System.out.println("Expected Output " + result.getOutput1());
//                System.out.println("Generated Output " + result.getOutput2());
//                if(result.getError().size() > 0)
//                    System.out.println("Error Message" + result.getError().toString());
//            }
//        }
//        else
//        {
//            System.out.println("Test 2 Failed");
//            System.out.println("Message" + m_tester1.getMessage());
//        }
        
    }    
}