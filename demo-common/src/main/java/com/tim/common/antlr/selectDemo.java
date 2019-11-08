package com.tim.common.antlr;

import com.tim.common.antlr.gen.SelectExample1Lexer;
import com.tim.common.antlr.gen.SelectExample1Parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by friendsyh on 2019/11/6.
 * 首先根据.g4文件生成对应的词法语法分析的类。然后可以直接使用这些类。
 */
public class selectDemo {

    public static void main(String[] args) {
        // first, form input charstream from string
        CharStream input = CharStreams.fromString("select name from studetnt;");

        // 1. Lexer-Lexical analysis
        // Create a lexer that feeds off of input CharStream.
        SelectExample1Lexer lexer = new SelectExample1Lexer(input);

        // 2. Create a buffer of tokens pulled from the lexer.
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 3. Parser-Syntax analysis
        // Create a parser that feeds off the tokens buffer.
        SelectExample1Parser parser = new SelectExample1Parser(tokens);

        // 4. Begin parsing at "select" rule.
        ParseTree tree = parser.sql();
        System.out.println(tree.toStringTree(parser));
    }
}
