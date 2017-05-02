package saferefactor.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jdom.JDOMException;

import saferefactor.core.Parameters;
import saferefactor.core.Report;
import saferefactor.core.SafeRefactor;
import saferefactor.core.SafeRefactorImp;
import saferefactor.core.execution.CoverageImpactedMethodReport;
import saferefactor.core.execution.CoverageMeter;
import saferefactor.core.execution.CoverageDataReader.CoverageReport;
import saferefactor.core.util.Project;
import saferefactor.core.util.ast.Method;

public class Main2 {

	public static void main(String[] args) {
		/*File previousProjectDirectory = new File("/home/gleison/JUnit/Source/");
		File currentProjectDirectory = new File("/home/gleison/JUnit/Target/");
		
		File previousBinDirectory = new File("/home/gleison/JUnit/Source/bin");
		File currentBinDirectory = new File("/home/gleison/JUnit/Target/bin");
		
		File previousSrcDirectory = new File("/home/gleison/JUnit/Source/src");
		File currentSrcDirectory = new File("/home/gleison/JUnit/Target/src");*/
		
		/*File previousProjectDirectory = new File("/home/gleison/JUnit/junit4-r4.11/");
		File currentProjectDirectory = new File("/home/gleison/JUnit/junit4-r4.12/");
		
		File previousBinDirectory = new File("/home/gleison/JUnit/junit-4.11/bin");
		File currentBinDirectory = new File("/home/gleison/JUnit/junit-4.12/bin");
		
		File previousSrcDirectory = new File("/home/gleison/JUnit/junit4-r4.11/src");
		File currentSrcDirectory = new File("/home/gleison/JUnit/junit4-r4.12/src");
		
		File previousLibDirectory = new File("/home/gleison/JUnit/junit4-r4.11/lib");
		File currentLibDirectory = new File("/home/gleison/JUnit/junit4-r4.12/lib");*/
		
		File previousProjectDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.4/");
		File currentProjectDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.5/");
		
		File previousBinDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.4/bin");
		File currentBinDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.5/bin");
		
		File previousSrcDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.4/src");
		File currentSrcDirectory = new File("/home/gleison/experimentoSafeRefactor/commonsLang3.5/src");
		
		//File previousLibDirectory = new File("/home/gleison/JUnit/commonsLang3.1/lib");
		//File currentLibDirectory = new File("/home/gleison/JUnit/commonsLang3.2/lib");
		
		Project projectPrevious = new Project();
		projectPrevious.setProjectFolder(previousProjectDirectory);
		//projectPrevious.setLibFolder(previousLibDirectory);
		projectPrevious.setBuildFolder(previousBinDirectory);
		projectPrevious.setSrcFolder(previousSrcDirectory);
		
		Project projectCurrent = new Project();
		projectCurrent.setProjectFolder(currentProjectDirectory);
		//projectPrevious.setLibFolder(currentLibDirectory);
		projectCurrent.setBuildFolder(currentBinDirectory);
		projectCurrent.setSrcFolder(currentSrcDirectory);
		
		
		
		Parameters parameters = new Parameters();
		parameters.setTimeLimit(Integer.parseInt("10"));
		parameters.setCompileProjects(true);
		
		Report report = new Report();
		
		for (int i = 4; i < 5; i++) {
			try {
				SafeRefactor saferefactor = new SafeRefactorImp(projectPrevious, projectCurrent, parameters);
				saferefactor.checkTransformation();
				report = saferefactor.getReport();
				
				
				System.out.println("refactoring: " + report.isRefactoring());
				System.out.println("number of tests: " + report.getNumberTests());
				System.out.println("detected changes: " + report.getChanges());
				
				File dir = new File("/home/gleison/experimentoSafeRefactor/test" + i);
				dir.mkdir();
				
				PrintWriter print = new PrintWriter(new FileWriter(dir.getAbsolutePath() + "/result.txt"));
				print.print(report.getChanges());
				print.close();
				
				for (File testFile : report.getGeneratedTestFiles()) {
					FileUtils.copyFileToDirectory(testFile, new File("/home/gleison/experimentoSafeRefactor/test" + i));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
