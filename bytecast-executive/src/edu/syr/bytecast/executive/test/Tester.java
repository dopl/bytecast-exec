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
  
    private List<TestCase> m_testcases;
    
    public Tester()
    {        
       m_testcases = new ArrayList<TestCase>();
    }
    
    public void addTestCase(PocFile file, String[] arguments)
    {
        TestCase m_testcase = new TestCase(file);
        m_testcase.setArguments(arguments);
        m_testcases.add(m_testcase);
    }
    
    public void startTest()
    {       
        for(TestCase testcase : m_testcases)
        {
            try {
                StringBuilder command1 = new StringBuilder(testcase.getPocFile().getcommand1());
                String[] arguments = testcase.getArguments();
                command1.append(" ");
                for(int i = 0; i < arguments.length; i++)
                {
                    command1.append(arguments[i]);
                    command1.append(" ");
                }
                
                RunProcess rp = new RunProcess();                
                rp.exec(command1.toString(), new File(testcase.getPocFile().getdirectory1()));
                testcase.setOutput1(rp.getOutput());
                testcase.setError1(rp.getError());              
            } catch (IOException ex) {
                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<TestCase> getResults()
    {
        return m_testcases;
    }        
}