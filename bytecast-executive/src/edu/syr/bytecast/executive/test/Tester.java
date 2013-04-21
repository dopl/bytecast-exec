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
    
    private String buildCommand(String command, String[] arguments)
    {
        StringBuilder command1 = new StringBuilder(command);        
        command1.append(" ");
        for(int i = 0; i < arguments.length; i++)
        {
           command1.append(arguments[i]);
           command1.append(" ");
        }
        return command1.toString();
    }
    
    public void startTest()
    {       
        for(TestCase testcase : m_testcases)
        {
            try {
                String command1 = buildCommand(testcase.getPocFile().getcommand1(), testcase.getArguments());
                RunProcess rp = new RunProcess();
                rp.exec(command1.toString(), new File(testcase.getPocFile().getdirectory1()));
                testcase.setOutput1(rp.getOutput());
                if(rp.getError().size() > 0)
                    testcase.add("error", rp.getError().toString());
                String command2 = buildCommand(testcase.getPocFile().getcommand2(), testcase.getArguments());
                RunProcess rp1 = new RunProcess();
                rp1.exec(command2.toString(), new File(testcase.getPocFile().getdirectory2()));
                testcase.setOutput2(rp1.getOutput());
                if(rp.getError().size() > 0)
                    testcase.add("error", rp1.getError().toString());
                if(testcase.getOutput1().size() != testcase.getOutput2().size())
                    testcase.setResult(false);
                else
                {
                    int count = 0;
                    boolean result = true;
                    for(String output : testcase.getOutput1())
                    {
                        if(!output.equals(testcase.getOutput2().get(count++)))
                        {
                            result = false;
                            break;
                        }
                    }
                    testcase.setResult(result);                    
                }
                
            } catch (IOException ex) {
                testcase.add("error", ex.getMessage());
            } catch (InterruptedException ex) {
                testcase.add("error", ex.getMessage());
            }
        }
    }
    
    public List<TestCase> getResults()
    {
        return m_testcases;
    }        
}