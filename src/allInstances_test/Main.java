package allInstances_test;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLPackage;

public class Main {

    public static void main(String[] args) {

        final String input = "model/test.uml";
        
        System.out.println("Initialization");
        ResourceSet rs = new ResourceSetImpl();
        
        EssentialOCLStandaloneSetup.doSetup();
        org.eclipse.ocl.pivot.uml.UMLStandaloneSetup.init();
        
        OCL ocl = OCL.newInstance(rs);

        System.out.println("Loading UML model " + input);
        Resource resource = ocl.getResourceSet().getResource(URI.createFileURI(new File(input).getAbsolutePath()), true);

        Model uml = (Model)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.eINSTANCE.getModel());

        try {
            Class message = (Class)uml.getPackagedElement("Class1");
            System.out.println("\numl: " + message);
            org.eclipse.ocl.pivot.Class messageAS = ocl.getMetamodelManager().getASOf(org.eclipse.ocl.pivot.Class.class, message);
            System.out.println("pivot: " + messageAS);
            ExpressionInOCL expr = ocl.createInvariant(messageAS, "Class1.allInstances()->notEmpty()");
            System.out.println("Expression: " + expr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class message = (Class)uml.getPackagedElement("Class2");
            System.out.println("\numl: " + message);
            org.eclipse.ocl.pivot.Class messageAS = ocl.getMetamodelManager().getASOf(org.eclipse.ocl.pivot.Class.class, message);
            System.out.println("pivot: " + messageAS);
            ExpressionInOCL expr = ocl.createInvariant(messageAS, "Class2.allInstances()->notEmpty()");
            System.out.println("Expression: " + expr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Signal message = (Signal)uml.getPackagedElement("Signal1");
            System.out.println("\numl: " + message);
            org.eclipse.ocl.pivot.Signal messageAS = ocl.getMetamodelManager().getASOf(org.eclipse.ocl.pivot.Signal.class, message);
            System.out.println("pivot: " + messageAS);
            ExpressionInOCL expr = ocl.createInvariant(messageAS, "Signal1.allInstances()->notEmpty()");
            System.out.println("Expression: " + expr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Signal message = (Signal)uml.getPackagedElement("Signal2");
            System.out.println("\numl: " + message);
            org.eclipse.ocl.pivot.Signal messageAS = ocl.getMetamodelManager().getASOf(org.eclipse.ocl.pivot.Signal.class, message);
            System.out.println("pivot: " + messageAS);
            ExpressionInOCL expr = ocl.createInvariant(messageAS, "Signal2.allInstances()->notEmpty()");
            System.out.println("Expression: " + expr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
