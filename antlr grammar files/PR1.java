import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Phaser;

/**
 * Evan Bourgoine
 * Project 1: PR1 Java File
 */
public class PR1 {

    public static void main (String[] args) throws IOException {

        //set up variables to read the input file
        BufferedReader readFile = new BufferedReader(new InputStreamReader(System.in));
        String inputFile;
        PR1FullVisitor visitor = new PR1FullVisitor();
    
        //create global scope
        visitor.initializeGlobalScope();
    
        //Read each line
        while ((inputFile = readFile.readLine()) != null) 
        {
            CharStream inputStream = CharStreams.fromString(inputFile);
            PR1Lexer lexer = new PR1Lexer(inputStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PR1Parser parser = new PR1Parser(tokens);
    
            ParseTree tree = parser.prog();
    
            visitor.visit(tree);
        }
    }
}