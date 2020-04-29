// Generated from D:/project_myself/demo-tim/demo-common/src/main/java/com/tim/common/antlr\SelectExample1.g4 by ANTLR 4.7.2
package com.tim.common.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SelectExample1Parser}.
 */
public interface SelectExample1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SelectExample1Parser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSql(SelectExample1Parser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectExample1Parser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSql(SelectExample1Parser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SelectExample1Parser#tables}.
	 * @param ctx the parse tree
	 */
	void enterTables(SelectExample1Parser.TablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SelectExample1Parser#tables}.
	 * @param ctx the parse tree
	 */
	void exitTables(SelectExample1Parser.TablesContext ctx);
}