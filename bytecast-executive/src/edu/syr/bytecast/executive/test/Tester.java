/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.syr.bytecast.executive.test;

import edu.syr.bytecast.util.RunProcess;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhrumin
 */
public class Tester {
  
    private List<TestResult> m_testcases;
    
    public Tester()
    {        
       m_testcases = new ArrayList<TestResult>();
    }
    
    public void addTestCase(String command1, String command2, String directory1, String directory2)
    {
        TestResult m_result = new TestResult(command1, command2, directory1, directory2);
        m_testcases.add(m_result);
    }
    
    public void startTest()
    {       
        for(TestResult result : m_testcases)
        {
            try {
                RunProcess rp = new RunProcess();
                String command1 = result.getcommand1();
                String directory1 = result.getdirectory1();
                rp.exec(command1, null, new File(directory1));
                result.setOutput1(rp.getOutput());
                
            } catch (IOException ex) {
                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}