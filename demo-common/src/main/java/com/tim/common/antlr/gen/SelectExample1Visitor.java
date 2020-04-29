// Generated from D:/project_myself/demo-tim/demo-common/src/main/java/com/tim/common/antlr\SelectExample1.g4 by ANTLR 4.7.2
package com.tim.common.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SelectExample1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SelectExample1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SelectExample1Parser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(SelectExample1Parser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectExample1Parser#tables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTables(SelectExample1Parser.TablesContext ctx);
}