package lang;

import lang.parser.TensorLangLexer;
import lang.parser.TensorLangParser;
import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String file = "program.mlang";
        if (args.length > 0) {
            file = args[0];
        }
        String code = java.nio.file.Files.readString(java.nio.file.Paths.get(file));
        CharStream input = CharStreams.fromString(code);
        TensorLangLexer lexer = new TensorLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TensorLangParser parser = new TensorLangParser(tokens);
        // Supondo que o interpretador espera um ParseTree:
        var tree = parser.program();
        TensorLangInterpreter interpreter = new TensorLangInterpreter();
        interpreter.visit(tree);
    }
}